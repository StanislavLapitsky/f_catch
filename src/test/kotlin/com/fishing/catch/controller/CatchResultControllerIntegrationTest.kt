package com.fishing.catch

import com.fishing.catch.dto.CatchDto
import com.fishing.catch.entity.CatchEntity
import com.fishing.catch.entity.CatchResult
import com.fishing.catch.entity.LocationInfo
import com.fishing.catch.repository.CatchRepository
import org.apache.commons.io.IOUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.test.context.junit4.SpringRunner
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
               ,properties = arrayOf("spring.data.mongodb.inMemory:true","spring.data.mongodb.port:0"))
class CatchResultControllerIntegrationTest {
	@Autowired
	lateinit var catchRepository: CatchRepository

	@LocalServerPort
	private val port: Int = 0

	@Value("\${server.contextPath}")
    lateinit var contextPath: String

    lateinit var base: String

	@Autowired
    lateinit var template: TestRestTemplate

	val newCatch = CatchEntity(
			id = null,
			date = SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS Z").parse("2017.06.03 01:02:03:999 UTC"),
			locationInfo = LocationInfo(1.1,2.2, "address"),
			result = CatchResult(1.01, listOf(Pair("Bream", 9), Pair("Roach", 18))),
			image = null,
			ipAddress = "127.0.0.1",
			login = "fisher",
			phone = "322-223",
			tackle = listOf("feeder"))

	@Before
	@Throws(Exception::class)
	fun setUp() {
		this.base = "http://localhost:" + port

		catchRepository.save(newCatch)
	}

	@Test
	@Throws(Exception::class)
	fun testProjectControllerAutowired() {
		val response = template.exchange(
				base + contextPath + "/catch/list",
				HttpMethod.GET,
				null,
				object : ParameterizedTypeReference<String>() {
				})

		assertTrue { response.body.isNotEmpty()  }
        val expectedJson = IOUtils.toString(this.javaClass.getResourceAsStream("/test/CatchResultControllerIntegrationTestList.json"),"UTF-8");
		JSONAssert.assertEquals(expectedJson, response.body, false)
	}

    @Test
    fun findAllTest() {
        val results = catchRepository.findAll()
        assertEquals(0,results.size)
    }


}

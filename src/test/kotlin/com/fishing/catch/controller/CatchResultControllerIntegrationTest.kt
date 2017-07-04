package com.fishing.catch

import com.fishing.catch.repository.CatchRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.test.context.junit4.SpringRunner
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

	@Before
	@Throws(Exception::class)
	fun setUp() {
		this.base = "http://localhost:" + port
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

		assertTrue { response.body.length > 0 }
	}

    @Test
    fun findAllTest() {
        val results = catchRepository.findAll()
        assertEquals(0,results.size)
    }


}

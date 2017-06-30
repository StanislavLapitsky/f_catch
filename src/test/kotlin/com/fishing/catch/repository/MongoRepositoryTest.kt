package com.fishing.catch

import com.fishing.catch.config.MainTestConfig
import com.fishing.catch.entity.CatchEntity
import com.fishing.catch.entity.CatchResult
import com.fishing.catch.entity.LocationInfo
import com.fishing.catch.repository.CatchRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import kotlin.test.assertEquals

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */
@RunWith(SpringRunner::class)
@SpringBootTest(properties = arrayOf("spring.data.mongodb.inMemory:true","spring.data.mongodb.port:0"))
class MongoRepositoryTest {
    @Autowired
    lateinit var catchRepository: CatchRepository

    @Test
    fun testRepository() {
        val results = catchRepository.findAll()
        assertEquals(0,results.size)
        val newCatch = CatchEntity(
                id = null,
                date= Date(),
                locationInfo = LocationInfo(0.0,0.0, "address"),
                result = CatchResult(0.01, listOf(Pair("Bream", 9), Pair("Roach", 18))),
                image = null,
                ipAddress = "127.0.0.1",
                login = "fisher",
                phone = "322-223",
                tackle = listOf("feeder"))
        catchRepository.save(newCatch)
        val results2 = catchRepository.findAll()
        assertEquals(1, results2.size)
        assertEquals(newCatch, results2[0])
    }

}
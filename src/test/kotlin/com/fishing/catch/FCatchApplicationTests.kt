package com.fishing.catch

import com.fishing.catch.repository.CatchRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
class FCatchApplicationTests {

	@Autowired
	lateinit var catchRepository: CatchRepository
    @Test
	fun contextLoads() {
		val results = catchRepository.findAll()
		assertEquals(0,results.size)

	}

}

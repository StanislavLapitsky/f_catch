package com.fishing.catch.config

import com.fishing.catch.entity.CatchEntity
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
@TestConfiguration
@ComponentScan(basePackages = arrayOf("com.fishing.catch"),
        excludeFilters = arrayOf(ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                                                        value = MongoConfig::class) ))
class MainTestConfig {
    @Bean
    fun testBean():CatchEntity {
        return CatchEntity()
    }
}
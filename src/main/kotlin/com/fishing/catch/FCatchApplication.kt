package com.fishing.catch

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class,
                                         MongoRepositoriesAutoConfiguration::class))
class FCatchApplication

fun main(args: Array<String>) {
    SpringApplication.run(FCatchApplication::class.java, *args)
}

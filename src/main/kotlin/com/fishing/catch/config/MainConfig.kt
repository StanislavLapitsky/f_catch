package com.fishing.catch.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
@Configuration
@EnableMongoRepositories(basePackages = arrayOf("com.fishing.catch.repository"))
@ComponentScan(basePackages = arrayOf("com.fishing.catch"))
class MainConfig
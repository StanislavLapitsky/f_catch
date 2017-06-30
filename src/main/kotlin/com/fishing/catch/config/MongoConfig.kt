package com.fishing.catch.config

import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */
@Configuration
@ConditionalOnProperty(havingValue= "false", name= arrayOf("spring.data.mongodb.inMemory"), matchIfMissing = true)
class MongoConfig {
    @Value("\${spring.data.mongodb.host}")
    lateinit var mongoHost: String
    @Value("\${spring.data.mongodb.port}")
    lateinit var mongoPort: String
    @Value("\${spring.data.mongodb.database}")
    lateinit var mongoDB: String
    @Value("\${spring.data.mongodb.inMemory:missing}")
    lateinit var checkProperty: String
    @Bean
    fun mongoDbFactory():MongoDbFactory {
		return SimpleMongoDbFactory(MongoClient(mongoHost, mongoPort.toInt()), mongoDB);
	}
    @Bean
    fun mongoTemplate():MongoTemplate {
		val mongoTemplate = MongoTemplate(mongoDbFactory())
		return mongoTemplate;
	}
}
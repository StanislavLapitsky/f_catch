package com.fishing.catch.config

import com.mongodb.Mongo
import com.mongodb.MongoClientOptions
import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodProcess
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.IMongodConfig
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder
import de.flapdoodle.embed.mongo.distribution.Version
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import java.io.IOException

//@Configuration
//@EnableAutoConfiguration(exclude = arrayOf(EmbeddedMongoAutoConfiguration::class))
class TestMongoConfig {

    @Autowired
    lateinit var properties: MongoProperties
    @Autowired
    lateinit var environment: Environment

    @Autowired(required = false)
    lateinit var options: MongoClientOptions

    @Bean(destroyMethod = "close")
    @Throws(IOException::class)
    fun mongo(mongodProcess: MongodProcess): Mongo {
        val net = mongodProcess.config.net()
        properties.host = net.serverAddress.hostName
        properties.port = net.port
        return properties.createMongoClient(this.options, this.environment)
    }

    @Bean(destroyMethod = "stop")
    @Throws(IOException::class)
    fun mongodProcess(mongodExecutable: MongodExecutable): MongodProcess {
        return mongodExecutable.start()
    }

    @Bean(destroyMethod = "stop")
    @Throws(IOException::class)
    fun mongodExecutable(mongodStarter: MongodStarter, iMongodConfig: IMongodConfig): MongodExecutable {
        return mongodStarter.prepare(iMongodConfig)
    }

    @Bean
    @Throws(IOException::class)
    fun mongodConfig(): IMongodConfig {
        return MongodConfigBuilder().version(Version.Main.PRODUCTION).build()
    }

    @Bean
    fun mongodStarter(): MongodStarter {
        return MongodStarter.getDefaultInstance()
    }

}
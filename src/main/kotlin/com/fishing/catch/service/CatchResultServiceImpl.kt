package com.fishing.catch.service

import com.fishing.catch.entity.CatchEntity
import com.fishing.catch.repository.CatchRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
@Service
class CatchResultServiceImpl: CatchResultService {
    val logger = LoggerFactory.getLogger(CatchResultService::class.java)

    @Autowired
    lateinit var catchRepository: CatchRepository

    override fun add(catchEntity: CatchEntity) {
        logger.debug("saving {}", catchEntity)

        catchRepository.save(catchEntity)
    }

    override fun list(): List<CatchEntity> {
        logger.debug("getting list")
        return catchRepository.findAll()
    }
}
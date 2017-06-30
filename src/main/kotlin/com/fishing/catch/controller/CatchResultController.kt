package com.fishing.catch.controller

import com.fishing.catch.entity.CatchEntity
import com.fishing.catch.service.CatchResultService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
@RestController
@RequestMapping(path = arrayOf("/catch"))
class CatchResultController {
    val logger = LoggerFactory.getLogger(CatchResultController::class.java)

    @Autowired
    lateinit var catchResultService: CatchResultService

    @RequestMapping(
            path = arrayOf("/list"),
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun listCatchResults(): List<CatchEntity> {
        logger.debug("/catch/list")
        val list = catchResultService.list()
        return list
    }

    @RequestMapping(
            path = arrayOf("/add"),
            method = arrayOf(RequestMethod.POST),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun addCatchResult(@RequestBody catchEntity:CatchEntity) {
        logger.debug("/catch/add {}", catchEntity)
        catchResultService.add(catchEntity)
    }
}
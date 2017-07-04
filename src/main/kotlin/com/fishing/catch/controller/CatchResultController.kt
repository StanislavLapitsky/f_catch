package com.fishing.catch.controller

import com.fishing.catch.dto.CatchDto
import com.fishing.catch.entity.CatchEntity
import com.fishing.catch.service.CatchResultService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
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
@Api(value = "f_catch", description = "Project API")
@RestController
@RequestMapping(path = arrayOf("/catch"))
class CatchResultController {
    val logger = LoggerFactory.getLogger(CatchResultController::class.java)

    @Autowired
    lateinit var catchResultService: CatchResultService

    @ApiOperation(value = "Get list of catches", notes = "Returns page of catches")
//    @ApiImplicitParams(ApiImplicitParam(name = "offset", value = "Offset", required = false, dataType = "long", paramType = "query"), ApiImplicitParam(name = "pageSize", value = "Page size", required = false, dataType = "long", paramType = "query"), ApiImplicitParam(name = "sort", value = "Sort", required = false, dataType = "String", paramType = "query"))
    @RequestMapping(
            path = arrayOf("/list"),
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun listCatchResults(): List<CatchDto> {
        logger.debug("/catch/list")
        val list = catchResultService.list()
        return list
    }

    @ApiOperation(value = "Add catch", notes = "Adds a catch")
    @RequestMapping(
            path = arrayOf("/add"),
            method = arrayOf(RequestMethod.POST),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun addCatchResult(@RequestBody catch:CatchDto) {
        logger.debug("/catch/add {}", catch)
        catchResultService.add(catch)
    }
}
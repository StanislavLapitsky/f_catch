package com.fishing.catch.controller

import com.fishing.catch.dto.CatchDto
import com.fishing.catch.dto.filter.SearchFilterRaw
import com.fishing.catch.service.CatchSearchService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
@Api(value = "f_catch", description = "Project API")
@RestController
@RequestMapping(path = arrayOf("/search"))
class CatchSearchController {
    val logger = LoggerFactory.getLogger(CatchSearchController::class.java)

    @Autowired
    lateinit var catchSearchService: CatchSearchService

    @ApiOperation(value = "Search catches", notes = "Returns page of catches according to search filter criteria")
    @RequestMapping(
            path = arrayOf("/home"),
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun searchHome(@Valid filter:SearchFilterRaw, request:HttpServletRequest): List<CatchDto> {
        logger.debug("/search/home")
        val list = catchSearchService.search(filter.validFilter())
        return list
    }

}
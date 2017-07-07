package com.fishing.catch.service

import com.fishing.catch.dto.CatchDto
import com.fishing.catch.dto.filter.SearchFilter
import com.fishing.catch.repository.CatchRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author stanislav.lapitsky created 7/6/2017.
 */
@Service
class CatchSearchServiceImpl:CatchSearchService {
    val logger = LoggerFactory.getLogger(CatchResultService::class.java)

    @Autowired
    lateinit var catchRepository: CatchRepository

    override fun search(filter: SearchFilter): List<CatchDto> {
        return catchRepository
                .searchByFilter(filter.latTop, filter.latBottom)
                .map { item -> CatchDto.Mapper.from(item)}
    }
}
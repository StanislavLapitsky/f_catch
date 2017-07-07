package com.fishing.catch.service

import com.fishing.catch.dto.CatchDto
import com.fishing.catch.dto.filter.SearchFilter

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
interface CatchSearchService {
    fun search(filter: SearchFilter):List<CatchDto>
}
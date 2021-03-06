package com.fishing.catch.service

import com.fishing.catch.dto.CatchDto

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
interface CatchResultService {
    fun add(catch: CatchDto)
    fun list():List<CatchDto>
}
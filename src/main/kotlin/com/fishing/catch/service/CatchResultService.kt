package com.fishing.catch.service

import com.fishing.catch.entity.CatchEntity

/**
 * @author stanislav.lapitsky created 6/30/2017.
 */
interface CatchResultService {
    fun add(catchEntity: CatchEntity)
    fun list():List<CatchEntity>
}
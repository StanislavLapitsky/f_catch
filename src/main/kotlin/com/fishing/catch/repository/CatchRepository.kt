package com.fishing.catch.repository

import com.fishing.catch.entity.CatchEntity
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */
interface CatchRepository:MongoRepository<CatchEntity, String> {

}
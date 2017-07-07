package com.fishing.catch.repository

import com.fishing.catch.dto.filter.SearchFilter
import com.fishing.catch.entity.CatchEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */
interface CatchRepository:MongoRepository<CatchEntity, String> {
    @Query("{'locationInfo.lat':{'\$lt':?0}, " +
            "'\$and':[{'locationInfo.lat':{'\$gt':?1}}," +
            "         {'locationInfo.lon':{'\$lt':?2}}," +
            "         {'locationInfo.lon':{'\$gt':?3}}," +
            "         {'date':{'\$gt':?4}}," +
            "         {'date':{'\$lt':?5}}]}")
    fun searchByFilter(latTop:Double,
                       latBottom:Double,
                       lonTop:Double,
                       lonBottom:Double,
                       startDate:Long,
                       endDate:Long):List<CatchEntity>
}
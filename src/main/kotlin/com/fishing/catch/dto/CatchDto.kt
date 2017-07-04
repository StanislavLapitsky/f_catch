package com.fishing.catch.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fishing.catch.entity.CatchEntity
import com.fishing.catch.entity.CatchResult
import com.fishing.catch.entity.LocationInfo
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

/**
 * @author stanislav.lapitsky created 7/4/2017.
 */
data class CatchDto (
    @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd") @Field val date: Date = Date(),
    @Field val locationInfo: LocationInfo = LocationInfo(0.0,0.0, null),
    @Field val result: CatchResult = CatchResult(0.0, null),
    @Field val image: Array<Byte>? = null,
    @Field val tackle: List<String>? = null,
    @Field val ipAddress: String? = null,
    @Field val phone: String? = null,
    @Field val login: String? = null
) {
    object Mapper {
        fun from(entity: CatchEntity) =
                CatchDto(date = entity.date,
                        locationInfo = entity.locationInfo,
                        result = entity.result,
                        image = entity.image,
                        tackle = entity.tackle,
                        ipAddress = entity.ipAddress,
                        phone = entity.phone,
                        login = entity.login
                        )
    }
}
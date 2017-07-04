package com.fishing.catch.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.fishing.catch.dto.CatchDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */
@Document(collection = "catch-result")
data class CatchEntity (
        @Id val id: String? = null,
        @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd") @Field val date: Date = Date(),
        @Field val locationInfo: LocationInfo = LocationInfo(0.0,0.0, null),
        @Field val result: CatchResult = CatchResult(0.0, null),
        @Field val image: Array<Byte>? = null,
        @Field val tackle: List<String>? = null,
        @Field val ipAddress: String? = null,
        @Field val phone: String? = null,
        @Field val login: String? = null
)
{
    object Mapper {
        fun from(dto: CatchDto) =
                CatchEntity(date = dto.date,
                        locationInfo = dto.locationInfo,
                        result = dto.result,
                        image = dto.image,
                        tackle = dto.tackle,
                        ipAddress = dto.ipAddress,
                        phone = dto.phone,
                        login = dto.login
                )
    }
}
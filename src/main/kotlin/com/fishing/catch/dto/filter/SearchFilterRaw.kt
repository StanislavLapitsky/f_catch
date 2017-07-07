package com.fishing.catch.dto.filter

import org.hibernate.validator.constraints.Range
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * @author stanislav.lapitsky created 7/6/2017.
 */
const val DEFAULT_INTERVAL_DAYS:Long = 14
data class SearchFilterRaw(
        @Range(max = 90, min = -90)
        @Field var lat:Double? = null,
        @Range(max = 180, min = -180)
        @Field var lon:Double? = null,
        @Field var ip:String? = null,
        @Field var startDate: Long? = null,
        @Field var endDate: Long? = null
) {
    fun validFilter():SearchFilter {
        val startDate = if (this.startDate!=null)
                             this.startDate!!
                        else
                             LocalDateTime.now().minusDays(DEFAULT_INTERVAL_DAYS).toEpochSecond(ZoneOffset.UTC)
        val endDate = if (this.endDate!=null)
                             this.endDate!!
                        else
                             LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)

        val latTop:Double = if (this.lat!=null) this.lat!! + 1 else 1.0
        val latBottom:Double = if (this.lat!=null) this.lat!! - 1 else -1.0
        val lonTop:Double = if (this.lon!=null) this.lon!! + 1 else 1.0
        val lonBottom:Double = if (this.lon!=null) this.lon!! - 1 else -1.0

        return SearchFilter(latTop, latBottom, lonTop, lonBottom, startDate, endDate)
    }
}
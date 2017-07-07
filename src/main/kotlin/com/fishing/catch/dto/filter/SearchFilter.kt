package com.fishing.catch.dto.filter

import java.time.LocalDateTime

/**
 * @author stanislav.lapitsky created 7/6/2017.
 */
data class SearchFilter(
        val latTop:Double,
        val latBottom:Double,
        val lonTop:Double,
        val lonBottom:Double,
        val startDate: Long,
        val endDate: Long
) {
}
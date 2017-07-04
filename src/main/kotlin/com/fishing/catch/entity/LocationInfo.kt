package com.fishing.catch.entity

import com.fasterxml.jackson.annotation.JsonCreator

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */

data class LocationInfo (val lat:Double = 0.0, val lon:Double = 0.0, val address:String?)
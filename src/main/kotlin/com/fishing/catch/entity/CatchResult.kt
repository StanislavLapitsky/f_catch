package com.fishing.catch.entity

/**
 * @author stanislav.lapitsky created 6/29/2017.
 */
data class CatchResult(val weight:Double, val fishes: List<Pair<String, Int>>?) {
}
package com.apps.restaurantsapp2.rickandmorty.datamodel

import com.google.gson.annotations.SerializedName

data class CharacterList(
    val results: List<Character>,
    val info: PageInfo
)

data class PageInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)
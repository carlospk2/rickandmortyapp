package com.apps.restaurantsapp2.rickandmorty

import com.apps.restaurantsapp2.rickandmorty.datamodel.CharacterList
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    fun getCharacters(@Query("page") page: Int): Call<CharacterList>

}

data class CharacterResponse(
    @SerializedName("results") val results: List<Character>
)

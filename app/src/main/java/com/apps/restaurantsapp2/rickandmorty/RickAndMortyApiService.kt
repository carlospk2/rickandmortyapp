package com.apps.restaurantsapp2.rickandmorty

import com.apps.restaurantsapp2.rickandmorty.datamodel.CharacterList
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    fun getCharacters(): Call<CharacterList>
}

data class CharacterResponse(
    @SerializedName("results") val results: List<Character>
)

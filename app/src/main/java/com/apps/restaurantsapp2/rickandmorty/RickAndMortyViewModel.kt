package com.apps.restaurantsapp2.rickandmorty

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apps.restaurantsapp2.rickandmorty.datamodel.Character
import com.apps.restaurantsapp2.rickandmorty.datamodel.CharacterList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyViewModel: ViewModel() {

    private var apiInterface: RickAndMortyApiService
    private lateinit var charactersCall: Call<CharacterList>
    val state = mutableStateOf(emptyList<Character>())

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
        apiInterface = retrofit.create(RickAndMortyApiService::class.java)
        getCharacters()
    }

    private fun getCharacters() {
        charactersCall = apiInterface.getCharacters()
        charactersCall.enqueue(
            object : Callback<CharacterList> {
                override fun onResponse(
                    call: Call<CharacterList>,
                    response: Response<CharacterList>
                ) {
                    response.body()?.let { characterList ->
                        state.value = characterList.results
                    }
                }

                override fun onFailure(call: Call<CharacterList>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }



    override fun onCleared() {
        super.onCleared()
        charactersCall.cancel()
    }

}

package com.apps.restaurantsapp2.rickandmorty.api

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyViewModel: ViewModel() {

    private var apiInterface: RickAndMortyApiService
    private lateinit var charactersCall: Call<CharacterList>
    val state = mutableStateOf(emptyList<Character>())

    //Pagination
    var currentPage = mutableStateOf(1)
    var maxPages = mutableStateOf(1)

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
        apiInterface = retrofit.create(RickAndMortyApiService::class.java)
        getCharacters(currentPage.value)
    }

    fun loadPreviousPage() {
        getPreviousPage()?.let {
            getCharacters(it)
        }
    }

    fun loadNextPage() {
        getNextPage()?.let {
            getCharacters(it)
        }
    }

    private fun getPreviousPage(): Int? {
        val previousPage = currentPage.value - 1
        return if (previousPage in 1..maxPages.value) previousPage else null
    }

    private fun getNextPage(): Int? {
        val nextPage = currentPage.value + 1
        return if (nextPage in 1..maxPages.value) nextPage else null
    }

    fun getCharacters(page: Int) {
        charactersCall = apiInterface.getCharacters(page)
        charactersCall.enqueue(
            object : Callback<CharacterList> {
                override fun onResponse(
                    call: Call<CharacterList>,
                    response: Response<CharacterList>
                ) {
                    response.body()?.let { characterList ->
                        state.value = characterList.results
                        currentPage.value = if (page in 1..maxPages.value) page else 1
                        maxPages.value = characterList.info.pages
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

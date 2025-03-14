package com.example.scaffoldandnavigationwalkthrough.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Coffee (
    var id: Int,
    var blend_name: String,
    val origin: String,
    val variety: String,
    val notes: String,
    val intensifier: String
)

const val BASE_URL = "https://random-data-api.com/api/"

interface CoffeeApi {
    // to fetch list of coffees
    @GET("coffee/random_coffee?size=3")
    suspend fun getCoffees() : List<Coffee>

    companion object {
        var coffeeService: CoffeeApi? = null

        fun getInstance(): CoffeeApi {
            if (coffeeService === null) {
                coffeeService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(CoffeeApi::class.java)
            }
            return coffeeService!!
        }
    }
}
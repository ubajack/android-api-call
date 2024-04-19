package fr.ubalia.callapis

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

const val BASE_URL = "https://random-data-api.com/api/v2/"

private val retrofit = Retrofit.Builder()
    // .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("credit_cards")
    suspend fun getCreditCard(): CreditCard
    // suspend fun getCreditCard(): String
}

object CreditCardApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface BeerService {
    @GET("beers")
    suspend fun getBeer(): Beer
}

object BeerApi {
    val retrofitService: BeerService by lazy {
        retrofit.create(BeerService::class.java)
    }
}
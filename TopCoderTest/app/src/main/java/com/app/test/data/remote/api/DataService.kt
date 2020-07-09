package com.app.test.data.remote.api

import com.app.test.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Service to fetch data using dummy end point [API_URL].
 */
interface DataService {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    suspend fun getData(): Response<DataResponse>

    companion object {
        const val API_URL = "https://dl.dropboxusercontent.com"
    }
}
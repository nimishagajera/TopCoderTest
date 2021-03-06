package com.app.test.data.repository

import com.app.test.data.remote.api.DataService
import com.app.test.model.DataResponse
import com.app.test.model.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Singleton repository for fetching data from remote
 */
@Singleton
class
DataRepository @Inject constructor(private val dataService: DataService) {

    /**
     * Fetched the data from network and show
     */
     fun getAllData(): Flow<State<DataResponse>> {
         return object : NetworkBoundRepository<DataResponse>() {
             override suspend fun fetchFromRemote(): Response<DataResponse> = dataService.getData()

         }.asFlow().flowOn(Dispatchers.IO)
     }
}
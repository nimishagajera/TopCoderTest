package com.app.test.data.repository

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.app.test.model.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

/**
 * A repository which provides resource from local database as well as remote end point.
 *
 * [RESULT] represents the type for database.
 * [REQUEST] represents the type for network.
 */
@ExperimentalCoroutinesApi
abstract class NetworkBoundRepository<REQUEST> {

    fun asFlow() = flow<State<REQUEST>> {

        // Emit Loading State
        emit(State.loading())

        try {
            // Fetch latest data from remote
            val apiResponse = fetchFromRemote()

            // Parse body
            val remotePosts = apiResponse.body()

            // Check for response validation
            if (apiResponse.isSuccessful && remotePosts != null) {
                //show data to user
                emit(State.success(apiResponse.body()!!))
            } else {
                // Something went wrong! Emit Error state.
                emit(State.error(apiResponse.message()))
            }
        } catch (e: Exception) {
            // Exception occurred! Emit error
            emit(State.error("Network error! Can't get latest data."))
            e.printStackTrace()
        }
    }

    /**
     * Fetches [Response] from the remote end point.
     */
    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>
}

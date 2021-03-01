package com.app.unit.unitsa.api.wrappers

import com.app.unit.unitsa.api.dto.DTOWithPagination
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response
import timber.log.Timber

@Suppress("UNCHECKED_CAST")
class ProcessCallResponse<T> {

    suspend fun processCall(response: Response<*>): Resource<DTOWithPagination<T>> {
        return withContext(Dispatchers.IO) {
            try {
                val responseCode = response.code()
                val errorResponse = response.errorBody()

                if (response.isSuccessful) {
                    val body = response.body() as BaseResponseWrapper<*>
                    val data = body.data
                    if (body.status == true && data != null) {
                        Resource.Success(data = DTOWithPagination(body.data as T, body.pagination))
                    } else {
                        Resource.DataError(errorCode = body.message)
                    }
                } else {
                    val jsonObj = JSONObject(errorResponse!!.charStream().readText())
                    Timber.d(jsonObj.toString())
                    Resource.DataError(errorCode = jsonObj.getString("message"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Resource.DataError(errorCode = "Something went wrong")
            }
        }
    }
}
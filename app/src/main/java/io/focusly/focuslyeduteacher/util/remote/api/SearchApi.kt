package io.focusly.focuslyeduteacher.util.remote.api

import io.focusly.focuslyedu.data.remote.search.SearchListResponse
import io.focusly.focuslyeduteacher.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchApi {
    @Headers(
        "X-Naver-Client-Id:${BuildConfig.CLIENT_ID}",
        "X-Naver-Client-Secret:${BuildConfig.SECRET_ID}"
    )
    @GET("search/webkr.json")
    fun call(
        @Query("query") query:String,
        @Query("start") start:Long,
        @Query("display") display:Int = 10,
        @Query("sort") sort:String = "sim"
    ): Call<SearchListResponse>
}
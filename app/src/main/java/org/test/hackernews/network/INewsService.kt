package org.test.hackernews.network

import io.reactivex.Observable
import org.test.hackernews.models.NewsResponse
import retrofit2.http.GET

interface INewsService {
    @GET("search_by_date?query=android")
    fun getHackerNews(): Observable<NewsResponse>
}
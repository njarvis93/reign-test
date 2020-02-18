package org.test.hackernews.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import org.test.hackernews.network.INewsService
import org.test.hackernews.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.Moshi
import org.test.hackernews.models.NewsResponse


@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {
    /**
     * Provides the Hacker News service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the News service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideNewsService(retrofit: Retrofit): INewsService {
        return retrofit.create(INewsService::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        val moshi:Moshi = Moshi.Builder().build()
        //moshi.adapter(NewsResponse::class.java).toJson(NewsResponse())
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}
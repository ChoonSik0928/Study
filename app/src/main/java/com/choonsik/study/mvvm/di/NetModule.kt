package com.choonsik.study.mvvm.di

import com.choonsik.study.BuildConfig
import com.choonsik.study.mvvm.data.network.BreedService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetModule {

    private const val BASE_URL = "https://catfact.ninja/"

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideOkHttpBuilder(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient().newBuilder()
            .addInterceptor(httpLoggingInterceptor)

    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

    @Provides
    fun provideBreedService(
        okHttpClientBuilder: OkHttpClient.Builder
    ): BreedService {
//        okHttpClientBuilder.addInterceptor(HeaderInterceptor())
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BreedService::class.java)
    }
}
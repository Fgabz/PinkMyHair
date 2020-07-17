package com.pinkmyhair.service

import com.pinkmyhair.annotation.PerApp
import com.pinkmyhair.repository.service.IRemoteAvatarUploadService
import com.pinkmyhair.service.api.IPictureUploadWebService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module(includes = [RemoteModule.AbstractionModule::class])
class RemoteModule {

    @Module
    abstract class AbstractionModule {
        @Binds
        abstract fun provideRemoteAvatarUploadService(remoteGithubService: RemoteAvatarUploadService): IRemoteAvatarUploadService
    }

    @PerApp
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @PerApp
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(12, TimeUnit.SECONDS)

        httpClient
            .addInterceptor(loggingInterceptor)

        return httpClient.build()
    }

    @PerApp
    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://interview.photoroom.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @PerApp
    @Provides
    fun providesRemotePictureWebService(retrofit: Retrofit): IPictureUploadWebService {
        return retrofit.create(IPictureUploadWebService::class.java)
    }
}

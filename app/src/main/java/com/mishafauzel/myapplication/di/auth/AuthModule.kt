package com.mishafauzel.myapplication.di.auth

import com.mishafauzel.myapplication.api.auth.OpenApiAuthService
import com.mishafauzel.myapplication.persistence.AccountPropertiesDao
import com.mishafauzel.myapplication.persistence.AuthTokenDao
import com.mishafauzel.myapplication.repository.auth.AuthRepository
import com.mishafauzel.myapplication.seesion.SessionManager
import com.mishafauzel.myapplication.util.LiveDataCallAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class AuthModule {

    // TEMPORARY
    @AuthScope
    @Provides
    fun provideFakeApiService(retrofitBuilder:Retrofit.Builder): OpenApiAuthService{
        return retrofitBuilder.build()
            .create(OpenApiAuthService::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager
        )
    }





}
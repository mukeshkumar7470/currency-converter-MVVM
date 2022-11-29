package com.mukesh.currency.di

import android.content.Context
import com.mukesh.currency.data.dao.CurrencyDao
import com.mukesh.currency.data.dao.ExchangeRateDao
import com.mukesh.currency.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * this class describes how hilt injects specific objects
 */
@InstallIn(SingletonComponent::class)
@Module
class DBModuleInjection {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }


    @Provides
    fun provideCurrencyDao(appDatabase: AppDatabase): CurrencyDao {
        return appDatabase.currencyDao()
    }


    @Provides
    fun provideExchangeRateDao(appDatabase: AppDatabase): ExchangeRateDao {
        return appDatabase.exchangeRateDao()
    }
}
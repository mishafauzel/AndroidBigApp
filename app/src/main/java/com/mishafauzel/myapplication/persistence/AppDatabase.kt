package com.mishafauzel.myapplication.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mishafauzel.myapplication.models.AccountProperties
import com.mishafauzel.myapplication.models.Token

@Database(entities = [AccountProperties::class,Token::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getAccountPropertiesDao():AccountPropertiesDao
    abstract fun getAuthTokenDao():AuthTokenDao

}
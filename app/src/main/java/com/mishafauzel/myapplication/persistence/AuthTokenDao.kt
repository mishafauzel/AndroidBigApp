package com.mishafauzel.myapplication.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mishafauzel.myapplication.models.Token

@Dao
interface AuthTokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(token:Token):Long
    @Query("SELECT * FROM auth_token WHERE account_pk=:pk")
    fun selectTokenByAccountPk(pk:Int):Token
    @Query("UPDATE auth_token SET token=null WHERE account_pk=:pk")
    fun nullifyToken(pk:Int):Int

}
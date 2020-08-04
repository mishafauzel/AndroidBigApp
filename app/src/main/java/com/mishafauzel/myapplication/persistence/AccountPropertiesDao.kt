package com.mishafauzel.myapplication.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mishafauzel.myapplication.models.AccountProperties

@Dao
interface AccountPropertiesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWithIgnore(authPropertiesDao: AccountProperties):Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(authPropertiesDao: AccountProperties):Long
    @Query("SELECT * FROM account_properties WHERE email=:email")
    fun selectAccountPropertiesByEmail(email:String):AccountProperties
    @Query("SELECT * FROM account_properties WHERE pk=:pk")
    fun selectAccountByPk(pk:Int):LiveData<AccountProperties>


}
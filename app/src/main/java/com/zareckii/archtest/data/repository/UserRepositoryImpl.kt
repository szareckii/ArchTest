package com.zareckii.archtest.data.repository

import android.content.Context
import com.zareckii.archtest.domain.models.SaveUserNameParam
import com.zareckii.archtest.domain.models.UserName
import com.zareckii.archtest.domain.repository.UserRepository

class UserRepositoryImpl(private val context: Context) : UserRepository {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.firstName).apply()
        return true
    }

    override fun getNane(): UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME


        return UserName(firstName = firstName, lastName = lastName)

    }

    companion object {
        private const val SHARED_PREFS_NAME = "shared_pref_name"
        private const val KEY_FIRST_NAME = "firstName"
        private const val KEY_LAST_NAME = "lastName"
        private const val DEFAULT_LAST_NAME = "Default last name"

    }
}
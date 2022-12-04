package com.zareckii.archtest.data.repository

import com.zareckii.archtest.data.storage.UserStorage
import com.zareckii.archtest.data.storage.models.User
import com.zareckii.archtest.domain.models.SaveUserNameParam
import com.zareckii.archtest.domain.models.UserName
import com.zareckii.archtest.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getNane(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam) : User {
        return User(saveParam.firstName, saveParam.lastName)
    }

    private fun mapToDomain(user: User) : UserName {
        return UserName(user.firstName, user.lastName)
    }
}
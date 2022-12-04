package com.zareckii.archtest.data.storage

import com.zareckii.archtest.data.storage.models.User

interface UserStorage {

    fun get() : User

    fun save(user: User) : Boolean
}
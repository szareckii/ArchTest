package com.zareckii.archtest.domain.repository

import com.zareckii.archtest.domain.models.SaveUserNameParam
import com.zareckii.archtest.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getNane(): UserName
}
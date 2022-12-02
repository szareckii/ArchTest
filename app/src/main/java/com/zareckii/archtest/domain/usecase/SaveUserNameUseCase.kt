package com.zareckii.archtest.domain.usecase

import com.zareckii.archtest.domain.models.SaveUserNameParam
import com.zareckii.archtest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getNane()
        if (oldUserName.firstName == param.firstName)
            return true
        return userRepository.saveName(saveParam = param)
    }
}
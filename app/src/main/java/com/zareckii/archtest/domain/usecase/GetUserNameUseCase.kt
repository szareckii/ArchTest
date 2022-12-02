package com.zareckii.archtest.domain.usecase

import com.zareckii.archtest.domain.models.UserName
import com.zareckii.archtest.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getNane()
    }
}
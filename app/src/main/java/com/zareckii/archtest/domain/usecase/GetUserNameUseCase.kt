package com.zareckii.archtest.domain.usecase

import com.zareckii.archtest.domain.models.UserName

class GetUserNameUseCase() {

    fun execute(): UserName {
        return UserName(firstName = "Stas", lastName = "Zareckii")
    }
}
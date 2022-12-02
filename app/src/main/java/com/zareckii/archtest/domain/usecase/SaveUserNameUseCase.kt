package com.zareckii.archtest.domain.usecase

import com.zareckii.archtest.domain.models.SaveUserNameParam

class SaveUserNameUseCase() {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.firstName.isNotEmpty()
    }
}
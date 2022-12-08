package com.zareckii.archtest.di

import com.zareckii.archtest.domain.usecase.GetUserNameUseCase
import com.zareckii.archtest.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}
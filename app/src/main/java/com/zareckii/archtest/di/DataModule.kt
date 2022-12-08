package com.zareckii.archtest.di

import com.zareckii.archtest.data.repository.UserRepositoryImpl
import com.zareckii.archtest.data.storage.UserStorage
import com.zareckii.archtest.data.storage.sharedpref.SharedPrefUserStorage
import com.zareckii.archtest.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}
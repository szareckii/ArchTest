package com.zareckii.archtest.di

import android.content.Context
import com.zareckii.archtest.data.repository.UserRepositoryImpl
import com.zareckii.archtest.data.storage.UserStorage
import com.zareckii.archtest.data.storage.sharedpref.SharedPrefUserStorage
import com.zareckii.archtest.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}
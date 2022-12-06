package com.zareckii.archtest.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zareckii.archtest.data.repository.UserRepositoryImpl
import com.zareckii.archtest.data.storage.sharedpref.SharedPrefUserStorage
import com.zareckii.archtest.domain.usecase.GetUserNameUseCase
import com.zareckii.archtest.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }
}
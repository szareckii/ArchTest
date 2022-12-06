package com.zareckii.archtest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zareckii.archtest.domain.models.SaveUserNameParam
import com.zareckii.archtest.domain.usecase.GetUserNameUseCase
import com.zareckii.archtest.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase,
    ) : ViewModel() {

    private val userLiveMutable = MutableLiveData<String>()
    val userLive: LiveData<String> = userLiveMutable

    fun getUser() {
        val user = getUserNameUseCase.execute()
        userLiveMutable.value = "${user.firstName} ${user.lastName}"
    }

    fun saveUser(text: String) {
        val params = SaveUserNameParam(firstName = text, lastName = "Zar")
        val result = saveUserNameUseCase.execute(param = params)
        userLiveMutable.value = "Save result = $result"
    }
}
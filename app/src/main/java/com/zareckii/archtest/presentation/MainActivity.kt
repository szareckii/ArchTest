package com.zareckii.archtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.zareckii.archtest.R
import com.zareckii.archtest.data.repository.UserRepositoryImpl
import com.zareckii.archtest.data.storage.sharedpref.SharedPrefUserStorage
import com.zareckii.archtest.domain.models.SaveUserNameParam
import com.zareckii.archtest.domain.usecase.GetUserNameUseCase
import com.zareckii.archtest.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val sharedPrefUserStorage by lazy { SharedPrefUserStorage(context = applicationContext) }
    private val userRepository by lazy { UserRepositoryImpl(userStorage = sharedPrefUserStorage) }
    private val getUserNameUseCase by lazy {  GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy {  SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditView)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(firstName = text, lastName = "Zar")
            val result = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

    }
}
package com.nzwa.storyapp.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nzwa.storyapp.response.LoginResponse
import com.nzwa.storyapp.data.database.StoryRepository
import com.nzwa.storyapp.data.di.Event
import com.nzwa.storyapp.data.preferences.SessionModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: StoryRepository) : ViewModel() {
    val loginResponse: LiveData<LoginResponse> = repository.loginResponse
    val toastText: LiveData<Event<String>> = repository.toastText

    fun postLogin(email: String, password: String) {
        viewModelScope.launch {
            repository.postLogin(email, password)
        }
    }

    fun saveSession(session: SessionModel) {
        viewModelScope.launch {
            repository.saveSession(session)
        }
    }

    fun login() {
        viewModelScope.launch {
            repository.login()
        }
    }
}
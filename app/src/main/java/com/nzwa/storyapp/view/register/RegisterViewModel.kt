package com.nzwa.storyapp.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nzwa.storyapp.data.database.StoryRepository
import com.nzwa.storyapp.response.RegisterResponse
import com.nzwa.storyapp.data.di.Event
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: StoryRepository) : ViewModel() {
    val registerResponse: LiveData<RegisterResponse> = repository.registerResponse
    val toastText: LiveData<Event<String>> = repository.toastText

    fun postRegister(name: String, email: String, password: String) {
        viewModelScope.launch {
            repository.postRegister(name, email, password)
        }
    }
}
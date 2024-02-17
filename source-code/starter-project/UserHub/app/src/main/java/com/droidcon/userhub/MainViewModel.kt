package com.droidcon.userhub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.data.UserRepository
import com.droidcon.data.api.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch {
        _users.value = repository.getUsers()
    }
}
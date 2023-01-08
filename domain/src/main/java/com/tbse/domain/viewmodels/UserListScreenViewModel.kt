package com.tbse.domain.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbse.domain.use_case.UserListScreenUseCase
import com.tbse.service.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by toddsmith on 1/7/23.
 */
@HiltViewModel
class UserListScreenViewModel @Inject constructor(
    private val userListScreenUseCase: UserListScreenUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<UserListScreenState>(UserListScreenState.Loading)
    val stateFlow: StateFlow<UserListScreenState>
        get() = _stateFlow.asStateFlow()

    fun getUsers() {
        userListScreenUseCase().onEach { result ->
            _stateFlow.emit(
                when (result) {
                    is Resource.Loading -> UserListScreenState.Loading
                    is Resource.Success -> {
                        when (val data = result.data) {
                            null -> UserListScreenState.Error("Data error")
                            else -> UserListScreenState.ReceivedUserList(data)
                        }
                    }
                    is Resource.Error -> UserListScreenState.Error(error = result.message ?: "No error msg")
                }
            )
        }.launchIn(viewModelScope)
    }

}
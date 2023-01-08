package com.tbse.randomuserslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.tbse.domain.viewmodels.UserListScreenState
import com.tbse.domain.viewmodels.UserListScreenViewModel
import com.tbse.randomuserslist.ui.theme.RandomUsersTheme
import com.tbse.ui.user_list.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<UserListScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val uiState = viewModel.stateFlow.collectAsState()

            RandomUsersTheme {
                when (val value = uiState.value) {
                    is UserListScreenState.Error -> Text(
                        text = value.error
                    )
                    UserListScreenState.Loading -> Text(
                        text = "Loading..."
                    )
                    is UserListScreenState.ReceivedUserList -> {
                        UserListScreen(
                            value.users
                        )
                    }
                }
            }

        }

        viewModel.getUsers()
    }
}

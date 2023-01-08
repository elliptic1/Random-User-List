package com.tbse.domain.viewmodels

import com.tbse.domain.models.UserInfo
import com.tbse.domain.models.UsersDomain

/**
 * Created by toddsmith on 1/7/23.
 */
sealed class UserListScreenState {
    object Loading : UserListScreenState()

    data class ReceivedUserList(
        val users: UsersDomain
    ) : UserListScreenState()

    data class Error(
        val error: String
    ) : UserListScreenState()
}

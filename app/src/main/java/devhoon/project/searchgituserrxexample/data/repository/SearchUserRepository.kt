package devhoon.project.searchgituserrxexample.data.repository

import devhoon.project.searchgituserrxexample.data.response.SearchUsersResponse
import io.reactivex.rxjava3.core.Single

interface SearchUserRepository {
    fun searchUsers(
        searchUserId: String
    ): Single<SearchUsersResponse>

    fun loadMore(
        searchUserId: String,
        page: Int
    ): Single<SearchUsersResponse>
}
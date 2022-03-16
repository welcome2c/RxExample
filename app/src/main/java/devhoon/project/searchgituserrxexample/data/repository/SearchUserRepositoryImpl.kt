package devhoon.project.searchgituserrxexample.data.repository

import devhoon.project.searchgituserrxexample.data.GitHubApi
import devhoon.project.searchgituserrxexample.data.response.SearchUsersResponse
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.flow

class SearchUserRepositoryImpl(
    private val gitHubApi: GitHubApi
): SearchUserRepository {
    override fun searchUsers(searchUserId: String): Single<SearchUsersResponse> {
        return gitHubApi.getUserList(searchUserId, 1)
    }

    override fun loadMore(searchUserId: String, page: Int): Single<SearchUsersResponse> {
        return gitHubApi.getUserList(searchUserId, page)
    }
}
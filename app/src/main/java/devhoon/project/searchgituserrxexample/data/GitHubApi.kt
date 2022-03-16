package devhoon.project.searchgituserrxexample.data

import devhoon.project.searchgituserrxexample.data.response.SearchUsersResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("users")
    fun getUserList(
        @Query("q") id: String,
        @Query("page") page: Int
    ): Single<SearchUsersResponse>

    companion object {
        const val BASE_URL = "https://api.github.com/search/"
    }
}
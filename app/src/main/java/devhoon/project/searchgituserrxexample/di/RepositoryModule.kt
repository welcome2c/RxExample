package devhoon.project.searchgituserrxexample.di

import devhoon.project.searchgituserrxexample.data.repository.SearchUserRepository
import devhoon.project.searchgituserrxexample.data.repository.SearchUserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchUserRepository> { SearchUserRepositoryImpl(get()) }
}
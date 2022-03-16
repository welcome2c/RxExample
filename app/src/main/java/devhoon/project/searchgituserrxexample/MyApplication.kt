package devhoon.project.searchgituserrxexample

import android.app.Application
import org.koin.core.context.startKoin
import devhoon.project.searchgituserrxexample.di.githubApiModule
import devhoon.project.searchgituserrxexample.di.repositoryModule
import devhoon.project.searchgituserrxexample.di.viewModelModule

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    githubApiModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}
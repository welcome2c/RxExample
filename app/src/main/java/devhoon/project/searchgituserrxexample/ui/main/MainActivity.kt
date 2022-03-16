package devhoon.project.searchgituserrxexample.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import devhoon.project.searchgituser.ui.custom.CustomItemDecoration
import devhoon.project.searchgituserrxexample.ui.base.BaseActivity
import devhoon.project.searchgituserrxexample.R
import devhoon.project.searchgituserrxexample.databinding.ActivityMainBinding
import devhoon.project.searchgituserrxexample.ext.doOnQueryTextSubmit
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding {
            mainVm = mainViewModel
            searchView.doOnQueryTextSubmit(
                onSubmit = { query ->
                    mainViewModel.searchUsers(query)
                    searchView.clearFocus()
                }
            )
            rvUserList.apply {
                adapter = UserListAdapter()
                addItemDecoration(CustomItemDecoration())
                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        if (!canScrollVertically(1)) {
                            mainViewModel.loadMore()
                        }
                    }
                })
            }
        }

        observing {
            errorMsg.observe(this@MainActivity) { msg ->
                showErrorMsg(msg)
            }
        }
    }

    private fun observing(action: MainViewModel.() -> Unit) {
        mainViewModel.run(action)
    }
}
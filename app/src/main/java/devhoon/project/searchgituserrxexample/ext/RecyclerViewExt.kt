package devhoon.project.searchgituserrxexample.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import devhoon.project.searchgituserrxexample.ui.model.SearchResult
import devhoon.project.searchgituserrxexample.ui.main.UserListAdapter

@BindingAdapter("android:setItems")
fun <T> RecyclerView.setItems(items: List<T>?) {
    items?.let {
        when (adapter) {
            is UserListAdapter -> {
                (adapter as UserListAdapter).submitList(items as List<SearchResult>)
            }
        }
    }
}
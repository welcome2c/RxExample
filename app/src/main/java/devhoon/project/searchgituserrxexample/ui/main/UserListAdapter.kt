package devhoon.project.searchgituserrxexample.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import devhoon.project.searchgituser.ui.base.BaseViewHolder
import devhoon.project.searchgituserrxexample.BR
import devhoon.project.searchgituserrxexample.R
import devhoon.project.searchgituserrxexample.databinding.ItemUserListBinding
import devhoon.project.searchgituserrxexample.ui.model.SearchResult

class UserListAdapter: ListAdapter<SearchResult, UserListAdapter.UserListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            BR.item,
            parent,
            R.layout.item_user_list
        )
    }

    override fun getItemViewType(position: Int) = position

    override fun submitList(list: List<SearchResult>?) {
        super.submitList(list?.let { ArrayList(list) })
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    inner class UserListViewHolder(
        itemId: Int,
        parent: ViewGroup,
        layoutRes: Int
    ) : BaseViewHolder<SearchResult, ItemUserListBinding>(itemId, parent, layoutRes)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SearchResult>() {
            override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
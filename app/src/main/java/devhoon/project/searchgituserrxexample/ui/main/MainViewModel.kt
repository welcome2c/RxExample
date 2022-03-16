package devhoon.project.searchgituserrxexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devhoon.project.searchgituserrxexample.data.repository.SearchUserRepository
import devhoon.project.searchgituserrxexample.data.response.toPresentation
import devhoon.project.searchgituserrxexample.ui.base.BaseViewModel
import devhoon.project.searchgituserrxexample.ui.model.SearchResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Job

class MainViewModel(
    private val searchUserRepository: SearchUserRepository
) : BaseViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    private val _userList = MutableLiveData<MutableList<SearchResult>>()
    val userList: LiveData<MutableList<SearchResult>> = _userList

    private var beforeQuery = ""
    private var page = 1

    fun searchUsers(searchId: String) {
        if (beforeQuery != searchId) {
            _isLoading.value = true
            beforeQuery = searchId

            addDisposable(
                searchUserRepository.searchUsers(searchId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        _userList.value = response.items.toPresentation()
                        _isLoading.value = false
                    }, { e ->
                        beforeQuery = ""
                        _errorMsg.value = e.toString()
                        _isLoading.value = false
                    })
            )
        }
    }

    fun loadMore() {
        _isLoading.value = true
        page += 1
        addDisposable(
            searchUserRepository.loadMore(beforeQuery, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    _userList.value = _userList.value?.apply {
                        addAll(response.items.toPresentation())
                    }
                    _isLoading.value = false
                }, { e ->
                    beforeQuery = ""
                    _errorMsg.value = e.toString()
                    _isLoading.value = false
                })
        )
    }
}
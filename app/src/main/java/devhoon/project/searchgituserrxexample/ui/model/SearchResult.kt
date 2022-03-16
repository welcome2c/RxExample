package devhoon.project.searchgituserrxexample.ui.model

data class SearchResult(
    val id: Int,
    val userid: String,
    val imgUrl: String,
    var isFavorite: Boolean = false
)
package devhoon.project.searchgituserrxexample.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import devhoon.project.searchgituserrxexample.util.GlideUtil

@BindingAdapter("android:setProfileImageCircle")
fun ImageView.setProfileImageCircle(url: String) {
    GlideUtil.loadImageTransferCircle(this, url)
}

@BindingAdapter("android:setFavoriteSelected")
fun ImageView.setFavoriteSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}
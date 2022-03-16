package devhoon.project.searchgituserrxexample.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<B: ViewDataBinding>(
    private val layoutRes: Int
): AppCompatActivity() {

    private lateinit var dataBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        dataBinding.lifecycleOwner = this
    }

    protected fun binding(action: B.() -> Unit) {
        dataBinding.run(action)
    }

    protected fun showErrorMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
package com.xd.ihsan.coffee.view.activities.login

import androidx.lifecycle.ViewModelProvider
import com.xd.ihsan.coffee.BR
import com.xd.ihsan.coffee.R
import com.xd.ihsan.coffee.databinding.ActivityLoginBinding
import com.xd.ihsan.coffee.view.base.BaseActivity
import com.xd.ihsan.core.utils.extentions.safeGet
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    private val loginViewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory).get(LoginViewModel::class.java)
    }
    override val viewModel: Class<LoginViewModel> = LoginViewModel::class.java

    override fun getBindingVariable() =BR.viewModel

    override val layoutId = R.layout.activity_login

    override fun initUserInterface() {
        btn_masuk.setOnClickListener {
            loginViewModel.check(et_pin, this)
        }
    }

}
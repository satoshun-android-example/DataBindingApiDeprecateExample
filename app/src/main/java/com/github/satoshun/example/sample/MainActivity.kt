package com.github.satoshun.example.sample

import android.content.Context
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.satoshun.example.sample.databinding.MainAct2Binding
import com.github.satoshun.example.sample.databinding.MainActBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {
  @Inject lateinit var okOk: OkOk
  @Inject lateinit var resource: UserResource

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<MainActBinding>(this, R.layout.main_act)
    binding.model = Model("TEST")

    DataBindingUtil.setContentView<MainAct2Binding>(this, R.layout.main_act2)
  }
}

@ActivityScope
class UserResource @Inject constructor(private val context: Context)

data class Model(val userName: String)
data class Model2(val userName: String)

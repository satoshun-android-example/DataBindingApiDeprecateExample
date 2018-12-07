package com.github.satoshun.example.sample

import android.content.Context
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.satoshun.example.sample.databinding.MainActBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {
  @Inject lateinit var resource: UserResource

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<MainActBinding>(this, R.layout.main_act)
  }
}

@ActivityScope
class UserResource @Inject constructor(private val context: Context)

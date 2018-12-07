package com.github.satoshun.example.sample.module

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.satoshun.example.test.R
import com.github.satoshun.example.test.databinding.Module1Binding

fun test(inflater: LayoutInflater, parent: ViewGroup) {
  DataBindingUtil.inflate<Module1Binding>(inflater, R.layout.module1, parent, false)
}

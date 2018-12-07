package com.github.satoshun.example.sample

import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    InjectorsModule::class
  ]
)
interface AppComponent : AndroidInjector<App> {
  @dagger.Component.Builder
  abstract class Builder : AndroidInjector.Builder<App>()
}

@Module
interface InjectorsModule {
  @ActivityScope
  @ContributesAndroidInjector(modules = [MainActivityBuilder::class])
  fun mainActivity(): MainActivity
}

@Module
interface MainActivityBuilder {
  @Binds
  fun bindContext(activity: MainActivity): Context
}

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

class OkOk @Inject constructor()

package com.github.satoshun.example.sample

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
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
  @ContributesAndroidInjector(modules = [MainActivityBuilder::class, MainActivityProvider::class])
  fun mainActivity(): MainActivity
}

@Module
interface MainActivityBuilder {
}

@Module
class MainActivityProvider {
  @Provides
  fun providesFoo(context: Context): UserResource {
    return UserResource(context)
  }
}

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

class OkOk @Inject constructor()

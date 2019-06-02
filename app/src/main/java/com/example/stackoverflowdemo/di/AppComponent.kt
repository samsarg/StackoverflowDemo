package com.example.stackoverflowdemo.di

import com.example.stackoverflowdemo.presentation.App
import dagger.Component
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
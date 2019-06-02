package com.example.stackoverflowdemo.di

import com.example.stackoverflowdemo.data.di.DataLayerModule
import dagger.Module
import dagger.android.AndroidInjectionModule

@Module(
    includes = [
        DataLayerModule::class,
        ViewModelModule::class,
        AppSubcomponentBindings::class,
        AndroidInjectionModule::class
    ]
)
class AppModule {
}
package com.example.stackoverflowdemo.data.di

import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        ConverterModule::class
    ]
)
class DataLayerModule {
}
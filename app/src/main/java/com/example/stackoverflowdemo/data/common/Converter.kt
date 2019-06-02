package com.example.stackoverflowdemo.data.common

interface Converter<F, T> {
    fun convert(from: F): T
}
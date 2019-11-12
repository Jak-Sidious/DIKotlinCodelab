package com.example.android.dagger.di

import com.example.android.dagger.registration.RegistrationActivity
import dagger.Component

// Definition of a Dagger component that adds info from the StorageModule to the graph
@Component(modules = [StorageModule::class])
interface AppComponent {
    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
}
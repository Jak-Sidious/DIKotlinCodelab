package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationComponent

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
// Definition of a Dagger component that adds info from the StorageModule to the graph
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {

    //factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Expose RegistrationComponent factory from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)
}


package org.test.hackernews.base

import androidx.lifecycle.ViewModel
import org.test.hackernews.injection.components.DaggerViewModelInjector
import org.test.hackernews.injection.components.ViewModelInjector
import org.test.hackernews.injection.module.NetworkModule
import org.test.hackernews.view.NewsListViewModel

abstract class BaseViewModel : ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is NewsListViewModel -> injector.inject(this)
        }
    }
}
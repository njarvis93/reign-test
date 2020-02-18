package org.test.hackernews.injection.components

import dagger.Component
import org.test.hackernews.injection.module.NetworkModule
import org.test.hackernews.view.NewsListViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified NewsListViewModel.
     * @param newsListViewModel newsListViewModel in which to inject the dependencies
     */
    fun inject(newsListViewModel: NewsListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
package com.pinkmyhair.annotation

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Provider

class DaggerViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>
) : IDaggerFactoryViewModel {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return requireNotNull(viewModelsMap[modelClass]).get() as T
    }
}
package com.pinkmyhair.annotation

import com.cleangithubviewer.annotation.PerActivity
import com.cleangithubviewer.feature.login.LoginActivity
import com.cleangithubviewer.feature.login.di.LoginModule
import com.cleangithubviewer.feature.user_repo.GitRepositoryActivity
import com.cleangithubviewer.feature.user_repo.GitRepositoryModule
import com.cleangithubviewer.feature.user_repo.listing.di.GitRepositoryListModule
import com.cleangithubviewer.feature.user_repo.repo_detail.di.RepositoryDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            LoginModule::class
        ]
    )
    abstract fun contributeHomeActivityInjector(): LoginActivity

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            GitRepositoryModule::class,
            GitRepositoryListModule.Provider::class,
            RepositoryDetailModule.Provider::class
        ]
    )
    abstract fun contributeGitRepoActivityInjector(): GitRepositoryActivity
}
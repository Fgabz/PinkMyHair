package com.pinkmyhair

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.pinkmyhair.entity.Answer
import com.pinkmyhair.entity.FailureReason
import com.pinkmyhair.feature.picturetopink.EditPhotoInteractor
import com.pinkmyhair.feature.picturetopink.IEditPhotoPresenter
import com.pinkmyhair.repository.AvatarDatasource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.InputStream

class EditPhotoInteractorTest {

    private lateinit var interactor: EditPhotoInteractor

    private val repository: AvatarDatasource = mock()
    private val presenter: IEditPhotoPresenter = mock()

    @Before
    fun setUp() {
        interactor = EditPhotoInteractor(repository, presenter)
    }

    @Test
    fun uploadAvatarTest_Success() = runBlocking {
        whenever(repository.uploadAvatar(mockInputStream)).thenReturn(Answer.Success("base64img"))
        interactor.uploadAvatar(mockInputStream)


        verify(repository).uploadAvatar(mockInputStream)
        verify(presenter).displayPicture("base64img")
    }

    @Test
    fun uploadAvatarTest_Failure() = runBlocking {
        whenever(repository.uploadAvatar(mockInputStream)).thenReturn(Answer.Failure(Throwable(), "error", FailureReason.NETWORK))
        interactor.uploadAvatar(mockInputStream)


        verify(repository).uploadAvatar(mockInputStream)
        verify(presenter).displayError()
    }

    companion object {
        val mockInputStream: InputStream = mock()

    }
}
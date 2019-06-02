package com.example.stackoverflowdemo.presentation.question

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.stackoverflowdemo.data.question.QuestionEntity
import com.example.stackoverflowdemo.data.question.QuestionRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import io.reactivex.plugins.RxJavaPlugins
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


@RunWith(MockitoJUnitRunner::class)
class QuestionViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var questionRepository: QuestionRepository

    lateinit var clazzUnderTest: QuestionViewModel

    @Before
    fun before() {
        //TODO create a rule for this
        RxJavaPlugins.setInitIoSchedulerHandler { immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }

//        RxJavaPlugins.setErrorHandler { e -> {
//
//        }}

        clazzUnderTest = QuestionViewModel(questionRepository)
    }

    @Test
    fun getInitialQuestions_loading() {
        val result = listOf(QuestionEntity(1, ":", false, 12, 12, emptyList()))
        Mockito.`when`(
            questionRepository
                .getQuestionsByTag("tag", 1)
        ).thenReturn(
            Single.just(result)
        )
        clazzUnderTest.setTag("tag")
        clazzUnderTest.getInitialQuestions(false)


        Assert.assertEquals(result, clazzUnderTest.questions.value)
    }

    private val immediate = object : Scheduler() {
        override fun scheduleDirect(run: Runnable,
                                    delay: Long, unit: TimeUnit
        ): Disposable {
            return super.scheduleDirect(run, 0, unit)
        }

        override fun createWorker(): Scheduler.Worker {
            return ExecutorScheduler.ExecutorWorker(
                Executor { it.run() })
        }
    }
}
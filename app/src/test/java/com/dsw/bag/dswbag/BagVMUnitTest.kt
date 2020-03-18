package com.dsw.bag.dswbag

import com.dsw.bag.dswbag.model.BussinesObject
import com.dsw.bag.dswbag.repository.Repository
import com.dsw.bag.dswbag.viewmodel.MainViewModel
import com.time.set.appteam.app.App
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

@ExperimentalCoroutinesApi
class BagVMUnitTest {
    private val mainThread = newSingleThreadContext("ui thread")
    private val repository = mockk<Repository>()
    private lateinit var viewModel: MainViewModel
    private val app = mockk<App>()
    @Before
    fun setUp(){
        viewModel = MainViewModel(repository)
        coEvery { repository.getBagInfo(app.cacheDir) } returns BussinesObject(null,null,null)
        Dispatchers.setMain(mainThread)
    }
    @After
    fun reset(){
        Dispatchers.resetMain()
        mainThread.close()
    }
    @Test
    fun `should_return_bag_with_successul_API_call`(){
        runBlocking {
            viewModel.bagInfo(app.cacheDir)
            Assert.assertEquals(viewModel.bussinesObject.value, null)
        }
    }

}
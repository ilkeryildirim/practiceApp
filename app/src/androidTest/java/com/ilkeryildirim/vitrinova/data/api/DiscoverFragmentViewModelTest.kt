package com.ilkeryildirim.vitrinova.data.api

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.ilkeryildirim.vitrinova.api.VitrinovaApiResult
import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel
import com.ilkeryildirim.vitrinova.ui.discover.DiscoverDataRepository
import com.ilkeryildirim.vitrinova.ui.discover.DiscoverViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class DiscoverFragmentViewModelTest {

    private lateinit var viewModel: DiscoverViewModel

    @MockK
    private lateinit var discoverRepository: DiscoverDataRepository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        viewModel = DiscoverViewModel(discoverRepository)
    }

    @Test
    fun `when get discover is called, state flow value is set`() =
        mainCoroutineRule.runBlockingTest {
            val res = VitrinovaApiResult.Success(mockk<ArrayList<DiscoverModel>>())
            coEvery { discoverRepository.getDiscoverData() } returns res
            viewModel.getDiscoverData()
            assertEquals(viewModel.uiState.value, res)
        }
}
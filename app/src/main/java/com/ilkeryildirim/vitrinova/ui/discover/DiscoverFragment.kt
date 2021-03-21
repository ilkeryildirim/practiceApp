package com.ilkeryildirim.vitrinova.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.material.snackbar.Snackbar
import com.ilkeryildirim.vitrinova.api.model.discover.*
import com.ilkeryildirim.vitrinova.api.model.discover.Collection
import com.ilkeryildirim.vitrinova.databinding.FragmentDiscoverBinding
import com.ilkeryildirim.vitrinova.ui.discover.DiscoverFragmentUIState.*
import com.ilkeryildirim.vitrinova.ui.subviews.categories.CategoriesAdapter
import com.ilkeryildirim.vitrinova.ui.subviews.collections.CollectionsAdapter
import com.ilkeryildirim.vitrinova.ui.subviews.editorShops.EditorShopsAdapter
import com.ilkeryildirim.vitrinova.ui.subviews.featured.FeaturedSliderViewPager
import com.ilkeryildirim.vitrinova.ui.subviews.products.ProductsAdapter
import com.ilkeryildirim.vitrinova.utils.ViewPagerTransformer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class DiscoverFragment : Fragment() {

    private val viewModel: DiscoverViewModel by viewModels()

    private var _binding: FragmentDiscoverBinding? = null
    private val binding get() = _binding!!

    var featuredViewPagerAdapter: FeaturedSliderViewPager? = null
    var productsAdapter: ProductsAdapter? = null
    var categoriesAdapter: CategoriesAdapter? = null
    var collectionsAdapter: CollectionsAdapter? = null
    var editorShopsAdapter: EditorShopsAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscoverBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDiscoverData()
        observeDiscoverFragmentViewState()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(binding.lifecycleOwner!!) {
            when (it) {
                true -> {
                    binding.lytContent.animate().alpha(0.0f)
                }
                false -> {
                    binding.lytContent.animate().alpha(1.0f)
                }
            }
        }
    }

    private fun observeDiscoverFragmentViewState() {
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collectLatest { state ->
                when (state) {
                    is Success -> {
                        state.discoverData.let(::initDataView)
                    }
                    is Error -> {
                        showError(state.message)
                    }
                    is Loading -> {
                        viewModel.getDiscoverData()
                    }
                    is Navigating -> {
                        navigate(destinationId = state.destinationId, bundle = state.bundle)
                    }

                    else -> Unit
                }
            }
        }
    }

    private fun getDiscoverData() {
        lifecycleScope.launchWhenCreated {
            viewModel.getDiscoverData()
        }
    }

    private fun initDataView(discoverData: ArrayList<DiscoverModel>) {
        discoverData.forEach {
            it.featured?.let { it1 -> initFeatureds(it1) }
            it.products?.let { it1 -> initProducts(it1) }
            it.categories?.let { it1 -> initCategories(it1) }
            it.collections?.let { it1 -> initCollections(it1) }
            it.shops?.let { it1 -> initEditorShops(it1) }
        }
    }

    private fun initFeatureds(featured: List<Featured>) {
        binding.vpFeatured.apply {
            featuredViewPagerAdapter?.let { viewPager ->
                viewPager.featureds = featured
                viewPager.notifyDataSetChanged()
            }.run {
                featuredViewPagerAdapter = FeaturedSliderViewPager(requireContext(), featured)
            }
            binding.tabDots.setupWithViewPager(binding.vpFeatured, true)
            binding.vpFeatured.setPageTransformer(true, ViewPagerTransformer())
            adapter = featuredViewPagerAdapter

        }
    }

    private fun initProducts(products: List<Product>) {
        binding.rvProducts.apply {
            productsAdapter?.let { productsAdapter ->
                productsAdapter.products = products
                productsAdapter.notifyDataSetChanged()
            }.run {
                productsAdapter = ProductsAdapter(products)
            }
            adapter = productsAdapter
        }
    }

    private fun initCategories(categories: List<Category>) {
        binding.rvCategories.apply {
            categoriesAdapter?.let { categoriesAdapter ->
                categoriesAdapter.categories = categories
                categoriesAdapter.notifyDataSetChanged()
            }.run {
                categoriesAdapter = CategoriesAdapter(categories)
            }
            adapter = categoriesAdapter
        }
    }

    private fun initCollections(collections: List<Collection>) {
        binding.rvCollections.apply {
            collectionsAdapter?.let { collectionsAdapter ->
                collectionsAdapter.collections = collections
                collectionsAdapter.notifyDataSetChanged()
            }.run {
                collectionsAdapter = CollectionsAdapter(collections)
            }
            adapter = collectionsAdapter
        }
    }

    private fun initEditorShops(editorShops: List<Shop>) {
        binding.rvEditorShops.apply {
            editorShopsAdapter?.let { editorShopsAdapter ->
                editorShopsAdapter.editoShops = editorShops
                editorShopsAdapter.notifyDataSetChanged()
            }.run {
                editorShopsAdapter = EditorShopsAdapter(editorShops)
            }
            onFlingListener = null
            PagerSnapHelper().attachToRecyclerView(this)
            adapter = editorShopsAdapter
        }
    }

    private fun showError(error: String) {
        Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
    }

    private fun navigate(destinationId: Int, bundle: Bundle?) {
       findNavController().navigate(
                destinationId,
                bundle
        )
    }

}

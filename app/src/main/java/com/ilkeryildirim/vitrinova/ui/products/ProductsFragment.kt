package com.ilkeryildirim.vitrinova.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel

import com.ilkeryildirim.vitrinova.api.model.discover.Product
import com.ilkeryildirim.vitrinova.databinding.FragmentProductsBinding
import com.ilkeryildirim.vitrinova.ui.subviews.products.ProductsAdapter
import com.ilkeryildirim.vitrinova.utils.Constants
import com.ilkeryildirim.vitrinova.utils.GridLayoutColumnUtil
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private val viewModel: ProductsViewModel by viewModels()

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProducts()
    }



    private fun getProducts(){
            lifecycleScope.launchWhenCreated {
                arguments?.getParcelableArrayList<DiscoverModel>(Constants.PRODUCTS_KEY)?.let { discoverData ->
                    discoverData.forEach {
                        it.products?.let { it1 -> initProducts(it1) }
                    }

                } ?: run {
                    findNavController().popBackStack()
                }
            }

    }



    private fun initProducts(products:List<Product>){

      binding.rvAllProducts.apply {
            viewModel.productsAdapter?.let {productsAdapter->
                productsAdapter.products = products
                productsAdapter.notifyDataSetChanged()
            }.run{
                viewModel.productsAdapter = ProductsAdapter(products)
            }
          val mNoOfColumns = GridLayoutColumnUtil.calculateNoOfColumns(context,180F)
          layoutManager = GridLayoutManager(context, mNoOfColumns)

            adapter = viewModel.productsAdapter
        }



    }


    private fun showError(error: String) {
        Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
    }

    private fun navigate(destinationId:Int,bundle: Bundle) {
        findNavController().navigate(
            destinationId,
                bundle
          //  bundleOf(HomeDetailFragment.PRODUCT_ID to productId)
        )
    }

}

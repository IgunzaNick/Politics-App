package com.example.ngogoyo.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngogoyo.R
import com.example.ngogoyo.adapters.NewsAdapter
import com.example.ngogoyo.ui.Views.MainActivity
import com.example.ngogoyo.ui.Views.NewsViewModel
import com.example.ngogoyo.util.Constants.Companion.QUERY_PAGE_SIZE
import com.example.ngogoyo.util.Resource
import kotlinx.android.synthetic.main.internationalnews.*
import kotlinx.android.synthetic.main.searchnewsfragment.paginationProgressBar


class Internationalnews : Fragment(R.layout.internationalnews) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
       setupRecyclerView()
       newsAdapter.setOnItemClickListener{
       val bundle = Bundle().apply{
       putSerializable("Article",it)
       }
       }
        viewModel.breakingNews.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideprogressbar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles.toList())
                        val totalPages = newsResponse.totalResults / QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.breakingNewsPage == totalPages
                    }
                }
                is Resource.Error -> {
                    hideprogressbar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")

                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }

            }

        }
    }
    private fun hideprogressbar(){
        paginationProgressBar.visibility = View.INVISIBLE
        isloading = true
    }
    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }
    var isloading = false
    var isLastPage = false
    var isScrolling = false

    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            val isNotLoadingAndNotLastPage = !isloading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeggining = firstVisibleItemPosition >= 0
            val isTotalMoreThanVisible = totalItemCount >= QUERY_PAGE_SIZE
            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeggining &&
                    isTotalMoreThanVisible && isScrolling
            if (shouldPaginate){
                viewModel.getbreakingnews("us")
                isScrolling = false
            }else{
                rvInterntionalNews.setPadding(0,0,0,0)
            }
        }
    }

    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        rvInterntionalNews.apply{
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@Internationalnews.scrollListener)
        }
    }
}


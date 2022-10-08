package com.example.ngogoyo.ui.fragments

import android.os.Bundle

import android.view.View
import android.webkit.WebViewClient

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs


import com.example.ngogoyo.R
import com.example.ngogoyo.ui.Views.MainActivity
import com.example.ngogoyo.ui.Views.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.articlefragment.*

class ArticleFragment: Fragment(R.layout.articlefragment) {

    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewModel

        fab.setOnClickListener{
            Snackbar.make(view,"Article Saved Successfully",Snackbar.LENGTH_SHORT).show()
        }
    }

}


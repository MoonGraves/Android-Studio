package com.example.ihmeprojekti


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fav.*

/**
 * A simple [Fragment] subclass.
 */
class FavFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? =
        // Inflate the layout for this fragment
         inflater.inflate(R.layout.fragment_fav, container, false)


}

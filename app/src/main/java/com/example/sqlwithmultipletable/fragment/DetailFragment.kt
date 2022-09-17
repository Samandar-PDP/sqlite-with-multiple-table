package com.example.sqlwithmultipletable.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sqlwithmultipletable.R
import com.example.sqlwithmultipletable.model.Cars

class DetailFragment : Fragment() {

    private lateinit var cars: Cars

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cars = arguments?.getSerializable("car")!! as Cars
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).text = cars.name
    }
}
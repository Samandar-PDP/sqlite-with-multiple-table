package com.example.sqlwithmultipletable.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlwithmultipletable.R
import com.example.sqlwithmultipletable.activity.MainActivity
import com.example.sqlwithmultipletable.adapter.CarAdapter
import com.example.sqlwithmultipletable.database.MyDatabase
import com.example.sqlwithmultipletable.databinding.ChangeAlertDialogBinding
import com.example.sqlwithmultipletable.databinding.CustomAlertDialogBinding
import com.example.sqlwithmultipletable.databinding.FragmentCarsBinding
import com.example.sqlwithmultipletable.databinding.PopUpMenuBinding
import com.example.sqlwithmultipletable.model.Cars
import com.example.sqlwithmultipletable.utils.OnMenuClicked
import com.example.sqlwithmultipletable.utils.snack

class CarsFragment : Fragment() {

    private var _binding: FragmentCarsBinding? = null
    private val binding get() = _binding!!
    private lateinit var carAdapter: CarAdapter
    private lateinit var myDatabase: MyDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        myDatabase = (activity as MainActivity).myDatabase
        carAdapter = CarAdapter(onMenuClicked)
        setupRv()

        carAdapter.onItemClicked = {
            val bundle = bundleOf("car" to it)
            view.findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }

        binding.fab.setOnClickListener {
            val binding = CustomAlertDialogBinding.inflate(LayoutInflater.from(requireContext()))
            val alertDialog = AlertDialog.Builder(requireContext()).create()
            alertDialog.setView(binding.root)
            binding.textSave.setOnClickListener {
                val name = binding.name.text.toString().trim()
                val color = binding.color.text.toString().trim()
                val price = binding.price.text.toString().trim()
                val brand = binding.brand.text.toString().trim()
                myDatabase.saveCar(Cars(name, brand, color, price))
                snack("Car saved successfully!")
                setupRv()
                alertDialog.dismiss()
            }
            binding.textBack.setOnClickListener {
                alertDialog.dismiss()
            }
            alertDialog.show()
        }
    }

    private fun setupRv() = binding.recyclerView.apply {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = carAdapter
        carAdapter.carList = myDatabase.getAllCars()
    }

    private val onMenuClicked = object : OnMenuClicked {
        override fun onMenuClicked(cars: Cars, pos: Int) {
           val binding = PopUpMenuBinding.inflate(LayoutInflater.from(requireContext()))
            val alertDialog = AlertDialog.Builder(requireContext()).create()
            alertDialog.setView(binding.root)
            binding.textEdit.setOnClickListener {
                alertDialog.dismiss()
                editDialog(cars)
            }
            binding.textDelete.setOnClickListener {
                AlertDialog.Builder(requireContext()).apply {
                    setMessage("Do you want to delete this car?")
                    setPositiveButton("Yes") { dialog, _ ->
                        carAdapter.notifyItemRemoved(pos)
                        myDatabase.deleteCar(cars.id)
                        snack("Successfully deleted!")
                        dialog.dismiss()
                        alertDialog.dismiss()
                        setupRv()
                    }
                    setNegativeButton("No") { di, _ ->
                        di.dismiss()
                        alertDialog.dismiss()
                    }
                }.create().show()
            }
            alertDialog.show()
        }
    }

    private fun editDialog(cars: Cars) {
        val bn = ChangeAlertDialogBinding.inflate(LayoutInflater.from(requireContext()))
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setView(bn.root)
        bn.name.setText(cars.name)
        bn.brand.setText(cars.brand)
        bn.price.setText(cars.price)
        bn.color.setText(cars.color)
        bn.textBack.setOnClickListener {
            alertDialog.dismiss()
        }
        bn.textEdit.setOnClickListener {
            val name = bn.name.text.toString().trim()
            val color = bn.color.text.toString().trim()
            val price = bn.price.text.toString().trim()
            val brand = bn.brand.text.toString().trim()
            val car = Cars(cars.id, name, brand, color, price)
            myDatabase.updateCar(car)
            alertDialog.dismiss()
            setupRv()
            snack("Successfully updated")
        }
        alertDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
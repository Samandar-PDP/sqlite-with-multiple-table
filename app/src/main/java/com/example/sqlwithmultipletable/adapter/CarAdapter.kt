package com.example.sqlwithmultipletable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlwithmultipletable.databinding.ItemLayoutBinding
import com.example.sqlwithmultipletable.model.Cars
import com.example.sqlwithmultipletable.utils.OnMenuClicked

class CarAdapter(
    private val onMenuClicked: OnMenuClicked
): RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<Cars>() {
        override fun areItemsTheSame(oldItem: Cars, newItem: Cars): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cars, newItem: Cars): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClicked: (Cars) -> Unit

    private val differ = AsyncListDiffer(this, diffCallBack)
    var carList: MutableList<Cars>
        get() = differ.currentList
    set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int = carList.size

    inner class CarViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cars: Cars) {
            binding.apply {
                textTitle.text = cars.name
                textDesc.text = cars.price

                itemView.setOnClickListener {
                    onItemClicked(cars)
                }
                binding.menuBtn.setOnClickListener {
                    onMenuClicked.onMenuClicked(cars, adapterPosition)
                }
            }
        }
    }
}
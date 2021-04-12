package com.devtides.coroutinesretrofit.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.androidcoroutinesretrofit.databinding.ItemCountryBinding
import com.devtides.androidcoroutinesretrofit.model.Country

class CountryListAdapter(private var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root)

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        with(holder) {
            binding.name.text = country.countryName
            binding.capital.text = country.capital
            binding.imageView.loadImage(country.flag)
        }
    }
}
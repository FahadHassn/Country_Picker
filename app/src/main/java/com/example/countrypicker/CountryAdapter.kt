package com.example.countrypicker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CountryAdapter(private val context: Context, private val countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: TextView = itemView.findViewById(R.id.imageViewFlag)
        val nameTextView: TextView = itemView.findViewById(R.id.textViewCountryName)
        val codeTextView: TextView = itemView.findViewById(R.id.textViewCountryCode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recyecler_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countryList[position]

        holder.nameTextView.text = country.name
        holder.flagImageView.text = country.emoji
        holder.codeTextView.text = country.dial_code
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}

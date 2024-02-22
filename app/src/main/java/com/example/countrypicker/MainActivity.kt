package com.example.countrypicker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private val gson = Gson()
    private lateinit var countryList: List<Country>

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = loadJSONFromAsset("countries.json")

        val countryListType = object : TypeToken<List<Country>>() {}.type
        countryList = gson.fromJson(jsonString, countryListType)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val adapter = CountryAdapter(this, countryList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun loadJSONFromAsset(fileName: String): String {
        val json: String?
        try {
            val inputStream: InputStream = assets.open(fileName)
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()

            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }

            inputStream.close()
            json = stringBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            return ""
        }

        return json
    }

}
package com.example.mifirstapp.superhero.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mifirstapp.databinding.ActivitySuperHeroListBinding
import com.example.mifirstapp.superhero.app.services.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofitInstance()
        initUi()
    }

    private fun initUi() {
        binding.searchViewHeroApp.isIconified = false
        binding.searchViewHeroApp.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchHero(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        adapter = SuperHeroAdapter()
        binding.recyclerViewSuperHeroList.setHasFixedSize(true)
        binding.recyclerViewSuperHeroList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSuperHeroList.adapter = adapter
    }

    private fun searchHero(query: String?) {
        if(query.isNullOrEmpty()){
            return
        }
        binding.progressBarSuperHeroList.visibility = android.view.View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.create(ApiService::class.java).getSuperHeroList(query)
            if(response.isSuccessful){
                val responseBody = response.body()
                if(responseBody != null){
                    if(responseBody.response == "success"){
                        Log.i("superheroApp", "Response: $responseBody")
                        runOnUiThread {
                            binding.progressBarSuperHeroList.visibility = android.view.View.GONE
                            adapter.setList(responseBody.superheroes)
                        }
                    }else{
                        Log.i("superheroApp", "Response error: ${responseBody.error}")
                    }
                }
            }else{
                Log.i("superheroApp", "Error: ${response.errorBody()}")
            }
        }
    }

    private fun getRetrofitInstance(): Retrofit {
         return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}
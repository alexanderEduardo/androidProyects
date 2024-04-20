package com.example.mifirstapp.superhero.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.example.mifirstapp.utils.RetrofitInstance
import retrofit2.Retrofit
import com.example.mifirstapp.databinding.ActivityDetailsSuperHeroBinding
import com.example.mifirstapp.superhero.app.services.ApiService
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

class DetailsSuperHeroActivity : AppCompatActivity() {

    companion object{
        const val SUPER_HERO_ID = "super_hero_id"
    }

    private lateinit var binding: ActivityDetailsSuperHeroBinding
    private lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = RetrofitInstance.getInstance()
        val id:  String = intent.getStringExtra(SUPER_HERO_ID).orEmpty()
        getSuperHeroInfo(id)
    }

    private fun getSuperHeroInfo(id: String) {
        binding.progressBarSuperHeroDetail.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.create(ApiService::class.java).getSuperHeroDetail(id)
            if(response.isSuccessful){
                val responseBody: SuperHeroDetail? = response.body()
                if(responseBody != null){
                    //withContext(Dispatchers.Main){
                    runOnUiThread{
                        binding.progressBarSuperHeroDetail.visibility = View.GONE
                        binding.tvSuperHeroName.text = responseBody.name
                        binding.tvSuperheroRealName.text = responseBody.biography.fullName
                        binding.tvBirthday.text = responseBody.biography.placeOfBirth
                        binding.tvPublisher.text = responseBody.biography.publisher
                        updateHeightOnBarChart(responseBody)
                        Picasso.get().load(responseBody.image.url).into(binding.ivSuperHeroImage)
                    }
                }
            }else{
                withContext(Dispatchers.Main){
                    binding.progressBarSuperHeroDetail.visibility = View.GONE
                }
            }
        }
    }

    private fun updateHeightOnBarChart(resBody: SuperHeroDetail){
        updateHeight(binding.viewIntelligence, resBody.powerstats.intelligence)
        updateHeight(binding.viewStrength, resBody.powerstats.strength)
        updateHeight(binding.viewSpeed, resBody.powerstats.speed)
        updateHeight(binding.viewDurability, resBody.powerstats.durability)
        updateHeight(binding.viewPower, resBody.powerstats.power)
        updateHeight(binding.viewCombat, resBody.powerstats.combat)
    }
    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }
    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }
}
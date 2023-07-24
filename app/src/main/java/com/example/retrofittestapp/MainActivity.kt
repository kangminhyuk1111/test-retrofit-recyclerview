package com.example.retrofittestapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofittestapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Client.api.getMemberList().enqueue(object : Callback<JsonDto>{
            override fun onResponse(call: Call<JsonDto>, response: Response<JsonDto>) {
                if(response.isSuccessful) {
                    val data:JsonDto = response.body()!!
                    for (item in data){
                        println("log ${item.title}")
                    }
                } else {
                    println("no res~")
                }
            }

            override fun onFailure(call: Call<JsonDto>, t: Throwable) {
                println("throw err ${t.message}")
            }
        })

        Client.api.postMemberList(1).enqueue(object :Callback<JsonDto>{
            override fun onResponse(call: Call<JsonDto>, response: Response<JsonDto>) {
                if(response.isSuccessful) {
                    val data:JsonDto = response.body()!!
                    println(data)
                } else {
                    println("no res~")
                }
            }

            override fun onFailure(call: Call<JsonDto>, t: Throwable) {
                println("hi")
            }

        })
    }
}
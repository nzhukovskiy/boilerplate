package com.example.wearmodule

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.core.view.InputDeviceCompat
import androidx.core.view.MotionEventCompat
import androidx.core.view.ViewConfigurationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.wear.widget.WearableLinearLayoutManager
import androidx.wear.widget.WearableRecyclerView
import com.example.wearmodule.databinding.ActivityMain3Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class MainActivity3 : Activity() {

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofit_s = RetrofitClient.getClient("https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/")
        val my_s = retrofit_s.create(ICityRetrofit::class.java)
        my_s.getAll().enqueue(object: Callback<MutableList<City>> {
            override fun onFailure(call: Call<MutableList<City>>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<MutableList<City>>,
                response: Response<MutableList<City>>
            ) {
                val recycler_view : WearableRecyclerView = binding.wearRecyclerView
                recycler_view.layoutManager = WearableLinearLayoutManager(this@MainActivity3)
                recycler_view.adapter = RecyclerAdapter(response.body())
                recycler_view.setOnGenericMotionListener { v, ev ->
                    if (ev.action == MotionEvent.ACTION_SCROLL &&
                        ev.isFromSource(InputDeviceCompat.SOURCE_ROTARY_ENCODER)
                    ) {
                        // Don't forget the negation here
                        val delta = -ev.getAxisValue(MotionEventCompat.AXIS_SCROLL) *
                                ViewConfigurationCompat.getScaledVerticalScrollFactor(
                                    ViewConfiguration.get(applicationContext), applicationContext
                                )
                        // Swap these axes to scroll horizontally instead
                        v.scrollBy(0, delta.roundToInt())
                        true
                    } else {
                        false
                    }
                }

                //TODO("Not yet implemented")
            }
        })


    }
}
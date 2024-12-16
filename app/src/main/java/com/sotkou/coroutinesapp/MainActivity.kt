package com.sotkou.coroutinesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.sotkou.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

lateinit var binding: ActivityMainBinding
private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.countBtn.setOnClickListener {
            binding.counterText.text = counter++.toString()
        }

        binding.downloadBtn.setOnClickListener {
            // Coroutines
            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFileFromNet()
            }
            // Χωρίς Coroutines
            // downloadBigFileFromNet()
        }
    }

    private suspend fun downloadBigFileFromNet() {
        for (i in 1 .. 100_000)  {
            Log.i("TAGY", "Downloading $i in ${Thread.currentThread().name}")

            //binding.downloadText.text = " $i from ${Thread.currentThread().name}"
            //withContext(Dispatchers.Main) {
            //    binding.downloadText.text = " $i from ${Thread.currentThread().name}"
            //}
        }
    }
}
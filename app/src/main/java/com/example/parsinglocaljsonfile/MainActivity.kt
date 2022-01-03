package com.example.parsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parsinglocaljsonfile.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding
    lateinit var rvMain: RecyclerView
    val imageList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rvMain = findViewById(R.id.rvMain)
        rvMain.layoutManager = LinearLayoutManager(this)
        fetchImage()
    }


    fun fetchImage() {

        val openImageFile = assets.open("data.json")
        val jsonData = openImageFile.bufferedReader().use { it.readText() }
        var jsonImage = JSONArray(jsonData)
        for (i in 0 until jsonImage.length()) {
            var holdURL = jsonImage.getJSONObject(i).getString("Hd")
            imageList.add(holdURL)

        }
        

        rvMain.adapter = RVAdapter(imageList)
        rvMain.adapter!!.notifyDataSetChanged()
    }
}
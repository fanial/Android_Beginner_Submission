package com.codefal.android_beginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.codefal.android_beginner.adapter.AdapterList
import com.codefal.android_beginner.databinding.ActivityMainBinding
import com.codefal.android_beginner.model.DataList

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterList: AdapterList
    private val list = ArrayList<DataList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //get data from string resource
        list.addAll(getListData())

        //show data to recycler view
        showList()

    }

    private fun getListData(): ArrayList<DataList> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataIsi = resources.getStringArray(R.array.detail_isi)
        val dataPic = resources.obtainTypedArray(R.array.img)
        val dataReview = resources.obtainTypedArray(R.array.img_review)
        val listData = ArrayList<DataList>()
        for (i in dataJudul.indices){
            val data = DataList(dataJudul[i], dataIsi[i], dataPic.getResourceId(i, -1), dataReview.getResourceId(i,-1))
            listData.add(data)
        }
        return listData
    }

    private fun showList() {
        binding.rvHome.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterList = AdapterList(list)
        binding.rvHome.adapter = adapterList
    }


    //Profile Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return super .onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.about_page -> {
                val move = Intent(this@MainActivity, Profile::class.java)
                startActivity(move)
            }
        }
        return super .onOptionsItemSelected(item)
    }

}
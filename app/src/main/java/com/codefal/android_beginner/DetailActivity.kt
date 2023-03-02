package com.codefal.android_beginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.codefal.android_beginner.databinding.ActivityDetailBinding
import com.codefal.android_beginner.databinding.ActivityMainBinding
import com.codefal.android_beginner.model.DataList

class DetailActivity : AppCompatActivity() {
    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //parsing data from adapter
        val get = intent.getParcelableExtra("key_data") as DataList?
        binding.imageView.setImageResource(get?.pic!!)
        binding.judulDetail.text = get.judul
        binding.isiDetail.text = get.isi
        binding.imgReview.setImageResource(get.review)

    }

    //Share Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.share, menu)
        return super .onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_share -> {
                val set = intent.getParcelableExtra("key_data") as DataList?
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                if (set != null) {
                    intent.putExtra(Intent.EXTRA_TEXT, "${set.judul}, ${set.isi}")
                }
                startActivity(Intent.createChooser(intent, "Share via"))
            }
        }
        return super .onOptionsItemSelected(item)
    }
}
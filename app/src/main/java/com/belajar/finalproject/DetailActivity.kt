package com.belajar.finalproject

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val PHOTO = "foto"
        const val GAME_NAME ="nama_game"
        const val GAME_DESCRIPTION = "deskripsi_game"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        val dataTransfer = intent.getParcelableExtra<GamePc>(TRANSFER)
        val photoTransfer = intent.getIntExtra(PHOTO, 0)
        val nameTransfer = intent.getStringExtra(GAME_NAME)
        val descTransfer = intent.getStringExtra(GAME_DESCRIPTION)
        findViewById<CircleImageView>(R.id.cv_detail_photo).setImageResource(photoTransfer)
        findViewById<TextView>(R.id.tv_detail_name).text = nameTransfer
        findViewById<TextView>(R.id.tv_detail_description).text = descTransfer
        supportActionBar?.apply {
            title = intent.getStringExtra(GAME_NAME)
        }

//        if (dataTransfer != null) {
//            findViewById<TextView>(R.id.tv_detail_name).text = dataTransfer.name
//            findViewById<TextView>(R.id.tv_detail_description).text = dataTransfer.description
//        }

        Log.d("Detail Data", photoTransfer.toString())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar
//        if (dataTransfer != null) {
//            val name = dataTransfer.name
//            val description = dataTransfer.description
//            val photo = dataTransfer.photo
//            tvDetailName.text = name
//            tVdetailDescription.text = description
//            // Assuming that photo is an integer representing the resource ID
//            cvDetailImg.setImageResource(photo)
//        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_share) {
            val moveIntent = Intent(Intent.ACTION_SEND)
            moveIntent.setType("image/*")
            val textShare = "Share the info"
            val textExtra = intent.getStringExtra(GAME_DESCRIPTION)
            val photoExtra =intent.getIntExtra(PHOTO, 0)
            val bitmapFactory = BitmapFactory.decodeResource(resources, photoExtra)
            val path = MediaStore.Images.Media.insertImage(contentResolver, bitmapFactory,"Title", null)
            val uri = Uri.parse(path)
            moveIntent.putExtra(Intent.EXTRA_SUBJECT, textShare)
            moveIntent.putExtra(Intent.EXTRA_TEXT, textExtra)
            moveIntent.putExtra(Intent.EXTRA_STREAM, uri)

            startActivity(Intent.createChooser(moveIntent,"Share"))
        }
        return super.onOptionsItemSelected(item)
    }
}
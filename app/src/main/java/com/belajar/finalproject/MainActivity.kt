package com.belajar.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class MainActivity : AppCompatActivity() {

    private lateinit var rvGamePc: RecyclerView
    private val gamePcList = ArrayList<GamePc>()



    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvGamePc = findViewById(R.id.rv_games_pc)
        rvGamePc.setHasFixedSize(true)


        gamePcList.addAll(gamePcList())
        recyclerViewForm()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
            startActivity(moveIntent)
        }
        return super.onOptionsItemSelected(item)
    }
    private fun gamePcList(): ArrayList<GamePc> {
        val getPhoto = resources.obtainTypedArray(R.array.photo_link)
        val getName = resources.getStringArray(R.array.name_data)
        val getDesc = resources.getStringArray(R.array.data_description)
        val listGame = ArrayList<GamePc>()
        for (i in getName.indices){
            val gameName = GamePc(photo = getPhoto.getResourceId(i,-1), name = getName[i], description = getDesc[i])
            listGame.add(gameName)
        }
        return listGame
    }
    private fun  recyclerViewForm() {
        rvGamePc.layoutManager = GridLayoutManager(this, 2)
        val gamePcAdapter = GameAdapter(gamePcList)
        rvGamePc.adapter = gamePcAdapter
//        gamePcAdapter.setOnItemClickCallback(object : GameAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: GamePc) {
//                clickAble(data)
//            }
//        })

    }

//    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        val clickedItem = gamePcList[position]
//        val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
//        moveIntent.putExtra(TRANSFER, clickedItem)
//        startActivity(moveIntent)
//    }
//    fun clickAble(data: GamePc) {
//    val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
//    moveIntent.putExtra(DetailActivity.TRANSFER, data)
//    startActivity(moveIntent)
//    }



    }



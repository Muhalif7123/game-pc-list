package com.belajar.finalproject

import android.content.Intent
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import java.net.URL


class GameAdapter(private val gamePcList: ArrayList<GamePc>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
//    fun setOnClickItem(onItemClick: OnItemClickListener){
//        this.onItemClick = onItemClick
//    }
//    private lateinit var onItemClickCallback: OnItemClickCallback

//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
        class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvPhoto  = itemView.findViewById<CircleImageView>(R.id.cv_img_photo)
        val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
        val tvDesc = itemView.findViewById<TextView>(R.id.tv_item_description)

//        fun bindItem(gamePc: GamePc){
//            tvName.text = gamePc.name
//            tvDesc.text = gamePc.description
//            Glide.with(itemView.context)
//                .load(R.array.photo_link)
//                .into(imgPhoto)
//
//
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_row_games, parent, false)
        return GameViewHolder(view)
    }
//    interface OnItemClick{
//        fun getOnItemClick(data: GamePc)
//    }
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
//        holder.bindItem(this@GameAdapter.gamePcList[position])
        val (name, description, photo) = gamePcList[position]
        holder.cvPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDesc.text = description
        holder.itemView.setOnClickListener {
            val moveIntent = Intent(holder.itemView.context, DetailActivity::class.java)
//          moveIntent.putExtra(DetailActivity.TRANSFER, holder.adapterPosition.toString())
            moveIntent.putExtra(DetailActivity.GAME_NAME, name)
            moveIntent.putExtra(DetailActivity.GAME_DESCRIPTION, description)
            moveIntent.putExtra(DetailActivity.PHOTO, photo)
            holder.itemView.context.startActivity(moveIntent)
        }


    }
    override fun getItemCount() = gamePcList.size
    interface OnItemClickCallback {
        fun onItemClicked(data: GamePc)
    }


}
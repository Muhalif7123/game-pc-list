package com.belajar.finalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamePc(val name: String, val description: String, val photo: Int): Parcelable {

}
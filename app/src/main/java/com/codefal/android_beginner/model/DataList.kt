package com.codefal.android_beginner.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataList(
    var judul : String,
    var isi: String,
    var pic : Int,
    var review : Int
) : Parcelable

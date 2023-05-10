package com.books.app.utils

import android.content.Context
import android.widget.Toast
import com.books.app.data.models.Data
import com.books.app.data.models.DetailsData
import com.google.firebase.perf.ktx.trace
import com.google.firebase.perf.metrics.Trace
import kotlinx.serialization.json.Json

fun Context.toast(string: String) = Toast.makeText(this, string, Toast.LENGTH_SHORT).show()

inline fun <T> trace(name: String, block: Trace.() -> T) = Trace.create(name).trace(block)

fun String.decodeJsonData() :Data? = try {
    println(this)
    Json.decodeFromString(Data.serializer(), this)
} catch (ex :Exception) {
    ex.printStackTrace()
    null
}

fun String.decodeDetailsData() : DetailsData? = try {
    Json.decodeFromString(DetailsData.serializer(), this)
} catch (ex :Exception) {
    ex.printStackTrace()
    null
}
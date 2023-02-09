package com.example.win32

import android.R.attr.bitmap
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import java.util.concurrent.Executors


object LoadImage {
    fun load(layout: LinearLayout, context: Context){
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        executor.execute {
            val imageURL = "http://49.12.202.175/win32/myImage.jpg"
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    //imageView.setImageBitmap(image)
                    val mDrawable: Drawable = BitmapDrawable(context.resources, image)
                    layout.background = mDrawable
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
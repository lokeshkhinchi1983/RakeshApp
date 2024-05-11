package com.rakeshapps.example

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    private val context=this@MainActivity
    private var imageViews = listOf(
        R.id.im1,
        R.id.im2,
        R.id.im3,
        R.id.im4,
        R.id.im5,
        R.id.im6,
        R.id.im7,
        R.id.im8,
        R.id.im9,
        R.id.im10,
        R.id.im11,
        R.id.im12,
        R.id.im13,
        R.id.im14,
        R.id.im15,
        R.id.im16,
        R.id.im17,
        R.id.im18,
        R.id.im19,
        R.id.im20,
        R.id.im21,
        R.id.im22,
        R.id.im23,
        R.id.im24,
        R.id.im25,
        R.id.im26,
        R.id.im27,
        R.id.im28,
        R.id.im29,
        R.id.im29,
        R.id.im29,
        R.id.im29)
    private val imageTabsViews = listOf(
        R.id.im1,
        R.id.im2,
        R.id.im3,
        R.id.im4,
        R.id.im5,
        R.id.im6,
        R.id.im7,
        R.id.im8,
        R.id.im9,
        R.id.im10,
        R.id.im11,
        R.id.im12,
        R.id.im13,
        R.id.im14,
        R.id.im15,
        R.id.im16,
        R.id.im17,
        R.id.im18,
        R.id.im19,
        R.id.im20,
        R.id.im21,
        R.id.im22,
        R.id.im23,
        R.id.im24,
        R.id.im25,
        R.id.im26,
        R.id.im27,
        R.id.im28,
        R.id.im29,
        R.id.im30,
        R.id.im31,
        R.id.im32,
        R.id.im33,
        R.id.im34,
        R.id.im35,
        R.id.im36,
        R.id.im37,
        R.id.im38,
        R.id.im39,
        R.id.im40,
        R.id.im41,
        R.id.im42,
        R.id.im43,
        R.id.im44,
        R.id.im45,
        R.id.im46,
        R.id.im47,
        R.id.im48,
        R.id.im49,
        R.id.im50,
        R.id.im51,
        R.id.im52,
        R.id.im53,
        R.id.im54,
        R.id.im54,
        R.id.im54)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //check list of Tablet or mobile
        imageViews=imageTabsViews.takeIf { checkIsTablet() }?:imageViews
        startLoop()
    }

    @SuppressLint("DiscouragedApi")
    private fun startLoop() {
        Thread {
            for (i in imageViews.indices) {
                // set first color dot
                val id = resources.getIdentifier(
                    imageViews[i].toString(), "drawable", packageName)
                val view: ImageView = findViewById(id)
                view.setImageResource(R.drawable.circle_blue)

                // set second color dot
                if (i>0){
                    val idGreen = resources.getIdentifier(
                        imageViews[i-1].toString(), "drawable", packageName)
                    val viewGreen: ImageView = findViewById(idGreen)
                    viewGreen.setImageResource(R.drawable.circle_green)
                }
                //set third color dot
                if (i>1){
                    val idRed = resources.getIdentifier(imageViews[i-2].toString(), "drawable", packageName)
                    val viewRed: ImageView = findViewById(idRed)
                    viewRed.setImageResource(R.drawable.circle_red)
                    defaultsAll(i-2)
                }
                if (i == imageViews.size-1) {
                    defaultsAll(i)
                    startLoop()
                }
                Thread.sleep(250)
            }
        }.start()
    }

    /* Set Default view Circle */
    @SuppressLint("DiscouragedApi")
    private fun defaultsAll(pos: Int) {
        for (j in 0 until pos){
            val idBlack = resources.getIdentifier(imageViews[j].toString(), "drawable", packageName)
            val viewBlack: ImageView = findViewById(idBlack)
            viewBlack.setImageResource(R.drawable.circle_stroke)
        }
    }

    private fun checkIsTablet():Boolean{
        return if (isTablet(context)) {
            getDevice5Inch(context)
        }else
            false
    }

     // Check Device layout 5 th or above
    private fun getDevice5Inch(context: Context): Boolean {
        return try {
            val displayMetrics: DisplayMetrics = context.resources.displayMetrics
            val yInch = displayMetrics.heightPixels / displayMetrics.ydpi
            val xInch = displayMetrics.widthPixels / displayMetrics.xdpi
            val diagonalInch = sqrt((xInch * xInch + yInch * yInch).toDouble())
            diagonalInch >= 6
        } catch (e: Exception) {
            false
        }
    }

    //Check configure screen
    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }
}
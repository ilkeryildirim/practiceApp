package com.ilkeryildirim.vitrinova.utils

import android.content.Context


//https://stackoverflow.com/questions/33575731/gridlayoutmanager-how-to-auto-fit-columns
object GridLayoutColumnUtil {
    fun calculateNoOfColumns(context: Context, columnWidthDp: Float=24F):Int { // For example columnWidthdp=180
        val displayMetrics = context.resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        val noOfColumns = (screenWidthDp / columnWidthDp + 0.5).toInt() // +0.5 for correct rounding to int.
        return noOfColumns
    }
}
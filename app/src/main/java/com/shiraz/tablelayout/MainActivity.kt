package com.shiraz.tablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //create Map of String, String
    var androidMap:HashMap<String, String> = HashMap()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        androidMap.put("Android 9.0", "Pie")
        androidMap.put("Android 8.0", "Oreo")

        for ((key,value) in androidMap){
            addInRow(key,value)
        }
    }

    //addInRow function
    private fun addInRow(key: String, value: String) {

        //create a new table row
        val tableRow = TableRow(getApplicationContext())

        //Set new table row layout parameters
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setLayoutParams(layoutParams)

        //add values into row by calling addView()
        var textView = TextView(this)
        textView.text= key
        tableRow.addView(textView,0)

        textView = TextView(this)
        textView.text= value
        tableRow.addView(textView,1)

        //Finally add the created row into the layout
        tableLayout.addView(tableRow)
    }

    //when Add button is clicked, this function is run
    fun addClick(view: View){
        addInRow(androidVersion.text.toString(),androidCode.text.toString())
    }
}
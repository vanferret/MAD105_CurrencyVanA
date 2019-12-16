package com.example.android.currencyxchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.idConverNumber)
        val rbD2P = findViewById<RadioButton>(R.id.idRBD2P)
        val rbP2D = findViewById<RadioButton>(R.id.idRBP2D)
        val btnConvert = findViewById<Button>(R.id.idBtnConvert)
        val result = findViewById<TextView>(R.id.idResult)

        btnConvert.setOnClickListener{
            val formatterUS = DecimalFormat("\u00A4###,###,###.00")
            val formatterUK = DecimalFormat("\u00A3###,###,###.00")
            var dblIn = convertNum.text.toString().toDouble()
            var dblOutStr = ""
            var blToast = false

            if(rbD2P.isChecked){
                dblIn *= 1.34
                dblOutStr = formatterUS.format(dblIn)
                blToast = dblIn > 10000
            } else {
                blToast = dblIn > 10000
                dblIn *= 0.75
                dblOutStr = formatterUK.format(dblIn)
            }
            if (blToast) {
                Toast.makeText(this@MainActivity,"Value is greater than $10,000.00.",Toast.LENGTH_LONG).show()
            }
            result.text = dblOutStr
        }
    }
}

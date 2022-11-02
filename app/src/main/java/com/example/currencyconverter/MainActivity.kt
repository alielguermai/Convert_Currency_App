package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val dirham="Moroccan Dirham"
    private val dollar="American dollar"
    private val euro="Euro"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but : Button=findViewById(R.id.button)
        val amountField : TextInputEditText = findViewById(R.id.amountedittext)
        val selectField1 : AutoCompleteTextView = findViewById(R.id.selectcountry1)
        val selectField2 : AutoCompleteTextView = findViewById(R.id.selectcountry2)
        val resultField : TextInputEditText = findViewById(R.id.resultfield)
        val amounts = listOf(dirham,dollar,euro)
        val adapter = ArrayAdapter(this,R.layout.drop_down_menu,amounts)
        selectField1.setAdapter(adapter)
        selectField2.setAdapter(adapter)
        but.setOnClickListener {
            val amount = amountField.text.toString().toDouble()
            var result : Double= 0.0
            val fieldvalue1=selectField1.text.toString()
            val fieldvalue2=selectField2.text.toString()
            when (fieldvalue1){
                dirham->when (fieldvalue2){
                    dirham->result=amount
                    dollar->result=amount.times(0.092)
                    euro->result=amount.times(0.093)
                }
                dollar->when(fieldvalue2){
                    dollar->result=amount
                    dirham->result=amount.times(10.93)
                    euro->result=amount.times(1.01)
                }
                euro->when(fieldvalue2){
                    euro->result=amount
                    dirham->result=amount.times(10.82)
                    dollar->result=amount.times(0.99)
                }
            }
            resultField.setText(result.toString())
        }
    }
}
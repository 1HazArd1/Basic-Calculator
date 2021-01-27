package com.aakash.calci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var  res1:Double= Double.NaN
    private var  res2:Double=Double.NaN
    private var action:Char?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOne.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "1"
        }
        btnTwo.setOnClickListener {
            etDisplay.text = etDisplay.text.toString()+ "2"
        }
        btnThree.setOnClickListener {
            etDisplay.text = etDisplay.text.toString()+"3"
        }
        btnFour.setOnClickListener {
            etDisplay.text = etDisplay.text.toString()+ "4"
        }
        btnFive.setOnClickListener {
            etDisplay.text = etDisplay.text.toString()+ "5"
        }
        btnSix.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "6"
        }
        btnSeven.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "7"
        }
        btnEight.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "8"
        }
        btnNine.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "9"
        }
        btnZero.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "0"
        }
        btnDot.setOnClickListener {
            etDisplay.text = etDisplay.text.toString() + "."
        }

        btnC.setOnClickListener {
            etDisplay.text = null
            res1 = Double.NaN
            res2 = Double.NaN
        }
        btnBack.setOnClickListener {
            if (etDisplay.text.isNotEmpty()) run {
                val name: CharSequence = etDisplay.text.toString()
                etDisplay.setText(name.subSequence(0, name.length - 1))
            }
        }


        btnPlus.setOnClickListener {
            if(etDisplay==null){
                etDisplay.text = null
            }
            else{
                compute()
                action='+'
                etDisplay.text = null
            }
        }
        btnMinus.setOnClickListener {
            if(etDisplay==null){
                etDisplay.text = null
            }
            else{
                compute()
                action='-'
                etDisplay.text = null
            }
        }
        btnMultiply.setOnClickListener {
            if(etDisplay==null){
                etDisplay.text = null
            }
            else{
                compute()
                action='x'
                etDisplay.text = null
            }
        }
        btnDivide.setOnClickListener {
            if(etDisplay==null){
                etDisplay.text = null
            }
            else{
                compute()
                action='/'
                etDisplay.text = null
            }
        }
        btnPercent.setOnClickListener {
            if(etDisplay==null){
                etDisplay.text = null
            }
            else{
                res1=etDisplay.text.toString().toDouble()
                res1 /= 100
                etDisplay.setText(res1.toString())
            }
        }

        btnEquals.setOnClickListener {
            compute()
            etDisplay.setText(res1.toString())

        }
    }

    private fun compute() {
        if(!res1.isNaN()){
            res2=etDisplay.text.toString().toDouble()
            when(action) {
                '+' -> res1 = (res1 + res2)
                '-' -> res1 = (res1 - res2)
                'x' -> res1 = (res1 * res2)
                '/'-> res1 = (res1 / res2)
            }
        }
        else{
            res1=etDisplay.text.toString().toDouble()
        }
    }

}

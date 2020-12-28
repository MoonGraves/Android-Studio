package com.example.eka_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Time to diet!"

        //painoindeksi BMI laskenta menee näin tulos = (paino) / (pituus ^2)
        //eli (paino) / (pituus * pituus)

        //button laskee painoindeksin
        button.setOnClickListener { view ->
            // TODO jtn

            var bmiPaino = editPainoText.text.toString().toFloat()
            var bmiPituus = editPituusText.text.toString().toFloat()
            var bmiCalc = ( bmiPaino ) / ( bmiPituus * bmiPituus )

            editPainoText.setText("")

            //textView.toString().toFloat()

            //laskussa tulostuu desimaalin, jtn 0.012345, joten pyöristettään n.10 tuhanteen osaan tarkkuuteen
            textView.text = "Tulos on:: " + bmiCalc.toFloat() * 10000
        }

    }
}

package com.example.toinen_laksy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.listView
import kotlinx.android.synthetic.main.content_main2.*
import kotlinx.android.synthetic.main.content_main3.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        textView.text = "Time to diet!!"

        /*____________________________________________________________________________________________________________________________________________*/

        //painoindeksi BMI laskenta menee näin tulos = (paino) / (pituus ^2) tai lasku kaava (paino) / (pituus * pituus)

        /* content_main.xml >> Text >> Plain Text

        1. edittext lisää common attributes >> numberDecimal, ja muista "apply", jonka avulla käyttäjä voi antaa decimaali lukuja esim. pituus 182.3

        2. common attributes >> "text" kirjoittaa jtn, että käyttäjä näppyttää sinne num tai tekstiä

        3. common attributes >> "hinta" kirjoittaa jtn, sama kuin "text"
        mutta vähä himmeä teksti, joka toimii kuin "text"*/


        /*toisen aktivity luominen --> new >> Activity >> Basic Activity */

        //painoindeksi laskutulos
        var bmiCalc = 0.0f

        //TODO:: osa tallennuksesta rivistä koodista
        val sharedPreferences = getSharedPreferences("sp_info", Context.MODE_PRIVATE)

        //BUTTON LASKEMINEN START HERE:::
        button.setOnClickListener { view ->

            // TODO painoindeksi lasku
            var bmiPaino = editPainoText.text.toString().toFloat()
            var bmiPituus = editPituusText.text.toString().toFloat()

            bmiCalc = ( bmiPaino ) / ( bmiPituus * bmiPituus ) * 10000
            //lasku tulos näkkyy desimaalin tarkkuudella, eli esim 0.00abcd & siksi pyöristämme
            //textView.toString().toFloat()
            textView.text = "Uusi tulos:: " + bmiCalc.toFloat()

            // TODO:: TALLENNUS START HERE:::
            val editor = sharedPreferences.edit()
            editor.putFloat("bmiTulos", bmiCalc)
            editor.putFloat("bmiPituus", bmiPituus)
            editor.putFloat("bmiPaino", bmiPaino)
            //tämä lähettää button-methodin string:in, josta tulostettaan se viimeisin / tallennettun tuloksen
            //sama kuin toisen button "avain"-sanan, jotta se tallentuu se luku
            editor.apply()


        }

        //TOINEN BUTTON START HERE:::
        /*button2.setOnClickListener { view ->
            //TODO:: avaa toisen main2acitivity & myös intent välittää string nimen ja muuttujan toiseen mainacitivityyn
            //TODO:: i put avain, joka lähettää luvun/tekstin toiseen activitettyyn

            /*
            val i = Intent(this@MainActivity, Main2Activity::class.java)
            i.putExtra("avain", bmiCalc)
            // i.putExtra("avain", "tieto1") //viesti "tieto1" lähettää toiseen aktivitityyn oleva textview
            startActivityForResult(i, 1) //tehtv; näytä main2activity:n textview:ssä
            */

            //TODO:: tallennsu & tulostaa edellisen bmi-lasku tuloksen, painikkeen-avulla, myös klikkaa toisen kerran, jonka avulla korvaa uusimman tuloksen
            //TODO:: $-dollari merkki, joka viittaa tallenuksen operaattoriin
            /*
            val tulos = sharedPreferences.getFloat("bmiTulos", 0.0f)
            val pituus = sharedPreferences.getFloat("bmiPituus", 0.0f)
            val paino  = sharedPreferences.getFloat("bmiPaino", 0.0f)


            val lista1 : ArrayList<String> = arrayListOf("Viimeisin indeksi:  $tulos" + " \n " + "pituus: " + pituus + "cm")
            val lista2 : ArrayList<String> = arrayListOf("Paino: " + paino)
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista1 + lista2)
            */
        }*/

        fab.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //.setAction("Action", null).show()

            val tulos = sharedPreferences.getFloat("bmiTulos", 0.0f)
            val pituus = sharedPreferences.getFloat("bmiPituus", 0.0f)
            val paino  = sharedPreferences.getFloat("bmiPaino", 0.0f)


            /*TODO:: tallennettun painoindeksi tulos, pituus ja paino, josta tulostettaan nappista muodostettuna lista näkymä
            $ - dollari merkki, joka viittaa sen muuttuujaan, että lasukkeseen olevaan merkkijononssa tässä tilanteessa, siksi
            pitää olla "" lainausmerkkien sisällä, koska tämä "tulos" eli painoindeksi on laskettujen pituus ja painoindeksi, joka
            tulostuu desimaalilukuna siksi käytettään "getFloat" - muuttujaa, jos on "getInt" = kokonaisluku on muuttuja


            */
            val lista1 : ArrayList<String> = arrayListOf("Viimeisin indeksi:  $tulos" + " \n " + "pituus: " + pituus + "cm")
            val lista2 : ArrayList<String> = arrayListOf("Paino: " + paino)
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista1 + lista2)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //oikea kulma kolme piste valikkosta
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> { //avaa kolmanen main3activity:n
                //Toast.makeText(this, "Toast it!", Toast.LENGTH_LONG).show()
                val abc = Intent (this@MainActivity, Main3Activity::class.java)
                abc.putExtra("steppi", editPituusText.text.toString().toFloat())
                abc.putExtra("steppi2", editPainoText.text.toString().toFloat())
                startActivity(abc)

                true
            }

            R.id.action_info -> {
                Toast.makeText(this, "You've seen it all!! BUSTED!!", Toast.LENGTH_LONG).show()
                true
            }

            R.id.action_show -> {
                //avaa toisen main2activityn
                val ab = Intent (this@MainActivity, Main2Activity::class.java)
                ab.putExtra("steppi",editPituusText.text.toString().toFloat())
                ab.putExtra("steppi2", editPainoText.text.toString().toFloat())
                startActivity(ab)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}

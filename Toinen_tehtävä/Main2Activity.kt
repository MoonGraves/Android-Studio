package com.example.toinen_laksy

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        var extras = intent.extras ?: return
        //TODO: saa pääsovelluksen aktivityn "avain", eli sen viestin, myös toimii seuraavan rivi koodi, nouttaa lasku pää-activity sovelluksesta
        //var value1 = extras.getStringArray("avain")

        //value1 kaksoispiste, joka erottaa tyyppisen string luvun yksikkön Float eli decimaalinen tyyppinen luku yksikkönä
        //jonka jälkeen tunnistaa "avain"-sanan pää-mainactivityn, josta avaa sen tämän main2activityn sivuston, että
        //viimeisenä defaultValue, jos halutun tyypin arvoa ei ole tallennettu annetulla nimellä.
        //tässä tilanteessa vaikuttaa Float-string tyyppiin siksi on käytettään 0.0f, että tämä on methodi-rivi koodi

        //tämä on tarkoitettu sille, jos pää-aktivitystä laskettin tulos, tuodaan "avain"-sanalla, josta siirtää sen tuloksen tänne
        //siksi tossa on Float - koska desimaaln tarkkkuus ja loppussa siksi on 0.0f, jos on kokonaisluku käytettään Int
        //var value1 : Float = intent.getFloatExtra("avain", 0.0f)
        //var value1 : Int = intent.getIntExtra("avain", 0)


        //tämä on pää-aktivityn oikea ylä nurkkan kolme pisteen sieltä valikkosta kuin "switch activity"
        //joka vastaanottaa nimen/avain-sanan tyyppisen, josta lähettää käyttäjän näppytettyn pituudenssa
        //var pituus1 : int = intent.getFloatExtra("steppi", 0.0f) //jos int = kokonaisluku & float = desimaalintarkkuus

        var pituus1 : Float = intent.getFloatExtra("steppi", 0.0f)
        var paino1 : Float = intent.getFloatExtra("steppi2", 0.0f)


        //nappaa pääsovelluksen lasku harjoituksen tulos
        //textView2.text = "Tulos: " + value1

        textView4.text = "Antama pituus: "+ pituus1 + " cm " + " & " + paino1 + "kg"



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}

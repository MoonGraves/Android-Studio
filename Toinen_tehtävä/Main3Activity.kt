package com.example.toinen_laksy

import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.content_main3.*
import java.util.ArrayList

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        setSupportActionBar(toolbar)

        var extras = intent.extras ?: return

        textView5.text = "Scores: "

        var pituus1 : Float = intent.getFloatExtra("steppi", 0.0f)
        var paino1 : Float = intent.getFloatExtra("steppi2", 0.0f)


        //listan luominen, pieni testi
        val lista1 = arrayListOf("Yks " + " kaks ", " kolme " + " neljä ", " viisi ")
        val lista2 : ArrayList<String> = arrayListOf( "$pituus1 cm " + " & " + "$paino1 kg")
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista1 + lista2)




        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}

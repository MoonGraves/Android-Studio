package com.example.location2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    //Read class file Adapter
    lateinit var adapters: Adapters
    
    /* Lisää nämä tonne kansioon kuin:: Gradle Scripts/build.gralde(Module: app) --> dependencies { zxcv }
        //View Pager
    implementation "androidx.viewpager2:viewpager2:1.0.0"
    // Rounded image view
    implementation 'com.makeramen:roundedimageview:2.3.0'

    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        setSupportActionBar(toolbar)


        //TODO: add lista mitä kuvia haluat näyttää siinä sovelluksessa, kaiken lisäksi kuvan nimi pitää olla pienellä..? normaalisti pitäisi hyväksyä iso/pien kirjaimia
        var list = mutableListOf<Int>()

        /*list.add(R.drawable.one)
        list.add(R.drawable.two)
        list.add(R.drawable.three)
        list.add(R.drawable.four)
         */
        list.add(R.drawable.sieppaaakkari)
        list.add(R.drawable.five)
        list.add(R.drawable.one)
        list.add(R.drawable.six)
        list.add(R.drawable.seven)
        list.add(R.drawable.eight)


        adapters = Adapters(this)
        adapters.setContentList(list)
        viewpager.adapter = adapters

    }

}

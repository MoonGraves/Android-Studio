package com.example.ihmeprojekti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

//TÄMÄ ON JOTAIN MUUTTA
class Main3Activity : AppCompatActivity() {

    //TODO:: yleis toiminnat START HERE::::::
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        textView5.text = "pälä pälä" + " \n Pälä pälä pälä \n pölö pölö "
        textView6.text = "abc defg" + " \n asdfsdaf \n qwer qwer "
        textView7.text = "1324" + " \n 56 789 \n 2345 980 "
        textView9.text = "Sudo" + " \n APT INSTALL \n UPDATE PENA "

    }


    /*TODO luodaan vasempaan reunaan sellainen menu-valikko
    * TODO tässä funktiossa tapahtuu jotakin, kohdassa (menuinflater),
    *  joka tarkoituksena lukee sen luoneen kansion mukaisen tiedoston asetukset ja nimen mukaan siksi
    *  siinä lukee (R.menu.main,menu)
    * */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main,menu)
        return true
    }



    //TODO muodostaen menu-valikkon toiminta esim.näkymätön, ei ole käytettävissä ja näin
    // & lisäksi nämä valikkot menevät 0,1,2,3,4.... ja jne järjestyksessä, eivät mene 1,2,3 ja pälä pälä
    // TODO:: sekä ne järjestykset menevät määritettyjen (main.xml) mukaan, eli 0,1,2,3 ja jne....
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        //menu?.getItem(2)?.setEnabled(false) //(false) - näkyy menu:ssa mutta ei ole käytettävis
        menu?.getItem(1)?.isVisible = false //kokonaan näkymätön, sitä ei näy menu-valikossa yhtään
        menu?.getItem(2)?.isVisible = false //kokonaan näkymätön, sitä ei näy menu-valikossa yhtään

        return super.onPrepareOptionsMenu(menu)
    }
    //TODO käyttäjä kun valitsee toiminnan jotakin tapahtuu tässä & oikea kulma kolme piste valikkosta
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        var selectedOption = ""
        when(item.itemId) {
            R.id.Pala -> selectedOption = "Pala"

            //TODO takaisin etusivulle - MAINACTIVITY
            R.id.Etusivu -> {
                selectedOption = "Etusivu"
                val SettingAsetus = Intent(this@Main3Activity, MainActivity::class.java)
                startActivity(SettingAsetus)
                true
            }

            //TODO mennään main4activity:yyn
            R.id.valikko2 -> {
                selectedOption = "valikko2"
                val nelosActivity = Intent(this@Main3Activity, Main4Activity::class.java)
                startActivity(nelosActivity)
                true
            }


            R.id.valikko3 -> selectedOption = "valikko3"
            R.id.abc -> selectedOption = "abc"
            R.id.asd -> selectedOption = "asd"

        }
        Toast.makeText(this,"Options: " + selectedOption, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)

    }

}

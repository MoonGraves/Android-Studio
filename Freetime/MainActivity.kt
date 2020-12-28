package com.example.ihmeprojekti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


//TÄMÄ ON ETUSIVU - PÄÄ-MAINACTIVITY
class MainActivity : AppCompatActivity() {

    /*TODO:: jos uusien main-activityen kanssa tulee ongelma, mm. tän rivin koodilta kuin >> SetContentView(R.layout.acitivity_mainXY) <<- tän kanssa
    *  jos sen kanssa, ei tunnista sitä kirjaston/kansion sisällön olevan tiedostoa, tarkista ylemppi rivien (import) >> tää: import kotlinx.android.synthetic.main.activity_mainXY.*
    *  Näistä vaihtoehtoidsta kansii kokeilla, mikäli toimii
    *  TODO:: 1. FILE | Invalidate Caches / Restart >> Invalidate Caches / Restart (käynnistää koko sovelluksen uuestaan & myös käynnistäes odota vähä aikaan...
    *   2. Re-import the project (pluginnista) & 3. Clean & 4. Deleting .idea folder
    * */

    /*TODO:: swipe down systeemi lisääminen/teko, lisää polkuun/tiedostoon kuin (  implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0" )
    *  Vasen valikkosta Android --> Gradle Scripts --> valitse kuin:: build gradle (module:app), joka muistuu elefanti kuviolta,
    *  sen (dependencies)-funktion sisään lisäät ton implementation & sitten näiden näkyy sininen palkki ylhäällä jossa luke:
    *
    * TODO::: "Gradle files having changed since last project sync..... pälä pälä", joka antaa luvan tähän projektiin tehdä muutosta ja näin, klikkaa "Sync Now",
    *  josta tän jälkeen antaa luvan päivittää sen projektin ja tehdä muutoksen, sisältyen funktiot/metodin ja jne... jos on muu kirjasto sama homma, antaa sen install:aa pieni hetki
    * */

    //TODO TOIMINTA, START HERE:::::::
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refresApp() //täää pitää olla mukana, kun refresh:aa

        //TODO button tekee jotakin
        submit_button1.setOnClickListener { view ->
            //Avaa toisen ikkunan Main2Activity:n
            val main2 = Intent (this@MainActivity, Main2Activity::class.java)
            startActivity(main2)

        }
    }

    /*TODO luodaan vasempaan reunaan sellainen menu-valikko
    *TODO luo ensin vasempaan valikkoon kansiot, (res) -> oikea hiiren näppäin (new) -> (android resource directory) anna sille jokin nimi vaan ja jätä oletus valikkot,
    * sen jälkeen taas luot uuden kansion minkä annoit (android resource directory):lle, oikea hiiren näppäin (new) -> (menu resource file), jätä ne oletus valikkot
    *
    * TODO tässä funktiossa tapahtuu jotakin, kohdassa (menuinflater), joka tarkoituksena lukee sen luoneen kansion mukaisen tiedoston asetukset ja nimen mukaan siksi
    *  siinä lukee (R.menu.main,menu)
    *
    * */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    //TODO muodostaen menu-valikkon toiminta esim.näkymätön, ei ole käytettävissä ja näin
    // & lisäksi nämä valikkot menevät 0,1,2,3,4.... ja jne järjestyksessä, eivät mene 1,2,3 ja pälä pälä
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        //menu?.getItem(2)?.setEnabled(false) //(false) - näkyy menu:ssa mutta ei ole käytettävis
        menu?.getItem(3)?.isVisible = false //kokonaan näkymätön, sitä ei näy menu-valikossa yhtään
        menu?.getItem(2)?.isVisible = false //kokonaan näkymätön, sitä ei näy menu-valikossa yhtään
        menu?.getItem(4)?.isVisible = false //kokonaan näkymätön, sitä ei näy menu-valikossa yhtään


        return super.onPrepareOptionsMenu(menu)
    }


    //TODO käyttäjä kun valitsee toiminnan jotakin tapahtuu tässä & oikea kulma kolme piste valikkosta
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        /*TODO, täs kohdassa menu valikkoon, että avaa toisen sivun (mainactivity) ohjelman
        * TODO: Näiden pitää mennä sen id_tunnuksen mukaan, eli tiedostosta (vasen puolel) se (res) -> (menu) -> (main.xml)
        *  ja sen objektin/valikkon id-tunnuksen mukaan esim) ( android:id="@+id/palapala ) & myös näkee siin pää-MainActivity:ssäkin
        *
        * TODO: vasta loppusa lisättään se MainActivity tai mikäli on nimetty sen mukaisesti (activity name)
        *  tossa (main.xml) siel on pieni koodi muunnos, check check!!
        * */

        var selectedOption = ""
        when(item.itemId) {

            R.id.Pala -> selectedOption = "Pala"

            R.id.Login -> {
                selectedOption = "Login"
                val SettingAsetus = Intent(this@MainActivity, Main2Activity::class.java)
                Toast.makeText(this, "Tämä on Login-sivu", Toast.LENGTH_SHORT).show()
                startActivity(SettingAsetus)
                true
            }

            R.id.Etusivu -> {
                selectedOption = "Etusivu"
                val SettingAsetus = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(SettingAsetus)
                true
            }

            /*R.id.valikko2 -> selectedOption = "valikko2"
            R.id.valikko3 -> selectedOption = "valikko3"
            R.id.abc -> selectedOption = "abc"
            R.id.asd -> selectedOption = "asd"*/
        }
        //Toast.makeText(this,"Options: " + selectedOption,Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)

}

    var myrandomTulos1 = 0
    val drinkkiList = arrayListOf("Jameson", "Gin", "Heineken", "Sake", "Guiness", "Calvados", "Crisp" , "Pirkka Olut")

    //TODO Tyyppilinen swipe down päivitys funktio, kuten nyky puhelimessa
    //  & RESFRESH TOIMINTA START HERE::::::
    private fun refresApp() {

        swipeToRefresh.setOnRefreshListener {

            //Swipe jälkeen näkyy pikainen viesti
            Toast.makeText(this, "Page refreshing!", Toast.LENGTH_SHORT).show()
            swipeToRefresh.isRefreshing = false

            /*TODO:: Jos leikkisti luoddaan annettaisi satunnainen luku
            *esim) Random.nextInt(5..10) << tolle pitää tulla range välis & Random.nextInt(10) <<until, eli kunnes
            *Ja se tulostuu tohon textview1:in kohtaan
            * */

            var myrandomInt1 = (0..10).random()
            textView1.text = "Eka luku on: ${myrandomInt1} "

            var myrandomInt2 = (-5..10).random()
            textView2.text = "Toinen luku on: ${myrandomInt2}"

            myrandomTulos1 = (myrandomInt1 + myrandomInt2).toInt()

            /*TODO:: tulostetaan listasta jotain satunnaist tekstiä mitä siinä onkaan
            *  */
            val random = java.util.Random()
            val drinkkitype = random.nextInt(drinkkiList.count())

            textView3.text = "Laskut:: ($myrandomInt1) + ($myrandomInt2) = $myrandomTulos1 \n" +
                    "Ota vaikkapa: "+ drinkkiList[drinkkitype] + "\t shottia $myrandomTulos1"


        }
    }


}

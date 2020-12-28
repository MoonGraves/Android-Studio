package com.example.ihmeprojekti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

//TÄMÄ ON SPLASH SCREEN ACTIVITY
class SplashScreenActivity : AppCompatActivity() {

    //TODO toiminta start here::::
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        /* TODO: tässä tapahtuu tyyppilinen kun avaa sovelluksen siinä heti silmäisellä näkyy pikainen logo, joka esiintyy n. 1.5s
        *   & Muutoksia tulee vasemman tiedostoista tän aktivityn.kt, sen layout (design-hommat) ja values (styles.xml)
        *
        * TODO: Ensin: uusi (Empty activity), anna sille jokin nimi, joka ilmestyy pää-MainActivity:n kanssa, että muut tiedostot
        *   2. (drawable) -> (new) -> (vector assets) jonka luot oman haluamanssa splash screen animation
        *   n. kokoa 150 - 230 dp ja id-nimi, että haluamanssa värinssä
        *   3. Menet täm luoneen activityn sen design eli (layout)-kansion sieltä sen tän activityn:n xml
        *   4. avaat (values) -> style.xml -> kospaat yhen <style></style> nimisen funtkio/objektin, muuta vain nimi ja lopussa pitää olla "NoActionBar"
        *   5. (manifests) -> tän kokonais android ohjelman (AndroidManifest.xml) -> sinne tulee pieni muutos ja lisäystä sinne
        *   joka on, <intent-filter> pälä pälä </intent-filter>
        *   viimeisen on: alhaalla olevat koodi rivit, josta tapahtuu kun käynnistää/avaa sen sovelluksen
        *   niin se logo vilkuu siinä hetkeksi, jonka jälkeen automaatisesti menee sinne pää-MainActivity:n sivuston
        *   esim) kuin käyttäjä avaisi whatsapp/instagram app-sovelluksen, jonka ensimmäisenä näkyy se logo pikaisesti
        *
        *   TODO: HUOM! mikäli lisää esim. textview jotakin tekstiä logon kanssa, joka esiintyy pariks sekunniksi
        *    Kuten käyttäjä avaisi oman puhelimesta app-sovelluksen kuten (Whatsapp) sen alhaalla tulee se teksti mukaan &
        *    & se on vain maku asia mikäli lisää tekstin tai ei
        *    Mikäli lisää tekstin, siihen EI TARVITSE erillistä koodi pätkää,
        *    koska se on samassa design xml pohjassa, me haluttaan vain se logossa on pien animatio
        * */

        iv_note.alpha = 0f
        iv_note.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this, Main2Activity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
        /*
        textView4.alpha = 0f
        textView4.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in)
            finish()
        }
        */
    }
}

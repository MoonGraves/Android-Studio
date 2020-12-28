package com.example.ihmeprojekti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main4.swipeToRefresh
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

//TÄSSÄ TAPAHTUU JOTAIN - BOTTOM NAVIGATION BAR ACTIVITY
class Main4Activity : AppCompatActivity() {

    /*TODO:: jos uusien main-activityen luomisessa tulee ongelma, mm. tän rivin koodilta kuin >> SetContentView(R.layout.acitivity_mainXY) <<- tän kanssa
    *  jos sen kanssa, ei tunnista sitä kirjaston/kansion sisällön olevan tiedostoa, tarkista alku rivien (import) >> tää: import kotlinx.android.synthetic.main.activity_mainXY.*
    *  Näistä vaihtoehtoidsta kansii kokeilla, mikäli toimii
    *  TODO:: 1. FILE | Invalidate Caches / Restart >> Invalidate Caches / Restart (käynnistää koko sovelluksen uuestaan & myös käynnistäes odota vähä aikaan...
    *   2. Re-import the project (pluginnista) & 3. Clean & 4. Deleting .idea folder
    * */

    /* TODO:: täs main4activity:ssä luodaan (BOTTOM NAVIGATION BAR) tyyppillinen & yhteen sivuun, jossa on monta sivua vähä kuin sovellus INSTAGRAM
    *   1)jotta ei tarvitse koko ajan klikkaa esim) (valikkoX) -> siitä (valikkoY) -> siitä kohti seuraavaan mainactivity:yyn & sama homma pikku valikkoi
    *   pelkä suoraan yksi klikkaus, mennään sinne mainactivity:yyn & paitsi mikäli on paljon valikkoa sitten erillinen toiminta
    *
    * --------------------------------------------------------------------------------------------------------------------------------------------
    *
    *   TODO:: 2) HUOM!! tää on pakko olla mukana tän ohjelman/projektin kanssa >>> polku kuin (Grandle Scripts/build.grandle(module:app))
    *    sinne kohtaan kuin (dependencies)-kohtaan lisäät tämän johonkin (implementation 'com.android.support:design:28.0.0'), jonka jälkeen
    *    2.1) Näkyy sininen palkki, (Gradle files have change since last project sync. pälä pälä) ja hyväksy (Sync now) , jotta antaa tän projektin/ohjelman lisätä tätä kirjastoa kuin (install)
    *
    *   TODO:: Sen (Install) saattaa kestää vähän aikaan, jonka jälkeen siirryt suoraan siihen pää-mainXactivity:n editointiin (layout/(.xml)), minne haluat tehdä sen (BOTTOM navigation bar)
    *    2.2) (.xml) editoinnissa lisäät tän kuin; Bottom Navigation Bar (<com.google.android.material.bottomnavigation.BottomNavigationView) & jonka jälkeen itse määrität sen mihin se tulee
    *
    *    TODO:: 2.3) tulet luomaan sille, editoinnin kaltainen menu:n osaston, kuin editoinnin missä järjestykessä se tulee olemaan esim) 1)home 2)favorite 3)profile ja jne
    *     polkuun (res/menu) menun:n kansioon luot, tai mikäli on ennen, luo kuitenkin jonkinlainen kansio sille, luot kuin; bottom_menu.xml &
    *     jonka sisään luot ne <item></item> &myös luot id-tunnus mikäli on home/favorite/ ja jne & samanaikaisesti voidaan luoda niille icon/logot - tunnistus merkki
    *
    *--------------------------------------------------------------------------------------------------------------------------------------------
    *
    *    TODO: 3) icon/logot - tunnistus merkki toiminta, tapahtuu polkun kansioon (res/drawable) >> (new) >> (image asset) jonka jälkee avauttuu uus ikkuna
    *     Eka kohta (icon type) valitset sielt (action bar and tab icons) & nimen luot sille, jonka tunnistat sen & sama homma vaikuttaa siihen kansion (menu)
    *      luoneen (.xml), eli äskeinen kappale 2.3) lopussa, koska siihen vaikuttaa sen editoinnin (icon/logon) tunnistamiseen,
    *      että se sijaitsee esim) android:icon="@drawable/ic_logon_nimi"
    *
    *    TODO: 3.1) icon/logo hommaan viel kesken) valitset oman luomanssa logon kohtaa (Clip Art) & (Trim) NO & (Theme): valitset joko HOLO_LIGHT tai omanssa haluaman teeman sille
    *       Siirryt seuraavaan sivuun (NEXT), joka se automaatisesti menee sinne kansioon (drawable), mikäli alussa käyttäjä on valinnut sinne kansioon lisät sen (icon/logon:ssa)
    *
    * --------------------------------------------------------------------------------------------------------------------------------------------
    *
    * */

    /* TODO:: Neljä objektia, tarkoittaa niitä edellisien kappale kohta 2) menun kohteita eli (home/favorite/profile/settings) valikkoa,
    *   mutta tämä objekti, avataan kuin tyyppilisen kaltaisen kuin oltaisi luotu tavallisen mainactivity:n sivuston, mutta toiminta on saman tyyppinen, vain pien ero sisällä
    *
    *TODO:: 4) luonti tapahtuu sitten, että polkujen kansioon kuin(app) >> hiiren oikea klick (new) >> (fragment) >> (fragment(Blank)) >> anna sille jokin nimi, joka pitää id-tyyppinen,
    * jotta tunnistaa, täs pää main4acitivty:n toiminassa
    * ennen kun klikkaat (Finish), kaksi kohtaa pitää olla tyhjä (Fragment(Blank)) luonnissa,
    *
    *  TODO: 4.1) Samalla voidaan esim tehdä sillä jonkilainen editointi, mm. se BOTTOM navigation Bar ulkonäön muoto on kaareva
    *    esim) koska sellainen suorakulmio tyyppinen [x_¯_y¯_¯z_¯_¯] xyz ovat ne toiminnat sivut esim) jos haluu sellaisen, että ne kulmat on tylppä
    *    toiminta tapahtuu >> (res/drawable) >> luot uuden tiedoston (new)>> (drawable resource file) >> Jokin_tunnus_kaareva_nimi
    *    lisäät vaan nää;;; & vaikka ei tuhoaisi sitä muiden ulkonäköä, mutta tää pitää olla tunnistettuna siinä tän pää-ohjelman editoinnissa
    *
    *   <shape xmlns:android="http://schemas.android.com/apk/res/android"
        android:shape="rectangle">
        <solid android:color="#fff"/>
        <corners android:radius="80dp"/>
        </shape>
    *
    *   TODO:: sun pitää avata tän pää-ohjelman editoinnin kuin (activity_mainY.xml), mikäli on tehty se kuin;;
    *    <com.google.android.material.bottomnavigation.BottomNavigationView>
    *    & sinne sisään lisäät (background) objekti/nimisen editoinnin (android:background="@drawable/Jokin_tunnus_kaareva_nimi")
    *
    *
    *
    *   TODO:: 4.2) HUOM!! nämä kaksi pitää olla TYHJÄ kuin; (include fragment factory methods?) & (include itnerface callbacks?)
    *    Näiden jälkeen voi vahvistaa (Finish)
    *    Vahvistuksen jälkeen, ne automaatisesti siirtyy polkuun muiden mainactivity:jen kanssa samaan kansioon & sama homma niiden editointi (.xml)
    *    Niiden fragment toiminta, on melko samankaltainen kuin tavallinen mainactivity:n & eli niillä on editoinnin (.xml) mistä löydät polku kansion (res/layout)
    *    Vain niiden Fragment:ien sisällön ohjelma ja editoinnin (.xml) on vähä eri, OLE TARKKANNA!!!!!
    *
    *TODO:: 4.3) Sitten vaan fragment:ien editointien (.xml) kohdassa vaan teet oman haluaman toiminnan/editoinnin homman
    *  4.3.1) Äskeisestä liittyen neljään objektiin hommaan, täs alhaalla koodi kuin (lateinit var x-tää : SeFragment) & että sen toiminta
    *  Liittyy siihen, että lukaisee sen luonneen Fragment:in tunnuksen ja tän pää-ohjelman mainactivity:n kanssa.
    *--------------------------------------------------------------------------------------------------------------------------------------------
    *
    *TODO:: 5) Kyse liittyen (lateinit var), täs tarkoituksena lukaista tän ohjelman toiminnan funktion kuin (override fun onCreate)
    *  Koska ihmee vaikuttaa sen nimetyn funktio mikäli, niiden objekti tunnistaa sen luoneen Fragmentin (nimen kanssa)
    *  Samana sen sisällä oleva funktio sisältyy sen yksi niistä osista liittyen (Bottom Nav bar:ien kanssa) eli (framelayout)
    *  Sekä oletuksena on ekana (homefragment), koska voidaan valita sitä ensimmäisenä ikkunanna, kun käynnistettään ohjelma tai mikäli mennään sen sivulle
    *
    *TODO:: 5.1)Viimeisenä täs sisältyy kuin (.setOnNavigationItemSelectedListener) - funtkio, joka on tän pää-ohjelman ikkunan, sen editoinnin (.xml)
    *  koska jotta tämä toiminta kuuntelee sitä, jotta ne objektien ikkunien fragment - ymmärtävät toisiinssa, koska jotta päästään ees takas / satunnaisesti, siksi on TRUE
    *  Siksi sen sisällä pitää olla jokaisen Fragment:ien objekti funktio
    *
    * THE END*/

    //TODO:: CREATE FOUR FRAGMENTS OBJECTS
    lateinit var homesFragment: homeFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var favFragment: FavFragment
    lateinit var settingsFragment: SettingsFragment

    //TODO:: yleis toiminnat START HERE::::::
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        refresApp() //täää pitää olla mukana, kun refresh:aa

        //TODO:: lukaisee & tunnistaa editoinnin luonneen BottomNavigation homman, kantsii tarkistaa TÄMÄN main4activity:n editointi polku kansio (.xml)
        //framlayout & bottomnav variables
        //var bottomnav : BottomNavigationView = findViewById<BottomNavigationView>(R.id.BottomNavMenu)
        var frame : FrameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        var bottomnav : BottomNavigationView = findViewById(R.id.BottomNavMenu)
        //var messageBadge : BadgeDrawable = bottomnav.getOrCreateBadge(R.id.favorite)
        //messageBadge.setNumber(5)

        /*//TODO:: Create BADGE TO BOTTOM NAVIGATION BAR (part 1 & yksi vaihtoehdoista & mutta ei poista ilmoitusta)
        val navBar = findViewById<BottomNavigationView>(R.id.BottomNavMenu)
        navBar.getOrCreateBadge(R.id.favorite).number = 3
        navBar.getOrCreateBadge(R.id.profile).number = 9999*/

        //TODO:: Create BADGE TO BOTTOM NAVIGATION BAR (part 2 & lisätään ilmoitus numero & poisto tapahtuu alhaalla)
        Handler().postDelayed({
            badgeSetup(R.id.favorite, 7)
        }, 2000)
        badgeSetup(R.id.profile, 200)
        badgeSetup(R.id.settings, 9)

        //Default fragments (tapahtuu kun siirryttään tähän ikkunaan, tämä on ensimmäisenä päällä, oletuksena)
        homesFragment = homeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, homesFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        //TODO: bottom navigation bar START HERE::::
        // josta pääsee klikkaamalla satunnaisesti, että home/profile/favourite/settings toimivat
        //create different fragements & add the menu events listener
        bottomnav.setOnNavigationItemSelectedListener { item ->

            //select each menu item and add an event when it's selected
            when (item.itemId)
            {
                R.id.home ->
                {
                    homesFragment = homeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, homesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    badgeClear(R.id.home)
                }

                R.id.favorite ->
                {
                    favFragment = FavFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, favFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    badgeClear(R.id.favorite)

                }

                R.id.profile->
                {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    badgeClear(R.id.profile)
                }

                R.id.settings ->
                {
                    settingsFragment = SettingsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    badgeClear(R.id.settings)

                }
            }
            true
        } //TODO: bottom navigation bar ENDS HERE::
        //Run to apply


    } //TODO:: YLEISET TOIMINNAT ENDS HERE::::::

    /*TODO::: Create BADGE TO BOTTOM NAVIGATION BAR (part 2 & funktio/methodi kuinka saadaan ilmoitus pois)
    *  Kun käyttäjä siirtyy toiseen sivuun eli ne objektit [favorite/profile/settings] Fragment:iin, niin ilmoitus numero lähtee pois heti
    *  Myös tähän vaikuttaa jokaisen objektin funktio/methodin tunnuksen (R.id.homman), jotta poistaa sen ilmoituksen samantien
    *  Että voidaan tunnistaa siitä, että se ilmoitus lähtee pois noiden Fragment:ien methodin/funktion sisällä lukee se >> (badgeClear(R.id.tää))
    */
    private fun badgeSetup(id: Int, alerts: Int){
        val badge = BottomNavMenu.getOrCreateBadge(id)
        badge.isVisible = true
        badge.number = alerts
    }

    private fun badgeClear(id: Int){
        val badgeDrawable = BottomNavMenu.getBadge(id)
        if(badgeDrawable != null) {
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------

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
        menu?.getItem(2)?.isVisible = false
        menu?.getItem(3)?.isVisible = false

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
                val SettingAsetus = Intent(this@Main4Activity, MainActivity::class.java)
                startActivity(SettingAsetus)
                true
            }

            R.id.valikko3 -> selectedOption = "valikko3"
            R.id.abc -> selectedOption = "abc"
            R.id.asd -> selectedOption = "asd"

        }

        Toast.makeText(this,"Options: " + selectedOption, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)

    }

    //var myrandomTulos1 = 0
    //val programLista = arrayListOf("C#", "C++", "Python", "Ruby", "Java", "JavaScript", "Kotlin" , "MySql", "Arduino", "Linux", "Ubuntu")
    val programLista = arrayListOf(" Salamani", " Mexicana", " Americana", "Beef Taco", "Big Mac")
    //"Euro-juusto", "Kana Fajita", "Chicken Lasagna", "Meat Lasagne"

    //TODO Tyyppilinen swipe down päivitys funktio, kuten nyky puhelimessa
    //  & RESFRESH TOIMINTA START HERE::::::
    private fun refresApp() {

        swipeToRefresh.setOnRefreshListener {

            //Swipe jälkeen näkyy pikainen viesti
            Toast.makeText(this, "Page refreshing!", Toast.LENGTH_SHORT).show()
            swipeToRefresh.isRefreshing = false

            /*TODO:: Jos leikkisti luoddaan annettaisi satunnainen luku/sanasto
            *esim) Random.nextInt(5..10) << tolle pitää tulla range välis & Random.nextInt(10) <<until, eli kunnes
            *Ja se tulostuu tohon textview1:in kohtaan
            * */

            var myrandomInt1 = (0..10).random()
            textView11.text = "Eka luku on: ${myrandomInt1} "

            val random = Random()
            val programType = random.nextInt(programLista.count())

            textView12.text = "Anna jotain tilaa vaikka: ${programLista[programType]}"

            /*
            myrandomTulos1 = (myrandomInt1 + myrandomInt2).toInt()


            /*TODO:: tulostetaan listasta jotain satunnaist tekstiä mitä siinä onkaan
            *  */
            val random = java.util.Random()
            val programType = random.nextInt(programLista.count())

            textView13.text = "Laskut:: ($myrandomInt1) + ($myrandomInt2) = $myrandomTulos1 \n" +
                    "Ota vaikkapa: "+ programLista[programType] + "\t shottia $myrandomTulos1"
            */

        }
    }

}

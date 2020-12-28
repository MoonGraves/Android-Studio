package com.example.ihmeprojekti

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main3.*

//TÄMÄ ON LOGIN SYSTEMS - MAIN2ACTIVITY
class Main2Activity : AppCompatActivity() {

    private var mIsShowPass = false

    //TODO:: yleiset toiminnat START HERE::::: erityisesti button, switch .... pälä pälä
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        /*TODO:: submit button homma, eli lukaisee käyttäjän tonne edittext1 kohtaan mikäli syöttää sen salasanan
            elikkäs: (editText1) lukee käyttäjän antaman salasanan & kun käyttäjä klikkaa (submit - button)
            että se tunnistaa (editext1) tekstin, että onko se oikein ja väärin. Siks on: equals("salasana"))

        TODO:: jos on esim) käyttäjä ja salasana edittext sitten lisääntyy siihen väliin tulee muodostuu tällainen merkki && lisäys
         TÄLLAINEN KOODI PÄTKÄ:::
            var status = if(editText1.text.toString().equals("Username")
               && editText2.text.toString().equals("Password")) "Logged in successfully" else "Loggin Failed"
        */

        /*TODO:: Nyt tässä saadaan toimintaan kuin käyttäjä syöttäisi sen oikean salasanan mikäli
        *  täs if-else lauseen sisällä ollaan määritetty, ei ole rajoitusta monta yritystä päästää sisään
        *
        * TODO:: Jos syöttää oikean salasanan, klikkaa submit-button, josta sen jälkeen siirtyy main3:seen,
        *  niin kauan kuin käyttäjä syöttää määritettyn salasanan eli (oppilas123)
        */

        var status = ""

        submit_button1.setOnClickListener {
            val main3 = Intent(this, Main3Activity::class.java)


            status = if(editText1.text.toString().equals("oppilas123"))
            {
                "Successful " + startActivity(main3) + "To Main3"
            }
            else
            { "Something Wrong" }

            //main3.putExtra("oppilas123", status123)
            //startActivity(main3)
            /*var status =  if(editText1.text.toString().equals("oppilas123")) "Correct"
            else "Incorrect"*/

            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
        }


        //TODO:: Password toiminta osa yksi niistä start here:
        ivShowHidePass.setOnClickListener{
            mIsShowPass = !mIsShowPass
            showPassword((mIsShowPass))
        }
        showPassword(mIsShowPass)


        //TODO:: vasen ala kulman pyöreä nappi/muu merkki
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    //TODO:: password toiminta START HERE:::::
    private fun showPassword(isShow: Boolean) {
        if(isShow)  {
            //TODO:: to show the password
            editText1.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_show_password)
            //toi alempi else-if voisi siirtää tähänkin, jos toimii?
        }

        /*//TODO:: salasanan error näkyy, jos käyttäjä ei anna/lyö salasanaa sinne edittext:iin,
        // koska ei saa olla tyhjä & pien pun varoitus merkki mikäli puuttuu jotain siinä edittext:issä
        else if(editText1.text.toString().isEmpty()){
            editText1.error = "Password cannot be empty"
        }*/

        else {
            //TODO: to hide the password
            editText1.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_hide_password)
        }




        //TODO:: this line of code to put the pointer at the end of password string
        editText1.setSelection(editText1.text.toString().length)
    }

}

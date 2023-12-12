package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.vistas.AccountsFragment
import com.example.myapplication.vistas.HomeFragment
import com.example.myapplication.vistas.LightsFragment
import com.example.myapplication.vistas.SettingsFragment

//configurar viewBinding
    class MainActivity() : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // configurar viewBinding
        setContentView(binding.root)

        //cargar fragmento cuando inicie la aplicación
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HomeFragment()).commit()
        }



        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId){

                R.id.nav_home -> {
                    //mostar fragmento home
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, HomeFragment()).commit()
                    true
                }
                R.id.nav_luces -> {
                    //mostar fragmento luces
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, LightsFragment()).commit()
                    true
                }
                R.id.nav_accounts -> {
                    //mostar fragmento accounts
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AccountsFragment()).commit()
                    true
                }
                R.id.nav_settings -> {
                    //mostar fragmento settings
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, SettingsFragment()).commit()
                    true
                }






                else -> false
                }
            }

        binding.bottomNav.setOnItemReselectedListener {
            when (it.ItemId) {
                R.id.nav_home -> Toast.makeText(this, "Bienvienido al inicio", Toast.LENGTH_SHORT).show()
                R.id.nav_luces -> Toast.makeText(this,"Aquí puedes ver tus luces", Toast.LENGTH_SHORT).show()
                R.id.nav_accounts -> Toast.makeText(this,"Aquí puedes ver tu cuenta", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(this,"Aquí puedes configurar la app", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //darle función al botón
        binding.btnIniciarSesion.setOnClickListener{
            //llamar segunda vista
            try {
                val  usuario = binding.usuario.text.toString()
                val  password = binding.password.text.toString()
                if (usuario.isNotEmpty() && password.isNotEmpty()){
                    val intent = Intent(this, segundavista::class.java)
                    intent.putExtra("usuario", usuario)
                    startActivity(intent)
                    Toast.makeText(this, "Bienvenido $usuario", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception){
                Log.e("Error", e.message.toString())
            }

    }
}
}
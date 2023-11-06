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

class MainActivity() : AppCompatActivity(), Parcelable {
    private lateinit var binding:ActivityMainBinding

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

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
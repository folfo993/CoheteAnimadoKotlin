package com.example.folfo93.kotlinanimado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        start_button.setOnClickListener {
            val datos = Intent(this, AnimationActivity::class.java)
            datos.putExtra("key1", "valor1")
            startActivity(datos)
        }
    }


}

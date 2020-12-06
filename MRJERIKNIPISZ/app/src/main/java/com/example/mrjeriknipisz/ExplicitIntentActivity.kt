package com.example.mrjeriknipisz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ExplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        txt_angsuran.text = "angsuran"
        txt_kapasitas.text = "kapasitas"
        txt_kategori.text = "kategori"
        txt_opsi_elektrik.text = "opsi elektrik"
        txt_rem_depan.text = "rem depan"

        btn_Back.setOnClickListener {
            val backIntent = Intent(this@ExplicitIntentActivity, MainActivity::class.java)
            startActivity(backIntent)
        }
    }
}
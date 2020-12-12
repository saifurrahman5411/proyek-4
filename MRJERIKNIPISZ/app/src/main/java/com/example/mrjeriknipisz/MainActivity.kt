package com.example.mrjeriknipisz

import android.content.Intent
import android.graphics.Color.parseColor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val REQUEST_CODE = 100

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_simple_intent = findViewById<Button>(R.id.btn_simple_intent)
        val btn_intent_with_data = findViewById<Button>(R.id. btn_intent_with_data)
        val btn_intent_with_parceable = findViewById<Button>(R.id.btn_intent_with_parceable)
        val btn_implicit_intent = findViewById<Button>(R.id. btn_implicit_intent)
        val intent_with_result = findViewById<Button>(R.id.btn_intent_with_result)

        btn_simple_intent.setOnClickListener{
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
        startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity,ExplicitIntentActivity::class.java)
            startActivity(dataIntent)
        }
        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "092154557908"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        btn_intent_with_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 200){
           val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
          view_result.setBackgroundColor(parseColor(color))
        }
    }
}
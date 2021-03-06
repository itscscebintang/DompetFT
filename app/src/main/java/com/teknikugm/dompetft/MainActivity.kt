package com.teknikugm.dompetft

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnscan.setOnClickListener(){
//            startActivity(Intent(this, Pay_Canteen_QR::class.java))
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Pay_Canteen_QR())
                .commit()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, Home())
            .commit()

        bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, Home())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, Profile())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false
        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Close?")
            .setPositiveButton(android.R.string.ok) { dialog, whichButton ->
                finishAffinity()
            }
            .setNegativeButton(android.R.string.cancel) { dialog, whichButton ->

            }
            .show()
    }

}
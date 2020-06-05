package com.example.pizzaorderdetail

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.conform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //About Application
        var Imag = findViewById<ImageButton>(R.id.imageButton)
        Imag.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage(
                "Pizz Pizz, Inc.,[6] branded as Pizzazz, " +
                        "is an American multinational pizza restaurant chain founded in 1960. The " +
                        "corporation is headquartered at the Pizz pizz Farms Office Park in Ann Arbor, Michigan, and " +
                        "incorporated in Delaware. In February 2018, the chain had sold more products out of all pizza sellers worldwide"
            )
                .setCancelable(false)
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("About Us")
            alert.show()
        }
        // Pizza list
        val lstpizza = resources.getStringArray(R.array.Pizzas)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            var adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, lstpizza
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + lstpizza[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }

        fun confrom(){
            var pizzlist = spinner
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Order Details")
            builder.setMessage("Your Order has Been Conformed")

            builder.setPositiveButton(android.R.string.yes) { dialog, which -> 

            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
        val btn = findViewById<Button>(R.id.conform)
        btn.setOnClickListener { confrom()}

    }



}



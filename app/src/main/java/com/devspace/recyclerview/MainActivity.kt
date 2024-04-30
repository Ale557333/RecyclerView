package com.devspace.recyclerview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
    }
}

val contacts = listOf(
    Contact(
        name = "Bini",
        phone = "+1 (647) 871-3073",
        R.drawable.sample8
    ),
    Contact(
        name = "Pamela Shein",
        phone = "+1 (647) 871-6743",
        R.drawable.sample11
    ),
    Contact(
        name = "Sergie",
        phone = "+1 (647) 871-0990",
        R.drawable.sample14
    ),
    Contact(
        name = "Jujuba",
        phone = "+1 (395) 871-1242",
        R.drawable.sample3
    ),
    Contact(
        name = "Julio Miguel",
        phone = "+1 (647) 871-8877",
        R.drawable.sample12
    )
)
package com.devspace.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
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
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setClickOnListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

val contacts = listOf(
    Contact(
        name = "Bini",
        phone = "+1 (647) 871-3073",
        R.drawable.sample8
    ),
    Contact(
        name = "Pamela",
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
        name = "Julio",
        phone = "+1 (647) 871-8877",
        R.drawable.sample12
    ),
    Contact(
        name = "Fifi",
        phone = "+1 (647) 395-1112",
        R.drawable.sample4
    ),
    Contact(
        name = "Pégue",
        phone = "+1 (647) 871-7766",
        R.drawable.sample15
    ),
    Contact(
        name = "Inês",
        phone = "+1 (647) 395-0990",
        R.drawable.sample1
    ),
    Contact(
        name = "Bia",
        phone = "+1 (647) 395-4513",
        R.drawable.sample5
    ),
    Contact(
        name = "Gil",
        phone = "+1 (647) 781-2448",
        R.drawable.sample9
    ),
    Contact(
        name = "Carlos",
        phone = "+1 (647) 781-6775",
        R.drawable.sample2
    ),
    Contact(
        name = "Angel",
        phone = "+1 (647) 395-8775",
        R.drawable.sample6
    ),
    Contact(
        name = "Chico",
        phone = "+1 (647) 781-2309",
        R.drawable.sample10
    ),
    Contact(
        name = "Megan",
        phone = "+1 (647) 781-6566",
        R.drawable.sample7
    )

)
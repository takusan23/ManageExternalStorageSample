package com.example.manageexternalstoragesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION")
            startActivity(intent)
        }

        show.setOnClickListener {
            File("/storage/emulated/0/").listFiles().forEach {
                println(it.name)
            }
        }

        read.setOnClickListener {
            File("/storage/emulated/0/書き込みテスト.txt").apply {
                createNewFile()
                writeText("書き込めてる～？")
            }
        }

    }
}
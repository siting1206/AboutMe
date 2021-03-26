package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myName:MyName = MyName("Robert", "lobird")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.doneBotton.setOnClickListener {
                addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
        binding.myName = myName

    }
    private fun addNickname(view: View){
        binding.apply{
            //myName.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameText.text = nicknameEdit.text
            nicknameEdit.visibility = View.GONE
            doneBotton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
    private fun updateNickname(view: View){

        binding.apply{
            nicknameEdit.visibility = View.VISIBLE
            doneBotton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }
        binding.nicknameEdit.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)

    }
}
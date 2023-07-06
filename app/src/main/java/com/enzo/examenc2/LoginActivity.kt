package com.enzo.examenc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.enzo.examenc2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var isEmailOk: Boolean = false
    private var isPasswordOk: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()

    }
    private fun setupViews(){
        binding.tilEmail.editText?.addTextChangedListener{text ->
            binding.btnLogin.isEnabled = validateInputs(text.toString(), binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener{text ->
            binding.btnLogin.isEnabled= validateInputs(binding.tilEmail.editText?.text.toString(), text.toString())
        }
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateInputs(email: String,password: String):Boolean{
        val isEmailOk = email == "ejemplo@idat.edu.pe"
        val isPasswordOk = password == "123456"
        return isPasswordOk && isEmailOk
    }

}
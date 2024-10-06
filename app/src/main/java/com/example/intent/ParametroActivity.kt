package com.example.intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.MainActivity.Constantes.PARAMETRO_EXTRA
import com.example.intent.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {

    private val apb: ActivityParametroBinding by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)

        setSupportActionBar(apb.toolbarTb)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            subtitle = this@ParametroActivity.javaClass.canonicalName
        }

        intent.getStringExtra(PARAMETRO_EXTRA)?.also{ parametro ->
            apb.parametroEt.setText(parametro)
        }

        apb.enviarParametroBt.setOnClickListener {
            Intent().apply {
                apb.parametroEt.text.toString().let {
                    putExtra(PARAMETRO_EXTRA, it)
                }
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}
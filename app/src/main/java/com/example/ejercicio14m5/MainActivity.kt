package com.example.ejercicio14m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio14m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOk.setOnClickListener {
            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButtonSaldo ->
                    binding.textMonto.setText(saldo.toString())
                R.id.radioButtonIngresar -> ingresarSaldo()
                R.id.RadioButtonRetirar -> retirarSaldo()
                R.id.RadioButtonSalir -> finish()
            }
        }
    }

    fun retirarSaldo() {
        val monto =  binding.textMonto.text.toString().toInt()
        if (monto<=saldo) {
            saldo -= monto
            limpiarMonto()
            crearMensaje("El retiro ha sido realizado con exito")
        }
        else{
            Toast.makeText(applicationContext, "Su saldo supera el saldo inicial,intente nuevamente", Toast.LENGTH_LONG).show()
        }
    }
    fun ingresarSaldo() {
        saldo += binding.textMonto.text.toString().toInt()
        limpiarMonto()
        crearMensaje("su saldo ha sido actualizado  correctamente")
        Toast.makeText(applicationContext, "su saldo ha sido actualizado  correctamente", Toast.LENGTH_LONG).show()
    }

    fun limpiarMonto() {
        binding.textMonto.text.clear()
    }
    fun crearMensaje(s: String) {
        Toast.makeText(applicationContext, "", Toast.LENGTH_LONG).show()




    }
}


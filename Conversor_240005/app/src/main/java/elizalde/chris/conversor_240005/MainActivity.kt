package elizalde.chris.conversor_240005

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var tipoDeConversion = ""
    var valor = 0
    var resultado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonTemperatura: Button = findViewById(R.id.buttonTemperatura)
        val buttonPeso: Button = findViewById(R.id.buttonPeso)
        val buttonLongitud: Button = findViewById(R.id.buttonLongitud)
        val buttonVolumen: Button = findViewById(R.id.buttonVolumen)
        val txtConvertir: TextView = findViewById(R.id.txtConvertir)
        val edtTxtValor: EditText = findViewById(R.id.edtTxtValor)
        val txtResultadoConversion: TextView = findViewById(R.id.txtResultadoConversion)
        val buttonConfirm: Button = findViewById(R.id.confirmConversion)

        buttonTemperatura.setOnClickListener {
            txtConvertir.setText("Convertir Celcius a Fahrenheit")
            buttonConfirm.visibility= View.VISIBLE
            tipoDeConversion = "Temperatura"
        }

        buttonPeso.setOnClickListener {
            txtConvertir.setText("Convertir Kilogramos a Libras")
            buttonConfirm.visibility= View.VISIBLE
            tipoDeConversion = "Peso"
        }

        buttonLongitud.setOnClickListener {
            txtConvertir.setText("Convertir Metros a Pies")
            buttonConfirm.visibility= View.VISIBLE
            tipoDeConversion = "Longitud"
        }

        buttonVolumen.setOnClickListener {
            txtConvertir.setText("Convertir Litros a Onzas")
            buttonConfirm.visibility= View.VISIBLE
            tipoDeConversion = "Volumen"
        }

        buttonConfirm.setOnClickListener {
            val valorTexto = edtTxtValor.text.toString()

            if (valorTexto.isEmpty()) {
                txtResultadoConversion.text = "Por favor ingresa un valor"
                return@setOnClickListener
            }

            val valor = valorTexto.toDoubleOrNull()
            if (valor == null) {
                txtResultadoConversion.text = "El valor debe ser numérico"
                return@setOnClickListener
            }

            val resultado = when (tipoDeConversion) {
                "Temperatura" -> (valor * 9/5) + 32
                "Peso" -> valor * 2.20462
                "Longitud" -> valor * 3.28084
                "Volumen" -> valor * 33.814
                else -> null
            }

            if (resultado != null) {
                txtResultadoConversion.text = "Resultado: $resultado"
                buttonConfirm.visibility= View.INVISIBLE
                edtTxtValor.setText("")
            } else {
                txtResultadoConversion.text = "Error: conversión no definida"
            }
        }


    }
}
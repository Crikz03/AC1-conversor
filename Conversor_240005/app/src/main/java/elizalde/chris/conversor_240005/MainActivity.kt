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
        }

    }
}
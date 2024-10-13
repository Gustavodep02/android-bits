package br.edu.fateczl.calcularbits;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBits;
    private TextView tvSaida;
    private Button btnConverter;
    private RadioButton rbBytes, rbKBytes, rbMBytes, rbGBytes, rbTBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etBits = findViewById(R.id.etValor);
        tvSaida = findViewById(R.id.tvSaida);
        rbBytes = findViewById(R.id.rbBytes);
        rbBytes.setChecked(true);
        rbKBytes = findViewById(R.id.rbKbytes);
        rbMBytes = findViewById(R.id.rbMbytes);
        rbGBytes = findViewById(R.id.rbGbytes);
        rbTBytes = findViewById(R.id.rbTbytes);
        btnConverter = findViewById(R.id.btnConverter);
        btnConverter.setOnClickListener(op -> converter());

    }
    private void converter() {
        Long valor = Long.parseLong(etBits.getText().toString());
        String saida = "";
        if (rbBytes.isChecked()) {
            double bytes = valor / 8;
             saida = bytes + getString(R.string.saidaBytes);
        }else if (rbKBytes.isChecked()) {
            double kbytes = valor / 8192.0;
             saida = kbytes + getString(R.string.saidaKBytes);
        }else if(rbMBytes.isChecked()) {
            double mbytes = valor / 8388608.0;
             saida = mbytes + getString(R.string.saidaMBytes);
        }else if (rbGBytes.isChecked()) {
            double gbytes = valor / 8589934592.0;
             saida = gbytes + getString(R.string.saidaGBytes);
        }else if (rbTBytes.isChecked()) {
            double tbytes = valor / 8796093022208.0;
            saida = tbytes + getString(R.string.saidaTBytes);
        }
        tvSaida.setText(saida);
}
}
package tiil.edu.appcong;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText edtA,edtB;
    Button btnCong;
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnCong = findViewById(R.id.btnCong);
        txtKQ = findViewById(R.id.txtKQ);
        btnCong.setOnClickListener(v -> {
            String aStr = edtA.getText().toString().trim();
            String bStr = edtB.getText().toString().trim();
            if (aStr.isEmpty() || bStr.isEmpty()) {
                txtKQ.setText("Nhập đủ số");
                return;
            }
            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);
            txtKQ.setText(String.valueOf(a + b));
        });
    }
}
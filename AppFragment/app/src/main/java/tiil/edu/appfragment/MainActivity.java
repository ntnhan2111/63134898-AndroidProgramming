package tiil.edu.appfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> tinh("+"));
        btnSub.setOnClickListener(v -> tinh("-"));
        btnMul.setOnClickListener(v -> tinh("*"));
        btnDiv.setOnClickListener(v -> tinh("/"));
    }

       private void tinh(String phepToan){
            String aStr = edtA.getText().toString();
            String bStr = edtB.getText().toString();

            if (aStr.isEmpty() || bStr.isEmpty()) {
                tvResult.setText("Vui lòng nhập A và B");
                return;
            }

            double a = Double.parseDouble(aStr);
            double b = Double.parseDouble(bStr);
            double kq = 0;

            switch (phepToan) {
                case "+":
                    kq = a + b;
                    break;
                case "-":
                    kq = a - b;
                    break;
                case "*":
                    kq = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        tvResult.setText("Không thể chia cho 0");
                        return;
                    }
                    kq = a / b;
                    break;
            }
            tvResult.setText(String.valueOf(kq));
       }
}

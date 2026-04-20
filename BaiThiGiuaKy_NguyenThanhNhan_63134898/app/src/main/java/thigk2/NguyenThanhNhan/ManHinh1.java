package thigk2.NguyenThanhNhan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ManHinh1 extends AppCompatActivity {

    EditText edtDai, edtRong;
    Button btnTinh;
    TextView tvKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcn);

        edtDai = findViewById(R.id.edtDai);
        edtRong = findViewById(R.id.edtRong);
        btnTinh = findViewById(R.id.btnTinh);
        tvKQ = findViewById(R.id.tvKQ);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String daiStr = edtDai.getText().toString();
                String rongStr = edtRong.getText().toString();

                if(daiStr.isEmpty() || rongStr.isEmpty()){
                    tvKQ.setText("Vui lòng nhập đầy đủ!");
                    return;
                }

                double dai = Double.parseDouble(daiStr);
                double rong = Double.parseDouble(rongStr);

                double chuVi = 2 * (dai + rong);
                double dienTich = dai * rong;

                tvKQ.setText("Chu vi: " + chuVi + "\nDiện tích: " + dienTich);
            }
        });
    }
}
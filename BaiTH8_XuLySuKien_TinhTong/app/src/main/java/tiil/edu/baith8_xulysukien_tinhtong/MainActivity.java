package tiil.edu.baith8_xulysukien_tinhtong;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gắn layout tương ứng với file này
        setContentView(R.layout.activity_main);
    }
    //Đây là bộ lắng nghe và xử lý sự kiện click lên nút tính tổng
    public void XuLyCong(View view){
        EditText editTextsoA = findViewById(R.id.edtA);
        EditText editTextsoB = findViewById(R.id.edtB);
        EditText editTextKetQua = findViewById(R.id.edtKQ);

        //Lấy dữ liệu về ở điều kiện số a
        String strA = editTextsoA.getText().toString();
        //Lấy dữ liệu về ở điều kiện số b
        String strB = editTextsoB.getText().toString();

        //Chuyển dữ liệu sang dạng số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);

        //Tính toán theo yêu cầu
        int tong = so_A + so_B;
        String strTong = String.valueOf(tong);
        //Hiện ra màn hình
        editTextKetQua.setText(strTong);



    }
}
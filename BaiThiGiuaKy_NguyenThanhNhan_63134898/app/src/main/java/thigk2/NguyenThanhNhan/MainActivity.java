package thigk2.NguyenThanhNhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManHinh1.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManHinh2.class);
            startActivity(intent);
        });

        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManHinh3.class);
            startActivity(intent);
        });

        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManHinh4.class);
            startActivity(intent);
        });

    }
}
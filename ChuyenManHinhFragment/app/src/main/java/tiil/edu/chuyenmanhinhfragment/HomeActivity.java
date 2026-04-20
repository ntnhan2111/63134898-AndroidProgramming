package tiil.edu.chuyenmanhinhfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvUserName = findViewById(R.id.tvUserName);

        // nhận dữ liệu
        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");

        tvUserName.setText("Chào mừng " + username);
    }
}
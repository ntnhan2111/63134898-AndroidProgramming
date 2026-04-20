package tiil.edu.chuyenmanhinhfragment;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUserName = findViewById(R.id.edtUserName);
        EditText edtPass = findViewById(R.id.edtPass);
        EditText edtMail = findViewById(R.id.edtMail);
        Button btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(v -> {
            String username = edtUserName.getText().toString();

            Intent iQuiz = new Intent(LoginActivity.this, HomeActivity.class);
            iQuiz.putExtra("USER_NAME", username); // truyền dữ liệu
            startActivity(iQuiz);
        });
    }
}
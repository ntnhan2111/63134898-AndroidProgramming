package tiil.edu.quanlychitieu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    EditText edtName, edtMoney;
    Button btnSave;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtName = findViewById(R.id.edtName);
        edtMoney = findViewById(R.id.edtMoney);
        btnSave = findViewById(R.id.btnSave);

        databaseReference =
                FirebaseDatabase.getInstance()
                        .getReference("expenses");

        btnSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String name =
                                edtName.getText()
                                        .toString()
                                        .trim();

                        String moneyText =
                                edtMoney.getText()
                                        .toString()
                                        .trim();

                        if (TextUtils.isEmpty(name)
                                || TextUtils.isEmpty(moneyText)) {

                            Toast.makeText(
                                    AddActivity.this,
                                    "Nhập đầy đủ dữ liệu",
                                    Toast.LENGTH_SHORT
                            ).show();

                            return;
                        }

                        int money =
                                Integer.parseInt(moneyText);

                        String id =
                                databaseReference.push().getKey();

                        Expense expense =
                                new Expense(id, name, money);

                        databaseReference
                                .child(id)
                                .setValue(expense);

                        Toast.makeText(
                                AddActivity.this,
                                "Thêm thành công",
                                Toast.LENGTH_SHORT
                        ).show();

                        finish();
                    }
                });
    }
}
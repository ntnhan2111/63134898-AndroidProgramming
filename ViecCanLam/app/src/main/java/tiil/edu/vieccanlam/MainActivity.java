package tiil.edu.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtCongViec;
    Button btnThem;
    ListView listView;

    ArrayList<String> dsCongViec;
    ArrayAdapter<String> adapter;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        edtCongViec = findViewById(R.id.edtCongViec);
        btnThem = findViewById(R.id.btnThem);
        listView = findViewById(R.id.listView);

        // ArrayList
        dsCongViec = new ArrayList<>();

        // Adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsCongViec
        );

        listView.setAdapter(adapter);

        // Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference =
                firebaseDatabase.getReference("CongViec");

        // Thêm dữ liệu
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tenCongViec =
                        edtCongViec.getText()
                                .toString()
                                .trim();

                if (tenCongViec.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Nhập công việc",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                String id =
                        databaseReference.push().getKey();

                CongViec congViec =
                        new CongViec(tenCongViec);

                databaseReference
                        .child(id)
                        .setValue(congViec);

                edtCongViec.setText("");

                Toast.makeText(
                        MainActivity.this,
                        "Đã thêm",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Đọc dữ liệu realtime
        databaseReference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(
                            DataSnapshot snapshot) {

                        dsCongViec.clear();

                        for (DataSnapshot data :
                                snapshot.getChildren()) {

                            CongViec cv =
                                    data.getValue(
                                            CongViec.class
                                    );

                            if (cv != null) {
                                dsCongViec.add(
                                        cv.getTen()
                                );
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(
                            DatabaseError error) {

                    }
                }
        );
    }
}
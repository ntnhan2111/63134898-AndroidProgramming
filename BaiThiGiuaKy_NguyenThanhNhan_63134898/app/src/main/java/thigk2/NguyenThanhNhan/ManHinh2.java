package thigk2.NguyenThanhNhan;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ManHinh2 extends AppCompatActivity {

    ListView listViewTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh);

        listViewTinh = findViewById(R.id.listViewTinh);

        // Hard-code dữ liệu
        String[] dsTinh = {
                "TP Hồ Chí Minh",
                "Hà Nội",
                "Đà Nẵng",
                "Cần Thơ",
                "Hải Phòng",
                "Bình Dương",
                "Đồng Nai",
                "Khánh Hòa - Nguyễn Thành Nhân",
                "Huế",

        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsTinh
        );

        listViewTinh.setAdapter(adapter);
    }
}

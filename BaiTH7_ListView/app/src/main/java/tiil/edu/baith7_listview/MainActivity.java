package tiil.edu.baith7_listview;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTenTinhThanhVN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dsTenTinhThanhVN = new ArrayList<String>();
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Ninh Thuận");
        dsTenTinhThanhVN.add("Bình Thuận");
        dsTenTinhThanhVN.add("Nha Trang");

        ArrayAdapter<String> adapterTinhThanh = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dsTenTinhThanhVN
        );

        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);

        lvTenTinhThanh.setAdapter(adapterTinhThanh);

        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXL);

    }

    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            String strTenTinhChon = dsTenTinhThanhVN.get(i);
            Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + String.valueOf(i),Toast.LENGTH_LONG).show();

        }
    };
}
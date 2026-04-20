package thigk2.NguyenThanhNhan;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class ManHinh3 extends AppCompatActivity {

    ListView listView;
    ArrayList<HashMap<String, Object>> ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulich);

        listView = findViewById(R.id.listViewDL);

        ds = new ArrayList<>();

        // Hard-code 5 địa điểm
        ds.add(createItem("VinWonders Nha Trang", "Đảo Hòn Tre", R.drawable.h1));
        ds.add(createItem("Tháp Bà Ponagar", "2 Tháng 4", R.drawable.h2));
        ds.add(createItem("Chùa Long Sơn", "23/10", R.drawable.h3));
        ds.add(createItem("Hòn Chồng", "Phạm Văn Đồng", R.drawable.h4));
        ds.add(createItem("Viện Hải Dương Học", "Cầu Đá", R.drawable.h5));

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                ds,
                R.layout.item_dulich,
                new String[]{"hinh", "ten", "diachi"},
                new int[]{R.id.imgHinh, R.id.tvTen, R.id.tvDiaChi}
        );

        // xử lý ảnh
        adapter.setViewBinder((view, data, textRepresentation) -> {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource((Integer) data);
                return true;
            }
            return false;
        });

        listView.setAdapter(adapter);
    }

    private HashMap<String, Object> createItem(String ten, String diachi, int hinh) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ten", ten);
        map.put("diachi", diachi);
        map.put("hinh", hinh);
        return map;
    }
}

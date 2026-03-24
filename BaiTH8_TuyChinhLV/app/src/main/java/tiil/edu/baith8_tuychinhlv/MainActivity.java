package tiil.edu.baith8_tuychinhlv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tìm listview
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        //Chuẩn bị nguồn dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Cơm tấm sườn",25000,"Mô tả ở đây",R.drawable.cts));
        dsMonAn.add(new MonAn("Cơm tấm sườn trứng",27000,"Mô tả ở đây",R.drawable.cst));
        dsMonAn.add(new MonAn("Cơm gà xối mỡ",30000,"Mô tả ở đây",R.drawable.cgxm));
        dsMonAn.add(new MonAn("Cơm tấm sườn bì chả",32000,"Mô tả ở đây",R.drawable.csbc));
        dsMonAn.add(new MonAn("Cơm tấm đặc biệt",35000,"Mô tả ở đây",R.drawable.ctdb));

        //
        MonAnAdapter adapter = new MonAnAdapter(this,dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        //Bắt xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Lấy phần tử được chọn
                MonAn monAnChon = dsMonAn.get(i);

                Toast.makeText(MainActivity.this,monAnChon.getTenMonAn(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
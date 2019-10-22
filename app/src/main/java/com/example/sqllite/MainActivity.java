
package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<SinhVien> adapter;
    private ArrayList<SinhVien> listSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SinhVien sv1 = new SinhVien("1","Huy");
        SinhVien sv2 = new SinhVien("2","Hải");
        SinhVien sv3 = new SinhVien("3","Hiếu");

        DBClasses database = new DBClasses(this);
        database.addSinhVien(sv1);
        database.addSinhVien(sv2);
        database.addSinhVien(sv3);



        listView = (ListView) findViewById(R.id.lv_main);
        listSV = new ArrayList<>();

        listSV = database.getALLSinhVien();

        ArrayList<String> listshow = new ArrayList<>();

        for(int i = 0 ; i<database.getCount();i++)
        {
            String show = "ID: " + listSV.get(i).getId() + "   " + "Tên: "+listSV.get(i).getName();
            listshow.add(show);
        }

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listshow);
        listView.setAdapter(adapter);

    }


    public void XoaSinhVien(View view) {
        
    }
}

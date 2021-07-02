package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    MyListAdapter adapter; // 만들어놓은 adater 여기서 선언 (연결해야하므로)
    RecyclerView recyclerView;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        init();
    }
    private void init(){
        data.add("HARIM");
        data.add("MOTHER");
        data.add("FATHER");

        adapter = new MyListAdapter(this, data);
        recyclerView = findViewById(R.id.profilelist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);//연결

        et = findViewById(R.id.etAdd);
    }

    public void onAdd(View view) {
        String prof = et.getText().toString();
        data.add(prof);
        adapter.notifyDataSetChanged();// Adapter에게 데이터 변경됐으니 다시 뿌리라고 알림
        // 데이타 삭제도 마찬가지
    }
}
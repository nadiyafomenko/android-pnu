package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter();
        List<String> list = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 5; i++) {
            list.add(String.valueOf(i));
        }

        findViewById(R.id.button).setOnClickListener(view -> {
            int lastItem = Integer.parseInt(list.get(list.size() - 1));
            list.add(String.valueOf(lastItem + 1));
            adapter.notifyItemInserted(list.size() - 1);
        });

        adapter.setList(list);
        recyclerView.setAdapter(adapter);
    }
}
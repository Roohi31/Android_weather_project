package com.example.weatherapprsaba.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapprsaba.Adapters.HourlyAdapter;
import com.example.weatherapprsaba.Domains.Hourly;
import com.example.weatherapprsaba.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7daysBtn = findViewById(R.id.nextBtn);
        next7daysBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,TommorowActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("10 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sun"));
        items.add(new Hourly("12 pm",30,"wind"));
        items.add(new Hourly("01 pm",29,"rainy"));
        items.add(new Hourly("02 pm",27,"storm"));
        items.add(new Hourly("03 pm",25,"wind"));
        items.add(new Hourly("04 pm",26,"wind"));
        items.add(new Hourly("05 pm",23,"rainy"));
        items.add(new Hourly("06 pm",25,"cloudy"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
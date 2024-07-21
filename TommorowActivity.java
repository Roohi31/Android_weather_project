package com.example.weatherapprsaba.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapprsaba.Adapters.TommorowAdapter;
import com.example.weatherapprsaba.Domains.TommorowDomain;
import com.example.weatherapprsaba.R;

import java.util.ArrayList;

public class TommorowActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tommorow);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(TommorowActivity.this,MainActivity.class)));
    }

    public void initRecyclerView()
    {
        ArrayList<TommorowDomain> items = new ArrayList<>();

        items.add(new TommorowDomain("Sat","storm","Storm",25,10));
        items.add(new TommorowDomain("Sun","cloudy","Rainy_sunny",24,16));
        items.add(new TommorowDomain("Mon","cloudy_3","Cloudy",29,15));
        items.add(new TommorowDomain("Tue","cloudy_sunny","Cloudy-Sunny",22,13));
        items.add(new TommorowDomain("Wed","sun","Sunny",28,11));
        items.add(new TommorowDomain("Thu","rainy","Rainy",23,12));
        items.add(new TommorowDomain("Fri","storm","Storm",20,10));




        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTomorrow = new TommorowAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}











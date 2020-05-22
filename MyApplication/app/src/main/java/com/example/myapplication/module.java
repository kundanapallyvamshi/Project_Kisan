package com.example.myapplication;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class module extends AppCompatActivity {
    Button b3,b4;
    public void Init() {
        b3 = (Button) findViewById(R.id.button1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {

                Intent l = new Intent(module.this, admin.class);
                startActivity(l);
            }
        });

    }
    public void init() {
        b4 = (Button) findViewById(R.id.button2);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent l = new Intent(module.this, farmer.class);
                startActivity(l);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        init();
        Init();
    }
}

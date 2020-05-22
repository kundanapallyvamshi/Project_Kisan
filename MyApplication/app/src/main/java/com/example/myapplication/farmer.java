package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_SHORT;

public class farmer extends AppCompatActivity {
    EditText E1, E2, E3, E4;
    Button b3, r;

    public void init() {
        E1 = (EditText) findViewById(R.id.sub_id);
        E2 = (EditText) findViewById(R.id.user_number);
        E3 = (EditText) findViewById(R.id.gsm_number);
        E4 = (EditText) findViewById(R.id.GSM_location);
        b3 = (Button) findViewById(R.id.button5);
        r = (Button) findViewById(R.id.button7);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {

                String NUMBER = E3.getText().toString();
                if (NUMBER.length() != 10) {
                    if (NUMBER.length() != 10) {
                        if (NUMBER.length() > 0) {
                            int y = 1;
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(), "Invalid Number", Toast.LENGTH_SHORT);
                            toast1.setDuration(y);
                            toast1.show();
                            int X = 1;
                            Toast toast2 =
                                    Toast.makeText(getApplicationContext(), "Please Enter A Valid Number", Toast.LENGTH_SHORT);
                            toast2.setDuration(X);
                            toast2.show();
                        } else {
                            int y = 1;
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(), "GSM number is MUST", Toast.LENGTH_SHORT);
                            toast1.setDuration(y);
                            toast1.show();
                        }
                    }
                } else {
                    Intent I = new Intent(farmer.this, farmer_control_panel.class);
                    I.putExtra("my_key", NUMBER);
                    startActivity(I);
                }

            }
        });
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        init();

    }
}
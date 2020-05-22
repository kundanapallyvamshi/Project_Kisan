package com.example.myapplication;
import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class admin_control_panel extends AppCompatActivity {
    ToggleButton b4;
    Button b5;
    float x=(float)0.002;
    EditText num1;
    TextView t1,t2;
    public static final int MY_PERMISSION_REQUEST_SEND_SMS = 0;

    public void current_on() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, MY_PERMISSION_REQUEST_SEND_SMS);
        } else {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("9676089083", null, "CURRENT ON", null, null);
        }
    }

    public void current_off() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, MY_PERMISSION_REQUEST_SEND_SMS);
        } else {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("9676089083", null, "CURRENT OFF", null, null);
        }
    }
    void search()
    {
        b5 = (Button) findViewById(R.id.button9);
        num1=(EditText)findViewById(R.id.editText);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                if(num1!=null) {
                    t1 = (TextView) findViewById(R.id.textView7);
                    float y = (float) 1.5, z, n;
                    z = x * y;
                    t1.setText("Rs:" + (float) z);
                    t1.setTextColor(Color.BLUE);
                    t1.setTextSize((float) 40.6);
                    z+=x;
                }
                else
                {
                    int y = 1;
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(), "please enter the number", Toast.LENGTH_SHORT);
                    toast1.setDuration(y);
                    toast1.show();
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_control_panel);
        search();
        b4 = (ToggleButton) findViewById(R.id.toggleButton);
        b4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    current_on();
                } else {
                    current_off();
                }
            }

        });
    }
}



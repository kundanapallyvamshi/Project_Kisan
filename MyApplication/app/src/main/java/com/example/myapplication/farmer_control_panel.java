package com.example.myapplication;
import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class farmer_control_panel extends AppCompatActivity {
    Switch s1,s2;
    static float x= (float) 0.002;
    public ToggleButton b4;
    public RelativeLayout ll;
    static String msg,msg1,msg3;
    TextView t1,t2,t3;
    Button hr_1,hr_2,hr_3;
    int MY_PERMISSION_REQUEST_SEND_SMS=1;
    public void swtch(String N){
        final String num=N;
        s1 = (Switch) findViewById(R.id.motor);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    int x = 3;
                    Toast toast =
                            Toast.makeText(getApplicationContext(), "మోటర్ ఆన్ అయ్యింది", Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                    msg = "MON*";
                    t1.setBackgroundColor(Color.GREEN);
                    message_on(num);

                } else {
                    int x = 3;
                    Toast toast =
                            Toast.makeText(getApplicationContext(), "మోటర్ ఆఫ్ అయ్యింది", Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                    msg = "MOFF*";
                    t1.setBackgroundColor(Color.RED);
                    message_off(num);

                }
            }
        });
    }


    public void sms2(String M)
    {   final String number=M;
        s2=(Switch)findViewById(R.id.light);
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    int x=1;
                    Toast toast=
                            Toast.makeText(getApplicationContext(),"ట్రాపర్ ఆన్ అయ్యింది",Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                    msg1="LON*";
                    message_light_on(number);
                    t2.setBackgroundColor(Color.GREEN);
                }
                else{
                    int x=1;
                    Toast toast=
                            Toast.makeText(getApplicationContext(),"ట్రాపర్ ఆఫ్ అయ్యింది",Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                    msg1="LOFF*";
                    message_light_off(number);
                    t2.setBackgroundColor(Color.RED);

                }
            }
        });

    }


    public void  swtch_f() {
        s1 = (Switch) findViewById(R.id.motor);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    ll = (RelativeLayout) findViewById(R.id.layout);
                    ll.setBackgroundColor(Color.RED);
                    int x = 1;
                    Toast toast =
                            Toast.makeText(getApplicationContext(), "పానల్ అక్టివేట్ కాలెదు", Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                } else {
                    int x = 1;
                    Toast toast =
                            Toast.makeText(getApplicationContext(), "పానల్ అక్టివేట్ చెయ్యండి", Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();

                }
            }
        });
    }

    public void  sms_f()
    {
        s2=(Switch)findViewById(R.id.light) ;
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    ll=(RelativeLayout)findViewById(R.id.layout) ;
                    ll.setBackgroundColor(Color.RED);;
                    int x=1;
                    Toast toast=
                            Toast.makeText(getApplicationContext(),"పానల్ అక్టివేట్ కాలెదు",Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();

                }
                else{
                    ll=(RelativeLayout)findViewById(R.id.layout) ;
                    ll.setBackgroundColor(Color.RED);
                    int x=1;
                    Toast toast=
                            Toast.makeText(getApplicationContext(),"పానల్ అక్టివేట్ చెయ్యండి",Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                }
            }

        });
    }

    public  void message_off(String p)
    {
        String phno=p;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }
        else
        {
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(phno,null,msg,null,null);
            final MediaPlayer mp;
            mp = MediaPlayer.create(this, R.raw.motoroffayyindi);
            mp.start();
            t3=(TextView)findViewById(R.id.textView4);
            float y=(float) 1.5,z,n;
            z=x*y;
            t3.setText("Rs:"+(float) z);
            t3.setTextColor(Color.BLUE);
            t3.setTextSize((float) 40.6);
            x+=(float)0.002;
        }
    }
    public void message_on(String t)
    {
        String phno=t;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }
        else
        {
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(phno,null,msg,null,null);
            final MediaPlayer mp1;
            mp1 = MediaPlayer.create(this, R.raw.motoronayyindi);
            mp1.start();
        }
    }

    public  void message_light_off(String e)
    {

        String phno=e;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }
        else
        {
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(phno,null,msg1,null,null);
            final MediaPlayer mp;
            mp = MediaPlayer.create(this, R.raw.trapperoffayyindi);
            mp.start();
        }
    }
    public void message_light_on(String n)
    {
        String phno=n;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);

        }
        else
        {
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(phno,null,msg1,null,null);
            final MediaPlayer mp;
            mp = MediaPlayer.create(this, R.raw.trapperonayyindi);
            mp.start();
        }
    }

    public void activate(String X)
    {
        msg3="REGISTER*";
        String phno=X;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }
        else
        {
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(phno,null,msg3,null,null);
        }
    }
    public void schedule(final String X)
    {
        hr_1=(Button)findViewById(R.id.button4);
        hr_2=(Button)findViewById(R.id.button12);
        hr_3=(Button)findViewById(R.id.button13);
        hr_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                message_on(X);
            }
        });
        hr_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                message_on(X);

            }
        });
        hr_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                message_on(X);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_control_panel);
        t1=(TextView)findViewById(R.id.textView5);
        t2=(TextView)findViewById(R.id.textView3);
        t1.setBackgroundColor(Color.RED);
        t2.setBackgroundColor(Color.RED);
        Intent I=getIntent();
        final String num = I.getStringExtra("my_key");
        final MediaPlayer mp;
        mp = MediaPlayer.create(this, R.raw.panelactivatecheyyandi);
        String MSGFROMSUBSTATION="CURRENTCIRCULATIONSTART";
        String MSGFROMGSMWATERLEVEL="WATERLEVELCOMPLETED";
        mp.start();
        mp.start();
        swtch_f();
        sms_f();
        b4 = (ToggleButton) findViewById(R.id.action);
        int x = 1;
        Toast toast =
                Toast.makeText(getApplicationContext(), "పానల్ అక్టివేట్ చెయ్యండి", Toast.LENGTH_SHORT);
        toast.setDuration(x);
        toast.show();
        b4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    activate(num);
                    ll = (RelativeLayout) findViewById(R.id.layout);
                    ll.setBackgroundColor(Color.rgb(57, 255, 20));
                    int x = 1;
                    Toast toast =
                            Toast.makeText(getApplicationContext(), "పానల్ అక్టివేట్ అయ్యింది", Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                    swtch(num);
                    sms2(num);
                    schedule(num);
                } else {
                    ll.setBackgroundColor(Color.rgb(0, 221, 225));
                    int x = 1;
                    Toast toast =
                            Toast.makeText(getApplicationContext(), "పానల్  డిఅక్టివేట్ అయ్యింది", Toast.LENGTH_SHORT);
                    toast.setDuration(x);
                    toast.show();
                    swtch_f();
                    sms_f();
                }
            }
        });

    }
}

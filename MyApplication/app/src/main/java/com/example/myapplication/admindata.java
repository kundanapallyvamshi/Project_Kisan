package com.example.myapplication;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.admin_control_panel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admindata extends AppCompatActivity {
    Button bt3;
    EditText E1,E2,E3;
    DatabaseReference databaseadmins;
    public void Init() {
        bt3 = (Button) findViewById(R.id.button8);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                add_admin();
                Intent y = new Intent(admindata.this, admin_control_panel.class);
                startActivity(y);
            }
        });
    }
    private void add_admin()
    {
        String admin_id=E1.getText().toString();
        String password=E3.getText().toString();
        String admin_number=E2.getText().toString();
        if (!TextUtils.isEmpty(admin_id))
        {
            String ID=databaseadmins.push().getKey();
            admin_data admin=new admin_data(admin_id,password,admin_number);
            databaseadmins.child(ID).setValue(admin);
            Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"must be filled",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindata);
        E1=(EditText)findViewById(R.id.newid);
        E2=(EditText)findViewById(R.id.admin_number);
        E3=(EditText)findViewById(R.id.password) ;
        databaseadmins= FirebaseDatabase.getInstance().getReference("admin_data");
        Init();
    }

}

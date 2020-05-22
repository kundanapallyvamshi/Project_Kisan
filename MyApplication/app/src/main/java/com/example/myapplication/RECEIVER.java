package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class RECEIVER extends BroadcastReceiver {
    private static SmsListener  msgListener;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "vamshi", Toast.LENGTH_LONG).show();
        // TODO Auto-generated method stub
        Bundle bundle = intent.getExtras();

        Object messages[] = (Object[]) bundle.get("pdus");
        SmsMessage smsMessage[] = new SmsMessage[messages.length];
        for (int n = 0; n < messages.length; n++) {
            smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
        }

        // show first message
        Toast toast = Toast.makeText(context,
                "Received SMS: "/* + smsMessage[0].getMessageBody()*/,
                Toast.LENGTH_LONG);
        toast.show();

    }
}

package com.dam.firstfirestbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RealTimeActivity extends AppCompatActivity {

    // VARS GLOBALES
    private static final String TAG = "RealTimeActivity";


    FirebaseDatabase db;
    DatabaseReference myRef;

    private Button btnSend;
    private EditText etMessage;

    // Initalisation des composants
    private void initUI(){
        db = FirebaseDatabase.getInstance("https://todel-fb165-default-rtdb.europe-west1.firebasedatabase.app");
        myRef = db.getReference("message");
        btnSend = findViewById(R.id.btnSend);
        etMessage = findViewById(R.id.etMessage);
    }

    public void sendMessage(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();
                myRef.setValue(message);
            Toast.makeText(RealTimeActivity.this,
                        message, Toast.LENGTH_SHORT).show();
                Log.i(TAG, "sendMessage: " + message);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time);

        initUI();
        sendMessage();
    }
}
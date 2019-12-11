package com.example.ahmadalfa1;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    Button bt1;
    String stEmail, stPhone;
    EditText etEmail, etPhone, ed1, ed2;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        bt1 = (Button) findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();
    }


    public void createAccount() {
        mAuth.createUserWithEmailAndPassword(stEmail, stPhone)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                             FirebaseUser user = mAuth.getCurrentUser();
                        }
                    }
                });
    }


    public void register(View view) {
        stEmail = ed1.getText().toString();
        stPhone = ed2.getText().toString();
        createAccount();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s = item.getTitle().toString();
        t = new Intent(this, MainActivity.class);
        if (s.equals("authentication")) {
            t = new Intent(this, MainActivity.class);
            startActivity(t);
        }
        if (s.equals("Data base")) {
            t = new Intent(this, database.class);
            startActivity(t);
        }
        if (s.equals("maps")) {
            t = new Intent(this, maps.class);
            startActivity(t);
        }
        if (s.equals("ahmad")) {
            t = new Intent(this, ahmad.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }
}


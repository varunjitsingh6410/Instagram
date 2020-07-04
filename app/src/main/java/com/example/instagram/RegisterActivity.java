package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    Button btnMakeAccount;
    EditText etNewUsername;
    EditText etNewPassword;
    EditText etConfirmNewPassword;
    EditText etNewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnMakeAccount = findViewById(R.id.btnMakeAccount);
        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmNewPassword = findViewById(R.id.etConfirmNewPassword);
        etNewEmail = findViewById(R.id.etNewEmail);

        btnMakeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void createAccount()
    {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(etNewUsername.getText().toString());

        if (etNewPassword.getText().toString().equals(etConfirmNewPassword.getText().toString()))
        {
            user.setPassword(etNewPassword.getText().toString());
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Passwords do not meet security criteria, try again", Toast.LENGTH_SHORT).show();
        }

        user.setEmail(etNewEmail.getText().toString());

        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Toast.makeText(getApplicationContext(), "Something went wrong, try making an account later", Toast.LENGTH_SHORT).show();
                    Log.i("Register", e.toString());
                }
            }
        });
    }
}
package com.example.knlssmartapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    // variables for firebase db
    EditText regName,regUsername,regEmail,regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    // variable to go to login Screen from signup
    Button haveAccount;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

// hooks to all xml elements signup.xml
        regName = findViewById(R.id.CellNo);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.pfIfsccode);
        regBtn = findViewById(R.id.pf_Submtbtn);

// Save data in Firebase on Button click
        regBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String  name = regName.getText().toString();
                String  username = regUsername.getText().toString();
                String  email = regEmail.getText().toString();
                String phoneNo= regPhoneNo.getText().toString();
                String  password= regPassword.getText().toString();


                 Intent intent = new Intent (getApplicationContext(),VerifyPhoneNo.class);
                 intent.putExtra( "phoneNo", phoneNo);
                 startActivity(intent);


                // temporary hold to save the data on fire base

                UserHelperClass helperClass = new UserHelperClass(name,username,email,phoneNo,password);
                reference.child(phoneNo).setValue(helperClass);
                reference.setValue("pf data storage");


//                Intent intent2 = new Intent (Signup.this,  VerifyPhoneNo.class);
//                startActivity(intent2);

            }
        });


    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(Signup.this, VerifyPhoneNo.class);
//        startActivity(intent);

    }
}

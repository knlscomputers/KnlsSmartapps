package com.example.knlssmartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Services extends AppCompatActivity {

    EditText PfUan, PfCellno,PfName,PfDob,PfAadhar,PfBank,PfIfsccode,PfPAN;
    Button Pf_Submtbtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        // hooks to all xml elements services.xml
        PfUan = findViewById(R.id.pfUan);
        PfCellno = findViewById(R.id.pfCellno);
        PfName = findViewById(R.id.pfName);
        PfDob = findViewById(R.id.pfDob);
        PfAadhar = findViewById(R.id.pfAadhar);
        PfBank = findViewById(R.id.pfBank);
        PfIfsccode = findViewById(R.id.pfIfsccode);
        PfPAN = findViewById(R.id.pfPAN);
        Pf_Submtbtn = findViewById(R.id.pf_Submtbtn);

        Pf_Submtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("pfusers");

                String  pfuan  = PfUan.getText().toString();
                String pfcellno = PfCellno.getText().toString();
                String pfname = PfName.getText().toString();
                String pfdob = PfDob.getText().toString();
                String pfAadhar = PfAadhar.getText().toString();
                String pfBank = PfBank.getText().toString();
                String pfIfsccode = PfIfsccode.getText().toString();
                String pfPan = PfPAN.getText().toString();


                PfUserHelperClass pfUserHelperClass = new PfUserHelperClass(pfuan, pfcellno,pfname,pfdob,pfAadhar,pfBank,pfIfsccode,pfPan);
                // reference.child(pfcellno).setValue(pfUserHelperClass);

                reference.setValue("pfusers");



                 Toast.makeText(Services.this,"inserting values",Toast.LENGTH_LONG ).show();


            }
        });


    }
}

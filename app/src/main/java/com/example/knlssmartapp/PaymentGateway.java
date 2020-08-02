package com.example.knlssmartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PaymentGateway extends AppCompatActivity {
    EditText amount, note, name, upivirtualid;
    Button send;
    String TAG ="main";
    final int UPI_PAYMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway);

        send = (Button) findViewById(R.id.send);
        amount = (EditText)findViewById(R.id.amount_et);
        note = (EditText)findViewById(R.id.note);
        name = (EditText) findViewById(R.id.name);
        upivirtualid =(EditText) findViewById(R.id.upi_id);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Getting the values from the EditTexts
                if (TextUtils.isEmpty(name.getText().toString().trim())){
                    Toast.makeText(PaymentGateway.this," Name is invalid", Toast.LENGTH_SHORT).show();

                }else if (TextUtils.isEmpty(upivirtualid.getText().toString().trim())){
                    Toast.makeText(PaymentGateway.this," UPI ID is invalid", Toast.LENGTH_SHORT).show();

                }else if (TextUtils.isEmpty(note.getText().toString().trim())){
                    Toast.makeText(PaymentGateway.this," Note is invalid", Toast.LENGTH_SHORT).show();

                }else if (TextUtils.isEmpty(amount.getText().toString().trim())){
                    Toast.makeText(PaymentGateway.this," Amount is invalid", Toast.LENGTH_SHORT).show();
                }else{

                    payUsingUpi(name.getText().toString(), upivirtualid.getText().toString(),
                            note.getText().toString(), amount.getText().toString());

                }


            }

             void payUsingUpi(String name,String upiId, String note, String amount) {
                 Log.e("main ", "name "+name +"--up--"+upiId+"--"+ note+"--"+amount);
                 // main: name pavan n--up--pavan.n.sap@okaxis--Test UPI Payment--5.00
                 Uri uri = Uri.parse("upi://pay").buildUpon()
                         .appendQueryParameter("pa", upiId)
                         .appendQueryParameter("pn", name)
                         //.appendQueryParameter("mc", "")
                         //.appendQueryParameter("tid", "02125412")
                         //.appendQueryParameter("tr", "25584584")
                         .appendQueryParameter("tn", note)
                         .appendQueryParameter("am", amount)
                         .appendQueryParameter("cu", "INR")
                         //.appendQueryParameter("refUrl", "blueapp")
                         .build();
                 Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
                 upiPayIntent.setData(uri);
                 // will always show a dialog to user to choose an app
                 Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

                 // check if intent resolves
                 if(null != chooser.resolveActivity(getPackageManager())) {
                     startActivityForResult(chooser, UPI_PAYMENT);
                 } else {
                     Toast.makeText(PaymentGateway.this,"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
                 }

             }

            // @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data){
                 PaymentGateway.super.onActivityResult(requestCode,resultCode,data);

                Log.e("main ", "response "+resultCode );
        /*
       E/main: response -1
       E/UPI: onActivityResult: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
       E/UPIPAY: upiPaymentDataOperation: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
       E/UPI: payment successfull: 922118921612
         */
                switch (requestCode) {
                    case UPI_PAYMENT:
                        if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                            if (data != null) {
                                String trxt = data.getStringExtra("response");
                                Log.e("UPI", "onActivityResult: " + trxt);
                                ArrayList<String> dataList = new ArrayList<>();
                                dataList.add(trxt);
                                upiPaymentDataOperation(dataList);
                            } else {
                                Log.e("UPI", "onActivityResult: " + "Return data is null");
                                ArrayList<String> dataList = new ArrayList<>();
                                dataList.add("nothing");
                                upiPaymentDataOperation(dataList);
                            }
                        } else {
                            //when user simply back without payment
                            Log.e("UPI", "onActivityResult: " + "Return data is null");
                            ArrayList<String> dataList = new ArrayList<>();
                            dataList.add("nothing");
                            upiPaymentDataOperation(dataList);
                        }
                        break;
                }
            }

            private void upiPaymentDataOperation(ArrayList<String> dataList) {
            }


        });



    }
}

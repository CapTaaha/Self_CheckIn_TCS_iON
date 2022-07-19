package com.example.selfcheck_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Booking extends AppCompatActivity {

    private EditText Phone;
    private EditText Adults;
    private EditText Children;
    private EditText names;
    private Button DatePicker;
    private TextView Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        final EditText Phone = findViewById(R.id.Phone);
        final EditText names = findViewById(R.id.names);
        final EditText Adults = findViewById(R.id.Adults);
        final EditText Children = findViewById(R.id.Children);

        DatePicker = findViewById(R.id.DatePicker);
        Date = findViewById(R.id.Date);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

        Long today = MaterialDatePicker.todayInUtcMilliseconds();

        calendar.setTimeInMillis(today);

        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setStart(today);
        constraintBuilder.setEnd(today + 2);

        //MaterialDatePicker
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select Your Duration");
        builder.setCalendarConstraints(constraintBuilder.build());
        final MaterialDatePicker materialDatePicker = builder.build();

        DatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "Date_Picker");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                Date.setText(materialDatePicker.getHeaderText());
            }
        });

        Button bookDiamondForm = findViewById(R.id.bookDiamondForm);

        final ProgressBar progressBar = findViewById(R.id.progress);

        bookDiamondForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Phone.getText().toString().trim().isEmpty()){
                    Toast.makeText(Booking.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Adults.getText().toString().trim().isEmpty()){
                    Toast.makeText(Booking.this, "Enter Number of Adults", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Children.getText().toString().trim().isEmpty()){
                    Toast.makeText(Booking.this, "Enter Number of Children", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (names.getText().toString().trim().isEmpty()){
                    Toast.makeText(Booking.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                bookDiamondForm.setVisibility(View.VISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + Phone.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        Booking.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                bookDiamondForm.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                bookDiamondForm.setVisibility(View.VISIBLE);
                                Toast.makeText(Booking.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                bookDiamondForm.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), DiamondOTP.class);
                                intent.putExtra("phone", Phone.getText().toString());
                                intent.putExtra("verificationId",verificationId);
                                startActivity(intent);
                            }
                        }
                );
            }
        });
    }

}
package com.myschool.livedatademo;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.myschool.livedatademo.database.BorrowerModel;
import com.myschool.livedatademo.viewModels.AddItemViewModel;

import java.util.Calendar;
import java.util.Date;

public class ActivityAddItems extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText mName,mItem;
    Button mDate,mSubmit;
    AddItemViewModel itemViewModel;
    Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        mName = findViewById(R.id.name);
        mItem = findViewById(R.id.item);
        mDate = findViewById(R.id.date_picker);
        mSubmit = findViewById(R.id.submit);

        calendar = Calendar.getInstance();
        itemViewModel = ViewModelProviders.of(this).get(AddItemViewModel.class);

        datePickerDialog = new DatePickerDialog(this, ActivityAddItems.this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mName.getText() == null || mItem.getText() == null || date == null)
                    Toast.makeText(ActivityAddItems.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    itemViewModel.addBorrow(new BorrowerModel(
                            mName.getText().toString(),
                            mItem.getText().toString(),
                            String.valueOf(date.getTime())
                    ));
                    Intent intent = new Intent(ActivityAddItems.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();

    }
}

package com.example.hamburgueriax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerAno);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context: this, 
			R.array.years_array, android.R.layout.simple_spinner_dropdown_item);
			
		spinner.setAdapter(adapter);
    }

}
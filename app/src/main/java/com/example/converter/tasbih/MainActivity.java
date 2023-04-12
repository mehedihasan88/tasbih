package com.example.converter.tasbih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity{

    TextView displayTV;
    Button pressBtn;
    ToggleButton modeBtn;
    int cnt = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTV = findViewById(R.id.displayTV);
        pressBtn = findViewById(R.id.button);
        modeBtn = findViewById(R.id.toggleButton);
        displayTV.setText(Integer.toString(cnt));
        pressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(modeBtn.isChecked()) {
                    cnt++;
                }
                else {
                    cnt--;
                }
                displayTV.setText(Integer.toString(cnt));
            }
        });

    }
}
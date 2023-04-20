package com.example.converter.tasbih.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.converter.tasbih.R;
import com.example.converter.tasbih.databases.DatabaseHelper;
import com.example.converter.tasbih.databases.Verse;

public class MainActivity extends AppCompatActivity {

    TextView displayTV;
    Button pressBtn;
    Button setTargetBtn;

    int cnt = 0;
    int target = 0;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTV = findViewById(R.id.displayTV);
        pressBtn = findViewById(R.id.button);
        setTargetBtn = findViewById(R.id.setTargetBtn);
        displayTV.setText(Integer.toString(cnt));
        pressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(target != 0) cnt--;
                if (cnt == 0 && target != 0) {
                    displayTV.setText("DONE!");
                    vibrateOnDone();
                    target = 0;
                    return;
                } else if (cnt == 0 && target == 0) {
                    askTargetValue(this);
                }
                displayTV.setText(Integer.toString(Math.abs(cnt)));
            }
        });

        setTargetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askTargetValue(this);
                displayTV.setText(Integer.toString(Math.abs(cnt)));
            }
        });
    }

    private void vibrateOnDone() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(400);
    }

    private void askTargetValue(View.OnClickListener context) {
        // Create a new AlertDialog Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the title and message of the AlertDialog
        builder.setTitle("Set Target");
        builder.setMessage("Enter a number in range (1-999)");

        // Create a new EditText view to include in the AlertDialog
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set the positive button of the AlertDialog to display a Toast message with the input value
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String inputValue = input.getText().toString();
                target = cnt = Integer.parseInt(inputValue);
                if (target > 999) target = cnt = 999;
                else if(target < 1) target = cnt = 1;


                Verse verse = new Verse(id++, null, target, cnt);
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                System.out.println(databaseHelper.insert(verse));


                Toast.makeText(getApplicationContext(), "Target is set to " + Math.abs(cnt), Toast.LENGTH_SHORT).show();
                displayTV.setText(Integer.toString(Math.abs(cnt)));
            }
        });

        // Set the negative button of the AlertDialog to cancel the dialog
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
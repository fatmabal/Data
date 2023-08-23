package com.fatma.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    TextView textView;
    Button button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber=findViewById(R.id.editTextNumber);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        sharedPreferences=this.getSharedPreferences("package com.fatma.storingdata", Context.MODE_PRIVATE);
        int storedAge=sharedPreferences.getInt("storedAge",0);
        if(storedAge==0){
            textView.setText("your age:");
        } else {
            textView.setText("your age"+storedAge);
        }

    }
    public void save(View view){
        if(!editTextNumber.getText().toString().matches(" ")){
            int userAge=Integer.parseInt(editTextNumber.getText().toString());
            textView.setText("your age:"+userAge);
            sharedPreferences.edit().putInt("storedAge",userAge).apply();
        }
    }

    public void delet(View view){
        int storedData=sharedPreferences.getInt("storedAge",0);
        if(storedData!=0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("your age: ");

        }
    }
}
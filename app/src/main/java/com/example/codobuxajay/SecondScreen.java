package com.example.codobuxajay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondScreen extends AppCompatActivity {
    TextView id2;
    EditText name,age,salary;
    ImageView imageView;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        Intent intent=getIntent();
        id2=findViewById(R.id.id2);
        save=findViewById(R.id.save);
        name=findViewById(R.id.editName);
        age=findViewById(R.id.editAge);
        salary=findViewById(R.id.editSalary);
        imageView=findViewById(R.id.profilePic2);
        Bundle bundle=intent.getBundleExtra("Bundle");
        id2.setText(bundle.getString("id"));
        name.setText(bundle.getString("name"));
        age.setText(bundle.getString("age"));
        salary.setText(bundle.getString("salary"));
        Glide.with(this).load(bundle.getString("imageurl")).into(imageView);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("name2",name.getText().toString());
                bundle.putString("id2",id2.getText().toString());
                bundle.putString("age2",age.getText().toString());
                bundle.putString("salary2",salary.getText().toString());
                intent.putExtra("Bundle2",bundle);
                setResult(RESULT_OK,intent);
                finish();

            }
        });



    }
}
package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText password;
    private EditText updateOld;
    private EditText updateNew;
    private EditText delete;
    private MyDBOperations helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.editName);
        password = findViewById(R.id.editPass);
        updateOld = findViewById(R.id.editText3);
        updateNew = findViewById(R.id.editText5);
        delete = findViewById(R.id.editText6);

        helper = new MyDBOperations(this);
    }

    public void addUser(View view) {
        String t1 = Name.getText().toString();
        String t2 = password.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(this, "Enter both name and password", Toast.LENGTH_SHORT).show();
        } else {
            long id = helper.insertData(t1, t2);
            if (id <= 0) {
                Toast.makeText(this, "insertion failed", Toast.LENGTH_SHORT).show();
                Name.setText("");
                password.setText("");
            } else {
                Toast.makeText(this, "insertion success", Toast.LENGTH_SHORT).show();
                Name.setText("");
                password.setText("");
            }
        }
    }

    public void viewData(View view) {
        String data = helper.getData();
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    public void update(View view) {
        String u1 = updateOld.getText().toString();
        String u2 = updateNew.getText().toString();
        if (u1.isEmpty() || u2.isEmpty()) {
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();
        } else {
            int a = helper.updateName(u1, u2);
            if (a <= 0) {
                Toast.makeText(this, "Updation failed", Toast.LENGTH_SHORT).show();
                updateOld.setText("");
                updateNew.setText("");
            } else {
                Toast.makeText(this, "Updation Successfull", Toast.LENGTH_SHORT).show();
                updateOld.setText("");
                updateNew.setText("");
            }
        }

    }

    public void delete(View view) {
        String uname = delete.getText().toString();
        if (uname.isEmpty()) {
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();
        } else {
            int a = helper.delete(uname);
            if (a <= 0) {
                Toast.makeText(this, "Deletion failed", Toast.LENGTH_SHORT).show();
                delete.setText("");
            } else {
                Toast.makeText(this, "Deletion successfull", Toast.LENGTH_SHORT).show();
                delete.setText("");
            }
        }
    }
}
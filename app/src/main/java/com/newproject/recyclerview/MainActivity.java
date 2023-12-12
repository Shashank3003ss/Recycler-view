package com.newproject.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts = new ArrayList<>();

RecyclerContactAdapter adapter;
FloatingActionButton btnOpenDialog;
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);

                EditText etName = dialog.findViewById(R.id.etName);
                EditText etNumber = dialog.findViewById(R.id.etNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        String name = "", number = "";

                        if (!etName.getText().toString().equals("")) {
                            name = etName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter contact name", Toast.LENGTH_SHORT).show();
                        }

                        if (!etName.getText().toString().equals("")) {
                            number = etNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter contact number", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.add(new ContactModel(name, number));

                        adapter.notifyItemInserted(arrContacts.size()-1);

                        recyclerView.scrollToPosition(arrContacts.size()-1);

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.download, "Aria", "9945345467"));
        arrContacts.add(new ContactModel(R.drawable.download, "Ben", "9945215467"));
        arrContacts.add(new ContactModel(R.drawable.download, "Clara", "8945345467"));
        arrContacts.add(new ContactModel(R.drawable.download, "Dan", "9912315467"));
        arrContacts.add(new ContactModel(R.drawable.download, "Shh", "9945345467"));
        arrContacts.add(new ContactModel(R.drawable.download, "Tira", "9945215467"));
        arrContacts.add(new ContactModel(R.drawable.download, "jjj", "9945345467"));
        arrContacts.add(new ContactModel(R.drawable.download, "hcbn", "9945215467"));
        arrContacts.add(new ContactModel(R.drawable.download, "hsnd", "9945345467"));
        arrContacts.add(new ContactModel(R.drawable.download, "Zea", "9945215467"));

        adapter = new RecyclerContactAdapter(MainActivity.this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}
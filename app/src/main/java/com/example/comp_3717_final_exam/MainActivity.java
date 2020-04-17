package com.example.comp_3717_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText titleEdit, descriptionEdit, linkEdit;
    Button save, nextPage;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEdit = (EditText)findViewById(R.id.titleEdit);
        descriptionEdit = (EditText)findViewById(R.id.descriptionEdit);
        linkEdit = (EditText)findViewById(R.id.linkEdit);

        save = (Button)findViewById(R.id.save);
        nextPage = (Button)findViewById(R.id.nextPage);

        member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Movies");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String title = titleEdit.getText().toString();
                String description = descriptionEdit.getText().toString();
                String link = linkEdit.getText().toString();

                member.setTitle(title);
                member.setDescription(description);
                member.setLink(link);
                reff.child(title).setValue(member);
            }
        });
    }
}

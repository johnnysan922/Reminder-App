package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference root;
    public TextView saveReminder, cancel;
    public EditText editType, editName, editDate, editTime, editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        editType = findViewById(R.id.edit_type);
        editName = findViewById(R.id.edit_name);
        editDate = findViewById(R.id.edit_date);
        editTime = findViewById(R.id.edit_time);
        editNote = findViewById(R.id.edit_note);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        root = database.getReference().child("User Reminders").child(String.valueOf(mAuth.getCurrentUser().getUid()));

        saveReminder = findViewById(R.id.saveReminderBtn);
        cancel = findViewById(R.id.cancel_btn);

        saveReminder.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.saveReminderBtn:
                String type = editType.getText().toString();
                String name = editName.getText().toString();
                String date = editDate.getText().toString();
                String time = editTime.getText().toString();
                String note = editNote.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("type", type);
                userMap.put("name", name);
                userMap.put("date", date);
                userMap.put("time", time);
                userMap.put("note", note);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AddReminderActivity.this, "Reminder Saved", Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            case R.id.cancel_btn:
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }
    }
}
package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    public Button logOut, addReminder;
    private Toolbar mytoolbar;
    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference root;
    private MyAdapter adapter;
    private ArrayList<Model> list;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    private CardView reminderCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mytoolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("Reminders");

        Search prefs = new Search(HomeActivity.this);
        String search = prefs.getSearch();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        root = database.getReference().child("User Reminders").child(String.valueOf(mAuth.getCurrentUser().getUid()));

        logOut = findViewById(R.id.logout_btn);

        addReminder = findViewById(R.id.addReminder_btn);

        logOut.setOnClickListener(this);
        addReminder.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        reminderCard = findViewById(R.id.reminderCard);
//        reminderCard.

        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model model = dataSnapshot.getValue(Model.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.logout_btn:
                Log.d("log Out tag","logged Out User");
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
            case R.id.addReminder_btn:
                Log.d("Adding reminder","Adding reminder");
                startActivity(new Intent(getApplicationContext(),AddReminderActivity.class));
                break;
            case R.id.reminderCard:
                startActivity(new Intent(getApplicationContext(),CardDetailsActivity.class));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.new_search) {
            showInputDialog();
            // return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showInputDialog() {
        alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.searchview, null);
        final EditText newSearchEdt = view.findViewById(R.id.searchEdt);
        Button submitButton = view.findViewById(R.id.submitButton);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search prefs = new Search(HomeActivity.this);
                if (!newSearchEdt.getText().toString().isEmpty()) {

                    String search = newSearchEdt.getText().toString();
                    prefs.setSearch(search);
                    list.clear();
                    root.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                Model model = dataSnapshot.getValue(Model.class);
                                if(model.getType().contains(search)){
                                    list.add(model);
                                }
                            }

                            if(list.isEmpty()){
                                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    Model model = dataSnapshot.getValue(Model.class);
                                    list.add(model);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    list.clear();
                    root.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                Model model = dataSnapshot.getValue(Model.class);
                                list.add(model);
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                dialog.dismiss();
            }
        });
    }
}
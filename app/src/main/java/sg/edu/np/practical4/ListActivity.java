package sg.edu.np.practical4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int randomint = random.nextInt(999999);
            int randomint2 = random.nextInt(999999);
            boolean following = false;
            if (i % 2 == 0) {
                following = true;
            }

            else {
                following = false;
            }
            User user = new User("Name" + randomint, "" + randomint2, i, following);
            users.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.users);
        BrandsAdapter mAdapter = new BrandsAdapter(users);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
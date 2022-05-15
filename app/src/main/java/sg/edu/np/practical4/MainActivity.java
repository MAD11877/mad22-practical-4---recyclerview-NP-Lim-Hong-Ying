package sg.edu.np.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle receiving = getIntent().getExtras();
        String name = null;
        String description = null;
        final Boolean[] followed = {false};
        if (receiving != null) {
            name = receiving.getString("name");
            description = receiving.getString("description");
            followed[0] = receiving.getBoolean("followed");
        }

        TextView username = (TextView) findViewById(R.id.textView3);
        username.setText(name);

        TextView description2 = (TextView) findViewById(R.id.textView2);
        description2.setText("Description" + description);

        Button followbutton = (Button) findViewById(R.id.button3);
        if (followed[0] == false) {
            followbutton.setText("Follow");
        }

        else if (followed[0] == true) {
            followbutton.setText("Unfollow");
        }

        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (followed[0] == false) {
                    followed[0] = true;
                    followbutton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }

                else if (followed[0] == true) {
                    followed[0] = false;
                    followbutton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
package cc.soham.espresso_1_3_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button submit;
    Button reset;
    TextView state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.activity_main_username);
        password = (EditText) findViewById(R.id.activity_main_password);
        submit = (Button) findViewById(R.id.activity_main_submit);
        reset = (Button) findViewById(R.id.activity_main_reset);
        state = (TextView) findViewById(R.id.activity_main_state);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && password.getText() != null) {
                    String userNameEntered = username.getText().toString();
                    String passwordEntered = password.getText().toString();

                    if(isValid(userNameEntered, passwordEntered)) {
                        Toast.makeText(MainActivity.this, "Valid username and password", Toast.LENGTH_SHORT).show();
                        startSuccessActivity();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        state.setText("invalid state");
                    }
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText(null);
                password.setText(null);
            }
        });
    }

    /**
     * Starts the success activity
     */
    private void startSuccessActivity() {
        Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
        startActivity(intent);
    }

    /**
     * Checks if the given username and password parameters are correct
     * @param username
     * @param password
     * @return
     */
    private static boolean isValid(@NonNull String username, @NonNull String password) {
        if(username.toLowerCase().equals("hello") && password.toLowerCase().equals("world"))
            return true;
        else
            return false;
    }
}

package in.triumphinfotech.experiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ConnectUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_up);

        Button signUp = (Button) findViewById(R.id.btnSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(ConnectUpActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

        Button login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(ConnectUpActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        Button backToMain = (Button)findViewById(R.id.btnLftArrowConnectUp);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainIntent = new Intent(ConnectUpActivity.this, MainActivity.class);
                startActivity(backToMainIntent);
            }
        });

    }
}

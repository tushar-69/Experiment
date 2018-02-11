package in.triumphinfotech.experiment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Learn2MeditateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn2_meditate);

    }
//    TextView basics = (TextView) findViewById(R.id.txtBasics);
    public void callTheBasicsActivity(View view) {
        Intent lrn2meditateIntent = new Intent(Learn2MeditateActivity.this, TheBasicsActivity.class);
        startActivity(lrn2meditateIntent);
    }
}

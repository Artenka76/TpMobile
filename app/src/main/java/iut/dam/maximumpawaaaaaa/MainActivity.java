package iut.dam.maximumpawaaaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String email = bundle != null ? bundle.getString("email") : "NoValueEmail";
        String mdp = bundle != null ? bundle.getString("mdp") : "NoValueMdp";

        TextView AAAAAAAAAAAAAAAA = findViewById(R.id.transfer_email_mdp);
        AAAAAAAAAAAAAAAA.setText("Hello " + email + " your password is " + mdp);
    }
}
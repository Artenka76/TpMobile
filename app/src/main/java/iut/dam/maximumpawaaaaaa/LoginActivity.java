package iut.dam.maximumpawaaaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_connexion = findViewById(R.id.btn_connexion);
        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText text_email = findViewById(R.id.text_email);
                EditText text_mdp = findViewById(R.id.text_mdp);
                String email = text_email.getText().toString();
                String mdp = text_mdp.getText().toString();
                if(email.equals("abcd") && mdp.equals("EFGH")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("mdp", mdp);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

    }
}
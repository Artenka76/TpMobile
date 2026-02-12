package iut.dam.maximumpawaaaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import iut.dam.maximumpawaaaaaa.classe.User;
import iut.dam.maximumpawaaaaaa.utils.JsonUtils;

public class HabitatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_habitat);

        String jsonString = JsonUtils.loadJSONFromRaw(this, R.raw.users);
        ArrayList<User> userList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                User user = item;
                userList.add(userName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListView listView = findViewById(R.id.list_users);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        R.layout.item_user,
                        userNamesList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
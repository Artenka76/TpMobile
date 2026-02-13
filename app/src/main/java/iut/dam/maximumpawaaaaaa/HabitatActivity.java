package iut.dam.maximumpawaaaaaa;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
                User user = User.JsonToUser(item);
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListView listView = findViewById(R.id.list_users);
        UserAdapter adapter =
                new UserAdapter(this,
                        R.layout.item_user,
                        userList);
        listView.setAdapter(adapter);
    }
}
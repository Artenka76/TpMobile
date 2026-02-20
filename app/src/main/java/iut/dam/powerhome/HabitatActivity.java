package iut.dam.powerhome;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import iut.dam.powerhome.classe.User;
import iut.dam.powerhome.utils.JsonUtils;

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
package iut.dam.powerhome.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import iut.dam.powerhome.R;
import iut.dam.powerhome.UserAdapter;
import iut.dam.powerhome.classe.User;
import iut.dam.powerhome.utils.JsonUtils;

public class HabitatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habitat, container, false);

        String jsonString = JsonUtils.loadJSONFromRaw(view.getContext(), R.raw.users);
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

        ListView listView = view.findViewById(R.id.list_users);
        UserAdapter adapter =
                new UserAdapter(getContext(),
                        R.layout.item_user,
                        userList);
        listView.setAdapter(adapter);
        return view;
    }
}
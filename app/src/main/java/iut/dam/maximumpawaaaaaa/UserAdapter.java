package iut.dam.maximumpawaaaaaa;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import iut.dam.maximumpawaaaaaa.classe.User;

public class UserAdapter extends ArrayAdapter<User> {

    Activity activity;
    int itemResId;
    List<User> items;
    public UserAdapter(Activity activity, int itemResId, List<User> items) {
        super(activity, itemResId, items);

        this.activity = activity;
        this.itemResId = itemResId;
        this.items = items;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResId, parent, false);
        }
        TextView nameTV = layout.findViewById(R.id.tvName);
        TextView applianceCountTV = layout.findViewById(R.id.tvApplianceCount);
        TextView applianceTV = layout.findViewById(R.id.tvAppliance);
        ImageView appliance1IV = layout.findViewById(R.id.ivAppliance1);
        ImageView appliance2IV = layout.findViewById(R.id.ivAppliance2);
        ImageView appliance3IV = layout.findViewById(R.id.ivAppliance3);
        ImageView appliance4IV = layout.findViewById(R.id.ivAppliance4);
        TextView floorTV = layout.findViewById(R.id.tvFloor);

        User user = items.get(position);

        nameTV.setText(user.userName);
        applianceCountTV.setText(String.valueOf(user.appliances.size()));
        int applianceCount = user.appliances.size();

        if (applianceCount >= 1) {
            appliance1IV.setVisibility(View.VISIBLE);
            appliance1IV.setImageResource(getImageForType(user.appliances.get(0).name));
        }
        if (applianceCount >= 2) {
            appliance2IV.setVisibility(View.VISIBLE);
            appliance2IV.setImageResource(getImageForType(user.appliances.get(1).name));
            applianceTV.setText(R.string.appliances);
        }
        if (applianceCount >= 3) {
            appliance3IV.setVisibility(View.VISIBLE);
            appliance3IV.setImageResource(getImageForType(user.appliances.get(2).name));
        }
        if (applianceCount >= 4) {
            appliance4IV.setVisibility(View.VISIBLE);
            appliance4IV.setImageResource(getImageForType(user.appliances.get(3).name));
        }

        floorTV.setText(String.valueOf(user.floor));
        return layout;
    }

    private int getImageForType(String name) {
        switch (name) {
            case "Climatiseur":
                return R.drawable.ic_climatiseur;
            case "Aspirateur":
                return R.drawable.ic_aspirateur;
            case "Machine à laver":
                return R.drawable.ic_machine_a_laver;
            default:
                return R.drawable.ic_fer_a_repasser;
        }
    }
}


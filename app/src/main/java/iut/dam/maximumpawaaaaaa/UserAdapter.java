package iut.dam.maximumpawaaaaaa;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResId, parent, false);
        }
        TextView nameTV = layout.findViewById(R.id.tvName);
        TextView applianceCountTV = layout.findViewById(R.id.tvApplianceCount);
        ImageView appliance1IV = layout.findViewById(R.id.ivAppliance1);
        ImageView appliance2IV = layout.findViewById(R.id.ivAppliance2);
        ImageView appliance3IV = layout.findViewById(R.id.ivAppliance3);
        ImageView appliance4IV = layout.findViewById(R.id.ivAppliance4);

        nameTV.setText(items.get(position).userName);
        applianceCountTV.setText(items.size());
        appliance1IV.setImageResource(getImageForType(items.get(position).appliances.get(0).name));
        appliance2IV.setImageResource(getImageForType(items.get(position).appliances.get(1).name));
        appliance3IV.setImageResource(getImageForType(items.get(position).appliances.get(2).name));
        appliance4IV.setImageResource(getImageForType(items.get(position).appliances.get(3).name));
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


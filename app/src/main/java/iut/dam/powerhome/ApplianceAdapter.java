package iut.dam.powerhome;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import iut.dam.powerhome.classe.Appliance;

public class ApplianceAdapter extends ArrayAdapter<Appliance> {
    Activity activity;
    int itemResId;
    List<Appliance> items;
    public ApplianceAdapter(Activity activity, int itemResId, List<Appliance> items) {
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
        ImageView applianceLogoIV = layout.findViewById(R.id.ivApplianceLogo);
        TextView applianceNameTV = layout.findViewById(R.id.tvApplianceName);
        TextView applianceRefTV = layout.findViewById(R.id.tvApplianceRef);
        TextView applianceConsumptionTV = layout.findViewById(R.id.tvApplianceWattage);

        Appliance appliance = items.get(position);

        applianceLogoIV.setImageResource(getImageForType(appliance.name));
        applianceNameTV.setText(appliance.name);
        applianceRefTV.setText(appliance.reference);
        applianceConsumptionTV.setText(String.valueOf(appliance.wattage).concat(" W"));
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

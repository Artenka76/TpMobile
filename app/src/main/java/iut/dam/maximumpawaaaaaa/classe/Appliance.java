package iut.dam.maximumpawaaaaaa.classe;

import org.json.JSONException;
import org.json.JSONObject;

public class Appliance {
    public int id;
    public String name;
    public String reference; // format CL-xxx
    public int wattage;

    public Appliance(int id, String name, String reference, int wattage) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.wattage = wattage;
    }

    public static Appliance JsonToAppliance(JSONObject json) throws JSONException {
        return new Appliance(json.getInt("id"), json.getString("name"), json.getString("reference"), json.getInt("wattage"));
    }
}

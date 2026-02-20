package iut.dam.powerhome.classe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int id;
    public String userName;
    public int floor;
    public double area;
    public List<Appliance> appliances;
    public User(int id, String userName, int floor, double area, List<Appliance> appliances){
        this.id = id;
        this.userName = userName;
        this.floor = floor;
        this.area = area;
        this.appliances = appliances;
    }

    public static User JsonToUser(JSONObject json) throws JSONException {
        JSONArray applianceJSON = json.getJSONArray("appliances");
        List<Appliance> applianceList = new ArrayList<>();
        for(int i = 0; i < applianceJSON.length(); i++){
            applianceList.add(Appliance.JsonToAppliance(applianceJSON.getJSONObject(i)));
        }
        return new User(json.getInt("id"), json.getString("userName"), json.getInt("floor"), json.getDouble("area"), applianceList);
    }
}

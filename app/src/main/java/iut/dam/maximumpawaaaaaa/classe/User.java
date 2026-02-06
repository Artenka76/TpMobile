package iut.dam.maximumpawaaaaaa;

import java.util.List;

public class User {
    int id;
    String userName;
    int floor;
    double area;
    List<Appliance> appliances;
    public User(int id, String userName, int floor, double area, List<Appliance> appliances){
        this.id = id;
        this.userName = userName;
        this.floor = floor;
        this.area = area;
        this.appliances = appliances;
    }
}

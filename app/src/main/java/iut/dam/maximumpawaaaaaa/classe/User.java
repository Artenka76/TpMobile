package iut.dam.maximumpawaaaaaa.classe;

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
}

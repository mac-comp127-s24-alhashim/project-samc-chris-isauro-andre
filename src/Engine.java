/**
 * This class is to create unique Engine objects that is put in the menu for different Engine objects with differing
 * attributes be selected in the menu. The class is mainly responsible for how fast the car speeds up, and how fast the car can go.
 * 
 * @param engineKey a key string in a map to match it with its unique Engine object.
 * @param torque    value dictating how fast the car speeds up
 * @param topSpeed  value to limit how fast the car can go
 * @param weight    value that is used in calculations in the car class
 */

public class Engine {

    private String Ekey;
    private double torque;
    private int weight, topSpeed;

    public Engine(String engineKey, double torque, int topSpeed, int weight){
        this.torque = torque;
        this.weight = weight;
        this.topSpeed = topSpeed;
        Ekey = engineKey;
        
    }

    public String getKey(){
        return Ekey;
    }

    public int getTopSpeed(){
        return topSpeed;
    }
    
    public double getTorque(){
        return torque;
    }

    public int getWeight(){
        return weight;
    }

}


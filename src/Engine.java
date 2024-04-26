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


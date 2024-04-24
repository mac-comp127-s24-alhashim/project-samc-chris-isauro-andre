public class Engine {

    private String Ekey;
    private int torque, weight, topSpeed;

    public Engine(String engineKey, int torque, int topSpeed, int weight){
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
    
    public int getTorque(){
        return torque;
    }

    public int getWeight(){
        return weight;
    }

}


public class Engine {

    private int torque, weight, topSpeed;

    public Engine(String engineType, int torque, int topSpeed, int weight){
        this.torque = torque;
        this.weight = weight;
        this.topSpeed = topSpeed;
        
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


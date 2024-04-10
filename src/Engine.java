public class Engine {

    private int torque, weight;

    public Engine(String type, int torque, int weight){
        this.torque = torque;
        this.weight = weight;
        
    }

    public int getTorque(){
        return torque;
    }

    public int getWeight(){
        return weight;
    }


    }


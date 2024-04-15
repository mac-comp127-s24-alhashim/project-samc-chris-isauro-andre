public class Engine {

    private int torque, weight;

    public Engine(String type, int torque, int weight){
        this.torque = torque;
        this.weight = weight;
        
    }

    private int accelarateCalculator(){
        int engineAccelaration = torque;
        return torque;
    }

    public int getTorque(){
        return torque;
    }

    public int getWeight(){
        return weight;
    }
}


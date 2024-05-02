public class Engine {

    private String Ekey;
    private double torque;
    private int weight, topSpeed;

    /**
     * The identification and stats of an engine.
     * 
     * @param engineKey         The key of the selected engine.
     * @param torque            The assigned torque of the selected engine.
     * @param topSpeed          The terminal speed that the selected engine may go to.
     * @param weight            The weight of the selected engine.
     */
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


package com.example.transformers_dd;

public class TransformerYellow extends Transformer  implements Printable{
    public int num_lasers;

    private  String sound;



    public int getNum_lasers() {
        return num_lasers;
    }

    public void setNum_lasers(int num_lasers) {
        this.num_lasers = num_lasers;
    }

    public TransformerYellow(String name, int energy, int num_lasers) {
        super(name, energy);
        this.num_lasers = num_lasers;

    }

    public String printSelf() {
       return  sound = (getName()+ ": Wow!  I won!!");
    }

    @Override
    public void shooting() {

    }
}

package domain;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Oct 9, 2017 
 */
public class StykListe {
    private int fours;
    private int twos;
    private int ones;

    public StykListe(int fours, int twos, int ones) {
        this.fours = fours;
        this.twos = twos;
        this.ones = ones;
    }
    public void setHeight(int heigth){
        this.fours *= heigth;
        this.twos *= heigth;
        this.ones *= heigth;
    }
    public StykListe() {}
    
    public StykListe forbandtMe(){
        
        return this;
    }
    public StykListe concat(StykListe list){
        int f = this.fours + list.getFours();
        int t = this.twos + list.getTwos();
        int o = this.ones + list.getOnes();
        return new StykListe(f,t,o);
    }
    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }
    public void incFours(int fours){
        this.fours += fours;
    }
    public int getTwos() {
        return twos;
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    @Override
    public String toString() {
        return "Content of list: fours: " + fours + ", twos: " + twos + ", ones: " + ones;
    }
    
}

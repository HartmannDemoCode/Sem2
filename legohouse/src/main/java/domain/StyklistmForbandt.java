package domain;
/**
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Oct 9, 2017
 * @param length - house length in pricks.
 * @param  width: house width in pricks
 * @param  height: house height in bricks
 * @return Stykliste with how many bricks of each of 3 types are needed.
 */
public class StyklistmForbandt {
    public StykListe calcStykListe(int length, int width, int height){
        width = width - 4;
        StykListe lengthList = calcWall(length, height);
        StykListe widthList = calcWall(width, height);
        StykListe stklst = lengthList
                .concat(lengthList)
                .concat(widthList)
                .concat(widthList);
        //If both width and height has a two then they can instead share a four
        if(stklst.getTwos()/height == 4){
            stklst.setTwos(0);
            stklst.incFours(2);
        }
        return stklst;
    }
    
    private StykListe calcWall(int length, int heigth){
        int fours = length/4; int rest = length%4; 
        int twos = rest/2; rest = rest%2; 
        int ones = rest;
        StykListe sl = new StykListe(fours, twos, ones);
        sl.setHeight(heigth);
        return sl;
    }
    public static void main(String[] args) {
        StyklistmForbandt slb = new StyklistmForbandt();
        StykListe sl = slb.calcStykListe(14, 6, 4);
        System.out.println("stykliste: "+sl);
    }
}

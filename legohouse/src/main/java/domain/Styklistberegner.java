package domain;
/**
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Oct 9, 2017
 * @param length - house length in pricks.
 * @param  width: house width in pricks
 * @param  height: house height in bricks
 * @return Stykliste with how many bricks of each of 3 types are needed.
 */
public class Styklistberegner {
    public StykListe calcStykListe(int length, int width, int hight){
        width = width - 4;
        StykListe lengthList = calcWall(length, hight);
        StykListe widthList = calcWall(width, hight);
        return lengthList
                .concat(lengthList)
                .concat(widthList)
                .concat(widthList);
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
        Styklistberegner slb = new Styklistberegner();
        StykListe sl = slb.calcStykListe(14, 9, 4);
        System.out.println("stykliste: "+sl);
    }
}

/**
 * The purpose of IceHotClass is to...
 * @author kasper
 */
class IceHotClass {

    boolean icyHot( int temp1, int temp2 ) {
        return (temp1 <0 && temp2 > 100) || 
                (temp2 <0 && temp1 > 100);
    }

}

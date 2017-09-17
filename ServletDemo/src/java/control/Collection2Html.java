package control;

import domain.Car;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 17, 2017 
 */
public class Collection2Html {
    public static String carList2HtmlTable(List<Car> cars){
        String out = "<table><thead><tr><th>Make</th><th>Model</th><th>Year</th></tr></thead><tbody>";
        
        for (Car car : cars) {
            out += " <tr><td>"+car.getMake()+"</td><td>"+car.getModel()+"</td><td>"+car.getYear()+"</td></tr>";
        }
        out += "</tbody></table>";
        return out;
    }
    
}

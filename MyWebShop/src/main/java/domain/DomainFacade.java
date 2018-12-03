package domain;

import data.DataFacade;
import data.IDataFacade;
import domain.entity.Order;
import domain.entity.Product;
import domain.entity.User;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Dec 14, 2016 
 */
public class DomainFacade implements IDomainFacade{
    IDataFacade df = new DataFacade();
    
    @Override
    public void registerUser(User user) {
        df.registerUser(user);
    }

    @Override
    public boolean login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

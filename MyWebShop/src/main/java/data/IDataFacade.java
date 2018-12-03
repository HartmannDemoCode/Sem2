package data;

import domain.entity.Order;
import domain.entity.Product;
import domain.entity.User;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Dec 14, 2016
 */
public interface IDataFacade {
    void registerUser(User user);
    boolean login(String username, String password);
    List<Product> getProducts();
    void registerOrder(Order order);
}

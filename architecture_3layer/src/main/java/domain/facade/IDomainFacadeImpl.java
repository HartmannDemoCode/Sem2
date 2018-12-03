/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.facade;

import data.DBFacade;
import domain.entity.ArchitectureException;
import domain.entity.Customer;


public class IDomainFacadeImpl implements IDomainFacade {
    DBFacade dbf = new DBFacade();
    @Override
    public Customer getCustomer(int id) throws ArchitectureException {
        return dbf.getCustomer(id);
    }
    
}

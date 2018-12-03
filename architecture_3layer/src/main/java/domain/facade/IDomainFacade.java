/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.facade;

import domain.entity.ArchitectureException;
import domain.entity.Customer;

/**
 *
 * @author thomas
 */
public interface IDomainFacade {
    Customer getCustomer(int id) throws ArchitectureException;
}

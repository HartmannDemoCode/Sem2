/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author tha
 */
public class Connection {

    private static DataSource ds = new DataSource();

    {
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:java-config");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setMaxIdle(5);
        ds.setMinIdle(2);
    }
//    public static DataSource getDataSource(){
//        return ds.
//    }
}

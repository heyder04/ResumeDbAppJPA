/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public abstract class AbstractDAO {
        public  Connection connection() throws Exception{
         Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url="jdbc:mysql://localhost:3306/resume";
        String username="root";
        String password="admin";
        Connection c=DriverManager.getConnection(url,username,password);
        return c;
    }
}

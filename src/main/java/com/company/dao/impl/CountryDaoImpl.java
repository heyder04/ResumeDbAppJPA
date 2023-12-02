/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter{
//Data Access Object
  private Country getCountry(ResultSet rs)throws Exception{
      int id=rs.getInt("id");
      String name =rs.getString("name");
      String nationality=rs.getString("nationality");
   
//      Country nat=new Country(id,name,nationality); 
     return null;
  }
    
    

  
   @Override
    public List<Country> getAll() {
              List<Country> result=new ArrayList<>();
        try(Connection c=connection()) {
            
            Statement stmt=c.createStatement()   ;
            stmt.execute("select * from country");
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                Country  emp=getCountry(rs);
                result.add(emp);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
    }
    


    
}

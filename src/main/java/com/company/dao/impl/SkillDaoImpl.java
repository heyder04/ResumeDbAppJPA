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
import com.mycompany.dao.inter.SkillDaoInter;
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
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter{
//Data Access Object
  private Skill getSkill(ResultSet rs)throws Exception{
      int id=rs.getInt("id");
      String name =rs.getString("name");
     
      Skill skl=new Skill(id,name);
     return skl;
  }
    
    

  
   @Override
    public List<Skill> getAll() {
              List<Skill> result=new ArrayList<>();
        try(Connection c=connection()) {
            
            Statement stmt=c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                Skill  skl=getSkill(rs);
                result.add(skl);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
    }
    
    
    
         @Override
    public boolean insertSkill(Skill s) {
        boolean b=true;
        try(  Connection c=connection()) {
              PreparedStatement stmt=c.prepareStatement("insert into skill(name) values(?) ",Statement.RETURN_GENERATED_KEYS);
              stmt.setString(1, s.getName());
             
              b= stmt.execute( );
              ResultSet generatedKeys=stmt.getGeneratedKeys();
              if(generatedKeys.next()){
                  s.setId(generatedKeys.getInt(1));
              }
//Statement stmt=c.createStatement();
//            return stmt.execute("update user set name='azay' where id=1");
        } catch (Exception ex) {
            ex.printStackTrace();
            b=false;
        }
        return b;
    }
    


    
}

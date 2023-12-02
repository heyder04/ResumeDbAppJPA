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
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter{
//Data Access Object
  private EmploymentHistory getEmploymentHistory(ResultSet rs)throws Exception{
      String header=rs.getString("header");
      String jobDescription =rs.getString("job_description");
      Date beginDate=rs.getDate("begin_Date");
      Date endDate=rs.getDate("end_Date");
      int userId=rs.getInt("user_id");
//      EmploymentHistory emp=new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
     return null;
  }
    
    

  
   @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
              List<EmploymentHistory> result=new ArrayList<>();
        try(Connection c=connection()) {
            
            PreparedStatement stmt=c.prepareStatement(
            "select * from employment_history where user_id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                EmploymentHistory  emp=getEmploymentHistory(rs);
                result.add(emp);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
    }
    


    
}

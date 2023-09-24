/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
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
public class UserDaoImpl extends AbstractDAO implements UserDaoInter{
//Data Access Object
    private User getUser(ResultSet rs)throws Exception{
        int id=rs.getInt("id");
                String name=rs.getString("name");
                String surname=rs.getString("surname");
                String email=rs.getString("email");
                String profileDesc=rs.getString("profile_description");
                String phone=rs.getString("phone");
                int nationalityId=rs.getInt("nationality_id");
                int birthplaceId=rs.getInt("birthplace_id");
                String nationalityStr=rs.getString("nationality");
                String birthplaceStr=rs.getString("birthplace");
                Date birthdate=rs.getDate("birthdate");
                Country nationality=new Country(nationalityId,null,nationalityStr);
                Country birthplace =new Country(birthplaceId,birthplaceStr,null);
                return new User(id,name,surname,email,profileDesc,phone,birthdate,nationality,birthplace);
    }
    @Override
    public List<User> getAll() {
        List<User> result=new ArrayList<>();
        try(Connection c=connection()) {
            
            Statement stmt=c.createStatement();
            stmt.execute("select "
                    +"u.*, "
                    +"n.nationality as nationality, "
                    +"c.name as birthplace "
                    +"from user u "
                    +"left join country n on u.nationality_id=n.id "
                    +"left join country c on u.birthplace_id=c.id ");
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                User u=getUser(rs);
                result.add(u);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
    }

    
    
    @Override
    public boolean updateUser(User u) {
        try(  Connection c=connection()) {
              PreparedStatement stmt=c.prepareStatement("update user set name=?,surname=?,phone=?,email=?,profile_description=?,birthdate=?,birthplace_id=? where id=?");
              stmt.setString(1, u.getName());
              stmt.setString(2, u.getSurname());
              stmt.setString(3, u.getEmail());
              stmt.setString(4, u.getPhone());
               stmt.setString(5, u.getProfileDesc());
               stmt.setDate(6, u.getBirthDate());
               stmt.setInt(7, u.getBirthPlace().getId());
              stmt.setInt(8, u.getId());
              
              return stmt.execute( );
//Statement stmt=c.createStatement();
//            return stmt.execute("update user set name='azay' where id=1");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     @Override
    public boolean addUser(User u) {
        try(  Connection c=connection()) {
              PreparedStatement stmt=c.prepareStatement("insert into user(name,surname,phone,email,profile_description) values(?,?,?,?,?) ");
              stmt.setString(1, u.getName());
              stmt.setString(2, u.getSurname());
              stmt.setString(3, u.getEmail());
              stmt.setString(4, u.getPhone());
               stmt.setString(5, u.getProfileDesc());

              return stmt.execute( );
//Statement stmt=c.createStatement();
//            return stmt.execute("update user set name='azay' where id=1");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c=connection()) {
         
            Statement stmt=c.createStatement();
            return stmt.execute("delete from user where id="+id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
               User result=null;
        try(Connection c=connection()) {
            
            Statement stmt=c.createStatement();
            stmt.execute("select "
                    +"u.*, "
                    +"n.nationality as nationality, "
                    +"c.name as birthplace "
                    +"from user u "
                    +"left join country n on u.nationality_id=n.id "
                    +"left join country c on u.birthplace_id=c.id where u.id="
                    +userId);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
               
                
                result=getUser(rs);
                 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
    }
    


    


    
}

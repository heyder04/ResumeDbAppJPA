/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author HP 
 */
public interface UserDaoInter {
    public List<User>  getAll(String name,String surname,Integer nationalityId);
    public User getById(int id);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
    public boolean addUser(User u);
    
    
}

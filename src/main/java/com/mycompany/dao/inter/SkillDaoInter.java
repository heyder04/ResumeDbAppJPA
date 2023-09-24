/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.inter;

import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author HP 
 */
public interface SkillDaoInter {
   
    public List<Skill> getAll();
    public boolean insertSkill(Skill s);
    
}

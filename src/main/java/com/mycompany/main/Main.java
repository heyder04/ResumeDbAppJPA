package com.mycompany.main;


import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.SkillDaoImpl;
import com.company.entity.User;
import com.company.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;


public class Main {//loosely coupling classlar birbirinden asili deyil icine kecmewk demekdi     thightly coupling asilidi
    public static void main(String[] args) throws Exception { 
//        UserDaoInter userDao=new UserDaoImpl();
//        List<User> list=userDao.getAll();
//        System.out.println("list="+list);
//        userDao.removeUser(1);
//        List<User> list2=userDao.getAll();
//        System.out.println("list="+list2);
//        User u=userDao.getById(5);
////        userDao.addUser(u);
//        userDao.updateUser(u);
//        User u=new User();
//        u.setName("Heyder':delete from user;commit;select;");
//        u.setId(2);
//        userDao.updateUser(u);
//User u=new User(4,"HAidar","Haidar","haydaremail","994836373");
//        System.out.println(userDao.getAll());
//userDao.addUser(u);
//userDao.updateUser(u);
//System.out.println(userDao.getAllSkillByUserId(5));
//         EmploymentHistoryDaoImpl empDao=new EmploymentHistoryDaoImpl();
//        System.out.println( empDao.getAllEmploymentHistoryByUserId(5));
//        
        CountryDaoImpl dao=new CountryDaoImpl();
        System.out.println(dao.getAll());
        SkillDaoImpl dao2=new SkillDaoImpl();
        System.out.println(dao2.getAll());
    }
    
    
    

}
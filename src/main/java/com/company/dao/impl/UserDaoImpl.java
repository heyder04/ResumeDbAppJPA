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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author HP
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter{
//Data Access Object


    @Override
    public List<User> getAll(String name,String surname,Integer nationalityId) {
        EntityManager em=em();
        String jpql="select u from User u where 1=1" ;
        
//            String sql="select "
//                    +"u.*, "
//                    +"n.nationality as nationality, "
//                    +"c.name as birthplace "
//                    +"from user u "
//                    +"left join country n on u.nationality_id=n.id "
//                    +"left join country c on u.birthplace_id=c.id where  1=1 ";
            if (name!=null&& !name.trim().isEmpty()){
                jpql+=" and u.name=:name ";
            }
            if (surname!=null&& !surname.trim().isEmpty()){
                jpql+=" and u.surname=:surname ";
            }
            if (nationalityId!=null){
                jpql+=" and u.nationality.id=:nId";
            }
            Query q=em.createQuery(jpql,User.class);

            if(name!=null&&!name.trim().isEmpty()){
                q.setParameter("name", name);
             
            }
            if (surname!=null&&!surname.trim().isEmpty()){
               q.setParameter("surname", surname);
            }
            if (nationalityId!=null){
               q.setParameter("nId", nationalityId);
           
            }
           return q.getResultList();
    }

//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        EntityManager entityManager=em();
//        Query q=entityManager.createQuery("select u from User u where u.email=:e and u.password= :p",User.class);
//        q.setParameter("e",email);
//        q.setParameter("p",password);
//        List<User> list= q.getResultList();
//        if(list.size()==1){
//            return list.get(0);
//        }
//        return null;
//    }
    
    
        @Override
    public User findByEmailAndPassword(String email, String password) {
        EntityManager entityManager=em();
            CriteriaBuilder cb=entityManager.getCriteriaBuilder();
            CriteriaQuery<User> q1=cb.createQuery(User.class);
            Root<User> postRoot=q1.from(User.class);
            CriteriaQuery<User> q2=q1.
                    where(cb.equal(postRoot.get("email"), email),cb.equal(postRoot.get("password"), password));
     Query q=entityManager.createQuery(q2);
     List<User> list=q.getResultList();
     if(list.size()==1){
         return list.get(0);
     }
     return null;
    }
    //jpql
//      @Override
//    public User findByEmail(String email) {
//        EntityManager entityManager=em();
//        Query q=entityManager.createQuery("select u from User u where u.email=:e ",User.class);
//        q.setParameter("e",email);
//        
//        List<User> list= q.getResultList();
//        if(list.size()==1){
//            return list.get(0);
//        }
//        return null;
// 
//
//    }
    //criteria builder
//          @Override
//    public User findByEmail(String email) {
//          EntityManager entityManager=em();
//            CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//            CriteriaQuery<User> q1=cb.createQuery(User.class);
//            Root<User> postRoot=q1.from(User.class);
//            CriteriaQuery<User> q2=q1.
//                    where(cb.equal(postRoot.get("email"), email));
//     Query q=entityManager.createQuery(q2);
//     List<User> list=q.getResultList();
//     if(list.size()==1){
//         return list.get(0);
//     }
//     return null;
// 
//    }
    //namedquery
//              @Override
//    public User findByEmail(String email) {
//          EntityManager entityManager=em();
//        Query q= entityManager.createNamedQuery("User.findByEmail",User.class);
//         q.setParameter("email", email);
//     List<User> list=q.getResultList();
//     if(list.size()==1){
//         return list.get(0);
//     }
//     return null;
// 
//    }
    //sql
       @Override
    public User findByEmail(String email) {
          EntityManager entityManager=em();
        Query q= entityManager.createNativeQuery("select * from user where email = ?",User.class);
         q.setParameter(1, email);
     List<User> list=q.getResultList();
     if(list.size()==1){
         return list.get(0);
     }
     return null;
 
    }


    @Override
    public boolean updateUser(User u) {
      EntityManager entityManager=em();
     entityManager.getTransaction().begin();
     entityManager.merge(u);
     entityManager.getTransaction().commit();
     entityManager.close();
        

     return true;
    }
    
     @Override
    public boolean addUser(User u) {
          EntityManager entityManager=em();
     entityManager.getTransaction().begin();
     entityManager.persist(u);
     entityManager.getTransaction().commit();
     entityManager.close();
         
     return true;
    }

    @Override
    public boolean removeUser(int id) {
    EntityManager entityManager=em();
     User u=entityManager.find(User.class,id );
     entityManager.getTransaction().begin();
     entityManager.remove(u);
     entityManager.getTransaction().commit();
    entityManager.close();
     return true;
    }

    @Override
    public User getById(int userId) {
     EntityManager entityManager=em();
     User u=entityManager.find(User.class,userId );
     entityManager.close();
//        closeEnf();

     return u;
    }
    


    


    
}

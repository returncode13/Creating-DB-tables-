/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import hibernate.HibernateUtil;
import db.model.Descendant;
import db.model.Job;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sharath nair
 */
public class DescendantDAOImpl implements DescendantDAO {

    @Override
    public void addDescendant(Descendant d) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            session.save(d);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public Descendant getDescendant(Long did) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        Descendant anc=null;
        try{
            transaction=session.beginTransaction();
           anc = (Descendant) session.get(Descendant.class, did);
            System.out.println("retrieved "+anc.getId());
           transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return anc;
    }

    @Override
    public void updateDescendant(Long did, Descendant newD) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            Descendant desc= (Descendant) session.get(Descendant.class, did);
            desc.setDescendant(newD.getDescendant());
            desc.setJob(newD.getJob());
            session.update(desc);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void deleteDescendant(Long did) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
             Descendant anc= (Descendant) session.get(Descendant.class, did);
            session.delete(anc);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public Descendant getDescendantFor(Job fkid, Long descendant) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        List<Descendant> results=null;
        try{
            Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(Descendant.class);
        criteria.add(Restrictions.eq("job", fkid));
        criteria.add(Restrictions.eq("descendant", descendant));
        results=criteria.list();
     
        if(results.size()>0)return results.get(0);
         
            
         transaction.commit();
         
         
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }
    
}

/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.model.Header;
import db.model.QcMatrixRow;
import db.model.QcTable;
import db.model.QcType;
import db.model.Subsurface;
import db.model.Volume;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sharath nair <sharath.nair@polarcus.com>
 */
public class QcTableDAOImpl implements QcTableDAO{

    @Override
    public void createQcTable(QcTable qcm) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            session.saveOrUpdate(qcm);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        
    }

    @Override
    public QcTable getQcTable(Long qid) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            QcTable h= (QcTable) session.get(QcTable.class, qid);
            return h;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void updateQcTable(Long qid, QcTable newQ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            QcTable h= (QcTable) session.get(QcTable.class, qid);
           // h.setVolume(newQ.getVolume());
            h.setTime(newQ.getTime());
            /*h.setSequenceNumber(newQ.getSequenceNumber());
            h.setSubsurface(newQ.getSubsurface());*/
            //h.setHeaders(newQ.getHeaders());
            h.setSubsurface(newQ.getSubsurface());
            h.setResult(newQ.getResult());
          //  h.setQctype(newQ.getQctype());
          h.setQcMatrixRow(newQ.getQcMatrixRow());
            h.setComment(newQ.getComment());
            h.setUpdateTime(newQ.getUpdateTime());
            h.setSummaryTime(newQ.getSummaryTime());
            session.update(h);
            
            
          
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void deleteQcTable(Long qid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            QcTable h= (QcTable) session.get(QcTable.class, qid);
            session.delete(h);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    /*
    @Override
    public List<QcTable> getQcTableFor(Volume v) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    List<QcTable> result=null;
    try{
    transaction=session.beginTransaction();
    Criteria criteria=session.createCriteria(QcTable.class);
    criteria.add(Restrictions.eq("volume", v));
    result=criteria.list();
    transaction.commit();
    }catch(Exception e){
    e.printStackTrace();
    }finally{
    session.close();
    }
    return result;
    }
    
    @Override
    public List<QcTable> getQcTableFor(Volume v, QcType qctype) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    List<QcTable> result=null;
    try{
    transaction=session.beginTransaction();
    Criteria criteria=session.createCriteria(QcTable.class);
    criteria.add(Restrictions.eq("volume", v));
    criteria.add(Restrictions.eq("qctype", qctype));
    result=criteria.list();
    transaction.commit();
    }catch(Exception e){
    e.printStackTrace();
    }finally{
    session.close();
    }
    return result;
    }*/

    @Override
    public List<QcTable> getQcTableFor(QcMatrixRow qmx) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<QcTable> result=null;
        try{
        transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(QcTable.class);
        criteria.add(Restrictions.eq("qcmatrix", qmx));
        result=criteria.list();
        transaction.commit();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        session.close();
        }
        return result;
    }

    /* @Override
    public List<QcTable> getQcTableFor(Header h) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    List<QcTable> result=null;
    try{
    transaction=session.beginTransaction();
    Criteria criteria=session.createCriteria(QcTable.class);
    criteria.add(Restrictions.eq("headers", h));
    result=criteria.list();
    transaction.commit();
    }catch(Exception e){
    e.printStackTrace();
    }finally{
    session.close();
    }
    return result;
    }*/
    /* @Override
    public QcTable getQcTableFor(QcMatrixRow qmx, Header h) throws Exception{
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    List<QcTable> result=null;
    try{
    transaction=session.beginTransaction();
    Criteria criteria=session.createCriteria(QcTable.class);
    criteria.add(Restrictions.eq("qcmatrix", qmx));
    criteria.add(Restrictions.eq("headers", h));
    result=criteria.list();
    transaction.commit();
    }catch(Exception e){
    e.printStackTrace();
    }finally{
    session.close();
    }
    if(result.isEmpty()){
    return null;
    }else if(result.size()>1){
    throw new Exception("More than one qcTable entries encountered for qcmatrix :  id "+qmx.getId()+" and subsurface id: "+qmx.get);
    }else{
    return result.get(0);
    }
    
    }*/
    @Override
    public List<QcTable> getQcTableFor(Subsurface s) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<QcTable> result=null;
        try{
        transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(QcTable.class);
        criteria.add(Restrictions.eq("subsurface", s));
        result=criteria.list();
        transaction.commit();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        session.close();
        }
        return result;
    }

    @Override
    public QcTable getQcTableFor(QcMatrixRow qmx, Subsurface s) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<QcTable> result=null;
        try{
        transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(QcTable.class);
        criteria.add(Restrictions.eq("qcmatrix", qmx));
        criteria.add(Restrictions.eq("subsurface", s));
        result=criteria.list();
        transaction.commit();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        session.close();
        }
        if(result.isEmpty()){
            return null;
        }else if(result.size()>1){
            throw new Exception("More than one qcTable entries encountered for qcmatrix :  id "+qmx.getId()+" and subsurface id: "+s.getId()+" name: "+s.getSubsurface());
        }else{
            return result.get(0);
        }
    }
    
    
    
}

/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.model.Header;
import db.model.Log;
import db.model.Volume;
import db.model.Workflow;
import hibernate.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author sharath nair  
 * sharath.nair@polarcus.com
 */
public class LogsDAOImpl implements LogsDAO{

    @Override
    public void createLogs(Log l) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            session.saveOrUpdate(l);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public Log getLogs(Long lid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Log l= (Log) session.get(Log.class, lid);
            return l;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void updateLogs(Long lid, Log newL) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            Log ll=(Log) session.get(Log.class,lid);
            ll.setHeader(newL.getHeader());
            //ll.setSubsurfaces(newL.getSubsurfaces());
            ll.setSubsurface(newL.getSubsurface());
            ll.setInsightVersion(newL.getInsightVersion());
            ll.setLogpath(newL.getLogpath());
            ll.setTimestamp(newL.getTimestamp());
            ll.setVolume(newL.getVolume());
            ll.setCompletedsuccessfully(newL.getCompletedsuccessfully());
            ll.setErrored(newL.getErrored());
            ll.setRunning(newL.getRunning());
            ll.setCancelled(newL.getCancelled());
            ll.setWorkflow(newL.getWorkflow());
            ll.setUpdateTime(newL.getUpdateTime());
            ll.setSummaryTime(newL.getSummaryTime());
            session.update(ll);
            
            
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }    
    }

    @Override
    public void deleteLogs(Long lid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            Log h= (Log) session.get(Log.class, lid);
            session.delete(h);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Log> getLogsFor(Header h) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("headers", h));
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
    public List<Log> getLogsFor(Volume v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
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
    public List<Log> getLogsFor(Volume v, String subline) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.add(Restrictions.eq("subsurfaces", subline));
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
    public Log getLatestLogFor(Volume v, String subline) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.add(Restrictions.eq("subsurfaces", subline));
            criteria.addOrder(Order.desc("timestamp"));
            result=criteria.list();
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        if(result.isEmpty())return null;
        else{
        return result.get(0);
        }
    }

    @Override
    public List<Log> getLogsFor(Volume v, Boolean completed, Boolean running, Boolean errored, Boolean cancelled) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.add(Restrictions.eq("completedsuccessfully", completed));
            criteria.add(Restrictions.eq("running", running));
            criteria.add(Restrictions.eq("errored", errored));
            criteria.add(Restrictions.eq("cancelled", cancelled));
            
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
    public List<Log> getLogsFor(Volume v, String subline, Boolean completed, Boolean running, Boolean errored, Boolean cancelled) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.add(Restrictions.eq("subsurfaces", subline));
            criteria.add(Restrictions.eq("completedsuccessfully", completed));
            criteria.add(Restrictions.eq("running", running));
            criteria.add(Restrictions.eq("errored", errored));
            criteria.add(Restrictions.eq("cancelled", cancelled));
            
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
    public List<Log> getLogsFor(Volume v, Workflow workflow) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        List<Workflow> reswf=null;
        try{
            transaction=session.beginTransaction();
           
                Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            //criteria.add(Restrictions.eq("workflow", workflow));
            criteria.add(Restrictions.or(Restrictions.isNull("workflow"),Restrictions.eq("workflow", workflow)));
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
    public List<Log> getLogsFor(Volume v, Long seq) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.add(Restrictions.eq("sequence", seq));
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
    public List<Log> getSequencesFor(Volume v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("sequence"),"sequence")));
            criteria.setResultTransformer(Transformers.aliasToBean(Log.class));
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
    public List<Log> getSubsurfacesFor(Volume v, Long seq) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", v));
            criteria.add(Restrictions.eq("sequence", seq));
            criteria.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("subsurfaces"),"subsurfaces")));
            criteria.setResultTransformer(Transformers.aliasToBean(Log.class));
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
    public Log getLogsFor(Volume volume, String linename, String timestamp, String filename) throws Exception{
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Log> result=null;
        try{
            transaction=session.beginTransaction();
            Criteria criteria=session.createCriteria(Log.class);
            criteria.add(Restrictions.eq("volume", volume));
            criteria.add(Restrictions.eq("subsurfaces", linename));
            criteria.add(Restrictions.eq("logpath", filename));
            criteria.add(Restrictions.eq("timestamp", timestamp));
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
            throw new Exception("More than one results encountered for log: "+filename+" timestamp: "+timestamp+" volume: "+volume.getId()+" line: "+linename);
        }else{
            return result.get(0);
        }
            
        
    }

    

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.services;

import db.dao.QcMatrixRowDAO;
import db.dao.QcMatrixRowDAOImpl;
import db.model.Job;
import db.model.QcMatrixRow;
import db.model.QcType;

import java.util.List;

/**
 *
 * @author sharath nair <sharath.nair@polarcus.com>
 */
public class QcMatrixRowServiceImpl implements QcMatrixRowService{
    QcMatrixRowDAO qcmDao=new QcMatrixRowDAOImpl();
    
    @Override
    public void createQcMatrixRow(QcMatrixRow qcmatrix) {
        qcmDao.createQcMatrixRow(qcmatrix);
    }

    @Override
    public void updateQcMatrixRow(Long qid, QcMatrixRow newq) {
        qcmDao.updateQcMatrixRow(qid, newq);
    }

    @Override
    public QcMatrixRow getQcMatrixRow(Long qid) {
        return qcmDao.getQcMatrixRow(qid);
    }

    @Override
    public void deleteQcMatrixRow(Long qid) {
        qcmDao.deleteQcMatrixRow(qid);
    }

    /*@Override
    public List<QcMatrixRow> getQcMatrixRowForVolume(Volume v) {
    return qcmDao.getQcMatrixRowForVolume(v);
    }*/

    

    @Override
    public List<QcMatrixRow> getQcMatrixRowForJob(Job sd) {
        return qcmDao.getQcMatrixRowForJob(sd);
    }

    @Override
    public QcMatrixRow getQcMatrixRowFor(Job sd, QcType qctype) throws Exception {
        return qcmDao.getQcMatrixRowFor(sd, qctype);
    }

    @Override
    public List<QcMatrixRow> getQcMatrixRowForJob(Job job, boolean b) {
        return qcmDao.getQcMatrixRowForJob(job, b);
    }
    
}

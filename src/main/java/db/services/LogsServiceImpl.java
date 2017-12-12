/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.services;

import db.dao.LogsDAO;
import db.dao.LogsDAOImpl;
import db.model.Header;
import db.model.Log;
import db.model.Volume;
import db.model.Workflow;
import java.util.List;

/**
 *
 * @author sharath nair
 */
public class LogsServiceImpl implements LogsService{

    LogsDAO ldao=new LogsDAOImpl();
    @Override
    public void createLogs(Log l) {
        ldao.createLogs(l);
    }

    @Override
    public Log getLogs(Long lid) {
       return ldao.getLogs(lid);
    }

    @Override
    public void updateLogs(Long lid, Log newL) {
        ldao.updateLogs(lid, newL);
    }

    @Override
    public void deleteLogs(Long lid) {
        ldao.deleteLogs(lid);
    }

    @Override
    public List<Log> getLogsFor(Header h) {
        return ldao.getLogsFor(h);
    }

    @Override
    public List<Log> getLogsFor(Volume v) {
        return ldao.getLogsFor(v);
    }

    @Override
    public List<Log> getLogsFor(Volume v, String subline) {
        return ldao.getLogsFor(v, subline);
    }

    @Override
    public Log getLatestLogFor(Volume v, String subline) {
        return ldao.getLatestLogFor(v, subline);
    }

    @Override
    public List<Log> getLogsFor(Volume v, Boolean completed, Boolean running, Boolean errored, Boolean cancelled) {
        return ldao.getLogsFor(v, completed, running, errored, cancelled);
    }

    @Override
    public List<Log> getLogsFor(Volume v, String subline, Boolean completed, Boolean running, Boolean errored, Boolean cancelled) {
        return ldao.getLogsFor(v, subline, completed, running, errored, cancelled);
    }

    @Override
    public List<Log> getLogsFor(Volume v, Workflow workflow) {
        return ldao.getLogsFor(v, workflow);
    }

    @Override
    public List<Log> getLogsFor(Volume v, Long seq) {
        return ldao.getLogsFor(v, seq);
    }

    @Override
    public List<Log> getSequencesFor(Volume v) {
        return ldao.getSequencesFor(v);
    }

    @Override
    public List<Log> getSubsurfacesFor(Volume v, Long seq) {
        return ldao.getSubsurfacesFor(v, seq);
    }

    @Override
    public Log getLogsFor(Volume volume, String linename, String timestamp, String filename) throws Exception{
        return ldao.getLogsFor(volume,linename,timestamp,filename);
    }

   
    
}

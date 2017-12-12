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
import java.util.List;

/**
 *
 * @author naila0152
 */
public interface LogsDAO {
    public void createLogs(Log l);
    public Log getLogs(Long lid);
    public void updateLogs(Long lid, Log newL);
    public void deleteLogs(Long lid);
    
    public List<Log> getLogsFor(Header h);  //get the logs for which the foreign key=h.id
    public List<Log> getLogsFor(Volume v);
    public List<Log> getLogsFor(Volume v,Boolean completed,Boolean running,Boolean errored,Boolean cancelled);
    public List<Log> getLogsFor(Volume v,String subline);
    public List<Log> getLogsFor(Volume v,String subline,Boolean completed,Boolean running,Boolean errored,Boolean cancelled);
    public Log getLatestLogFor(Volume v, String subline);
    public List<Log> getLogsFor(Volume v, Workflow workflow);
    public List<Log> getLogsFor(Volume v,Long seq);       //get logs for seq
    public List<Log> getSequencesFor(Volume v);           //get distinct sequences in volume
    public List<Log> getSubsurfacesFor(Volume v, Long seq); //get distinct subsurfaces for  volume,seq

    public Log getLogsFor(Volume volume, String linename, String timestamp, String filename) throws Exception;
}

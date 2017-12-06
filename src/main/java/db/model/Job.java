/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 *
 * @author sharath nair
 */

@Entity
@Table(name="job",schema = "obpmanager")

public class Job implements Serializable{
    
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    @Column(name = "id",nullable = false,unique = true,length = 10)
    private Long id;
    
    @Column(name = "name",nullable = true,length = 256)
    private String nameJobStep;
    
    @Column(name = "insightVersionsUsed",nullable=false,length=2048)
    private String insightVersions;
    
    
    @Column(name = "alert",nullable = true)
    private Boolean alert;
    
    /*@Column(name = "type",nullable=false)
    private Long type;*/
    
   
    
    @ManyToOne
    @JoinColumn(name="nodetype_fk",nullable=false)
    private NodeType nodetype;
    
    @ManyToOne
    @JoinColumn(name="workspace_fk",nullable=false)
    private Workspace workspace;
    
    /*@Column(name = "pending",nullable = true)
    private Boolean pending;*/
    @OneToMany(mappedBy = "job")                              //create a member named "job" in the JobVolumeMap class definition
    private Set<JobVolumeMap> jobVolumeMap;
    
   
    /*public Job(String nameJobStep, Boolean alert,String insightVersion,Long type) {
    this.nameJobStep = nameJobStep;
    this.alert = alert;
    this.insightVersions=insightVersion;
    this.type=type;
    }
    */

    
    public Job(String nameJobStep, Boolean alert,String insightVersion,NodeType type) {
        this.nameJobStep = nameJobStep;
        this.alert = alert;
        this.insightVersions=insightVersion;
        this.nodetype=type;
    }
    
    public Job() {
    }
    

    
    

  
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    this.id = id;
    }
    
    public String getNameJobStep() {
        return nameJobStep;
    }

    public void setNameJobStep(String nameJobStep) {
        this.nameJobStep = nameJobStep;
    }

    public Boolean isAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    public Set<JobVolumeMap> getJobVolumeMap() {
        return jobVolumeMap;
    }

    public void setJobVolumeMap(Set<JobVolumeMap> jobVolumeMap) {
        
        if(jobVolumeMap!=null)
        {
        this.jobVolumeMap.clear();
        
        for (Iterator<JobVolumeMap> iterator = jobVolumeMap.iterator(); iterator.hasNext();) {
            JobVolumeMap next = iterator.next();
            this.jobVolumeMap.add(next);
        }
        }
        //this.jobVolumeMap = jobVolumeMap;
    }

   

    public String getInsightVersions() {
        return insightVersions;
    }

    public void setInsightVersions(String insightVersions) {
        this.insightVersions = insightVersions;
    }

    /* public Boolean getPending() {
    return pending;
    }
    
    public void setPending(Boolean pending) {
    this.pending = pending;
    }
    */

    /* public Long getType() {
    return type;
    }
    
    public void setType(Long type) {
    this.type = type;
    }*/

    /*public NodeType getType() {
    return nodetype;
    }
    
    public void setType(NodeType type) {
    this.nodetype = type;
    }*/

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public NodeType getNodetype() {
        return nodetype;
    }

    public void setNodetype(NodeType nodetype) {
        this.nodetype = nodetype;
    }
    
    

    

    
    
    
    
    
}

/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
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
import org.hibernate.annotations.Columns;

/**
 *
 * @author sharath nair
 */
@Entity
@Table(name="Header",schema = "obpmanager")
public class Header implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="volume_fk",nullable = false)
    private Volume volume;
    
    @ManyToOne
    @JoinColumn(name="job_fk",nullable = false)
    private Job job;
    
    
    
    @OneToMany(mappedBy = "header")
    private Set<Log> logs;
    
    /*@OneToMany(mappedBy = "headers",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<DoubtStatus> doubtstatus;
    
    @OneToMany(mappedBy = "headers",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<QcTable> qctable;*/
    
    
   
    

    
    @ManyToOne
    @JoinColumn(name="subsurface_fk",nullable = false)
    private Subsurface subsurface;
    
    
    @Column(name= "TimeStamp ")
    private String timeStamp;
    
    
    @Column(name= "TraceCount")
    private Long traceCount;
    
    @Column(name="InlineMax")
    private Long inlineMax;
    
    @Column(name="InlineMin")
    private Long inlineMin;
    
    @Column(name="InlineInc")
    private Long inlineInc;
    
    @Column(name="XlineMax")
    private Long xlineMax;
    
    @Column(name="XlineMin")
    private Long xlineMin;
    
    @Column(name="XlineInc")
    private Long xlineInc;
    
    @Column(name="DugShotMax")
    private Long dugShotMax;
    
    @Column(name="DugShotMin")
    private Long dugShotMin;
    
    @Column(name="DugShotInc")
    private Long dugShotInc;
    
    @Column(name="DugChannelMax")
    private Long dugChannelMax;
    
    @Column(name="DugChannelMin")
    private Long dugChannelMin;
    
    @Column(name="DugChannelInc")
    private Long dugChannelInc;
    
    @Column(name="OffsetMax")
    private Long offsetMax;
    
    @Column(name="OffsetMin")
    private Long offsetMin;
    
    @Column(name="OffsetInc")
    private Long offsetInc;
    
    @Column(name="CmpMax")
    private Long cmpMax;
    
    @Column(name="CmpMin")
    private Long cmpMin;
    
    @Column(name="CmpInc")
    private Long cmpInc;

    @Column(name="Modified")
    private Boolean modified=false;
    
    @Column(name="Deleted")
    private Boolean deleted=false; 
    
    @Column(name="NumberOfRuns")
    private Long numberOfRuns=0L;                                               //number of times the subsurface was run
    
        
    @Column(name="InsightVersion")
    private String insightVersion;                                        //version of insight as derived from the latest log.
    
    @Column(name="workflowVersion")                                       //version of workflow
    private Long workflowVersion;
    
    
    @Column(name="UpdateTime")
    private String updateTime;
    
    @Column(name="SummaryTime")
    private String summaryTime;
    
    @Column(name="textfilename")                                             //used for txt file types. job steptype=4
    private String textfilepath;         
    
    @Column(name="multiple_instances")
    private Boolean multipleInstances=false;
    
    @Column(name="chosen")
    private Boolean chosen=true;
    
    public Header() {
      
    }

    
    

    /*public Header(Long id, Volume volume, Long sequence, String subsurface, String timeStamp, Long traceCount, Long inlineMax, Long inlineMin, Long inlineInc, Long xlineMax, Long xlineMin, Long xlineInc, Long dugShotMax, Long dugShotMin, Long dugShotInc, Long dugChannelMax, Long dugChannelMin, Long dugChannelInc, Long offsetMax, Long offsetMin, Long offsetInc, Long cmpMax, Long cmpMin, Long cmpInc,Boolean modified,Boolean deleted,Long version) {
    this.id = id;
    this.volume = volume;
    this.sequence = sequence;
    this.subsurface = subsurface;
    this.timeStamp = timeStamp;
    this.traceCount = traceCount;
    this.inlineMax = inlineMax;
    this.inlineMin = inlineMin;
    this.inlineInc = inlineInc;
    this.xlineMax = xlineMax;
    this.xlineMin = xlineMin;
    this.xlineInc = xlineInc;
    this.dugShotMax = dugShotMax;
    this.dugShotMin = dugShotMin;
    this.dugShotInc = dugShotInc;
    this.dugChannelMax = dugChannelMax;
    this.dugChannelMin = dugChannelMin;
    this.dugChannelInc = dugChannelInc;
    this.offsetMax = offsetMax;
    this.offsetMin = offsetMin;
    this.offsetInc = offsetInc;
    this.cmpMax = cmpMax;
    this.cmpMin = cmpMin;
    this.cmpInc = cmpInc;
    this.modified=modified;
    this.deleted=deleted;
    this.numberOfRuns=version;
    }*/

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.volume);
        hash = 97 * hash + Objects.hashCode(this.subsurface);
        hash = 97 * hash + Objects.hashCode(this.traceCount);
        hash = 97 * hash + Objects.hashCode(this.inlineMax);
        hash = 97 * hash + Objects.hashCode(this.inlineMin);
        hash = 97 * hash + Objects.hashCode(this.inlineInc);
        hash = 97 * hash + Objects.hashCode(this.xlineMax);
        hash = 97 * hash + Objects.hashCode(this.xlineMin);
        hash = 97 * hash + Objects.hashCode(this.xlineInc);
        hash = 97 * hash + Objects.hashCode(this.dugShotMax);
        hash = 97 * hash + Objects.hashCode(this.dugShotMin);
        hash = 97 * hash + Objects.hashCode(this.dugShotInc);
        hash = 97 * hash + Objects.hashCode(this.dugChannelMax);
        hash = 97 * hash + Objects.hashCode(this.dugChannelMin);
        hash = 97 * hash + Objects.hashCode(this.dugChannelInc);
        hash = 97 * hash + Objects.hashCode(this.offsetMax);
        hash = 97 * hash + Objects.hashCode(this.offsetMin);
        hash = 97 * hash + Objects.hashCode(this.offsetInc);
        hash = 97 * hash + Objects.hashCode(this.cmpMax);
        hash = 97 * hash + Objects.hashCode(this.cmpMin);
        hash = 97 * hash + Objects.hashCode(this.cmpInc);
        hash = 97 * hash + Objects.hashCode(this.modified);
        hash = 97 * hash + Objects.hashCode(this.deleted);
        hash = 97 * hash + Objects.hashCode(this.numberOfRuns);
        hash = 97 * hash + Objects.hashCode(this.insightVersion);
        hash = 97 * hash + Objects.hashCode(this.workflowVersion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Header other = (Header) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        
        if (!Objects.equals(this.subsurface, other.subsurface)) {
            return false;
        }
        if (!Objects.equals(this.timeStamp, other.timeStamp)) {
            return false;
        }
        if (!Objects.equals(this.traceCount, other.traceCount)) {
            return false;
        }
        if (!Objects.equals(this.inlineMax, other.inlineMax)) {
            return false;
        }
        if (!Objects.equals(this.inlineMin, other.inlineMin)) {
            return false;
        }
        if (!Objects.equals(this.inlineInc, other.inlineInc)) {
            return false;
        }
        if (!Objects.equals(this.xlineMax, other.xlineMax)) {
            return false;
        }
        if (!Objects.equals(this.xlineMin, other.xlineMin)) {
            return false;
        }
        if (!Objects.equals(this.xlineInc, other.xlineInc)) {
            return false;
        }
        if (!Objects.equals(this.dugShotMax, other.dugShotMax)) {
            return false;
        }
        if (!Objects.equals(this.dugShotMin, other.dugShotMin)) {
            return false;
        }
        if (!Objects.equals(this.dugShotInc, other.dugShotInc)) {
            return false;
        }
        if (!Objects.equals(this.dugChannelMax, other.dugChannelMax)) {
            return false;
        }
        if (!Objects.equals(this.dugChannelMin, other.dugChannelMin)) {
            return false;
        }
        if (!Objects.equals(this.dugChannelInc, other.dugChannelInc)) {
            return false;
        }
        if (!Objects.equals(this.offsetMax, other.offsetMax)) {
            return false;
        }
        if (!Objects.equals(this.offsetMin, other.offsetMin)) {
            return false;
        }
        if (!Objects.equals(this.offsetInc, other.offsetInc)) {
            return false;
        }
        if (!Objects.equals(this.cmpMax, other.cmpMax)) {
            return false;
        }
        if (!Objects.equals(this.cmpMin, other.cmpMin)) {
            return false;
        }
        if (!Objects.equals(this.cmpInc, other.cmpInc)) {
            return false;
        }
        if (!Objects.equals(this.modified, other.modified)) {
            return false;
        }
        if (!Objects.equals(this.deleted, other.deleted)) {
            return false;
        }
        if (!Objects.equals(this.numberOfRuns, other.numberOfRuns)) {
            return false;
        }
        if (!Objects.equals(this.insightVersion, other.insightVersion)) {
            return false;
        }
        if (!Objects.equals(this.workflowVersion, other.workflowVersion)) {
            return false;
        }
        
        return true;
    }

   

    

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    /*  public Long getSequenceNumber() {
    return sequence;
    }
    
    public void setSequenceNumber(Long sequence) {
    this.sequence = sequence;
    }
    
    public String getSubsurface() {
    return subsurface;
    }
    
    public void setSubsurface(String subsurface) {
    this.subsurface = subsurface;
    }*/

    

    public Subsurface getSubsurface() {
        return subsurface;
    }

    public void setSubsurface(Subsurface subsurface) {
        this.subsurface = subsurface;
    }
    
    
    public Long getTraceCount() {
        return traceCount;
    }

    public void setTraceCount(Long traceCount) {
        this.traceCount = traceCount;
    }

    public Long getInlineMax() {
        return inlineMax;
    }

    public void setInlineMax(Long inlineMax) {
        this.inlineMax = inlineMax;
    }

    public Long getInlineMin() {
        return inlineMin;
    }

    public void setInlineMin(Long inlineMin) {
        this.inlineMin = inlineMin;
    }

    public Long getInlineInc() {
        return inlineInc;
    }

    public void setInlineInc(Long inlineInc) {
        this.inlineInc = inlineInc;
    }

    public Long getXlineMax() {
        return xlineMax;
    }

    public void setXlineMax(Long xlineMax) {
        this.xlineMax = xlineMax;
    }

    public Long getXlineMin() {
        return xlineMin;
    }

    public void setXlineMin(Long xlineMin) {
        this.xlineMin = xlineMin;
    }

    public Long getXlineInc() {
        return xlineInc;
    }

    public void setXlineInc(Long xlineInc) {
        this.xlineInc = xlineInc;
    }

    public Long getDugShotMax() {
        return dugShotMax;
    }

    public void setDugShotMax(Long dugShotMax) {
        this.dugShotMax = dugShotMax;
    }

    public Long getDugShotMin() {
        return dugShotMin;
    }

    public void setDugShotMin(Long dugShotMin) {
        this.dugShotMin = dugShotMin;
    }

    public Long getDugShotInc() {
        return dugShotInc;
    }

    public void setDugShotInc(Long dugShotInc) {
        this.dugShotInc = dugShotInc;
    }

    public Long getDugChannelMax() {
        return dugChannelMax;
    }

    public void setDugChannelMax(Long dugChannelMax) {
        this.dugChannelMax = dugChannelMax;
    }

    public Long getDugChannelMin() {
        return dugChannelMin;
    }

    public void setDugChannelMin(Long dugChannelMin) {
        this.dugChannelMin = dugChannelMin;
    }

    public Long getDugChannelInc() {
        return dugChannelInc;
    }

    public void setDugChannelInc(Long dugChannelInc) {
        this.dugChannelInc = dugChannelInc;
    }

    public Long getOffsetMax() {
        return offsetMax;
    }

    public void setOffsetMax(Long offsetMax) {
        this.offsetMax = offsetMax;
    }

    public Long getOffsetMin() {
        return offsetMin;
    }

    public void setOffsetMin(Long offsetMin) {
        this.offsetMin = offsetMin;
    }

    public Long getOffsetInc() {
        return offsetInc;
    }

    public void setOffsetInc(Long offsetInc) {
        this.offsetInc = offsetInc;
    }

    public Long getCmpMax() {
        return cmpMax;
    }

    public void setCmpMax(Long cmpMax) {
        this.cmpMax = cmpMax;
    }

    public Long getCmpMin() {
        return cmpMin;
    }

    public void setCmpMin(Long cmpMin) {
        this.cmpMin = cmpMin;
    }

    public Long getCmpInc() {
        return cmpInc;
    }

    public void setCmpInc(Long cmpInc) {
        this.cmpInc = cmpInc;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getModified() {
        return modified;
    }

    public void setModified(Boolean modified) {
        this.modified = modified;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getNumberOfRuns() {
        return numberOfRuns;
    }

    public void setNumberOfRuns(Long version) {
        this.numberOfRuns = version;
    }

    public String getInsightVersion() {
        return insightVersion;
    }

    public void setInsightVersion(String insightVersion) {
        this.insightVersion = insightVersion;
    }

    public Long getWorkflowVersion() {
        return workflowVersion;
    }

    public void setWorkflowVersion(Long workflowVersion) {
        this.workflowVersion = workflowVersion;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSummaryTime() {
        return summaryTime;
    }

    public void setSummaryTime(String summaryTime) {
        this.summaryTime = summaryTime;
    }

    public String getTextfilepath() {
        return textfilepath;
    }

    public void setTextfilepath(String textfilepath) {
        this.textfilepath = textfilepath;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }

    public Boolean getMultipleInstances() {
        return multipleInstances;
    }

    public void setMultipleInstances(Boolean multipleInstances) {
        this.multipleInstances = multipleInstances;
    }

    public Boolean getChosen() {
        return chosen;
    }

    public void setChosen(Boolean chosen) {
        this.chosen = chosen;
    }
    
    
    
   
   
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author sharath nair <sharath.nair@polarcus.com>
 */
@Entity
@Table(name="subsurface_job",schema="obpmanager")
@AssociationOverrides({
        @AssociationOverride(name="pk.job",joinColumns = @JoinColumn(name="job_id")),
        @AssociationOverride(name="pk.subsurface",joinColumns = @JoinColumn(name="id"))
        })

public class SubsurfaceJob {
    @EmbeddedId
    private SubsurfaceJobId pk=new SubsurfaceJobId();
    
    @Transient
    private Job job;
    
    @Transient 
    private Subsurface subsurface;

    public SubsurfaceJob() {
    }

    
    
    
    
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Subsurface getSubsurface() {
        return subsurface;
    }

    public void setSubsurface(Subsurface subsurface) {
        this.subsurface = subsurface;
    }

    public SubsurfaceJobId getPk() {
        return pk;
    }

    public void setPk(SubsurfaceJobId pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.pk);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubsurfaceJob other = (SubsurfaceJob) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

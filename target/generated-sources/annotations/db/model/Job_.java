package db.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Job.class)
public abstract class Job_ {

	public static volatile SingularAttribute<Job, Workspace> workspace;
	public static volatile SingularAttribute<Job, NodeType> nodetype;
	public static volatile SingularAttribute<Job, Boolean> alert;
	public static volatile SingularAttribute<Job, String> nameJobStep;
	public static volatile SetAttribute<Job, JobVolumeMap> jobVolumeMap;
	public static volatile SingularAttribute<Job, String> insightVersions;
	public static volatile SingularAttribute<Job, Long> id;

}


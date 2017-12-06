package db.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Headers.class)
public abstract class Headers_ {

	public static volatile SingularAttribute<Headers, Long> xlineMax;
	public static volatile SingularAttribute<Headers, Long> xlineInc;
	public static volatile SingularAttribute<Headers, Long> dugShotMax;
	public static volatile SingularAttribute<Headers, String> insightVersion;
	public static volatile SingularAttribute<Headers, Long> cmpMin;
	public static volatile SingularAttribute<Headers, String> textfilepath;
	public static volatile SingularAttribute<Headers, Long> dugShotInc;
	public static volatile SingularAttribute<Headers, Long> traceCount;
	public static volatile SingularAttribute<Headers, Long> inlineMax;
	public static volatile SingularAttribute<Headers, Long> inlineInc;
	public static volatile SingularAttribute<Headers, Boolean> modified;
	public static volatile SingularAttribute<Headers, Long> id;
	public static volatile SingularAttribute<Headers, Long> cmpInc;
	public static volatile SetAttribute<Headers, Logs> logs;
	public static volatile SingularAttribute<Headers, Long> dugShotMin;
	public static volatile SingularAttribute<Headers, Long> offsetMin;
	public static volatile SingularAttribute<Headers, Long> cmpMax;
	public static volatile SingularAttribute<Headers, Long> xlineMin;
	public static volatile SingularAttribute<Headers, Long> inlineMin;
	public static volatile SingularAttribute<Headers, Long> dugChannelMax;
	public static volatile SingularAttribute<Headers, Long> offsetInc;
	public static volatile SingularAttribute<Headers, Long> numberOfRuns;
	public static volatile SingularAttribute<Headers, String> updateTime;
	public static volatile SingularAttribute<Headers, Subsurface> subsurface;
	public static volatile SingularAttribute<Headers, Long> dugChannelInc;
	public static volatile SingularAttribute<Headers, Volume> volume;
	public static volatile SingularAttribute<Headers, String> timeStamp;
	public static volatile SingularAttribute<Headers, Sequence> sequence;
	public static volatile SingularAttribute<Headers, Long> offsetMax;
	public static volatile SingularAttribute<Headers, Boolean> deleted;
	public static volatile SingularAttribute<Headers, String> summaryTime;
	public static volatile SingularAttribute<Headers, Long> dugChannelMin;
	public static volatile SingularAttribute<Headers, Long> workflowVersion;

}


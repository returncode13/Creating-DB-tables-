package db.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subsurface.class)
public abstract class Subsurface_ {

	public static volatile SingularAttribute<Subsurface, Sequence> sequence;
	public static volatile SetAttribute<Subsurface, Headers> headers;
	public static volatile SingularAttribute<Subsurface, Long> id;
	public static volatile SetAttribute<Subsurface, Acquisition> acquisition;
	public static volatile SingularAttribute<Subsurface, String> subsurface;

}

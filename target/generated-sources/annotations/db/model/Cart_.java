package db.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cart.class)
public abstract class Cart_ {

	public static volatile SingularAttribute<Cart, Double> total;
	public static volatile SingularAttribute<Cart, String> name;
	public static volatile SingularAttribute<Cart, Long> id;
	public static volatile SetAttribute<Cart, Item> items;

}


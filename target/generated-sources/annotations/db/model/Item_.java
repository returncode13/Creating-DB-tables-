package db.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, String> itemName;
	public static volatile SingularAttribute<Item, Double> itemTotal;
	public static volatile SingularAttribute<Item, Double> quantity;
	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, Cart> cart;

}


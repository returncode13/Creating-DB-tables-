package main;

import db.model.Cart;
import db.model.Item;
import hibernate.HibernateUtil;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
        
        Cart cart=new Cart();
        cart.setName("cart1");
        
        Item item1=new Item("I1", 10.0, 1.0, cart);
        Item item2=new Item("I2",20.0,2.0,cart);
        Set<Item> items=new HashSet<>();
        cart.setItems(items);
        cart.setTotal(item1.getItemTotal()*item2.getItemTotal());
        
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        
        try{
            //getSession
            sessionFactory=HibernateUtil.getSessionFactory();
            session=sessionFactory.openSession();
            System.out.println("main.FXMLController.handleButtonAction(): session created");
            transaction=session.beginTransaction();
            session.save(cart);
            session.save(item1);
            session.save(item2);
            transaction.commit();
            
        }catch(Exception e){
            System.out.println("main.FXMLController.handleButtonAction(): "+e.getLocalizedMessage());
        }finally{
            if(!sessionFactory.isClosed()){
                sessionFactory.close();
            }
        }
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

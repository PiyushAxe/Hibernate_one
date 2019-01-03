import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
import java.util.*;
import org.hibernate.cfg.Configuration;

import javassist.Loader.Simple;


public class StoringData {

	//private static final int Integer = 0;

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StoringData sd = new StoringData();
		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();  
//       
//		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  		  
//		   SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//		   Session session = factory.openSession();  
			
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(SimpleClass.class);
			cfg.configure("hibernate1.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			Transaction t = session.beginTransaction(); 
			
				sd.addObject(session);
				t.commit();
				System.out.println("successfully saved");
				sd.updateObject(session);
				//t.commit();   
				sd.deleteObject(session);
				//t.commit();
				sd.read(session);
		  // Integer id = (Integer) 

		   
		   factory.close();  
		   session.close();    
		   

	}

	private void read(Session session) {
		// TODO Auto-generated method stub
			System.out.println("Reading Records");
			SimpleClass s =(SimpleClass) session.get(SimpleClass.class, 4241);
			session.beginTransaction();
			session.getTransaction().commit();
			System.out.println(s);
		
		
	}

	private void deleteObject(Session session) {
		// TODO Auto-generated method stub
		
		System.out.println("Deleting records..");
		SimpleClass s = (SimpleClass) session.get(SimpleClass.class,441);
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
		System.out.println("Deleted Successfully");
		
		
	}
	
	

	private void updateObject(Session session) {
		// TODO Auto-generated method stub
		SimpleClass j =  (SimpleClass) session.get(SimpleClass.class,114);
		   j.setModel("Naya Travis");
		   j.setColor("Red");
		   session.beginTransaction();
		   session.saveOrUpdate(j);
		   session.getTransaction().commit();
		System.out.println("Updated successfully"); 
		
		
	}

	public  void addObject(Session session) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of car");
		String name = sc.nextLine();
		
			Random r = new Random();
			int	i = r.nextInt(1000);
			SimpleClass s = new SimpleClass();
			s.setModel(name);
			s.setId(i);
			s.setPrice("£40,000.00");
			s.setColor("dark blue");
			session.save(s);  
			
	
	
	}

}

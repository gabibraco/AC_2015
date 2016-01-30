package Programa;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilities {
	//Declaramos la session
	private static SessionFactory sessionFactory = buildSessionFactory();
	
		
	private static SessionFactory buildSessionFactory(){
		try{
			//Creamos un objeto standardServiceRegistry y configuramos con el xml hibernate creado y lo construimos y instanciamos
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			//Creamos un objeto metadata
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			//Y aqui lo que recuperamos 
			return metadata.getSessionFactoryBuilder().build();
		}catch(HibernateException e){
			System.out.println("Problema creando SessionFactory "+e);
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
package arquiteturawebAC1.AC1.Config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    
    
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
            Configuration configuration = new Configuration().configure();
           
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            
            return configuration.buildSessionFactory(registryBuilder.build());
        } catch (Exception ex) {
           
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Erro ao criar a SessionFactory: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        
        getSessionFactory().close();
    }

}

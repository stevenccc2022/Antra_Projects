package src;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
public class Emp_Proj_Demo {

//    private DataSource getDataSource() {
//        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
////        dataSource.setDatabaseName("OrmDemo");
//        dataSource.setUser("postgres");
//        dataSource.setPassword("password");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/university");
//        return dataSource;
//    }

//    private Properties getProperties() {
//        final Properties properties = new Properties();
//        properties.put( "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect" );
//        properties.put( "hibernate.connection.driver_class", "org.postgresql.Driver" );
////        properties.put("hibernate.show_sql", "true");
//        return properties;
//    }

//    private EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties ){
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan( "com/example/java20il2021/week4/day15/demo3");
//        em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
//        em.setJpaProperties( hibernateProperties );
//        em.setPersistenceUnitName( "demo-unit" );
//        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        em.afterPropertiesSet();
//        return em.getObject();
//    }


    //
    public static void main(String[] args) {
       // Emp_Proj_Demo jpaDemo = new Emp_Proj_Demo();
       // DataSource dataSource = jpaDemo.getDataSource();
       // Properties properties = jpaDemo.getProperties();
       // EntityManagerFactory entityManagerFactory = jpaDemo.entityManagerFactory(dataSource, properties);
       // EntityManager em = entityManagerFactory.createEntityManager();
       // PersistenceUnitUtil unitUtil = entityManagerFactory.getPersistenceUnitUtil();

        //Insert(em);
        //Remove(em);

    }

    /***
     * Update
     * @param
     */
    private static String Retrieve(){return "";}
    private static void Create(){}
    private static void Insert(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Employee e = em.find(Employee.class, "14");
        Project p = em.find(Project.class, "9");
        Register ts = new Register();
        ts.setEmp(e);
        ts.setProj(p);
        em.persist(ts);
        tx.commit();
    }
    /***
     * Remove
     * @param em
     */
    private static void Remove(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select emp from employee join fetch e.register ts where emp.id = 1012");
        query.setParameter(1, "14");
        Employee s = (Employee) query.getSingleResult();
        Iterator<Register> itr = s.get_Register().iterator();
        while(itr.hasNext()) {
            Register ts = itr.next();
            if(ts.getId().equals("9")) {
                itr.remove();
                em.remove(ts);
            }
        }
        tx.commit();
    }
}

package com.redolf.application.batch.frontend.service;

import com.redolf.application.batch.frontend.models.*;
import com.redolf.application.batch.frontend.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class DatasourceService {

    public static void save(Datasource_ datasource){
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(datasource);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int datasourceId){
        Transaction transaction;
        Datasource_ datasource = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            datasource = session.get(Datasource_.class,datasourceId);
            if (datasource != null){
                session.remove(datasource);
            }else {
                System.out.println("No resource found for datasource");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Datasource_ obj, int datasourceId){
        Transaction transaction;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Datasource_ datasource = null;
            datasource = session.get(Datasource_.class,datasourceId);
            transaction = session.beginTransaction();
            if (datasource != null){
                datasource.setUsername(obj.getUsername());
                datasource.setPassword(obj.getPassword());
                datasource.setCreated_at(LocalDate.now());
                datasource.setDriver_name(obj.getDriver_name());
                datasource.setHostname(obj.getHostname());
                datasource.setPort(obj.getPort());
                datasource.setUrl(obj.getUrl());
                datasource.setDatabase_name(obj.getDatabase_name());
                datasource.setSchema_name(obj.getSchema_name());
                session.update(datasource);
            }else {
                System.out.println("No resource found for datasource");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Datasource_ findById(int datasourceId){
        Transaction transaction;
        Datasource_ datasource = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            datasource = session.get(Datasource_.class,datasourceId);
            if (datasource != null){
                datasource = new Datasource_(datasource.getId(), datasource.getDatabase_name(), datasource.getHostname(),
                        datasource.getPort(), datasource.getDriver_name(), datasource.getUsername(), datasource.getPassword()
                , datasource.getSchema_name(), datasource.getUrl(), datasource.getCreated_at());
            }else {
                System.out.println("No resource found for datasource");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datasource;
    }

    public static List findByName (String datasourceName){
        Transaction transaction;
        List list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select database_name from tb_datasource where database_name =:datasourceName");
            query.setParameter("datasourceName", datasourceName);
            query.executeUpdate();
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List queryById(int id){
        Transaction transaction;
        List list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select id from tb_datasource where id =:id");
            query.setParameter("id", id);
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void saveWriteBatchJobParameters(Parameters parameters){
        Transaction transaction;
        try (Session session = ParameterService.getSessionFactoryForParameters().openSession()) {
            transaction = session.beginTransaction();
            session.save(parameters);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveWriteBatchJobSummary(Summary summary){
        Transaction transaction;
        try (Session session = ParameterService.getSessionFactoryForParameters().openSession()) {
            transaction = session.beginTransaction();
            session.save(summary);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveWriteBatchStatus(Status status){
        Transaction transaction;
        try (Session session = ParameterService.getSessionFactoryForParameters().openSession()) {
            transaction = session.beginTransaction();
            session.save(status);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveWriteBatchTypes(Types types){
        Transaction transaction;
        try (Session session = ParameterService.getSessionFactoryForParameters().openSession()) {
            transaction = session.beginTransaction();
            session.save(types);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveWriteBatchCategory(BatchCategory category){
        Transaction transaction;
        try (Session session = ParameterService.getSessionFactoryForParameters().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

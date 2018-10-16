package ua.andrZav.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.andrZav.common.utils.hibernate.HibernateUtil;
import ua.andrZav.dao.FilesDao;
import ua.andrZav.domain.entity.Files;
import ua.andrZav.domain.entity.Statistics;
import ua.andrZav.domain.models.StatisticFilter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("filesDao")
public class FilesDaoImpl implements FilesDao {
  @Override
  public void deleteFile(Files file) throws SQLException {
    Session session = null;
    try{
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(file);
      session.getTransaction().commit();
    } catch (Exception ex){
      ex.printStackTrace();
    } finally {
      if ((session != null) && (session.isOpen())) {
        session.close();
      }
    }
  }

  @Override
  public Files getFile(String fileName) throws SQLException {
    Session session = null;
    Files file = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

      String hql = "FROM Files WHERE fileName=:fileName";
      Query query = session.createQuery(hql);
      query.setParameter("fileName", fileName);
      file = (Files)query.list().get(0);
    } catch (Exception ex){
      ex.printStackTrace();
    } finally {
      if ((session != null) && (session.isOpen())) {
        session.close();
      }
    }
    return file;
  }

  @Override
  public List<Files> getFiles() throws SQLException {
    List<Files> files = null;
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      String hql = "from Files order by dateTime asc";
      Query query = session.createQuery(hql);
      files = query.list();
      // files = session.createCriteria(Files.class).list();
      session.getTransaction().commit();
    } catch (Exception ex){
        ex.printStackTrace();
    } finally {
      if ((session != null) && (session.isOpen())) {
        session.close();
      }
    }
    return files;
  }

  @Override
  public List<Statistics> getStatistics(StatisticFilter filter) throws SQLException {
    if (filter == null || "".equals(filter.getFileName())) {
      return new ArrayList<>();
    }

    List<Statistics> statistics = null;
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

      String hql = "FROM Files WHERE fileName=:fileName";
      Query query = session.createQuery(hql);
      query.setParameter("fileName", filter.getFileName());
      Files file = (Files)query.list().get(0);

      int len = filter.getLineWidth();
      hql = "FROM Statistics WHERE LineLength>:lLength AND file.id=:idf";
      query = session.createQuery(hql);
      query.setParameter("lLength", len);
      query.setParameter("idf", file.getId());
      statistics = (List<Statistics>)query.list();
    } catch (Exception ex){
        ex.printStackTrace();
    } finally {
      if ((session != null) && (session.isOpen())) {
        session.close();
      }
    }
    return statistics;
  }
}

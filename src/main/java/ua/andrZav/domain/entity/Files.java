package ua.andrZav.domain.entity;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(appliesTo = "files")
public class Files implements Serializable {
  private static final long serialVersionUID = 1L;

  public Files() {
    statistics = new HashSet<>();
  }

  private int id;

  private Timestamp dateTime;

  private String fileName;

  private Set<Statistics> statistics;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Timestamp getDateTime() {
    return dateTime;
  }

  public void setDateTime(Timestamp dateTime) {
    this.dateTime = dateTime;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Set<Statistics> getStatistics() {
    return statistics;
  }

  public void setStatistics(Set<Statistics> statistics) {
    this.statistics = statistics;
  }
}

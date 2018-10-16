package ua.andrZav.domain.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(appliesTo = "statistics")
public class Statistics implements Serializable {
  private static final long serialVersionUID = 1L;

  public Statistics() {}

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @Column(name = "longest_word")
  private String longestWord;

  @Column(name = "shortest_word")
  private String shortestWord;

  @Column(name = "line_length")
  private int lineLength;

  @Column(name = "aver_words_length")
  private int averWordsLength;

  private Files file;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLongestWord() {
    return longestWord;
  }

  public void setLongestWord(String longestWord) {
    this.longestWord = longestWord;
  }

  public String getShortestWord() {
    return shortestWord;
  }

  public void setShortestWord(String shortestWord) {
    this.shortestWord = shortestWord;
  }

  public int getLineLength() {
    return lineLength;
  }

  public void setLineLength(int lineLength) {
    this.lineLength = lineLength;
  }

  public int getAverWordsLength() {
    return averWordsLength;
  }

  public void setAverWordsLength(int averWordsLength) {
    this.averWordsLength = averWordsLength;
  }

  public Files getFile() {
    return file;
  }

  public void setFile(Files file) {
    this.file = file;
  }
}

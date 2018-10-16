package ua.andrZav.domain.models;

public class StatisticFilter {
  private String dateTimeStart;
  private String dateTimeEnd;
  private String fileName;
  private int lineWidth;

  public String getDateTimeStart() {
    return dateTimeStart;
  }

  public void setDateTimeStart(String dateTimeStart) {
    this.dateTimeStart = dateTimeStart;
  }

  public String getDateTimeEnd() {
    return dateTimeEnd;
  }

  public void setDateTimeEnd(String dateTimeEnd) {
    this.dateTimeEnd = dateTimeEnd;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public int getLineWidth() {
    return lineWidth;
  }

  public void setLineWidth(int lineWidth) {
    this.lineWidth = lineWidth;
  }
}

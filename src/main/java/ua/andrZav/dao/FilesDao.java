package ua.andrZav.dao;

import ua.andrZav.domain.entity.Files;
import ua.andrZav.domain.entity.Statistics;
import ua.andrZav.domain.models.StatisticFilter;

import java.sql.SQLException;
import java.util.List;

public interface FilesDao {
  void deleteFile(Files file) throws SQLException;
  Files getFile(String fileName) throws SQLException;
  List<Files> getFiles() throws SQLException;
  List<Statistics> getStatistics(StatisticFilter filter) throws SQLException;
}




















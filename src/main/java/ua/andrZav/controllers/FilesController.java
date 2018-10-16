package ua.andrZav.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.andrZav.dao.FilesDao;
import ua.andrZav.domain.entity.Files;
import ua.andrZav.domain.entity.Statistics;
import ua.andrZav.domain.models.FilesResponse;
import ua.andrZav.domain.models.StatisticFilter;
import ua.andrZav.domain.models.StatisticResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/files")
public class FilesController {

  @Autowired
  private FilesDao filesDao;

  @RequestMapping(value = "/getFiles", method = RequestMethod.GET)
  @ResponseBody
  List<FilesResponse> getFiles() throws SQLException {
    return createFilesResponse();
  }

  @RequestMapping(value = "/getStatistic", method = RequestMethod.POST)
  @ResponseBody
  List<StatisticResponse> getStatistics(@RequestBody StatisticFilter filter) throws SQLException {
    List<Statistics> statisticsList = filesDao.getStatistics(filter);
    List<StatisticResponse> response = new LinkedList<>();
    for (Statistics statistics : statisticsList) {
      StatisticResponse statisticResponse = new StatisticResponse();

      statisticResponse.setLongestWord(statistics.getLongestWord());
      statisticResponse.setShortestWord(statistics.getShortestWord());
      statisticResponse.setLineLength(statistics.getLineLength());
      statisticResponse.setAverWordsLength(statistics.getAverWordsLength());
      response.add(statisticResponse);
    }
    return response;
  }

  @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
  @ResponseBody
  List<FilesResponse> deleteFile(@RequestBody StatisticFilter filter) throws SQLException {
    try {
      Files file = filesDao.getFile(filter.getFileName());
      filesDao.deleteFile(file);
    } catch (Exception ex) {
      return new ArrayList<>();
    }
    return createFilesResponse();
  }
  private List<FilesResponse> createFilesResponse() throws SQLException {
    List<Files> files = filesDao.getFiles();
    List<FilesResponse> filesResponses = new LinkedList<>();
    for (Files file : files) {
      FilesResponse filesResponse = new FilesResponse();
      filesResponse.setDateTime(file.getDateTime().toString());
      filesResponse.setFileName(file.getFileName());
      filesResponses.add(filesResponse);
    }
    return filesResponses;
  }

}

package ua.andrZav.domain.models;

public class StatisticResponse {
    private String longestWord;
    private String shortestWord;
    private int lineLength;
    private int averWordsLength;

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
}

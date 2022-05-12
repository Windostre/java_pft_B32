package ru.stqa.pft.addressbook;

public class CalendarData {
  private final String month;
  private final String day;
  private final String year;

  public CalendarData(String month, String day, String year) {
    this.month = month;
    this.day = day;
    this.year = year;
  }

  public String getMonth() {
    return month;
  }

  public String getDay() {
    return day;
  }

  public String getYear() {
    return year;
  }
}

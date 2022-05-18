package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String company;
  private final String address;
  private final String mobile;
  private final String email;
  private final int day;
  private final int month;
  private final String year;

  public ContactData(String firstName, String lastName, String company, String address, String mobile, String email, int day, int month, String year) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }
}

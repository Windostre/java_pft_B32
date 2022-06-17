package ru.stqa.pft.addressbook.model;

public class ContactData {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String firstName;
  private final String lastName;
  private final String company;
  private final String address;
  private final String mobile;
  private final String email;
  private final int day;
  private final int month;
  private final String year;
  private String group;

  public ContactData(int id, String firstName, String lastName, String company, String address
          , String mobile, String email, int day, int month, String year, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.day = day;
    this.month = month;
    this.year = year;
    this.group = group;
  }


  public ContactData(String firstName, String lastName, String company, String address
          , String mobile, String email, int day, int month, String year, String group) {
    this.id = 0;
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.day = day;
    this.month = month;
    this.year = year;
    this.group = group;
  }
  public int getId() {
    return id;
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

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

}

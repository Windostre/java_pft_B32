package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends  HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillCalendarData(ContactData contactData) {
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByIndex(contactData.getDay());
    // wd.findElement(By.xpath("//option[3]")).click();
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByIndex(contactData.getMonth());
    // wd.findElement(By.xpath("//select[2]/option[2]")).click();
    type(By.name("byear"), contactData.getYear());
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }
}

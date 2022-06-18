package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void GroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Group")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }
    /* Вариант 2
    if (! isElementPresent(By.tagName("h1"))
            || ! wd.findElement(By.tagName("h1")).getText().equals("Group")
            || ! isElementPresent(By.name("new"))) {
      click(By.linkText("groups"));
    }*/


 /*   Вариант 1
      if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Group")
            && isElementPresent(By.name("new"))) {
       } else {
        click(By.linkText("groups"));
       }
  }*/

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

}

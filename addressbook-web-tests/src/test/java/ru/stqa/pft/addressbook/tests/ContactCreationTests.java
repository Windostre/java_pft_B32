package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("NewFirstName", "NewLastName", "New Company"
            , "г. Город, Локомотивная, 7", "+1604210793", "test@mail.com", 0, 0, null));
    //app.getContactHelper().fillCalendarData(new ContactData(null, null, null, null
     //       , null, null, 2, 2, "1999"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    /*  Проверка наличия группы для создания контакта, если нет - создать */
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    /* Тест */
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("NewFirstName", "NewLastName", "New Company"
            , "г. Город, Локомотивная, 7", "+1604210793", "test@mail.com"
            , 2, 2, "1999", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}

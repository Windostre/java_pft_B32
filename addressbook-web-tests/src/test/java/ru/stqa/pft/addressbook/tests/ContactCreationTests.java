package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    /*  Проверка наличия группы для создания контакта, если нет - создать */
    app.goTo().GroupPage();
    if (!app.group().isThereAGroup()) {
      app.group().create(new GroupData().withName("test1"));
    }
    /* Тест */
    app.goTo().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData("NewFirstName", "NewLastName", null
            , null, "+1604210793", "test@mail.com"
            , 2, 2, null, null);
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitContactCreation();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1 );

  // Поиск макс ID при помощи цикла
/*    int maxId = 0;
    for (ContactData c : after) {
      if (c.getId() > maxId) {
        maxId = c.getId();
      }
    }*/

    before.add(contact);
    Comparator<? super ContactData> byId = (contact1, contact2) -> Integer.compare(contact1.getId(), contact2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}

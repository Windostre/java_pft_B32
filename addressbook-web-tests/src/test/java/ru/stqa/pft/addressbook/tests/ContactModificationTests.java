package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    /* Предусловие: проверка наличия контакта, если нет - создать*/
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("NewFirstName", "NewLastName", null
              , null, null, null
              , 2, 2, "1999", null));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Edited", "Edited", null
            , null, null, null, 2, 2, null, null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();

  }
}

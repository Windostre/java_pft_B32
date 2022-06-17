package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    /* Предусловие: проверка наличия контакта, если нет - создать*/
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("NewFirstName", "NewLastName", null
              , null, null, null
              , 2, 2, "1999", null));
    }
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().submitContactDeletion();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);

  }
}

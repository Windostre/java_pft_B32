package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // количество групп до
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    List<GroupData> after = app.getGroupHelper().getGroupList(); // количество групп после
    Assert.assertEquals(after.size(), before.size() + 1);
    app.logout(); // в лекции логаута нет
  }

}

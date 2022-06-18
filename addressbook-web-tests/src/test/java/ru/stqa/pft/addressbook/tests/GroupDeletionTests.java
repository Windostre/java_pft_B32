package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    /* Предусловие: проверка наличия группы */
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.getGroupHelper().getGroupList(); // список групп до
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // список групп после
    Assert.assertEquals(after.size(), before.size() - 1); // проверка размеров списка

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after); // проверка элементов списка цикл встроен в testng
  }

}

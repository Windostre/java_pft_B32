package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    /* Предусловие: проверка наличия группы */
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    /* Тест */
    List<GroupData> before = app.getGroupHelper().getGroupList(); // список групп до
    app.getGroupHelper().selectGroup(before.size() - 1); // выбран последний эллемент
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(),"test1", "edited2", "edited3");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // список групп после
    Assert.assertEquals(after.size(), before.size()); // проверка размеров списка

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // проверка элементов списка - списки преобразованы в множества

    app.logout();
  }

}

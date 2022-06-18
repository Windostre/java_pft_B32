package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    /* Предусловие: проверка наличия группы */
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void testGroupModification() {
    /* Тестовые данные */
    List<GroupData> before = app.getGroupHelper().getGroupList(); // список групп до
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "edited1", "edited2", "edited3");
    /* Тест */
    app.getGroupHelper().modifyGroup(index, group);
    /* Проверка количества групп*/
    List<GroupData> after = app.getGroupHelper().getGroupList(); // список групп после
    Assert.assertEquals(after.size(), before.size()); // проверка размеров списка
    /* Проверка содержания групп */
    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    // Метод сортировка до лямбда выражения и сравнениея Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // проверка элементов списка - списки преобразованы в множества

  }


}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // количество групп до
    GroupData group = new GroupData("test2", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList(); // количество групп после
    Assert.assertEquals(after.size(), before.size() + 1);
    // Вычисляем макс id
    /* способ сравнения при помощи цикла
    int maxId = 0; // допущение, что id новой группы должен быть максимальным
    for (GroupData g : after) {
      if (g.getId() > maxId) {
        maxId = g.getId();
      }
    }*/

    /*Сравнение при помощи компаратора для версий раньше 6
    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
      @Override
      public int compare(GroupData o1, GroupData o2) {
        return Integer.compare(o1.getId(), o2.getId());
      }
    };

    int maxId = after.stream().max(byId).get().getId();
    group.setId(maxId);
    */

    /*Сравнение через анонимную функциию*/
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group); // присваиваем новый Id для группы
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after); // проверка элементов списка - списки преобразованы в множества
  }

}

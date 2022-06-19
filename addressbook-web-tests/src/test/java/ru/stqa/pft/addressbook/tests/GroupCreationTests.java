package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    /* Тестовые данные */
    List<GroupData> before = app.group().list(); // количество групп до
    GroupData group = new GroupData().withName("test2");
    /* Тест */
    app.group().create(group);
    /* Проверка количества групп*/
    List<GroupData> after = app.group().list(); // количество групп после
    Assert.assertEquals(after.size(), before.size() + 1);

    /* Проверка содержания списка групп */
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

    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); // Сравнение через анонимную функциию
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}

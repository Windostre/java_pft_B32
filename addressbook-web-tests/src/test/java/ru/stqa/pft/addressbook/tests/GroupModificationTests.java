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
    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    /* Тестовые данные */
    Set<GroupData> before = app.group().all(); // множестов групп до
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("edited1").withHeader("edited2").withFooter("edited3");
    /* Тест */
    app.group().modify(group);
    /* Проверка количества групп*/
    Set<GroupData> after = app.group().all(); // множетсов групп после
    Assert.assertEquals(after.size(), before.size()); // проверка размеров списка
    /* Проверка содержания списка групп */
    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
    // Метод сортировка до лямбда выражения и сравнениея Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // проверка элементов списка - списки преобразованы в множества

  }


}

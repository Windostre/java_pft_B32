package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    /* Предусловие: проверка наличия группы */
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    /* Тестовые данные */
    List<GroupData> before = app.group().list(); // список групп до
    int index = before.size() - 1;
    /* Тест */
    app.group().delete(index);
    /* Проверка количества групп*/
    List<GroupData> after = app.group().list(); // список групп после
    Assert.assertEquals(after.size(), before.size() - 1); // проверка размеров списка
    /* Проверка содержания списка групп */
    before.remove(index);
    Assert.assertEquals(before, after); // проверка элементов списка цикл встроен в testng
  }



}

package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    /* Предусловие: проверка наличия группы */
    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    /* Тестовые данные */
    Groups before = app.group().all(); // список групп до
    GroupData deletedGroup = before.iterator().next();// в  before.remove(index) не может принимать индекс, так как у нас неопределн порядок. Вводим нов объект -> сначала итератор, потом множ-во;
    /* Тест */
    app.group().delete(deletedGroup);
    /* Проверка количества групп*/
    Groups after = app.group().all(); // список групп после
    assertEquals(after.size(), before.size() - 1); // проверка размеров списка
    /* Проверка содержания списка групп */
    //before.remove(deletedGroup);
    assertThat(after, equalTo(before.without(deletedGroup)));
    //Assert.assertEquals(before, after); // проверка элементов списка цикл встроен в testng
  }



}

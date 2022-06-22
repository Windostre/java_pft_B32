package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    /* Тестовые данные */
    Set<GroupData> before = app.group().all(); // количество групп до
    GroupData group = new GroupData().withName("test2");
    /* Тест */
    app.group().create(group);
    /* Проверка количества групп*/
    Set<GroupData> after = app.group().all(); // количество групп после
    assertThat(after.size(), equalTo(before.size() + 1));

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

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); //из коллекции after,  где есть группы с id
    // , превращаем в поток, затем этот поток превращаем в поток иденитификаторов, в качестве параметров ипм-ем анонимную функцию
    // , которая на вход получает GroupData - группу и првращает ее в целые числа
    before.add(group);
   /* // Так как заменили List на all - работает с множеством, то отпадает необходимость в сортировке множетва
   Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);*/
    //Assert.assertEquals(before, after);
    assertThat(after, equalTo(before));
  }

}

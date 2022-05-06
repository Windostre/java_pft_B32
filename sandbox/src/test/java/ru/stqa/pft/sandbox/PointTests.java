package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testsPointZeroPointsShowsZero() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,0);

    Assert.assertEquals(p1.distance(p2), 0);
  }
  @Test
  public void testsPointShowsCorrectDistance() {
    Point p1 = new Point(0,4);
    Point p2 = new Point(4,1);

    Assert.assertEquals(p1.distance(p2), 5);
  }
  @Test
  public void testPointShowsError(){
    Point p1 = new Point(1,2);
    Point p2 = new Point(3, 4);

    Assert.assertEquals(p1.distance(p2), 2.82842712474619, "Ошибка из-за количества знаков после запятой");
  }
  @Test
  public void testsPointShowsCorrectDistanceDelta(){
    Point p1 = new Point(1,2);
    Point p2 = new Point(3, 4);

    Assert.assertEquals(p1.distance(p2), 2.82842712474619, 0.009);

  }
}

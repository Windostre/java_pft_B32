package ru.stqa.pft.sandbox;

public class MyHomeWork {

  public static void main(String[] args) {

    Point p1 = new Point(0, 4);
    Point p2 = new Point(4, 1);

    /* Объявление переменной до создание конструктора
    p1.x = 0;
    p1.y = 4;
    p2.x = 4;
    p2.y = 1;
*/
    System.out.println("Растояние между точками " + "p1 (" + p1.x + "," + p1.y + ")" + " и " + "p2 (" + p2.x + "," + p2.y + ")" + " = " + p1.distance(p2));
  }

/* Изначальная функция
public static double distance(Point p1, Point p2) {
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
  }
 */
}

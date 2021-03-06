package ru.stqa.pft.sandbox;

public class Equation {

  private double a;
  private double b;
  private double c;

  private int n;

  public Equation(double a, double b, double c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;

    if (a != 0) {
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }

    } else if (b != 0) {
      n = 1;
    } else if (c != 0) {
      n = 0;
    } else {
      n = -1;
    }

  }

  /* №1 Вложенная форма
  if (d > 0) {
     n = 2;
   } else {
     if (d == 0) {
       n = 1;
     } else {
       n = 0;
     }
   }*/

  /*  № 2 Свернутая форма
   if (d > 0) {
    n = 2;
  } else if (d == 0) {
    n = 1;
  } else {
    n = 0;
  }*/

  /*  №3    if (a == 0) {
    System.out.println("Это вырожденное уроавнение");
  }

    if (d > 0) {
    n = 2;
  }
    if (d == 0) {
    n = 1;
  }
    if (d < 0) {
    n = 0;
  }
}*/

  /*  №4    if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        n = -1;
      } else {
        n = 0;
      }
    } else {
      n = 1;
    }

  } else {
    if (d > 0) {
      n = 2;
    } else if (d == 0) {
      n = 1;
    } else {
      n = 0;
    }

  }*/

  public int rootNumber() {
    return n;
  }
}

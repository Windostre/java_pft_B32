package ru.stqa.pft.sandbox;

public class Equality {
  public static void main(String[] args) {
    String s1 = "firefox";
   // String s2 = new String(s1); // выдаст fasle так как физически ссылка на другой объект. две разные ссылки
    //String s2 = s1;
    //String s2 = "firefox"; // выдаст тру. игры компилятора
    String s2 = "fire" + "fox"; // выдаст тру. игры компилятора

    System.out.println(s1 == s2); // сравнение ссылки
    System.out.println(s1.equals(s2)); // сравнение содерижмого
  }
}

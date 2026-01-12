class Demo implements Cloneable {
  int x = 10;
  int y = 20;
  Temp t = new Temp();

  public Demo clone() throws CloneNotSupportedException {
    Demo z = (Demo) super.clone();
    return z;
  }

  public static void main(String... s) {
    try {
      Demo d = new Demo();
      System.out.println(d.x);
      System.out.println(d.y);
      System.out.println(d.t.z);

      Demo c = d.clone();
      System.out.println(c.x);
      System.out.println(c.y);
      System.out.println(c.t.z);

      if (d.t == c.t) {
        System.out.println("same");
      }
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}

class Temp implements Cloneable {
  int z = 30;
}
class Dadaji {
    int x = 80;
}

class Base extends Dadaji{
    int x = 50;
}

class Child extends Base{
    int x=20;
    void show(){
        System.out.println(x);
        System.out.println(super.x);
        System.out.println(((Dadaji)this).x);
        System.out.println(((Base)this).x);
    }
    
    public static void main (String[] args) {
        Child c1 = new Child();
        c1.show();
        System.out.println(((Dadaji)c1).x);
    }
}
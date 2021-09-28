class Parent{
    int print(){
        System.out.println("In Parent");
        return 0;
    }
}
class Child extends Parent{
    public int print(int x){
        System.out.println("In child");
        return 1;
    }
    public static void main(String[] args){
        Parent ob=new Child();
        Child s=new Child();
        System.out.println(ob.print()+","+s.print());
    }
}
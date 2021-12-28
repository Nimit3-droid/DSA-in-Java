package OOPS;
class Parent{
    public int print(){
        System.out.println("In Parent");
        return 0;
    }
}
class Child extends Parent{
    public int  print(){
        System.out.println("In child");
        return 1;
    }
    public int  pprint(){
        System.out.println("In child");
        return 1;
    }
    public static void main(String[] args){
        Parent ob=new Parent();
        Child s=new Child();
        System.out.println(ob.print()+","+s.print());


        Parent parent = new Child();
        Child child = new Child();
        System.out.println(parent.print()+","+child.print());

        Parent[] employees = new Parent[] { parent, child };
        for (Parent employee : employees) {
            employee.print();
        }
    }
}
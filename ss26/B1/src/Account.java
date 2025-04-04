public class Account{
    private static Account instance;
    private int id;
    private String name;
    private int age;

    public Account(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Account getInstance(int id, String name, int age){
        if(instance == null){
            instance = new Account(id, name, age);
        }
        return instance;
    }

   public void display(){
        System.out.println(id + " " + name + " " + age);
   }
}

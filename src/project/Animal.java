package project;

public class Animal implements prey{
    @Override
    public void flee() {
        System.out.println("call from flee");
    }
    void show()
    {
        System.out.println(getGender());
        System.out.println(getAge());
        System.out.println(getName());
    }
    void speak()
    {
        System.out.println("aoaoaoaoaoao");
    }

    public  Animal()
    {
        this.name="23";
        this.age=22;
        this.gender="dad11";
    }
    public Animal(String Name,int Age,String Gender)
    {
         this.name=Name;
        this.age=Age;
        this.gender=Gender;
    }

    public Animal copy(Animal a)
    {
        this.age=a.age;
        this.gender=a.gender;
        this.name=a.name;
        return this;
    }

    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

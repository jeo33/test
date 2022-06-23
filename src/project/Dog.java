package project;

public class Dog extends Animal
{
    String neutering;
    Dog(String Name,int Age,String Gender,String Neu)
    {
        super(Name, Age, Gender);
        this.neutering = Neu;
    }
    void show()
    {
        System.out.println(getGender());
        System.out.println(getAge());
        System.out.println(getName());
        System.out.println(neutering);
    }

    public static interface prey {
    }
}

package project;

public class Jingba extends Dog{

    String bark="";
    Jingba(String Name,int Age,String Gender,String Neu,String bark)
    {
        super(Name, Age, Gender,Neu);
        this.bark=bark;
    }
    void show()
    {
        System.out.println(getGender());
        System.out.println(getAge());
        System.out.println(getName());
        System.out.println(neutering);
        System.out.println(bark);
    }

}

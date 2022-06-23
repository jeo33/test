package project2;

import project.Animal;

public class cat extends Animal {
    String neutering;
    cat(String Name,int Age,String Gender,String Neu)
    {
        super(Name, Age, Gender);
        this.neutering = Neu;
    }
}

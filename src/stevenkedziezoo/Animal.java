/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenkedziezoo;
import java.util.*;
/**
 *
 * @author Steven Kedzie
 */
public abstract class Animal
{
    protected String name;        // name of animal
    protected int age;            // age of animal in years
    protected Date birthDate;     // date the animal was born
    protected int lifeExpectancy; // number of years animal expected to live
    protected String species;     // species of the animal
    
    // constructor
    public Animal(String name, int age, Date birthDate, String species,
            int lifeExpectancy)
    {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.species = species;
        this.lifeExpectancy = lifeExpectancy;
    }
    
    // empty constructor
    public Animal(String xmlString)
    {
        
    }
    
    public void updateAnimal(String name, int age, Date birthDate,
            String spieces, int lifeExpectancy)
    {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.species = spieces;
        this.lifeExpectancy = lifeExpectancy;
    }
    
    abstract public double determineLifeExpectancy();
    
    @Override // overrides the Java built-in toString() method
    abstract public String toString();
}
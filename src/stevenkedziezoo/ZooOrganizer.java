/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenkedziezoo;
import java.util.*;
import java.io.*;
/**
 *
 * @author Steven Kedzie
 */
public class ZooOrganizer
{
    private Vector<Animal> animalsInZoo;
    private static double billingAmount;
    private static int lifeCount;
    
    public ZooOrganizer()
    {
         // create a Vector object to hold animals
        animalsInZoo = new Vector<Animal>();
    }
    
    public ZooOrganizer(String fileName)
    {
        try
        {
            animalsInZoo = new Vector<Animal>();
            
            FileInputStream fis = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            
            while ((line = br.readLine()) != null)
            {
                if (line.substring(0, 6).equals("<bird>"))
                {
                    Bird bird = new Bird(line);
                    
                    animalsInZoo.add(bird);
                }
                else if (line.substring(0, 8).equals("<mammal>"))
                {
                    Mammal mammal = new Mammal(line);
                    
                    animalsInZoo.add(mammal);
                }
                else if (line.substring(0, 9).equals("<reptile>"))
                {
                    Reptile reptile = new Reptile(line);
                    
                    animalsInZoo.add(reptile);
                }
            }
            
            br.close();            
        }
        catch (Exception e)
        {
            System.out.println("Zoo Constructor Error " + e.getMessage());
        }
    }
    
    public int addAnimal(String name, int age, Date birthDate, String species,
            int lifeExpectancy)
    {
        int speciesNum = 0;
        
        if (species.equals("eagle") || species.equals("hawk"))
            speciesNum = 1;
        
        if (species.equals("goat") || species.equals("lion") || species.equals("pig"))
            speciesNum = 2;
        
        if (species.equals("turtle") || species.equals("iguana"))
            speciesNum = 3;
        
        // call the appropriate constructor based from species attribute
        switch (speciesNum)
        {
            case 1:
                Bird bird = new Bird(name, age, birthDate, species, lifeExpectancy);
                // put Bird object on list
                animalsInZoo.add(bird);
                // return index number of Bird object
                return animalsInZoo.size();
            case 2:
                Mammal mammal = new Mammal(name, age, birthDate, species, lifeExpectancy);
                // put Mammal object on list
                animalsInZoo.add(mammal);
                // return index number of Mammal object
                return animalsInZoo.size();
            case 3:
                Reptile reptile = new Reptile(name, age, birthDate, species, lifeExpectancy);
                // put Reptile object on list
                animalsInZoo.add(reptile);
                // return index number of Reptile object
                return animalsInZoo.size();
            default:
                return 0;
        }
    }
    
    public void updateAnimal(int id, String name, int age, Date birthDate, String species,
            int lifeExpectancy)
    {
        //get Animal object at position id
        Animal animal = (Animal)animalsInZoo.elementAt(id);
        // load method parameters to object attributes
        animal.updateAnimal(name, age, birthDate, species, lifeExpectancy);
    }
    
    public void deleteAnimal(int id)
    {
        // remove the Animal from the animalsInZoo Vector object indexed at id
        animalsInZoo.removeElementAt(id);
    }
    
    public String getAnimalByID(int animalNum)
    {
        if (animalNum >= animalsInZoo.size())
            return null;
        else
        {
            // find the animal at position animalNumber in the animal list
            Animal animal = (Animal)animalsInZoo.elementAt(animalNum);
                
            // return Animal object
            return animal.toString();
        }
    }
    
    public void saveZooToFile(String fileName)
    {
        // create a file with fileName argument
        try
        {
            PrintWriter zooFile = new PrintWriter(fileName);
            // get each animal on the animalsInZoo list
            for (int i = 0; i < animalsInZoo.size(); i++)
            {
                // for each animal, write out data using toString()
                Animal animal = (Animal) animalsInZoo.elementAt(i);
                zooFile.println(animal.toString());
            }
            
            // close file
            zooFile.close();
        }
        catch (Exception e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    // accessor methods
    public static void setBillingAmount(double cost)
    {
        billingAmount = cost;
    }
    
    public double getBillingAmount()
    {
        return billingAmount;
    }
    
    public static void setLifeCount(int counter)
    {
        lifeCount = counter;
    }
    
    public int getLifeCount()
    {
        return lifeCount;
    }
}
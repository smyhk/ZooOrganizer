/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenkedziezoo;
import java.text.SimpleDateFormat;
//import java.util.Date;
/**
 *
 * @author Steven Kedzie
 */
public class StevenKedzieZOO
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();    // AOP
    }
    
    public static void testCase1()
    {
        try
        {
            ZooOrganizer myZoo = new ZooOrganizer();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
            
            myZoo.addAnimal("Mufasa", 7, formatter.parse("01/04/2008"), "lion", 0);
            
            myZoo.addAnimal("Glory", 3, formatter.parse("10/10/2013"), "eagle", 5);
            
            myZoo.addAnimal("Leonardo", 30, formatter.parse("05/15/1983"), "turtle", 0);
            
            System.out.println("Test Case 1");
            for (int i = 0; i < 3; i++)
                System.out.println(myZoo.getAnimalByID(i));
        }
        catch (Exception e)
        {
            System.out.println("Test Case 1 Error" + e.getMessage());
        }
        System.out.println();
    }
    
    public static void testCase2()
    {
        try
        {
            ZooOrganizer myZoo = new ZooOrganizer();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

            myZoo.addAnimal("Manny", 2, formatter.parse("01/01/2013"), "pig", 0);

            myZoo.addAnimal("Moe", 4, formatter.parse("12/12/2010"), "iguana", 0);
            
            myZoo.addAnimal("Jack", 1, formatter.parse("03/22/2014"), "hawk", 5);
            
            myZoo.addAnimal("Billy", 4, formatter.parse("01/01/2011"), "goat", 0);
            
            System.out.println("Test Case 2");
            int i = 0;
            String animal;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                    System.out.println(animal);
                i++;
            } while (animal != null);
        }
        catch (Exception e)
        {
            System.out.println("Test Case 2 Error " + e.getMessage());
        }
        System.out.println();
    }
    
    public static void testCase3()
    {
        try
        {
            ZooOrganizer myZoo = new ZooOrganizer();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

            myZoo.addAnimal("Manny", 2, formatter.parse("01/01/2013"), "pig", 0);

            myZoo.addAnimal("Moe", 4, formatter.parse("12/12/2010"), "iguana", 0);
            
            myZoo.addAnimal("Jack", 1, formatter.parse("03/22/2014"), "hawk", 5);
            
            myZoo.addAnimal("Billy", 4, formatter.parse("01/01/2011"), "goat", 0);
            
            myZoo.saveZooToFile("myzoo.txt");
            
            System.out.println("Test Case 3");
            int i = 0;
            String animal;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                    System.out.println(animal);
                i++;
            } while (animal != null);
        }
        catch (Exception e)
        {
            System.out.println("Test Case 3 Error " + e.getMessage());
        }
        System.out.println();
    }
    
    public static void testCase4()
    {
        try
        {
            ZooOrganizer myZoo = new ZooOrganizer("myzoo.txt");

            System.out.println("Test Case 4");
            int i = 0;
            String animal;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                {
                    System.out.println(animal);
                }
                i++;
            } while (animal != null);
        }
        catch (Exception e)
        {
            System.out.println("Test Case 4 Error " + e.getMessage());
        }
        System.out.println();
    }
    
    public static void testCase5()
    {
        try
        {
            ZooOrganizer myZoo = new ZooOrganizer("myzoo.txt");

            System.out.println("Test Case 5");
            int i = 0;
            String animal;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                {
                    System.out.println(animal);
                }
                i++;
            } while (animal != null);
            
            // delete some animals
            myZoo.deleteAnimal(3);
            myZoo.deleteAnimal(1);
            
            // display list after deletes
            System.out.println();
            i = 0;
            animal = null;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                {
                    System.out.println(animal);
                }
                i++;
            } while (animal != null);
        }
        catch (Exception e)
        {
            System.out.println("Test Case 5 Error " + e.getMessage());
        }
        System.out.println();
    }
    
    public static void testCase6()
    {
        try
        {
            ZooOrganizer myZoo = new ZooOrganizer();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

            myZoo.addAnimal("Reorx", 2, formatter.parse("01/01/2013"), "turtle", 0);

            myZoo.addAnimal("Bartles", 4, formatter.parse("12/12/2010"), "iguana", 0);
            
            myZoo.addAnimal("James", 1, formatter.parse("03/22/2014"), "hawk", 5);
            
            myZoo.addAnimal("Dr. Doom", 4, formatter.parse("07/04/2011"), "eagle", 5);
            
            myZoo.addAnimal("Cherry 2000", 5, formatter.parse("04/01/2010"), "goat", 0);
            
            myZoo.addAnimal("Chuck Norris", 9, formatter.parse("7/13/2006"), "lion", 0);
            
            myZoo.addAnimal("Olde Tusken", 13, formatter.parse("11/01/2002"), "goat", 0);
            
            System.out.println("Test Case 6");
            int i = 0;
            String animal;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                    System.out.println(animal);
                i++;
            } while (animal != null);
            
            // update some animals
            myZoo.updateAnimal(4, "Name Updated", 5, formatter.parse("04/01/2010"), "Species Updated", 0);
            myZoo.updateAnimal(2, "James", 45, formatter.parse("01/01/1970"), "hawk", 1000);
            
            System.out.println("\nUpdated Animal List");
            i = 0;
            animal = null;
            do
            {
                animal = myZoo.getAnimalByID(i);
                if (animal != null)
                    System.out.println(animal);
                i++;
            } while (animal != null);
            
            // save updated list to file
            myZoo.saveZooToFile("updatedZoo.txt");
        }
        catch (Exception e)
        {
            System.out.println("Test Case 6 Error " + e.getMessage());
        }
        System.out.println();
    }
    
    public static void testCase7()
    {
        System.out.println("Test Case 7");
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        try
        {
            Mammal myMammal = new Mammal("Chuck Norris", 9, formatter.parse("7/13/2006"), "lion", 0);
            System.out.println("Life Expectancy = " + myMammal.determineLifeExpectancy());
            
            Bird myBird = new Bird("Bartles", 3, formatter.parse("12/12/2011"), "eagle", 0);
            System.out.println("Life Expectancy = " + myBird.determineLifeExpectancy());
            
            Reptile myReptile = new Reptile("Smeagol", 4, formatter.parse("03/17/2011"), "iguana", 0);
            System.out.println("Life Expectancy = " + myReptile.determineLifeExpectancy());
        }
        catch (Exception e)
        {
            System.out.println("Test Case 7 Error " + e.getMessage());
        }
        System.out.println();
    }
    
    // AOP
    public static void testCase8()
    {
        System.out.println("Test Case 8");
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        try
        {
            Mammal myMammal = new Mammal("Chuck Norris", 9, formatter.parse("7/13/2006"), "lion", 0);
            myMammal.determineLifeExpectancy();
            
            Bird myBird = new Bird("Bartles", 3, formatter.parse("12/12/2011"), "eagle", 0);
            myBird.determineLifeExpectancy();
            
            Reptile myReptile = new Reptile("Smeagol", 4, formatter.parse("03/17/2011"), "iguana", 0);
            myReptile.determineLifeExpectancy();
        }
        catch (Exception e)
        {
            System.out.println("Test Case 8 Error " + e.getMessage());
        }
        
        ZooOrganizer myZoo = new ZooOrganizer();
        System.out.printf("Total times life expectancy calculated: %d\n",
                myZoo.getLifeCount());
        System.out.printf("Total amount billed: $%.2f\n", myZoo.getBillingAmount());
    }
}
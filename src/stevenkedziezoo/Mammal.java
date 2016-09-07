/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stevenkedziezoo;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Steven Kedzie
 */
public class Mammal extends Animal
{
    // used to calculate a mammal life span
    private final int upperLifeLimit = 15;
    
    public Mammal(String name, int age, Date birthDate, String species,
            int lifeExpectancy)
    {
        super(name, age, birthDate, species, lifeExpectancy);
    }
    
    // Parse line of xml formatted text as parameter from text file
    public Mammal(String xmlString)
    {
        super(xmlString);
        
        //Create Date object to store formatted birthDate attribute
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        //load attributes from parsed text to object attributes
        this.name = xmlString.substring(xmlString.indexOf("<name>") + 6,
                xmlString.indexOf("</name>"));
        this.age = Integer.parseInt(xmlString.substring(xmlString.indexOf("<age>") + 5,
                xmlString.indexOf("</age>")));
        try
        {
            this.birthDate = formatter.parse(xmlString.substring(xmlString.indexOf("<birthDate>") + 11,
                    xmlString.indexOf("</birthDate>")));
        }
        catch (Exception e)
        {
            System.out.println("Animal Creation Error " + e.getMessage());
        }
        this.species = xmlString.substring(xmlString.indexOf("<species>") + 9,
                xmlString.indexOf("</species>"));
        this.lifeExpectancy = Integer.parseInt(xmlString.substring(xmlString.indexOf("<lifeExpectancy>") + 16,
                xmlString.indexOf("</lifeExpectancy>")));
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        return "<mammal>" +
               "<name>" + name + "</name>" +
               "<age>" + age + "</age>" +
               "<birthDate>" + formatter.format(birthDate) + "</birthDate>" +
               "<species>" + species + "</species>" +
               "<lifeExpectancy>" + lifeExpectancy + "</lifeExpectancy>" +
               "</mammal>";
    }
    
    @Override
    public double determineLifeExpectancy()
    {
        double lifeSpan = upperLifeLimit - age;
        return lifeSpan;
    }
}
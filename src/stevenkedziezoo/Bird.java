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
public class Bird extends Animal
{
    private final double BIRD_LIFESPAN = 5;    // life expectancy does not change
    
    public Bird(String name, int age, Date birthDate, String species,
            int lifeExpectancy)
    {
        super(name, age, birthDate, species, lifeExpectancy);
    }
    
    // Parse line of xml formatted text as parameter from text file
    public Bird(String xmlString)
    {
        super(xmlString);
        
        // Create Date object to store formatted birthDate attribute
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        //load attributes from parsed text to object attributes
        name = xmlString.substring(xmlString.indexOf("<name>") + 6,
                xmlString.indexOf("</name>"));
        age = Integer.parseInt(xmlString.substring(xmlString.indexOf("<age>") + 5,
                xmlString.indexOf("</age>")));
        try
        {
            birthDate = formatter.parse(xmlString.substring(xmlString.indexOf("<birthDate>") + 11,
                    xmlString.indexOf("</birthDate>")));
        }
        catch (Exception e)
        {
            System.out.println("Animal Creation Error " + e.getMessage());
        }
        species = xmlString.substring(xmlString.indexOf("<species>") + 9,
                xmlString.indexOf("</species>"));
        lifeExpectancy = Integer.parseInt(xmlString.substring(xmlString.indexOf("<lifeExpectancy>") + 16,
                xmlString.indexOf("</lifeExpectancy>")));
    }
    
    @Override
    public double determineLifeExpectancy()
    {
        // Returns a Double that is the age of the Bird in years.
        return BIRD_LIFESPAN; // always 5.0
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        return "<bird>" +
               "<name>" + name + "</name>" +
               "<age>" + age + "</age>" +
               "<birthDate>" + formatter.format(birthDate) + "</birthDate>" +
               "<species>" + species + "</species>" +
               "<lifeExpectancy>" + lifeExpectancy + "</lifeExpectancy>" +
               "</bird>";
    }
}
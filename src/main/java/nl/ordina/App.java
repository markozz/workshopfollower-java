package nl.ordina;

import nl.ordina.exceptions.InvalidResponse;
import nl.ordina.models.WorkshopFollowerRepository;

/**
 * Simple app that queries the WorkshopFollower API
 */
public class App 
{
    public static void main( String[] args )
    {
        WorkshopFollowerRepository service = new WorkshopFollowerRepository("http://localhost:3333");
        try {
            service.findWorkshopFollower("8c36e86c-13b9-4102-a44f-646015dfd981");
        } catch (InvalidResponse e) {
            System.out.println(e.getMessage());
        }
    }
}

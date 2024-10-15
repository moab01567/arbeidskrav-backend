package no.moab015.BackendBicycles;

import no.moab015.BackendBicycles.module.Bicycle;
import no.moab015.BackendBicycles.module.Manufacturer;
import no.moab015.BackendBicycles.utli.FakeObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeObjectFactoryTest {

    public void printArrayByLine(ArrayList<?> arrayList){
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
    @Test
    public void generateManufacturerTest(){
        ArrayList<Manufacturer> manufacturers = FakeObjectFactory.generateManufacturer(10);
        System.out.println(manufacturers);
        assertEquals (manufacturers.size(), 10);
    }

    @Test
    public void generateBicyclesTest(){
        ArrayList<Manufacturer> manufacturers = FakeObjectFactory.generateManufacturer(10);
        ArrayList<Bicycle> bicycles = FakeObjectFactory.generateBicycles(50,manufacturers);
        printArrayByLine(bicycles);
        assertEquals (bicycles.size(), 50);
    }
}

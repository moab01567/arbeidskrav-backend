package no.moab015.BackendBicycles.utli;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import no.moab015.BackendBicycles.module.Bicycle;
import no.moab015.BackendBicycles.module.Manufacturer;

import java.util.ArrayList;
import java.util.Random;

public class FakeObjectFactory {

   private final static Faker faker = new Faker();

    public static ArrayList<Bicycle> generateBicycles(int totalBicycles, ArrayList<Manufacturer> manufacturers){
        ArrayList<Bicycle> bicycles = new ArrayList<>();
        for (int i = 1; i <= totalBicycles; i++) {
            Bicycle bicycle = Bicycle.builder()
                    .id(faker.idNumber().valid())
                    .name(faker.funnyName().name())
                    .color(faker.color().name())
                    .model("bike-"+i)
                    .InStock(new Random().nextInt(0,10))
                    .manufacturer(manufacturers.get(new Random().nextInt(0,manufacturers.size())))
                    .build();
            bicycles.add(bicycle);
        }

        return bicycles;
    }

    public static ArrayList<Manufacturer> generateManufacturer(int totalManufacturers){
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();

        for (int i = 1; i <= totalManufacturers; i++) {
           Company company = faker.company();
            Manufacturer manufacturer = Manufacturer
                    .builder()
                    .id(i)
                    .website(company.url())
                    .name(company.name())
                    .phoneNumber(faker.phoneNumber().phoneNumber())
                    .build();
            manufacturers.add(manufacturer);
        }

        return manufacturers;
    }

}

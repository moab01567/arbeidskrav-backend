package no.moab015.BackendBicycles;

import lombok.Getter;
import no.moab015.BackendBicycles.module.Bicycle;
import no.moab015.BackendBicycles.module.Manufacturer;
import no.moab015.BackendBicycles.utli.FakeObjectFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Getter
@Repository
public class BicycleRepository {

    private final ArrayList<Manufacturer> manufacturers;
    private final ArrayList<Bicycle> bicycles;

    public BicycleRepository(){
        manufacturers = FakeObjectFactory.generateManufacturer(10);
        bicycles = FakeObjectFactory.generateBicycles(50,manufacturers);
    }




}

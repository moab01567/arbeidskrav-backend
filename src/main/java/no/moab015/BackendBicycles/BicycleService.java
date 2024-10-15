package no.moab015.BackendBicycles;

import no.moab015.BackendBicycles.exception.BicycleNotFound;
import no.moab015.BackendBicycles.module.Bicycle;
import no.moab015.BackendBicycles.module.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BicycleService {

    private final BicycleRepository bicycleRepository;

    @Autowired
    BicycleService(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    public ArrayList<Bicycle> getAllBicycles() {
        return bicycleRepository.getBicycles();
    }


    public List<Bicycle> getAllBicyclesInStock() {
        ArrayList<Bicycle> bicycles = bicycleRepository.getBicycles();
        return bicycles.stream()
                .filter((bicycle) -> bicycle.getInStock() > 0)
                .collect(Collectors.toList());
        //https://medium.com/@javatechie/java-streams-features-exploring-hidden-methods-for-developers-72c89e641b03
    }

    public Bicycle getBicyclesById(String id) {
        for (Bicycle bicycle : bicycleRepository.getBicycles()) {
            if (bicycle.getId().equals(id))return bicycle;
        }
        throw new BicycleNotFound("No bicycle with id " + id + " in inventory", HttpStatus.NOT_FOUND);
    }

    public void addNewBicycles(Bicycle newBicycle) {
        addBicyclesToRepo(newBicycle);
        addManufacturerToRepo(newBicycle.getManufacturer());
    }
    private void addBicyclesToRepo(Bicycle newBicycle) {
        ArrayList<Bicycle> bicycles = bicycleRepository.getBicycles();
        for (Bicycle bicycle : bicycles) {
            if (bicycle.getId().equals(newBicycle.getId())) {
                bicycle.setInStock(bicycle.getInStock() + 1);
                return;
            }
        }
        bicycles.add(newBicycle);
    }
    private void addManufacturerToRepo(Manufacturer NewManufacturer) {
        ArrayList<Manufacturer> manufacturers = bicycleRepository.getManufacturers();
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getId() == (NewManufacturer.getId())) {
                return;
            }
        }
        manufacturers.add(NewManufacturer);
    }

    public void deleteBicycleById(String id) {
        ArrayList<Bicycle> bicycles = bicycleRepository.getBicycles();
        if(bicycles.removeIf((bicycle -> bicycle.getId().equals(id))))return;
        throw new BicycleNotFound("No bicycle with id " + id + " to delete", HttpStatus.NOT_FOUND);
    }
}

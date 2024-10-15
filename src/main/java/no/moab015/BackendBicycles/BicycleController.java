package no.moab015.BackendBicycles;

import no.moab015.BackendBicycles.module.Bicycle;
import no.moab015.BackendBicycles.module.ResponseMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bicycle")
public class BicycleController {
    final BicycleService bicycleService;

    @Autowired
    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<Bicycle>> getBicycles(){
        ArrayList<Bicycle> bicycles = bicycleService.getAllBicycles();
        return new ResponseEntity<>(bicycles, HttpStatus.OK);
    }
    @GetMapping("/in-stock")
    public ResponseEntity<?> getBicyclesInStock(){
        List<Bicycle> bicycles = bicycleService.getAllBicyclesInStock();
        return new ResponseEntity<>(bicycles,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBicyclesById(@PathVariable("id") String id){
        Bicycle bicycle = bicycleService.getBicyclesById(id);
        return new ResponseEntity<>(bicycle,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addBicycles(@RequestBody Bicycle bicycle){
        bicycleService.addNewBicycles(bicycle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBicycleById(@RequestParam(name = "id") String id){
        bicycleService.deleteBicycleById(id);
        return new ResponseEntity<>(new ResponseMassage("Bicycle with id " + id + " was deleted"),HttpStatus.OK);
    }



}

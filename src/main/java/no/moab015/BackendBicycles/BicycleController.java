package no.moab015.BackendBicycles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bicycle")
public class BicycleController {

    @GetMapping()
    public ResponseEntity<?> getBicycles(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}

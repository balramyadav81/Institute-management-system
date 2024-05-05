package Springboot.Institute.ManageMent.System.controller;

import Springboot.Institute.ManageMent.System.entity.Institute;
import Springboot.Institute.ManageMent.System.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutes")
public class InstituteController {
    @Autowired
    private InstituteService instituteService;

    // Endpoint to register a new institute
    @PostMapping
    public ResponseEntity<Institute> registerInstitute(@RequestBody Institute institute) {
        Institute createdInstitute = instituteService.registerInstitute(institute);
        return new ResponseEntity<>(createdInstitute, HttpStatus.CREATED);
    }


    // Endpoint to modify an existing institute
    @PutMapping("/{id}")
    public ResponseEntity<Institute> modifyInstitute(@PathVariable int id, @RequestBody Institute modifiedInstitute) {
        Institute updatedInstitute = instituteService.modifyInstitute(id, modifiedInstitute);
        if (updatedInstitute != null) {
            return new ResponseEntity<>(updatedInstitute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint to get an institute by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable int id) {
        Institute institute = instituteService.getInstituteById(id);
        if (institute != null) {
            return new ResponseEntity<>(institute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint to get all institutes
    @GetMapping("/all")
    public ResponseEntity<List<Institute>> getAllInstitutes() {
        List<Institute> institutes = instituteService.getAllInstitutes();
        return new ResponseEntity<>(institutes, HttpStatus.OK);
    }


    // Endpoint to delete an institute by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstituteById(@PathVariable int id) {
        // Call the delete method from service class
        boolean isDeleted = instituteService.deleteInstituteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Institute with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID: " + id);
        }
    }
}

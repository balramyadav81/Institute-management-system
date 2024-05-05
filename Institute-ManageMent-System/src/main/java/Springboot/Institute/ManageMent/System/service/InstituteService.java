package Springboot.Institute.ManageMent.System.service;

import Springboot.Institute.ManageMent.System.entity.Institute;
import Springboot.Institute.ManageMent.System.exception.InstituteNotFoundException;
import Springboot.Institute.ManageMent.System.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituteService {
    @Autowired
    private InstituteRepository instituteRepository;

    // Method to register a new institute
    public Institute registerInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    // Method to modify an existing institute
    public Institute modifyInstitute(int id, Institute modifiedInstitute) {
        Optional<Institute> existingInstitute = instituteRepository.findById(id);
        if (existingInstitute.isPresent()) {
            Institute institute = existingInstitute.get();
            institute.setName(modifiedInstitute.getName());
            institute.setLocation(modifiedInstitute.getLocation());
            institute.setContactInformation(modifiedInstitute.getContactInformation());
            return instituteRepository.save(institute);
        } else {
            throw new InstituteNotFoundException("Institute not found with id: " + id);
        }
    }

    // Method to retrieve an institute by its ID
    public Institute getInstituteById(int id) {
        return instituteRepository.findById(id)
                .orElseThrow(() -> new InstituteNotFoundException("Institute not found with id: " + id));
    }

    // Method to retrieve all institutes
    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    // Method to delete an institute by its ID
    public boolean deleteInstituteById(int id) {
        // Check if the institute exists
        if (instituteRepository.existsById(id)) {
            // If it exists, delete it and return true
            instituteRepository.deleteById(id);
            return true;
        } else {
            // If it doesn't exist, return false
            return false;
        }
    }
}

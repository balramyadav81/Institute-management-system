package Springboot.Institute.ManageMent.System.exception;

// Custom exception class to represent cases where an institute is not found
public class InstituteNotFoundException extends RuntimeException {

    // Constructor to create an instance of InstituteNotFoundException with a custom message
    public InstituteNotFoundException(String message) {
        super(message);
    }
}


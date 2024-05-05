package Springboot.Institute.ManageMent.System.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

// Define the mapping for the "institutes" table in the database
@Table(name = "institutes")
public class Institute {

    // Define the primary key for the entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // Define a column for the name of the institute
    @Column(name="name")
    private String name;

    // Define a column for the location of the institute
    @Column(name="location")
    private String location;

    // Define a column for the contact information of the institute
    @Column(name="contact_information")
    private String contactInformation;

}


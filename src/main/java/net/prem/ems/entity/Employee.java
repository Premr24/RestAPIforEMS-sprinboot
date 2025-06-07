package net.prem.ems.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter                    //To generate getter method
@Setter                    //To generate setter method
@NoArgsConstructor         //To create no argument constructor
@AllArgsConstructor        //To create parameterized constructor
@Entity                    //To specify class as entity
@Table(name = "employees") //To specify table details and name as table name

public class Employee {

    @Id                    //To configure primary key for this entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //To generate primary key
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;


}

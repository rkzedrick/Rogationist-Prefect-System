package com.rocs.osd.domain.person;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
/**
 * Represents the person entity.
 */
@MappedSuperclass
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 32)
    private String lastName;
    @Column(length = 64)
    private String firstName;
    @Column(length = 32)
    private String middleName;
    private Date birthdate;
    @Column(length = 128, nullable = true)
    private String birthplace;
    @Column(length = 8, nullable = true)
    private String sex;
    @Column(length = 16, nullable = true)
    private String civilStatus;
    @Column(length = 32, nullable = true)
    private String citizenship;
    @Column(length = 32, nullable = true)
    private String religion;
    @Column(length = 64, nullable = true)
    private String email;
    @Column(length = 128, nullable = true)
    private String address;
    @Column(length = 11, nullable = true)
    private String contactNumber;
}

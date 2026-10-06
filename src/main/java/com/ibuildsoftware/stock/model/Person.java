package com.ibuildsoftware.stock.model;

import com.ibuildsoftware.stock.enun.IdentifyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "person", uniqueConstraints = {
        @UniqueConstraint(name = "unique_identifier_value", columnNames = "identifierValue"),
        @UniqueConstraint(name = "unique_email", columnNames = "email")
})
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", allocationSize = 1, initialValue = 1)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    private Long id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "The name should be informed")
    private String name;

    @Column(length = 200)
    private String legalName;

    @Column(length = 200)
    private String tradeName;

    @Column(length = 50)
    private String stateOfFormation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @NotNull(message = "The identify Type must be specified")
    private IdentifyType identifierType;

    @Column(nullable = false, length = 50, unique = true)
    private String identifierValue;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "The telephone number must be provided correctly")
    private String telephone;

    @Column(nullable = false, length = 250, unique = true)
    @Email(message = "The email must be provided correctly")
    private String email;

    @Column(nullable = false)
    private Boolean active = false;

    @Column(nullable = false, updatable = false)
    @NotNull(message = "Registration date should be informed")
    private LocalDate registrationDate = LocalDate.now();

    @Column(length = 1000)
    private String observation;

    @Column(nullable = false, length = 250)
    @NotBlank(message = "The adress line1 must be provided correctly")
    private String adressLine1;

    @Column(length = 250)
    private String adressLine2;

    @Column(nullable = false, length = 250)
    @NotBlank(message = "The city must be provided correctly")
    private String city;

    @Column(length = 250)
    @NotBlank(message = "The state must be provided correctly")
    private String state;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "The zip code must be provided correctly")
    private String zipCode;

    @Column(nullable = false, length = 250)
    @NotBlank(message = "The country must be provided correctly")
    private String country;

    /*regarding multitenancy*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "company_fk"))
    @NotNull(message = "The company should be informed")
    private Company company;

    //embeddable adress and state =>: https://github.com/americoafonso/ESR-Especialista-Spring-Rest/tree/main/algafood-api/src/main/java/com/algaworks/algafood/domain/model
}

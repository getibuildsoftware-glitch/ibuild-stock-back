package com.ibuildsoftware.stock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "company", uniqueConstraints = {
        @UniqueConstraint(name = "unique_person_company", columnNames = "person_id")})
@SequenceGenerator(name = "seq_company", sequenceName = "seq_company", allocationSize = 1, initialValue = 1)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "plan_fk"))
    @NotNull(message = "The plan should be informed")
    private Plan plan;

    @Column(nullable = true)
    private Integer totalUsers = 0;

    @Column(nullable = true)
    private Integer totalCustomer = 0;

    @Column(nullable = false)
    private Boolean ativePlan = false;

    @Column(nullable = false)
    private Boolean blockage = false;

    @Column(columnDefinition = "text", nullable = false)
    @NotNull(message = "LogoType should be informed")
    private String logoType;

    @Column(nullable = true)
    private LocalDate planValidity;

    @JoinColumn(name = "person_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    @OneToOne(fetch = FetchType.LAZY)
    @NotNull(message = "The person should be informed")
    private Person person;

}

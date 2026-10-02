package com.ibuildsoftware.stock.model;

import com.ibuildsoftware.stock.enun.PlanType;
import jakarta.persistence.*;

@Entity
@Table(name = "plan")
@SequenceGenerator(name = "seq_plan", sequenceName = "seq_plan", allocationSize = 1, initialValue = 1)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plan")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private Boolean ative;

    @Column(nullable = false)
    private Double monthlyAmount;

    @Column(nullable = false)
    private Integer userLimit;

    @Column(nullable = false)
    private Integer customerLimit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanType planType;

}

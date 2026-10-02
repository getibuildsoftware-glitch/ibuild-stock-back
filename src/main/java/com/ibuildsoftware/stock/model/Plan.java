package com.ibuildsoftware.stock.model;

import com.ibuildsoftware.stock.enun.PlanType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "plan")
@SequenceGenerator(name = "seq_plan", sequenceName = "seq_plan", allocationSize = 1, initialValue = 1)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plan")
    private Long id;

    @NotBlank(message = "Name should be informed")
    @NotEmpty(message = "The name cannot be null")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Description should be informed")
    @NotEmpty(message = "The description cannot be null")
    @Column(nullable = false)
    private String description;

    private Boolean ative;

    @NotNull(message = "Monthly amount should be informed")
    @Min(value = 49, message = "The minimum value must be $49 USD")
    @Max(value = 150, message = "The maximum value should be $150 USD")
    @Column(nullable = false)
    private Double monthlyAmount;

    @NotNull(message = "The user limit cannot be null")
    @Min(value = 1, message = "The minimum user limit is 1")
    @Max(value = 150, message = "The maximum user limit is 150")
    @Column(nullable = false)
    private Integer userLimit;

    @NotNull(message = "The customer limit cannot be null")
    @Min(value = 1, message = "The minimum customer limit is 1")
    @Max(value = 150, message = "The maximum customer limit is 150")
    @Column(nullable = false)
    private Integer customerLimit;

    @NotNull(message = "Plan type cannot be null")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanType planType;

}

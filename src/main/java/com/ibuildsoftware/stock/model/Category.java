package com.ibuildsoftware.stock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Data
@Table(name = "category")
@SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize = 1, initialValue = 1)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    private Long id;

    @NotBlank(message = "The name should be informed")
    @NotEmpty(message = "The name can't be null")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "company_fk"))
    private Company company;
}

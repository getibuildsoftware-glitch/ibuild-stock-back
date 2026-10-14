package com.ibuildsoftware.stock.model;

import com.ibuildsoftware.stock.enun.UnitMeasurement;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product", uniqueConstraints = {@UniqueConstraint(name = "unique_sku", columnNames = "sku")})
@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1, initialValue = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "The product name cannot be null")
    @NotBlank(message = "The product name should be informed")
    @Size(max = 150, message = "The product name must have at most 150 characters")
    private String productName;

    private String description;

    @Column(columnDefinition = "text")
    @NotNull(message = "The image cannot be null")
    @NotBlank(message = "The image need to be registered")
    private String image;

    @Column(nullable = false)
    @NotNull(message = "The price should be informed")
    @Min(value = 1, message = "The price must be greater than or equal to 1")
    private Double price;

    @Column(nullable = false)
    @NotNull(message = "The stock must be greater than or equal to 1")
    private Double stock;

    @Column(nullable = false)
    @NotNull(message = "The minimum stock level should be informed")
    @Min(value = 1, message = "The minimum stock level cannot be negative")
    private Double minimumStockLevel;

    @Column(unique = true)
    private String sku;

    private String barcode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "The unit of measurement should be informed")
    private UnitMeasurement unitMeasurement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "category_fk"))
    @NotNull(message = "The category should be informed")
    private Category category;

    /*regarding multitenancy*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "company_fk"))
    @NotNull(message = "The company should be informed")
    private Company company;
}
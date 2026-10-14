package com.ibuildsoftware.stock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Data
@Table(name = "role", uniqueConstraints = {
        @UniqueConstraint(name = "unique_access", columnNames = "access")})
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1)
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "The access cannot be null")
    @NotBlank(message = "The access should be informed")
    private String access;

    @Override
    public @Nullable String getAuthority() {
        return this.access;
    }
}

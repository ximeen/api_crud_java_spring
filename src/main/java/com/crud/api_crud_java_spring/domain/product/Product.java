package com.crud.api_crud_java_spring.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(ProductRequest productRequest){
        this.name = productRequest.name();
        this.price_in_cents = productRequest.price_in_cents();
        this.active = true;
    }
}

package com.deva.foody.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "meal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long mealId;

    @NotBlank
    @Column(name = "meal_name", columnDefinition = "text")
    private String mealName;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @NotBlank
    @Column(name = "price")
    private Float price;

    @NotBlank
    @Column(name = "ingredients", columnDefinition = "text")
    private String Ingredients;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "rest_id", nullable = false)
//    private Restaurant restaurant;
}

package com.deva.foody.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cuisines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuisine extends AuditEntity {
    @Id
    @GeneratedValue(generator = "cuisine_generator")
    @SequenceGenerator(
            name = "cuisine_generator",
            sequenceName = "cuisine_sequence",
            initialValue = 1000
    )
    @ApiModelProperty(notes = "The database generated Cuisine id")
    private Long id;

    @NotBlank
    @Column(name = "cuisine_name", columnDefinition = "text")
    @ApiModelProperty(notes = "Cuisine names of the restaurant")
    private String cuisineName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", referencedColumnName="id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Restaurant restaurant;

}

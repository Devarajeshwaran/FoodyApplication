package com.deva.foody.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant extends AuditEntity {
    @Id
    @GeneratedValue(generator = "restaurant_generator")
    @SequenceGenerator(
            name = "restaurant_generator",
            sequenceName = "restaurant_sequence",
            initialValue = 1000
    )
    @ApiModelProperty(notes = "The database generated Restaurant id")
    private Long id;

    @NotNull
    @Column(name = "restaurant_name", columnDefinition = "text")
    @ApiModelProperty(notes = "Restaurant Name")
    private String restaurantName;

    //    @NotNull
    @Column(name = "phone_no")
    @ApiModelProperty(notes = "Phone number of the restaurant")
    private Long phoneNo;

    //    @NotNull
    @Column(name = "home_delivery_option")
    @ApiModelProperty(notes = "If home delivery option is available")
    private Boolean homeDeliveryOption;

    //    @NotNull
    @Column(name = "is_delivery_charge")
    @ApiModelProperty(notes = "If delivery charge is applicable")
    private Boolean isDeliveryCharge;

    //    @NotNull
    @Column(name = "delivery_charge")
    @ApiModelProperty(notes = "Delivery charge amount")
    private Float deliveryCharge;

    //    @NotNull
    @Column(name = "delivery_weekdays_time")
    @ApiModelProperty(notes = "Delivery time during weekdays")
    private String deliveryWeekDaysTime;

    //    @NotNull
    @Column(name = "delivery_weekend_time")
    @ApiModelProperty(notes = "Delivery time during weekend")
    private String deliveryWeekEndTime;

    //    @NotNull
    @Column(name = "address", columnDefinition = "text")
    @ApiModelProperty(notes = "Address of the restaurant")
    private String address;

    //    @NotNull
    @Column(name = "opening_time")
    @ApiModelProperty(notes = "Opening time of the restaurant")
    private String openingTime;

}
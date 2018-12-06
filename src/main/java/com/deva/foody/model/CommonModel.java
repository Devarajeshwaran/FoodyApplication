package com.deva.foody.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonModel {

    private String restaurantName;
    private Long phoneNo;
    private Boolean homeDeliveryOption;
    private Boolean isDeliveryCharge;
    private Float deliveryCharge;
    private String deliveryWeekDaysTime;
    private String deliveryWeekEndTime;
    private String address;
    private String openingTime;
    private String cuisineName;
}

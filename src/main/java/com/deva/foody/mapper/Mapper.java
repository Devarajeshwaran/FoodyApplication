package com.deva.foody.mapper;

import com.deva.foody.model.CommonModel;
import com.deva.foody.model.RequestModel;
import com.deva.foody.model.ResponseModel;
import com.deva.foody.entity.Restaurant;
import com.deva.foody.repository.CuisineRepository;
import com.deva.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    public CommonModel RequestToModelMapper(RequestModel requestModel) {
        CommonModel commonModel = new CommonModel();
        commonModel.setAddress(requestModel.getAddress());
        commonModel.setCuisineName(requestModel.getCuisineName());
        commonModel.setDeliveryCharge(requestModel.getDeliveryCharge());
        commonModel.setDeliveryWeekDaysTime(requestModel.getDeliveryWeekDaysTime());
        commonModel.setDeliveryWeekEndTime(requestModel.getDeliveryWeekEndTime());
        commonModel.setHomeDeliveryOption(requestModel.getHomeDeliveryOption());
        commonModel.setIsDeliveryCharge(requestModel.getIsDeliveryCharge());
        commonModel.setOpeningTime(requestModel.getOpeningTime());
        commonModel.setPhoneNo(requestModel.getPhoneNo());
        commonModel.setRestaurantName(requestModel.getRestaurantName());
        return commonModel;
    }

    public Restaurant ModelToEntityMapper(CommonModel commonModel) {
        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(commonModel.getAddress());
        restaurant.setDeliveryCharge(commonModel.getDeliveryCharge());
        restaurant.setDeliveryWeekDaysTime(commonModel.getDeliveryWeekDaysTime());
        restaurant.setDeliveryWeekEndTime(commonModel.getDeliveryWeekEndTime());
        restaurant.setOpeningTime(commonModel.getOpeningTime());
        restaurant.setDeliveryCharge(commonModel.getDeliveryCharge());
        restaurant.setRestaurantName(commonModel.getRestaurantName());
        restaurant.setHomeDeliveryOption(commonModel.getHomeDeliveryOption());
        restaurant.setPhoneNo(commonModel.getPhoneNo());
        restaurant.setIsDeliveryCharge(commonModel.getIsDeliveryCharge());
        return restaurant;
    }

    public ResponseModel EntityToResponseModelMapper(Restaurant restaurant) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setAddress(restaurant.getAddress());
        responseModel.setRestaurantName(restaurant.getRestaurantName());
        responseModel.setPhoneNo(restaurant.getPhoneNo());
        responseModel.setOpeningTime(restaurant.getOpeningTime());
        responseModel.setIsDeliveryCharge(restaurant.getIsDeliveryCharge());
        responseModel.setHomeDeliveryOption(restaurant.getHomeDeliveryOption());
        responseModel.setDeliveryWeekEndTime(restaurant.getDeliveryWeekEndTime());
        responseModel.setDeliveryWeekDaysTime(restaurant.getDeliveryWeekDaysTime());
        responseModel.setDeliveryCharge(restaurant.getDeliveryCharge());
        responseModel.setIsDeliveryCharge(restaurant.getIsDeliveryCharge());
        return responseModel;
    }
}

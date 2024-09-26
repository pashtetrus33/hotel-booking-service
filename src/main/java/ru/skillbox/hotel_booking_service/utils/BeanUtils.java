package ru.skillbox.hotel_booking_service.utils;

import lombok.experimental.UtilityClass;
import ru.skillbox.hotel_booking_service.entity.Hotel;

@UtilityClass
public class BeanUtils {


    public void copyHotelNotNullProperties(Hotel source, Hotel destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination must not be null");
        }

        if (source.getId() != null) {
            destination.setId(source.getId());
        }

        if (source.getName() != null) {
            destination.setName(source.getName());
        }

        if (source.getAnnouncement() != null) {
            destination.setAnnouncement(source.getAnnouncement());
        }

        if (source.getCity() != null) {
            destination.setCity(source.getCity());
        }

        if (source.getAddress() != null) {
            destination.setAddress(source.getAddress());
        }

        if (source.getDistanceFromCityCenter() >= 0) {
            destination.setDistanceFromCityCenter(source.getDistanceFromCityCenter());
        }
    }
}
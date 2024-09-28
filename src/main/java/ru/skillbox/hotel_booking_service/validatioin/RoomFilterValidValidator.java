package ru.skillbox.hotel_booking_service.validatioin;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;
import ru.skillbox.hotel_booking_service.web.model.RoomFilter;


public class RoomFilterValidValidator implements ConstraintValidator<RoomFilterValid, RoomFilter> {

    @Override
    public boolean isValid(RoomFilter value, ConstraintValidatorContext context) {

        // Проверяем, что оба поля page и size заданы
        if (ObjectUtils.anyNull(value.getPage(), value.getSize())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Both page and size must be specified.").addConstraintViolation();
            return false;
        }

        // Проверяем, что хотя бы одно поле для фильтрации задано
        if (ObjectUtils.allNull(value.getId(), value.getName(), value.getMinPrice(), value.getMaxPrice(), value.getMaxOccupancy(), value.getCheckInDate(), value.getCheckOutDate(), value.getHotelId())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("At least one of must be specified: id, name, minPrice, maxPrice, " + "maxOccupancy, checkInDate, checkOutDate, hotelId.").addConstraintViolation();
            return false;
        }

        // Проверка, что если указана дата заезда, то указана и дата выезда, и наоборот
        if (ObjectUtils.anyNull(value.getCheckInDate(), value.getCheckOutDate())) {
            if (!ObjectUtils.isEmpty(value.getCheckInDate()) || !ObjectUtils.isEmpty(value.getCheckOutDate())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Both check-in and check-out dates must be specified together.").addConstraintViolation();
                return false;
            }
        }

        // Проверка, что дата выезда позже даты заезда
        if (value.getCheckInDate() != null && value.getCheckOutDate() != null) {
            if (value.getCheckOutDate().isBefore(value.getCheckInDate())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Check-out date must be later than check-in date.").addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}


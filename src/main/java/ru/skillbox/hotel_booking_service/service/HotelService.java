package ru.skillbox.hotel_booking_service.service;

import ru.skillbox.hotel_booking_service.web.model.HotelListResponse;
import ru.skillbox.hotel_booking_service.web.model.HotelResponse;
import ru.skillbox.hotel_booking_service.web.model.UpdateHotelRequest;
import ru.skillbox.hotel_booking_service.web.model.UpsertHotelRequest;

public interface HotelService {

    HotelListResponse findAll(int page, int size);

    HotelResponse findById(Long id);

    HotelResponse save(UpsertHotelRequest request);

    HotelResponse update(Long id, UpdateHotelRequest request);

    void deleteById(Long id);

    void updateHotelRating(Long id, double newMark);
}
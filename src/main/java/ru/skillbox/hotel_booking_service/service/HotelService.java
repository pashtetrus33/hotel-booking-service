package ru.skillbox.hotel_booking_service.service;

import jakarta.validation.Valid;
import ru.skillbox.hotel_booking_service.web.model.*;

public interface HotelService {

    HotelListResponse findAll(int page, int size);

    HotelResponse findById(Long id);

    HotelResponse save(UpsertHotelRequest request);

    HotelResponse update(Long id, UpdateHotelRequest request);

    void deleteById(Long id);

    void updateHotelRating(Long id, double newMark);
<<<<<<< HEAD

    HotelListResponse filterBy(HotelFilter filter);
=======
>>>>>>> 563d0345f347e946c278863ccc86e8a3daa1917c
}
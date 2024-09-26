package ru.skillbox.hotel_booking_service.service;

import ru.skillbox.hotel_booking_service.web.model.RoomResponse;
import ru.skillbox.hotel_booking_service.web.model.UpdateRoomRequest;
import ru.skillbox.hotel_booking_service.web.model.UpsertRoomRequest;

public interface RoomService {

    RoomResponse findById(Long id);

    RoomResponse save(UpsertRoomRequest request, Long hotelId);

    RoomResponse update(Long id, UpdateRoomRequest request);

    void deleteById(Long id);
}
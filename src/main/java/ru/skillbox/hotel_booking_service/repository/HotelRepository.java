package ru.skillbox.hotel_booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.hotel_booking_service.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

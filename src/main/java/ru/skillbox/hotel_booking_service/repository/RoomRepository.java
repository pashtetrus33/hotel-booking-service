package ru.skillbox.hotel_booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.hotel_booking_service.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

package ru.skillbox.hotel_booking_service.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.skillbox.hotel_booking_service.entity.Room;
import ru.skillbox.hotel_booking_service.service.HotelService;
import ru.skillbox.hotel_booking_service.web.model.RoomResponse;
import ru.skillbox.hotel_booking_service.web.model.UpdateRoomRequest;
import ru.skillbox.hotel_booking_service.web.model.UpsertRoomRequest;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = HotelMapper.class)
public interface RoomMapper {

    @Mapping(target = "id", ignore = true)
    Room requestToRoom(UpsertRoomRequest request);

    Room requestToRoom(Long id, UpdateRoomRequest request);

    @Mapping(source = "hotel.id", target = "hotelId")
    RoomResponse roomToResponse(Room room);

    @Mapping(target = "hotel", expression = "java(hotelMapper.responseToHotel(hotelService.findById(response.getHotelId())))")
    Room responseToRoom(RoomResponse response, @Context HotelService hotelService, @Context HotelMapper hotelMapper);
}
package ru.skillbox.hotel_booking_service.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.hotel_booking_service.service.BookingService;
import ru.skillbox.hotel_booking_service.web.model.*;


@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @PostMapping
    public ResponseEntity<BookingResponse> bookRoom(@RequestBody @Valid UpsertBookingRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.bookRoom(request));
    }

    @GetMapping
    public ResponseEntity<BookingListResponse> findAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(bookingService.findAll(page, size));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
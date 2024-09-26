package ru.skillbox.hotel_booking_service.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.hotel_booking_service.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //@EntityGraph(attributePaths = {"roles"})
    Optional<User> findByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);
}
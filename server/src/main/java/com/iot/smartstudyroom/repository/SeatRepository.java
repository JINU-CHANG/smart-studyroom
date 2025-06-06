package com.iot.smartstudyroom.repository;

import com.iot.smartstudyroom.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}

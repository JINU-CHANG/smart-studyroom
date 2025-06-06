package com.iot.smartstudyroom.repository;

import com.iot.smartstudyroom.domain.MemberSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberSeatRepository extends JpaRepository<MemberSeat, Long> {
    Optional<MemberSeat> findBySeatId(Integer seatId);
}

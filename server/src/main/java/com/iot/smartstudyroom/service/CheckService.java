package com.iot.smartstudyroom.service;

import com.iot.smartstudyroom.domain.MemberSeat;
import com.iot.smartstudyroom.repository.MemberSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CheckService {

    private final MemberSeatRepository memberSeatRepository;

    public String checkInvalidUsage(InvalidUsageCheckRequest request) {
        if (request.sensorValue() <= 0) return "valid";

        Optional<MemberSeat> optionalMemberSeat = memberSeatRepository.findBySeatId(request.seatId());
        if (isInvalidUsage(optionalMemberSeat)) {
            System.out.println("invalid Usage");
            return "invalid";
        }

        return "valid";
    }

    private boolean isInvalidUsage(Optional<MemberSeat> optionalMemberSeat) {
        if (optionalMemberSeat.isEmpty()) {
            return true;
        }

        MemberSeat memberSeat = optionalMemberSeat.get();
        return memberSeat.isPassEndTime(LocalDateTime.now(), 30);
    }
}

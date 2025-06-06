package com.iot.smartstudyroom.service.dto;

import java.time.LocalDateTime;

public record ReserveRequest(String memberId, Integer seatId, LocalDateTime startTime, LocalDateTime endTime) {
}

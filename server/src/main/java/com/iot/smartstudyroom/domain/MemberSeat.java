package com.iot.smartstudyroom.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@Entity
public class MemberSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Seat seat;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public MemberSeat(Member member, Seat seat, LocalDateTime startTime, LocalDateTime endTime) {
        this.member = member;
        this.seat = seat;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isPassEndTime(LocalDateTime now, long minute) {
        Duration duration = Duration.between(now, endTime);
        long minutesDifference = Math.abs(duration.toMinutes());

        return minutesDifference >= minute;
    }
}

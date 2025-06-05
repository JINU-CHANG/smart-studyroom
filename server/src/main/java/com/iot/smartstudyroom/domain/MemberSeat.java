package com.iot.smartstudyroom.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

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

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDate date;

    public MemberSeat(Member member, Seat seat, LocalTime startTime, LocalTime endTime, LocalDate date) {
        this.member = member;
        this.seat = seat;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }
}

package com.iot.smartstudyroom.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class MemberSeatTest {

    @DisplayName("좌석 시간 종료 이후 30분이 지난경우 true를 반환한다.")
    @Test
    void isPassEndTime() {
        // given
        Member member = new Member("jinwoo@gmail.com", "password");
        Room room = new Room(1L);
        Seat seat = new Seat(1, room);

        LocalDateTime startTime = LocalDateTime.of(2025, 6, 6, 17, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 6, 6, 18, 0);

        MemberSeat memberSeat = new MemberSeat(member, seat, startTime, endTime);

        // when
        LocalDateTime now = LocalDateTime.of(2025, 6, 6, 18, 30);
        boolean result = memberSeat.isPassEndTime(now, 30);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("좌석 시간 종료 이후 30분이 지나지 않은 경우 false를 반환한다.")
    @Test
    void isNotPassEndTime() {
        // given
        Member member = new Member("jinwoo@gmail.com", "password");
        Room room = new Room(1L);
        Seat seat = new Seat(1, room);

        LocalDateTime startTime = LocalDateTime.of(2025, 6, 6, 17, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 6, 6, 18, 0);

        MemberSeat memberSeat = new MemberSeat(member, seat, startTime, endTime);

        // when
        LocalDateTime now = LocalDateTime.of(2025, 6, 6, 18, 29);
        boolean result = memberSeat.isPassEndTime(now, 30);

        // then
        Assertions.assertThat(result).isFalse();
    }
}

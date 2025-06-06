package com.iot.smartstudyroom.service;

import com.iot.smartstudyroom.domain.Member;
import com.iot.smartstudyroom.domain.MemberSeat;
import com.iot.smartstudyroom.domain.Seat;
import com.iot.smartstudyroom.repository.MemberRepository;
import com.iot.smartstudyroom.repository.MemberSeatRepository;
import com.iot.smartstudyroom.repository.SeatRepository;
import com.iot.smartstudyroom.service.dto.LoginRequest;
import com.iot.smartstudyroom.service.dto.ReserveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final SeatRepository seatRepository;
    private final MemberRepository memberRepository;
    private final MemberSeatRepository memberSeatRepository;

    @Transactional
    public String login(LoginRequest request) {
        Member member = memberRepository.findByIdAndPassword(request.id(), request.password())
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));
        return member.getId();
    }

    @Transactional
    public void reserve(ReserveRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new RuntimeException("멤버가 없습니다."));
        Seat seat = seatRepository.findById(request.seatId())
                .orElseThrow(() -> new RuntimeException("좌석이 존재하지 않습니다."));

        MemberSeat memberSeat = new MemberSeat(member, seat, request.startTime(), request.endTime());
        memberSeatRepository.save(memberSeat);
    }
}

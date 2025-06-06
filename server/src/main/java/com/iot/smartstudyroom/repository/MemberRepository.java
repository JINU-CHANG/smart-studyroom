package com.iot.smartstudyroom.repository;

import com.iot.smartstudyroom.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByIdAndPassword(String id, String password);
}

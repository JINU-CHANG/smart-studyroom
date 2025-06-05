package com.iot.smartstudyroom.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@Entity
public class Member {

    @Id
    private String id;
    private String password;

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
}

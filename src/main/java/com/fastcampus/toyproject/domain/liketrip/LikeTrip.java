package com.fastcampus.toyproject.domain.liketrip;

import com.fastcampus.toyproject.common.BaseTimeEntity;
import com.fastcampus.toyproject.domain.user.entity.User;
import com.fastcampus.toyproject.domain.trip.entity.Trip;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LikeTrip {

    @Id
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Trip trip;

    private Boolean isLike;

    @Embedded
    private BaseTimeEntity baseTimeEntity;
}

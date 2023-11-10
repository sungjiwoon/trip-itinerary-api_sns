package com.fastcampus.toyproject.domain.reply.entity;


import com.fastcampus.toyproject.common.BaseTimeEntity;
import com.fastcampus.toyproject.domain.user.entity.User;
import com.fastcampus.toyproject.domain.trip.entity.Trip;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reply {

    @Id
    private Long replyId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    private String content;

    @Embedded
    private BaseTimeEntity baseTimeEntity;

}

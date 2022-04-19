package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Proposal {

    @Id
    @SequenceGenerator(
            name = "proposal_sequence_generator",
            sequenceName = "proposal_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proposal_sequence_generator")
    private long id;

    private LocalDateTime creationDate;

    private String details;  // customer's name and sales person's name


    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User editor;

    @Column(name = "user_id")
    private Long editorId;

    // todo - proposal items

    public Proposal(String details, Long editorId) {
        this.details = details;
        this.editorId = editorId;  // TODO I think I can insert the user with a session method
        this.creationDate = LocalDateTime.now();
    }

}

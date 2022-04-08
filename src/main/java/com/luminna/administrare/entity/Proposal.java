package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Proposal {

    @Id
    @SequenceGenerator(
            name = "reservation_sequence_generator",
            sequenceName = "reservation_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence_generator")
    private long id;

    private LocalDateTime creationDate = LocalDateTime.now();  // automated

    private String details;  // customer's name

    private User editor;  // owner, TODO foreign key

    private User contact;  // sales person's name, TODO foreign key


    private List<ProposalItem> proposalItems;

    public Proposal(String details, User editor, User contact, List<ProposalItem> proposalItems) {
        this.details = details;
        this.editor = editor;  // TODO I think I can insert the user with a session method
        this.contact = contact;
        this.proposalItems = proposalItems;
    }

}

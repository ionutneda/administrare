package com.luminna.administrare.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
//@Builder
public class Reservation implements Serializable {

    @Id
    @SequenceGenerator(
            name = "reservation_sequence_generator",
            sequenceName = "reservation_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence_generator")
    private long id;

    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate creationDate;  // automated

    private int noOfDaysToBeActive; // the number of days to keep the reservation

    private LocalDate expirationDate;

    @Transient
    private Boolean old;  // true if Date is past expirationDate // TODO maybe I can use @Scheduled

    private String details;  // customer's name


    // todo - reservation items list


    // trying to get the editor's's id only
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User editor;

    @Column(name = "user_id")
    private Long userID;


    public Reservation(int noOfDaysToBeActive, String details, User editor) {
        this.noOfDaysToBeActive = noOfDaysToBeActive;
        this.details = details;
        this.creationDate = LocalDate.now();
        this.editor = editor;
        this.expirationDate = creationDate.plusDays(this.noOfDaysToBeActive);
        if (LocalDate.now().isAfter(expirationDate)) {
            this.old = true;
        } else {
            this.old = false;
        }
    }


}

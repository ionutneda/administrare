package com.luminna.administrare.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    private LocalDateTime creationDate = LocalDateTime.now();  // automated

    private int noOfDaysToBeActive; // the number of days to keep the reservation

    // it conflicts with @Builder if it's not included in the constructor
    // calculated; the user have to specify the number of days which will be added to the creation date.
    private LocalDateTime expirationDate = creationDate.plusDays(this.noOfDaysToBeActive);

    private Boolean old;  // true if Date is past expirationDate // TODO maybe I can use @Scheduled

    private String details;  // customer's name

    private List<ReservationItem> reservationItems;

    private User editor;  // TODO foreign key


    public Reservation(int noOfDaysToBeActive, String details, List<ReservationItem> reservationItems, User editor) {
        this.noOfDaysToBeActive = noOfDaysToBeActive;
        this.details = details;
        this.reservationItems = reservationItems;
        this.editor = editor;
    }

    public void setOld(){

        if (LocalDateTime.now().isAfter(expirationDate)){
            this.old = true;
        }
        else this.old = false;
    }

}

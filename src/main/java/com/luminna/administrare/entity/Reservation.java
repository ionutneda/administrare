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
@Table(name = "reservation")
public class Reservation {

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

    private int activePeriod; // the number of days to keep the reservation

    @JsonFormat(pattern = "dd/MM/yyy")
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
    private Long editorId;


    public Reservation(int activePeriod, String details, Long editorId) {
        this.activePeriod = activePeriod;
        this.details = details;
        this.creationDate = LocalDate.now();
        this.editorId = editorId;
        this.expirationDate = creationDate.plusDays(this.activePeriod);
        this.old = false;
    }

    public Boolean getOld() {
        if (LocalDate.now().isAfter(expirationDate)) {
            this.old = true;
        } else {
            this.old = false;
        }
        return old;
    }
}

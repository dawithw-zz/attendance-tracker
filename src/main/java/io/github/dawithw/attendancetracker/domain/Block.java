package io.github.dawithw.attendancetracker.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private LocalDate startDate;
    private LocalDate endDate;

    public Block(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    } 

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
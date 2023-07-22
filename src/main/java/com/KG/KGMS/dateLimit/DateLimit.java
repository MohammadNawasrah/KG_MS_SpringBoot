package com.KG.KGMS.dateLimit;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "DateLimit")
public class DateLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dateLimitId")
    private Long dateLimitId;
    @Column(name = "year")
    private String year;
    @Column(name = "fromDate")
    private String fromDate;
    @Column(name = "endDate")
    private String endDate;
    @Column(name = "typeStudent")
    private String typeStudent;

}

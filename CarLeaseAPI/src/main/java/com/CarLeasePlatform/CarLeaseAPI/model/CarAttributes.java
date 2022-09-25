package com.CarLeasePlatform.CarLeaseAPI.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
public class CarAttributes {

    /*
     * Used @Data to have clean code, by this we will include getter, setter and equals method as default
     * Used @Builder so that we can use it in test class to build mock data
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private String version;
    @Column
    private int nrOfDoors;
    @Column
    private String co2Emission;
    @Column
    private BigDecimal grossPrice;
    @Column
    private BigDecimal nettPrice;
    @Column
    private long mileage;
    @Column
    private int duration;
    @Column
    private double intrestRate;
    @Column
    private Date startDate;

}

package com.CarLeasePlatform.CarLeaseAPI.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class CustomerAttributes {

    /*
     * Used @Data to have clean code, by this we will include getter, setter and equals method as default
     * Used @Builder so that we can use it in test class to build mock data
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    @Column
    private String name;
    @Column
    private String street;
    @Column
    private String houseNumber;
    @Column
    private String zipCode;
    @Column
    private String place;
    @Column
    private String emailAddress;
    @Column
    private String phoneNumber;

}

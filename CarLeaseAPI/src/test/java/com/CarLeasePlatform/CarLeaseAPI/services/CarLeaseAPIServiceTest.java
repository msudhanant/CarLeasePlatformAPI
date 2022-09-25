package com.CarLeasePlatform.CarLeaseAPI.services;

import com.CarLeasePlatform.CarLeaseAPI.model.CarAttributes;
import com.CarLeasePlatform.CarLeaseAPI.repo.CarAttributesRepository;
import com.CarLeasePlatform.CarLeaseAPI.repo.CustomerAttribureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarLeaseAPIServiceTest {

    @Mock
    CustomerAttribureRepository customerRepo;
    @Mock
    CarAttributesRepository carRepo;

    @InjectMocks
    CarLeaseAPIService service;

    @Test
    void updateOrAddCustomer() {
    }

    @Test
    void getCalculatedLeaseRate() throws Exception {
        CarAttributes car = CarAttributes.builder()
                .carId(1L)
                .make("2020")
                .model("V20New")
                .version("20V")
                .nrOfDoors(4)
                .co2Emission("10C")
                .grossPrice(new BigDecimal(65000))
                .nettPrice(new BigDecimal(63000))
                .mileage(45000L)
                .duration(60)
                .intrestRate(4.5)
                .startDate(new Date(20/8/2015))
                .build();
        given(service.updateOrAddCarAttributes(car, 1L)).willReturn(car);
        when(service.getCalculatedLeaseRate(1L)).thenReturn(new BigDecimal(239.76));

        assertEquals(239.76, service.getCalculatedLeaseRate(1L));
    }
}
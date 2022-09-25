package com.CarLeasePlatform.CarLeaseAPI.services;

import com.CarLeasePlatform.CarLeaseAPI.model.CarAttributes;
import com.CarLeasePlatform.CarLeaseAPI.model.CustomerAttributes;
import com.CarLeasePlatform.CarLeaseAPI.repo.CarAttributesRepository;
import com.CarLeasePlatform.CarLeaseAPI.repo.CustomerAttribureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarLeaseAPIService {

    private final CustomerAttribureRepository customerRepo;
    private final CarAttributesRepository carRepo;

    /**
     * This method is used to fetch the all customer details
     * @return List of customer details
     */
    public List<CustomerAttributes> allCustomerAttributes(){
        return customerRepo.findAll();
    }

    /**
     * This method is used to fetch a particular customer details
     * @param id customer id
     * @return Specific customer details
     * @throws Exception if record not found
     */
    public CustomerAttributes getCustomerById(Long id) throws Exception {
        return customerRepo.findById(id)
                .orElseThrow(() -> new Exception("No record found for id: "+id));
    }

    /**
     * This method will try to find the customer for the given id else it will add the given customer
     * @param cust customer object
     * @param id customer id
     * @return Specified customer details
     */
    public CustomerAttributes updateOrAddCustomer(CustomerAttributes cust, Long id) {
        return customerRepo.findById(id).map(custAttributes -> {
            custAttributes.setName(cust.getName());
            custAttributes.setEmailAddress(cust.getEmailAddress());
            custAttributes.setHouseNumber(cust.getHouseNumber());
            custAttributes.setStreet(cust.getStreet());
            custAttributes.setPlace(cust.getPlace());
            custAttributes.setZipCode(cust.getZipCode());
            custAttributes.setPhoneNumber(cust.getPhoneNumber());
            return customerRepo.save(custAttributes);
        }).orElseGet(() -> customerRepo.save(cust));
    }

    /**
     * This method is used to delete the specified customer
     * @param id customer id
     */
    public void deleteCustomerAttributes(Long id){
        customerRepo.deleteById(id);
    }

    /**
     * This method will try to find the car details for the given id else it will add the given car details
     * @param car car object
     * @param carId car id
     * @return Specified car details
     */
    public CarAttributes updateOrAddCarAttributes(CarAttributes car, Long carId){
        return carRepo.findById(carId).map(carDetails -> {
            carDetails.setMake(car.getMake());
            carDetails.setModel(car.getModel());
            carDetails.setVersion(car.getVersion());
            carDetails.setNrOfDoors(car.getNrOfDoors());
            carDetails.setCo2Emission(car.getCo2Emission());
            carDetails.setGrossPrice(car.getGrossPrice());
            carDetails.setNettPrice(car.getNettPrice());
            carDetails.setMileage(car.getMileage());
            carDetails.setDuration(car.getDuration());
            carDetails.setIntrestRate(car.getIntrestRate());
            carDetails.setStartDate(car.getStartDate());
            return carRepo.save(carDetails);
        }).orElseGet(() -> carRepo.save(car));
    }

    /**
     * This method is used to find the lease rate for the given car id
     * @param carId car id
     * @return Lease rate amount
     * @throws Exception if record not found
     */
    public BigDecimal getCalculatedLeaseRate(Long carId) throws Exception {
        BigDecimal calculatedValue;
        CarAttributes car = carRepo.findById(carId)
                .orElseThrow(() -> new Exception("No record found for Car id: "+carId));
        BigDecimal carMileage = new BigDecimal(car.getMileage());
        BigDecimal carDuration = new BigDecimal(car.getDuration());
        BigDecimal carInterestRate = BigDecimal.valueOf(car.getIntrestRate());

        calculatedValue = (((carMileage.divide(new BigDecimal(12))).multiply(carDuration))
                .divide(car.getNettPrice()))
                .add(
                (((carInterestRate.divide(new BigDecimal(100)))
                        .multiply(car.getNettPrice())).divide(new BigDecimal(12))));

        return calculatedValue;
    }
}

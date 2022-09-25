package com.CarLeasePlatform.CarLeaseAPI.endpoints;

import com.CarLeasePlatform.CarLeaseAPI.model.CarAttributes;
import com.CarLeasePlatform.CarLeaseAPI.model.CustomerAttributes;
import com.CarLeasePlatform.CarLeaseAPI.services.CarLeaseAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * This is the controller class and @RequiredArgsConstructor is used to have in build constructor
 */
@RestController
@RequiredArgsConstructor
public class CarLeaseAPIEndpoint {

    private final CarLeaseAPIService apiService;

    /**
     * This method is used to fetch all customer details
     * @return List of customer details
     */
    @GetMapping("/customers")
    public List<CustomerAttributes> getAllCustomerAttributes(){
        return apiService.allCustomerAttributes();
    }

    /**
     * This method is used to fetch a specific customer details which is passed as path variable
     * @param id customer id
     * @return Specific customer details
     * @throws Exception if record not found
     */
    @GetMapping("/customer/{id}")
    public CustomerAttributes getCustomerById(@PathVariable Long id) throws Exception {
        return apiService.getCustomerById(id);
    }

    /**
     * This method is used to add or update the given customer details
     * @param customer customer object
     * @param id customer id
     * @return Specified customer details
     */
    @PutMapping("/customer/{id}")
    public CustomerAttributes addOrUpdateCustomer(@RequestBody CustomerAttributes customer, @PathVariable Long id){
        return apiService.updateOrAddCustomer(customer,id);
    }

    /**
     * This method is used to delete the specified customer
     * @param id customer id
     */
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
        apiService.deleteCustomerAttributes(id);
    }

    /**
     * his method is used to add or update the given car details
     * @param car car object
     * @param id car id
     * @return Specified car details
     */
    @PutMapping("/car/{id}")
    public CarAttributes addOrUpdateCar(@RequestBody CarAttributes car, @PathVariable Long id){
        return apiService.updateOrAddCarAttributes(car,id);
    }

    /**
     * This method is used to find the lease rate for the given car id
     * @param carId car id
     * @return Lease rate amount
     * @throws Exception if record not found
     */
    @GetMapping("/getCarLeaseRate/{CarId}")
    public BigDecimal getCarLeaseRate(@PathVariable Long carId) throws Exception {
        return apiService.getCalculatedLeaseRate(carId);
    }
}

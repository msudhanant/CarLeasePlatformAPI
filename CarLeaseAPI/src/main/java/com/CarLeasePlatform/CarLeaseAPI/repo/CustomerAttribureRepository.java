package com.CarLeasePlatform.CarLeaseAPI.repo;

import com.CarLeasePlatform.CarLeaseAPI.model.CustomerAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAttribureRepository extends JpaRepository<CustomerAttributes, Long> {
}

package com.CarLeasePlatform.CarLeaseAPI.repo;

import com.CarLeasePlatform.CarLeaseAPI.model.CarAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarAttributesRepository extends JpaRepository<CarAttributes, Long> {
}

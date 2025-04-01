package com.elecxa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elecxa.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

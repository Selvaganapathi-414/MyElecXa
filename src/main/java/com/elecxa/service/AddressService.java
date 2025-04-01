package com.elecxa.service;

import com.elecxa.model.Address;
import com.elecxa.model.User;
import com.elecxa.repository.AddressRepository;
import com.elecxa.repository.UserRepository;
import com.elecxa.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Address addAddress(Long userId, Address address) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        address.setState(addressDetails.getState());
        address.setCity(addressDetails.getCity());
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
    }
}

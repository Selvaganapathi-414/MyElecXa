package com.elecxa.controller;

import com.elecxa.model.Address;
import com.elecxa.model.User;
import com.elecxa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Address> getAddressesByUser(@PathVariable("userId") User user) {
        return addressService.getAddressesByUser(user);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}

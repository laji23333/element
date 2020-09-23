package com.element.Controller;

import com.element.Entity.po.Address;
import com.element.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAllAddress")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
}

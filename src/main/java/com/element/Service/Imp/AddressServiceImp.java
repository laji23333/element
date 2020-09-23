package com.element.Service.Imp;

import com.element.Dao.AddressMapper;
import com.element.Entity.po.Address;
import com.element.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddress() {
        return addressMapper.getAllAddress();
    }
}

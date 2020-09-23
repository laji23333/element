package com.element.Service.Imp;

import com.element.Mapper.AddressMapper;
import com.element.Entity.po.DeliveryAddress;
import com.element.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired(required = false)
    private AddressMapper addressMapper;

    @Override
    public List<DeliveryAddress> getAllAddress() {
        return addressMapper.getAllAddress();
    }
}

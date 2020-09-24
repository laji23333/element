package com.element.Service.Imp;

import com.element.Entity.po.DeliveryAddress;
import com.element.Mapper.AddressMapper;
import com.element.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<DeliveryAddress> getAllAddress() {
        return addressMapper.getAllAddress();
    }

    @Override
    public DeliveryAddress getAddressBydaId(Integer daId) {
        return addressMapper.getAddressBydaId(daId);
    }

    @Override
    public List<DeliveryAddress> getAddressByuserId(String userId) {
        return addressMapper.getAddressByuserId(userId);
    }

    @Override
    public int addAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address, String userId){
        return addressMapper.addAddress(daId,contactName,contactSex,contactTel,address,userId);
    }

    @Override
    public int updataAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address, String userId){
        return addressMapper.updataAddress(daId,contactName,contactSex,contactTel,address,userId);
    }

    @Override
    public int deleteAddress(Integer daId) {
        return addressMapper.deleteAddress(daId);
    }
}

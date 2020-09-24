package com.element.Service;

import com.element.Entity.po.DeliveryAddress;

import java.util.List;

public interface AddressService {
    List<DeliveryAddress> getAllAddress();

    DeliveryAddress getAddressBydaId(Integer daId);

    List<DeliveryAddress> getAddressByuserId(String userId);

    int addAddress(String contactName, Integer contactSex, String contactTel, String address, String userId);

    int updataAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address, String userId);

    int deleteAddress(Integer daId);
}

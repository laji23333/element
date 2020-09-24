package com.element.Mapper;

import com.element.Entity.po.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<DeliveryAddress> getAllAddress();


    DeliveryAddress getAddressBydaId(Integer daId);

    List<DeliveryAddress> getAddressByuserId(String userId);

    int addAddress(String contactName, Integer contactSex, String contactTel, String address, String userId);

    int updataAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address, String userId);

    int deleteAddress(Integer daId);
}

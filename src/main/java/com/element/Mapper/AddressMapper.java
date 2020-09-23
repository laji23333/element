package com.element.Mapper;

import com.element.Entity.po.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    public List<Address> getAllAddress();
}

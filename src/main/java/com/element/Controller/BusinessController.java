package com.element.Controller;


import com.alibaba.fastjson.JSONObject;
import com.element.Entity.po.Business;
import com.element.Entity.vo.BusinessVO;

import com.element.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/business")
@CrossOrigin
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    //获取所有商家信息
    @RequestMapping(value = "getAllBusiness", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAllBusiness(){
        List<BusinessVO> businessVOS=new ArrayList<>();
        for (Business business:businessService.getAllBusiness()){
            BusinessVO businessVO = new BusinessVO();

            businessVO.setBusinessId(business.getBusinessId());
            businessVO.setBusinessName(business.getBusinessName());
            businessVO.setBusinessExplain(business.getBusinessExplain());
            businessVO.setBusinessImg(business.getBusinessImg());
            businessVO.setStarPrice(business.getStarPrice());
            businessVO.setDeliveryPrice(business.getDeliveryPrice());
            businessVO.setRemarks(business.getRemarks());
            businessVOS.add(businessVO);
        }
        if (businessVOS.isEmpty()){
            JSONObject result = new JSONObject();
            result.put("status","failure");
            result.put("detail","还没有商家");
            return  result.toJSONString();
        }
        JSONObject result = new JSONObject();
        result.put("status","success");
        result.put("detail",businessVOS);
        return  result.toJSONString();
    }

    //根据商家所属类型获取商家列表信息
    @RequestMapping(value = "getBusinessByOrderTypeId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getBusinessByOrderTypeId(@RequestBody Business businessBO){
        int orderTypeId = businessBO.getOrderTypeId();
        System.out.println(orderTypeId);
        List<BusinessVO> businessVOS=new ArrayList<>();
        for (Business business:businessService.getBusinessByOrderTypeId(orderTypeId)){
            BusinessVO businessVO = new BusinessVO();
            businessVO.setBusinessId(business.getBusinessId());
            businessVO.setBusinessName(business.getBusinessName());
            businessVO.setBusinessExplain(business.getBusinessExplain());
            businessVO.setBusinessImg(business.getBusinessImg());
            businessVO.setStarPrice(business.getStarPrice());
            businessVO.setDeliveryPrice(business.getDeliveryPrice());
            businessVOS.add(businessVO);
        }
        if (businessVOS.isEmpty()){
            JSONObject result = new JSONObject();
            result.put("status","failure");
            result.put("detail","还没有商家");
            return  result.toJSONString();
        }
        JSONObject result = new JSONObject();
        result.put("status","success");
        result.put("detail",businessVOS);
        return  result.toJSONString();
    }

    /**
     * 获取商家的详情信息
     * @param businessId
     * @return businessService.getBusiness(businessId)
     */
    @GetMapping("/getBusiness/{id}")
    public String getBusinessDetail(@PathVariable("id") Integer businessId){
        JSONObject result = new JSONObject();
        result.put("status","success");
        result.put("detail",businessService.getBusiness(businessId));
        return result.toJSONString();
    }
}

package com.element.Controller;

import com.element.Entity.Business;
import com.element.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/getBusiness/{id}")
    public Map<Integer, Object> getBusiness(@PathVariable("id") Integer businessId){
        return businessService.getBusiness(businessId);
    }
}

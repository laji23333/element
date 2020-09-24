package com.element.Controller;

import com.alibaba.fastjson.JSONObject;
import com.element.Entity.po.Business;
import com.element.Entity.po.DeliveryAddress;
import com.element.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/getAllAddress")
    public String getAllAddress(){

        List<DeliveryAddress> address = addressService.getAllAddress();
        JSONObject result = new JSONObject();
        if (address.isEmpty()){
            result.put("status","failure");
            result.put("detail","暂无地址信息");
        }
        else {
            result.put("status","success");
            result.put("detail",address);
        }
        return  result.toJSONString();
    }


    @RequestMapping(value = "getAddressBydaId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAddressBydaId(@RequestBody DeliveryAddress addressBO){

        DeliveryAddress address = addressService.getAddressBydaId(addressBO.getDaId());
        JSONObject result = new JSONObject();
        if (address==null){
            result.put("status","failure");
            result.put("detail","暂无地址信息");
        }
        else {
            result.put("status","success");
            result.put("detail",address);
        }
        return  result.toJSONString();
    }

    @RequestMapping(value = "getAddressByuserId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAddressByuserId(@RequestBody DeliveryAddress addressBO){

        List<DeliveryAddress> address = addressService.getAddressByuserId(addressBO.getUserId());
        JSONObject result = new JSONObject();
        if (address.isEmpty()){
            result.put("status","failure");
            result.put("detail","暂无地址信息");
        }
        else {
            result.put("status","success");
            result.put("detail",address);
        }
        return  result.toJSONString();
    }


    @RequestMapping(value = "addAddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addAddress(@RequestBody DeliveryAddress addressBO){

        //判断id是否重复
        //DeliveryAddress repeat = addressService.getAddressBydaId(daId);
        JSONObject result = new JSONObject();
//        if(repeat != null){
//            result.put("status","failure");
//            result.put("detail","daId重复");
//            return  result.toJSONString();
//        }

        int insertres = addressService.addAddress(addressBO.getContactName(),addressBO.getContactSex(),addressBO.getContactTel(),addressBO.getAddress(),addressBO.getUserId());
        if (insertres == 0){
            result.put("status","failure");
            result.put("detail","保存失败");
        }
        else {
            result.put("status","success");
            List<DeliveryAddress> insertedadd = addressService.getAddressByuserId(addressBO.getUserId());
            //修改成功后 返回实体类
            result.put("detail",insertedadd);
        }
        return  result.toJSONString();
    }

    @RequestMapping(value = "updataAddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updataAddress(@RequestBody DeliveryAddress addressBO){
        int flag = addressService.updataAddress(addressBO.getDaId(),addressBO.getContactName(),addressBO.getContactSex(),addressBO.getContactTel(),addressBO.getAddress(),addressBO.getUserId());
        JSONObject result = new JSONObject();
        if (flag == 0){
            result.put("status","failure");
            result.put("detail","修改失败");
        }
        else {
            result.put("status","success");
            DeliveryAddress updataeddadd = addressService.getAddressBydaId(addressBO.getDaId());
            //修改成功后 返回实体类
            result.put("detail",updataeddadd);
        }
        return  result.toJSONString();
    }

    @RequestMapping(value = "deleteAddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String deleteAddress(@RequestBody DeliveryAddress addressBO){
        Integer daId = addressBO.getDaId();
        int flag = addressService.deleteAddress(daId);
        JSONObject result = new JSONObject();
        if (flag == 0){
            result.put("status","failure");
            result.put("detail","删除失败");
        }
        else {
            result.put("status","success");
            result.put("detail","删除成功");
        }
        return  result.toJSONString();
    }

}

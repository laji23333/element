package com.element.Controller;

import com.alibaba.fastjson.JSONObject;
import com.element.Entity.po.DeliveryAddress;
import com.element.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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


    @PostMapping("/getAddressBydaId")
    public String getAddressBydaId(@RequestParam("daId") Integer daId){

        DeliveryAddress address = addressService.getAddressBydaId(daId);
        JSONObject result = new JSONObject();
        if (address == null){
            result.put("status","failure");
            result.put("detail","暂无地址信息");
        }
        else {
            result.put("status","success");


            result.put("detail",address);
        }
        return  result.toJSONString();
    }


    @PostMapping("/addAddress")
    public String addAddress(@RequestParam("contactName") String contactName,
                             @RequestParam("contactSex") Integer contactSex,
                             @RequestParam("contactTel") String contactTel,
                             @RequestParam("address") String address,
                             @RequestParam("daId") Integer daId,
                             @RequestParam("userId") String userId){

        //判断id是否重复
        DeliveryAddress repeat = addressService.getAddressBydaId(daId);
        JSONObject result = new JSONObject();
        if(repeat != null){
            result.put("status","failure");
            result.put("detail","daId重复");
            return  result.toJSONString();
        }

        int insertres = addressService.addAddress(daId,contactName,contactSex,contactTel,address,userId);
        if (insertres == 0){
            result.put("status","failure");
            result.put("detail","保存失败");
        }
        else {
            result.put("status","success");
            DeliveryAddress insertedadd = addressService.getAddressBydaId(daId);
            //修改成功后 返回实体类
            result.put("detail",insertedadd);
        }
        return  result.toJSONString();
    }

    @PostMapping("/updataAddress")
    public String updataAddress(@RequestParam("contactName") String contactName,
                                @RequestParam("contactSex") Integer contactSex,
                                @RequestParam("contactTel") String contactTel,
                                @RequestParam("address") String address,
                                @RequestParam("daId") Integer daId,
                                @RequestParam("userId") String userId){
        int flag = addressService.updataAddress(daId,contactName,contactSex,contactTel,address,userId);
        JSONObject result = new JSONObject();
        if (flag == 0){
            result.put("status","failure");
            result.put("detail","修改失败");
        }
        else {
            result.put("status","success");
            DeliveryAddress updataeddadd = addressService.getAddressBydaId(daId);
            //修改成功后 返回实体类
            result.put("detail",updataeddadd);
        }
        return  result.toJSONString();
    }

    @PostMapping("/deleteAddress")
    public String deleteAddress(@RequestParam("daId") Integer daId){
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

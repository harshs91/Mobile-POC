package com.mobile.poc.controller;

import com.mobile.poc.entity.Mobile;
import com.mobile.poc.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/mobile")
public class MobileController {

    @Autowired
    MobileService mobileService;

    @PostMapping(path="")
    public Mobile addMobile(@RequestBody Mobile mobile){
        return mobileService.addMobile(mobile);
    }

    @GetMapping(path="/all")
    public Iterable<Mobile> getAllMobiles(){
        return mobileService.getAllMobiles();
    }

    @GetMapping(path="/{Id}")
    public Mobile getMobile(@PathVariable("Id") int Id){
        return mobileService.getMobile(Id);
    }

    @PutMapping(path="/{Id}")
    public Mobile updateMobile(@RequestBody Mobile updatedMobile, @PathVariable("Id") int Id){
        return mobileService.updateMobile(updatedMobile, Id);
    }
}

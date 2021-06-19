package com.mobile.poc.service;


import com.mobile.poc.entity.Mobile;
import com.mobile.poc.repo.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MobileService {

    @Autowired
    MobileRepo mobileRepo;

    public Mobile addMobile(@RequestBody Mobile mobile){
        return mobileRepo.save(mobile);
    }

    public Mobile getMobile(@PathVariable("Id") int Id){
        return mobileRepo.findById(Id).orElse(null);
    }

    public Iterable<Mobile> getAllMobiles(){
        return mobileRepo.findAll();
    }

    public Mobile updateMobile(@RequestBody Mobile updatedMobile, @PathVariable("Id") int Id) {
        return mobileRepo.findById(Id).map(mobile -> {
            mobile.setBrandName(updatedMobile.getBrandName());
            mobile.setModelName(updatedMobile.getModelName());
            return mobileRepo.save(mobile);
        }).orElseGet(() -> {
            return mobileRepo.save(updatedMobile);
        });
    }

}

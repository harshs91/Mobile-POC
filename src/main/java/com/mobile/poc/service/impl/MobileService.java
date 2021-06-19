package com.mobile.poc.service.impl;


import com.mobile.poc.entity.Mobile;
import com.mobile.poc.repo.MobileRepo;
import com.mobile.poc.service.interfaces.IMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService implements IMobileService {

    @Autowired
    MobileRepo mobileRepo;

    public Mobile addMobile(Mobile mobile){
        return mobileRepo.save(mobile);
    }

    public Mobile getMobile(int Id){
        return mobileRepo.findById(Id).orElse(null);
    }

    public Iterable<Mobile> getAllMobiles(){
        return mobileRepo.findAll();
    }

    public Mobile updateMobile(Mobile updatedMobile, int Id) {
        return mobileRepo.findById(Id).map(mobile -> {
            mobile.setBrandName(updatedMobile.getBrandName());
            mobile.setModelName(updatedMobile.getModelName());
            return mobileRepo.save(mobile);
        }).orElseGet(() -> {
            return mobileRepo.save(updatedMobile);
        });
    }

}

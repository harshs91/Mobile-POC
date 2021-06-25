package com.mobile.poc.service.impl;


import com.mobile.poc.entity.Mobile;
import com.mobile.poc.repo.MobileRepo;
import com.mobile.poc.service.interfaces.IMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class MobileService implements IMobileService {

    @Autowired
    MobileRepo mobileRepo;

    @Override
    public Mobile addMobile(Mobile mobile){
        return mobileRepo.save(mobile);
    }

    @Override
    public Mobile getMobile(int Id){
        return mobileRepo.findById(Id).orElse(null);
    }

    @Override
    public Iterable<Mobile> getAllMobiles(){
        return mobileRepo.findAll();
    }

    @Override
    public Mobile updateMobile(Mobile updatedMobile, int Id) {
        return mobileRepo.findById(Id).map(mobile -> {
            mobile.setBrandName(updatedMobile.getBrandName());
            mobile.setModelName(updatedMobile.getModelName());
            return mobileRepo.save(mobile);
        }).orElseGet(() -> {
            return mobileRepo.save(updatedMobile);
        });
    }

    //Below method is just an example for streams
    @Override
    public List<Mobile> getPhonesByBrand(String brandName) {
         return mobileRepo.findAll()
                 .stream().filter(mobile -> mobile.getBrandName().equals(brandName))
                 .collect(Collectors.toList());
    }

    @Override
    public Mobile patchMobile(Mobile patchedMobile, int Id){
        return mobileRepo.findById(Id).map(mobile -> {
            updateValue(mobile::setBrandName, patchedMobile.getBrandName());
            updateValue(mobile::setModelName, patchedMobile.getModelName());
            return mobileRepo.save(mobile);
        }).get();
    }

    //Partial update helper method
    private <T> void updateValue(Consumer<T> setterMethod, T value) {
        if (value != null){
            setterMethod.accept(value);
        }
    }

}

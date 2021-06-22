package com.mobile.poc.service.interfaces;

import com.mobile.poc.entity.Mobile;

import java.util.List;

public interface IMobileService {
    Mobile addMobile(Mobile mobile);
    Mobile getMobile(int Id);
    Iterable<Mobile> getAllMobiles();
    Mobile updateMobile(Mobile updatedMobile, int Id);
    List<Mobile> getPhonesByBrand(String brandName);
    Mobile patchMobile(Mobile patchedMobile, int Id);
}

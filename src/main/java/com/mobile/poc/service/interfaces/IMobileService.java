package com.mobile.poc.service.interfaces;

import com.mobile.poc.entity.Mobile;

public interface IMobileService {
    Mobile addMobile(Mobile mobile);
    Mobile getMobile(int Id);
    Iterable<Mobile> getAllMobiles();
    Mobile updateMobile(Mobile updatedMobile, int Id);
}

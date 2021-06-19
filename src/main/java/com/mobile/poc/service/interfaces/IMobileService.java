package com.mobile.poc.service.interfaces;

import com.mobile.poc.entity.Mobile;

public interface IMobileService {
    public Mobile addMobile(Mobile mobile);
    public Mobile getMobile(int Id);
    public Iterable<Mobile> getAllMobiles();
    public Mobile updateMobile(Mobile updatedMobile, int Id);
}

package com.mobile.poc.repo;

import com.mobile.poc.entity.Mobile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MobileRepo extends CrudRepository<Mobile, Integer> {
    List<Mobile> findAll();
}

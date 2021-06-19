package com.mobile.poc.repo;

import com.mobile.poc.entity.Mobile;
import org.springframework.data.repository.CrudRepository;

public interface MobileRepo extends CrudRepository<Mobile, Integer> {
}

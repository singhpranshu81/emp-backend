package com.mph.sprbootdemo.service;

import java.util.Optional;

import com.mph.sprbootdemo.entity.Suser;

public interface SuserService {
	 Optional<Suser> findByUsername(String username);
}

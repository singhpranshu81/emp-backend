package com.mph.sprbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mph.sprbootdemo.entity.Suser;
import com.mph.sprbootdemo.repository.SuserRepository;

@Service
public class SuserServiceImpl implements SuserService {
	@Autowired
	private SuserRepository suserRepository;

	public Optional<Suser> findByUsername(String username) {
		Optional<Suser> suser = suserRepository.findByUsername(username);
		if (suser.isPresent()) {
			return suser;
		} else {
			return null;
		}
	}
}
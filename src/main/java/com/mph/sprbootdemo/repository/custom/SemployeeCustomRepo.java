package com.mph.sprbootdemo.repository.custom;

import java.util.List;

import com.mph.sprbootdemo.entity.Semployee;

public interface SemployeeCustomRepo {
      public List<Semployee> findbylogic(String name);
}

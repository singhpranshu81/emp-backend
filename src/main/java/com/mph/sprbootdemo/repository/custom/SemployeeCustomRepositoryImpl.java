package com.mph.sprbootdemo.repository.custom;

import java.util.List;

import com.mph.sprbootdemo.entity.Semployee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class SemployeeCustomRepositoryImpl implements SemployeeCustomRepo{
      @PersistenceContext
      private EntityManager entityManager;
	
	@Override
	public List<Semployee> findbylogic(String name) {
		String jpql="select e from Semployee e where e.email= :param";
		TypedQuery<Semployee> qry  =entityManager.createQuery(jpql,Semployee.class);
		qry.setParameter("param", "%"+name+"%");
		return qry.getResultList();
	}

}

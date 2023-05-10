package com.worker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.worker.Repository.workerrepo;
import com.worker.entity.worker;


public interface workerService {

	public List<worker> getall();
	
	public worker getbyid(int id);
	
	public String delete(int id);
	
	public String upsert(worker worker);
}

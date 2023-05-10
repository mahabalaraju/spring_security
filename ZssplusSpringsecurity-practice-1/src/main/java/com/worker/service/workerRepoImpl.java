package com.worker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Repository.workerrepo;
import com.worker.entity.worker;
@Service
public class workerRepoImpl implements workerService{
@Autowired
private workerrepo workerrepo;
	@Override
	public List<worker> getall() {
		List<worker> getall= workerrepo.findAll();
		return getall;
	}

	@Override
	public worker getbyid(int id) {
		Optional<worker> getbyid=workerrepo.findById(id);
		if(getbyid.isPresent()) {
			return getbyid.get();
		}
		else
		return null;
	}

	@Override
	public String delete(int id) {
		if(workerrepo.existsById(id)) {
			workerrepo.deleteById(id);
			return "success:";
		}
		else
		return "element not found";
	}

	@Override
	public String upsert(worker worker) {
		workerrepo.save(worker);
		return "success";
	}

}

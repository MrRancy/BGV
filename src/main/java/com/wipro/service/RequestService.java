package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Request;
import com.wipro.entity.User;
import com.wipro.repository.RequestRepository;

@Service
public class RequestService {
	@Autowired
	private RequestRepository repo;

	public List<Request> listAll() {
		return repo.findAll();
	}

	public void save(Request product) {
		repo.save(product);
	}
	
	public Request get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Request> getValidData(List<Request> listRequests, User user) {
		List<Request> userRequestList = new ArrayList<Request>();
		listRequests.forEach(request -> {
			if (request.getRequestUser().iterator().next().getUsername().equalsIgnoreCase(user.getUsername())) {
				userRequestList.add(request);
			}
		});
		return userRequestList;
	}

}

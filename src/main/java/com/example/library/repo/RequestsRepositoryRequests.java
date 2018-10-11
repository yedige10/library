package com.example.library.repo;

import java.util.List;

import com.example.library.model.Requests;

public interface RequestsRepositoryRequests {
	public List<Requests> find(Long id);
	public List<Requests> findAllRequests();
	//public Requests updateR(Requests r);
	public List<Requests> findApproves();

	public List<Requests> findReturned();
}

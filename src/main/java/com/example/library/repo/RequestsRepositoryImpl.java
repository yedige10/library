package com.example.library.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.library.model.Requests;

public class RequestsRepositoryImpl implements RequestsRepositoryRequests {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Requests> find(Long id) {
		Query query = entityManager.createNativeQuery("select * from ((requests inner join book \r\n"
				+ "on requests.book_id=book.id) inner join user on\r\n" + "requests.user_id=user.id) where user_id=?",
				Requests.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Requests> findAllRequests() {
		Query query = entityManager.createNativeQuery(
				"select * from ((requests inner join book \r\n" + "on requests.book_id=book.id) inner join user on\r\n"
						+ "requests.user_id=user.id) where status='notapproved'",
				Requests.class);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Requests> findApproves() {
		Query query = entityManager.createNativeQuery(
				"select * from ((requests inner join book \r\n" + "on requests.book_id=book.id) inner join user on\r\n"
						+ "requests.user_id=user.id) where status='approve'",
				Requests.class);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Requests> findReturned() {
		Query query = entityManager.createNativeQuery(
				"select * from ((requests inner join book \r\n" + "on requests.book_id=book.id) inner join user on\r\n"
						+ "requests.user_id=user.id) where status='returned'",
				Requests.class);

		return query.getResultList();
	}
}

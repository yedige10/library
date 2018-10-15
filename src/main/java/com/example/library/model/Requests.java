
package com.example.library.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_id", insertable = false, updatable = false)
	private Long userId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
	private User user;

	@Column(name = "book_id", insertable = false, updatable = false)
	private Long bookId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "REQUESTS_TO_BOOK"))
	private Book book;

	@Column(name = "count")
	private long count;

	@Column(name = "status")
	private String status;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "return_date")
	private LocalDateTime returnDate;
}

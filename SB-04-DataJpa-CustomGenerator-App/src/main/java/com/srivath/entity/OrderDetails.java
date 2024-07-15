package com.srivath.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORD_DTLS")
public class OrderDetails {

	@Id
	@Column(name = "ORD_ID")
	@GeneratedValue(generator = "order_id_gen")
	@GenericGenerator(name = "order_id_gen", type = com.srivath.generator.OrderIdGenerator.class)
	private String orderId;

	@Column(name = "ORD_BY")
	private String orderBy;

	@CreationTimestamp
	@Column(name = "ORD_PLACED_DATE", updatable = false)
	private LocalDate orderPlacedDate;

}

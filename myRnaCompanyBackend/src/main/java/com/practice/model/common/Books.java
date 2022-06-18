/**
 * 
 */
package com.practice.model.common;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SAMEER KADGAYE
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "author" })
@Table(name = "tab_books")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookId")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	private String BookName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "authorId")
	//@JsonIgnore
	//@JsonManagedReference
	//@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Author author;

}

package org.xworkz.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "movie_review1")
public class MovieReviewDTO implements Serializable {
	
	@Id
	@GenericGenerator(name = "movie", strategy = "increment")
	@GeneratedValue(generator = "movie")
	@Column(name = "movie_id")
	private int id;
	@Column(name = "movie_name")
	private String name;
	@Column(name = "movie_language")
	private String language;
	@Column(name = "movie_budget")
	private long budget;
	@Column(name = "movie_rating")
	private int rating;
	@Column(name = "movie_recommanding")
	private boolean recommanding;
	
	
	
	
	public MovieReviewDTO() {
		super();
		
		System.out.println("created" + this.getClass().getName());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getBudget() {
		return budget;
	}
	public void setBudget(long budget) {
		this.budget = budget;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isRecommanding() {
		return recommanding;
	}
	public void setRecommanding(boolean recommanding) {
		this.recommanding = recommanding;
	}

	@Override
	public String toString() {
		return "MovieReviewDTO [id=" + id + ", name=" + name + ", language=" + language + ", budget=" + budget
				+ ", rating=" + rating + ", recommanding=" + recommanding + "]";
	}

}

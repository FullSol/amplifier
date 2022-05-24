package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "img_posts")
@Data
@ApiModel(value = "ImgPost", description = "This model serves as the basic model for all img post entity API operations.")
public class ImgPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any img post entity.", required = true, value = "1")
	private int id;

	@Column(name = "img_location", unique = true, nullable = false)
	@ApiModelProperty(name = "img_location", notes = "A string value URL to the img post.", required = true)
	private String img_location;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", unique = true)
	private User user;

	public ImgPost() {
	}

	public ImgPost(String img_location, int id, User user) {
		super();
		this.img_location = img_location;
		this.id = id;
		this.user = user;
	}

	public ImgPost(String img_location, User user) {
		super();
		this.img_location = img_location;
		this.user = user;
	}

	public ImgPost(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ImgPost [id=" + id + ", img_location=" + img_location + ", author_id=" + user + "]";
	}
	
	


}

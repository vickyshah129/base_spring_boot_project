package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "permission")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Permission implements java.io.Serializable {
	@Id
	private Long id;
	private String title;
	private String name;
	private String description;
	private Boolean enabled;
	private Boolean archived;
	private Long createdBy;
	private Date dateCreation;
	private Date dateArchive;
	private Date dateUpdate;

}

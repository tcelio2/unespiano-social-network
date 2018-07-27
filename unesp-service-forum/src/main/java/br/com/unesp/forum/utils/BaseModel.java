package br.com.unesp.forum.utils;

import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Where(clause = "DELETADO = '0'")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"new", "deleted"}, ignoreUnknown = true)
public abstract class BaseModel implements Persistable<Long> {

	  private static final long serialVersionUID = -5760141302531380288L;

	  @Column(name = "DATA_CRIACAO", updatable = false)
	  @CreatedDate
	  @JsonView(JsonProfile.ExpandedView.class)
	  private ZonedDateTime creationDate;

	  @Column(name = "DATA_ALTERACAO")
	  @LastModifiedDate
	  @JsonView(JsonProfile.ExpandedView.class)
	  private ZonedDateTime modifiedDate;

	  @Column(name = "MODIFICADO_POR")
	  @LastModifiedBy
	  @JsonView(JsonProfile.ExpandedView.class)
	  private String modifiedBy;

	  @Column(name = "CRIADO_POR")
	  @CreatedBy
	  @JsonView(JsonProfile.ExpandedView.class)
	  private String createdBy;

	  @Column(name = "DELETADO", nullable = false)
	  @JsonView(JsonProfile.ExpandedView.class)
	  private Boolean deleted = false;

	  public String getCreatedBy() {
	    return createdBy;
	  }

	  public void setCreatedBy(String createdBy) {
	    this.createdBy = createdBy;
	  }

	  public String getModifiedBy() {
	    return modifiedBy;
	  }

	  public void setModifiedBy(String modifiedBy) {
	    this.modifiedBy = modifiedBy;
	  }

	  @Override
	  public abstract Long getId();

	  public abstract void setId(Long id);

	  public Boolean isDeleted() {
	    return this.deleted;
	  }

	  public void setDeleted(Boolean deleted) {
	    this.deleted = deleted;
	  }

	  public ZonedDateTime getCreationDate() {
	    return creationDate;
	  }

	  public void setCreationDate(ZonedDateTime creationDate) {
	    this.creationDate = creationDate;
	  }

	  public ZonedDateTime getModifiedDate() {
	    return modifiedDate;
	  }

	  public void setModifiedDate(ZonedDateTime modifiedDate) {
	    this.modifiedDate = modifiedDate;
	  }

	  @Override
	  public boolean isNew() {
	    return Objects.isNull(this.getId());
	  }

	  @Transient
	  public Boolean getDeleted() {
	    return this.isDeleted();
	  }

	  @Transient
	  public String[] ignoredFields() {
	    return new String[0];
	  }
	}
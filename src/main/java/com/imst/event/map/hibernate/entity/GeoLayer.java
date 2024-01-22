package com.imst.event.map.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GeoLayer generated by hbm2java
 */
@Entity
@Table(name = "geo_layer", schema = "public")
public class GeoLayer implements java.io.Serializable {

	private Integer id;
	private Layer layer;
	private String name;
	private String data;
	private Timestamp createDate;
	private Boolean state;

	public GeoLayer() {
	}

	public GeoLayer(Layer layer, String name, String data) {
		this.layer = layer;
		this.name = name;
		this.data = data;
	}

	public GeoLayer(Layer layer, String name, String data, Timestamp createDate, Boolean state) {
		this.layer = layer;
		this.name = name;
		this.data = data;
		this.createDate = createDate;
		this.state = state;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_layer_id", nullable = false)
	public Layer getLayer() {
		return this.layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "data", nullable = false)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "create_date", length = 29)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "state")
	@org.hibernate.annotations.ColumnDefault("true")
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}

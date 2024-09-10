package tfm.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the vent_details database table.
 * 
 */
@Entity
@Table(name = "vent_details", schema = "public", catalog = "defaultdb")
@NamedQuery(name = "VentDetail.findAll", query = "SELECT v FROM VentDetail v")
public class VentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vent_detail")
	private Integer idVentDetail;

	private Integer amount;

	private Boolean iva;

	private BigDecimal subtotal;

	private BigDecimal total;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	// bi-directional many-to-one association to VentCab
	@ManyToOne
	@JoinColumn(name = "id_vent_cab")
	private VentCab ventCab;

	public VentDetail() {
	}

	public Integer getIdVentDetail() {
		return this.idVentDetail;
	}

	public void setIdVentDetail(Integer idVentDetail) {
		this.idVentDetail = idVentDetail;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Boolean getIva() {
		return this.iva;
	}

	public void setIva(Boolean iva) {
		this.iva = iva;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public VentCab getVentCab() {
		return this.ventCab;
	}

	public void setVentCab(VentCab ventCab) {
		this.ventCab = ventCab;
	}

}
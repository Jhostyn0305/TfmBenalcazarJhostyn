package tfm.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the vent_cabs database table.
 * 
 */
@Entity
@Table(name = "vent_cabs", schema = "public", catalog = "defaultdb")
@NamedQuery(name = "VentCab.findAll", query = "SELECT v FROM VentCab v")
public class VentCab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vent_cab")
	private Integer idVentCab;

	private BigDecimal subtotal;

	private BigDecimal total;

	@Temporal(TemporalType.DATE)
	@Column(name = "vent_date")
	private Date ventDate;

	// bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Client client;

	// bi-directional many-to-one association to VentDetail
	@OneToMany(mappedBy = "ventCab")
	private List<VentDetail> ventDetails;

	public VentCab() {
	}

	public Integer getIdVentCab() {
		return this.idVentCab;
	}

	public void setIdVentCab(Integer idVentCab) {
		this.idVentCab = idVentCab;
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

	public Date getVentDate() {
		return this.ventDate;
	}

	public void setVentDate(Date ventDate) {
		this.ventDate = ventDate;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<VentDetail> getVentDetails() {
		return this.ventDetails;
	}

	public void setVentDetails(List<VentDetail> ventDetails) {
		this.ventDetails = ventDetails;
	}

	public VentDetail addVentDetail(VentDetail ventDetail) {
		getVentDetails().add(ventDetail);
		ventDetail.setVentCab(this);

		return ventDetail;
	}

	public VentDetail removeVentDetail(VentDetail ventDetail) {
		getVentDetails().remove(ventDetail);
		ventDetail.setVentCab(null);

		return ventDetail;
	}

}
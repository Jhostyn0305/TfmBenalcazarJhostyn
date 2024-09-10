package tfm.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name = "clients", schema = "public", catalog = "defaultdb") 
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer idUser;

	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;

	private String email;

	@Column(name = "full_name")
	private String fullName;

	private String identification;

	private String phone;

	// bi-directional many-to-one association to VentCab
	@OneToMany(mappedBy = "client")
	private List<VentCab> ventCabs;

	public Client() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<VentCab> getVentCabs() {
		return this.ventCabs;
	}

	public void setVentCabs(List<VentCab> ventCabs) {
		this.ventCabs = ventCabs;
	}

	public VentCab addVentCab(VentCab ventCab) {
		getVentCabs().add(ventCab);
		ventCab.setClient(this);

		return ventCab;
	}

	public VentCab removeVentCab(VentCab ventCab) {
		getVentCabs().remove(ventCab);
		ventCab.setClient(null);

		return ventCab;
	}

}
package tfm.core.view.controller.modules.vent;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import tfm.model.client.managers.ManagerClient;
import tfm.model.core.entities.Client;
import tfm.model.core.entities.Product;
import tfm.model.product.manager.ManagerProduct;

@Named
@SessionScoped
public class BeanStore implements Serializable {
	private static final long serialVersionUID = 1L; // Añadir un serialVersionUID

	@EJB
	private ManagerClient mClient; // Marcar como 'transient'
	@EJB
	private ManagerProduct mProduct; // Marcar como 'transient'

	private List<Client> lstClients;
	private List<Product> lstProduct;
	private List<Category> lstCategories;

	public BeanStore() {

	}

	@PostConstruct
	public void construct() {
		lstClients = mClient.findAllClients();
		lstProduct = mProduct.findAllProducts();
		lstCategories = mProduct.findAllCategories();
	}

	public List<Client> getLstClients() {
		return lstClients;
	}

	public void setLstClients(List<Client> lstClients) {
		this.lstClients = lstClients;
	}

	public List<Product> getLstProduct() {
		return lstProduct;
	}

	public void setLstProduct(List<Product> lstProduct) {
		this.lstProduct = lstProduct;
	}

	public List<Category> getLstCategories() {
		return lstCategories;
	}

	public void setLstCategories(List<Category> lstCategories) {
		this.lstCategories = lstCategories;
	}

}

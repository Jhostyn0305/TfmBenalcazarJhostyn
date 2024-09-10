package tfm.model.product.manager;

import java.util.List;
import java.util.Locale.Category;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tfm.model.core.entities.Product;
import tfm.model.core.managers.ManagerDAO;

@Stateless
@LocalBean
public class ManagerProduct {

	@PersistenceContext
	private EntityManager em;
	@EJB
	private ManagerDAO mDAO;

	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		return mDAO.findAll(Product.class);
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAllCategories() {
		return mDAO.findAll(Category.class);
	}

}

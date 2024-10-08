package tfm.model.client.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tfm.model.core.entities.Client;
import tfm.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerCliente
 */
@Stateless
@LocalBean
public class ManagerClient {
	@PersistenceContext
	private EntityManager em;
	@EJB
	private ManagerDAO mDAO;

	@SuppressWarnings("unchecked")
	public List<Client> findAllClients() {
		return mDAO.findAll(Client.class);
	}
}

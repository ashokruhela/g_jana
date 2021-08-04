package in.gurujana.standalone.dao;


import java.util.List;

import in.gurujana.standalone.model.Client;
import in.gurujana.standalone.model.Email;

public interface ClientDao {
	
	public List<Client> getClients(Email email);
	
	public Client setClientForEmail(Email email) ;
}

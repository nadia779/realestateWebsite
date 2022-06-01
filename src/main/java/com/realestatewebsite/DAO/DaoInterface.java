package com.realestatewebsite.DAO;
import java.util.List;

public interface DaoInterface<T> {
	public void ajouter(T object);
	public void supprimer(T object);
	public void modifier(T object,T newobject);
	public List<T> afficherAll();
}





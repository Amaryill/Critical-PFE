package fr.eseo.criticalPfe.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {

	public T creer(T obj);

	public boolean supprimer(T obj);

	public T trouver(T obj);

	public T modifier (T obj);

	public T map(ResultSet result) throws SQLException;
}

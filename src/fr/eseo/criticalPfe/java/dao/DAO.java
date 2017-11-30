package fr.eseo.criticalPfe.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO<T> {

	public abstract boolean creer(T obj);

	public abstract boolean supprimer(T obj);

	public abstract T trouver(T obj);

	public abstract boolean modifier (T newObj, T oldObj);

	public abstract T map(ResultSet result) throws SQLException;
}

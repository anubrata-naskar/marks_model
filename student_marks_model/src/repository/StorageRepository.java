package repository;

import java.sql.SQLException;

import transferobjects.*;

interface StorageRepository {
	public String addDeltails();
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException;
}

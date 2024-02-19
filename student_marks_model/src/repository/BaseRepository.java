package repository;

import java.sql.SQLException;
import java.util.ArrayList;

import transferobjects.Student;

public abstract class BaseRepository {
	protected StorageRepository storage;
	protected BaseRepository(StorageRepository storage) {
		this.storage = storage;
	}
	public abstract void storeMarks(ArrayList<String> a);
	public abstract Student getAllDetails(String coll, String cate, int number, String section) throws SQLException;
}

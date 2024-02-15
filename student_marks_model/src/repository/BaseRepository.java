package repository;

import java.util.ArrayList;

public abstract class BaseRepository {
	protected StorageRepository storage;
	protected BaseRepository(StorageRepository storage) {
		this.storage = storage;
	}
	public abstract void storeMarks(ArrayList<String> a);
	public abstract String getAllDetails(String coll, String cate, int number, String section);
}

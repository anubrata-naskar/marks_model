package repository;

import java.util.ArrayList;

public class MarksRepository extends BaseRepository{
	public MarksRepository(StorageRepository storage) {
		super(storage);
	}
	public void storeMarks(ArrayList<String> myArrayList) {
		String str = storage.addDeltails();
		System.out.println(str);
	}
	public String getAllDetails(String coll, String cate, int number, String section) {
		String str = storage.getAllDetails(coll, cate, number, section);
		return str;
	}
}

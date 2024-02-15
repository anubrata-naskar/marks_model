package repository;

public class MySQLRepository implements StorageRepository{
	public String addDeltails() {
		String str = "add details";
		return str;
	}
	public String getAllDetails(String coll, String cate, int number, String section) {
	    String sec = section.toLowerCase();
	    String str = "SELECT * FROM `" + sec + "` WHERE `coll` LIKE '" + coll + "' AND `cate` LIKE '" + cate + "' AND `number` = " + number;
	    return str;
	}
//	public static void main(String args[]) {
//		String str = getAllDetails("T91","CSE",214031,"B.TECH.(COMPUTER SCIENCE & ENGINEERING) SEM V 2023");
//		System.out.println(str);
//	}
}

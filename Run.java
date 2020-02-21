package work_test;

import java.io.File;
//import java.util.List;

public class Run {
	public static void main(String[] args) {
		AddressBook book = new AddressBook(new File("通信录管理系统.txt"));
//		List<Person> list = book.getpersonLsit();
//		list.add(new Person("阿中","86960470","CN"));
		book.work();
	}
}

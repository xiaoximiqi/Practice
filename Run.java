package work_test;

import java.io.File;
//import java.util.List;

public class Run {
	public static void main(String[] args) {
		AddressBook book = new AddressBook(new File("ͨ��¼����ϵͳ.txt"));
//		List<Person> list = book.getpersonLsit();
//		list.add(new Person("����","86960470","CN"));
		book.work();
	}
}

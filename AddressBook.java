package work_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	private List<Person>personList;
	private File f;
	public AddressBook(File f) {
		personList = new ArrayList<Person>();
		this.f = f;
		//如果传入文件不存在就新建传入文件
		if(!this.f.exists()) {
			try {
				this.f.createNewFile();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Person> getpersonLsit(){
		return personList;
	}
	//读取指定文件
	public void getListFromFile() {
		try {
				FileReader fr = new FileReader(this.f);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				//循环读取
				while(true) {
					//读取每一行数据，存放到字符串中
					line = br.readLine();
				if(line!=null) {
					//分割每一行数据
					String[] split = line.split("\\|");
					//将数据封装成对象，添加到集合中
					Person person = new Person(split[0],split[1],split[2]);
					this.personList.add(person);
				}else {
					break;
				}
				fr.close();
				br.close();
				}
			}
				catch(Exception e) {
//					System.out.println("新建文件！");
			}
		}
	//写入指定文件
	public void writerFileFromList() {
		try {
				FileWriter fw = new FileWriter(this.f);
				for(Person son:this.personList) {
					String line = "姓名:"+son.getName()+";"+
								  "电话号码:"+son.getNumber()+";"+
								  "单位:"+son.getUnit()+"\n";
					fw.write(line);
				}
					fw.flush();
					fw.close();
			}
				catch(IOException e) {
					e.printStackTrace();
				}
		}
		
	public void work() {
		getListFromFile();
		System.out.println("通信录管理系统"+
						   "\n<1>添加联系人信息"+
						   "\n<2>删除联系人信息"+
				           "\n<3>修改联系人信息"+
		                   "\n<4>查询联系人信息"+
		                   "\n<5>显示全部联系人信息"+
						   "\n<0>退出");
		Scanner sc = new Scanner(System.in);
		out:while(true) {
			System.out.print("你想干嘛：");
			String code = sc.next();
			switch(code) {
			case "1":
				addPerson(sc);
				break;
			case "2":
				deletePerson(sc);
				break;
			case "3":
				modifyPerson(sc);
				break;
			case "4":
				selectPerson(sc);
				break;
			case "5":
				printPerson();
				break;
			case "0":
				writerFileFromList();
				break out;
			default:
				break;
			}
		}
	}
	//显示全部联系人信息
	public void printPerson() {
		System.out.println("-----联系人信息-----");
		for(int i=0;i<personList.size();i++) {
			System.out.println(personList.get(i));
		}
	}
	//查询联系人信息
	public void selectPerson(Scanner sc) {
		System.out.print("请输入联系人的姓名：");
		String spname = sc.next();
		boolean spflag = true;
		for(int i=0;i<personList.size();i++) {
			Person person = personList.get(i);
			if(person.getName().equals(spname)) {
				System.out.println(person);
				spflag = false;
				break;
			}
		}
		if(spflag) {
			System.out.println("没有这个人！");
		}
	}
	//修改联系人信息
	public void modifyPerson(Scanner sc) {
		System.out.print("你想修改谁的信息：");
		String mpname = sc.next();
		boolean mpflag = true;
		for(int i=0;i<personList.size();i++) {
			Person person = personList.get(i);
			if(person.getName().equals(mpname)) {
				System.out.print("修改后联系人姓名：");
				String name = sc.next();
				person.setName(name);
				System.out.print("修改后联系人电话号码：");
				String mnumber = sc.next();
				person.setNumber(mnumber);
				System.out.print("修改后联系人单位：");
				String unit = sc.next();
				person.setUnit(unit);
				System.out.println("修改成功！");
				mpflag = false;
				break;
			}
		}
		if(mpflag) {
			System.out.println("修改失败！");
		}
	}
	//删除联系人信息
	public void deletePerson(Scanner sc) {
		System.out.print("你想删除谁的信息：");
		String dpname = sc.next();
		boolean dpflag = true;
		for(int i=0;i<personList.size();i++) {
			Person person = personList.get(i);
			if(person.getName().equals(dpname)) {
				personList.remove(person);
				System.out.println("删除成功！");
				dpflag = false;
				break;
			}
		}
		if(dpflag) {
			System.out.println("删除失败！");
		}
	}
	//添加联系人信息
	public void addPerson(Scanner sc) {
		System.out.print("请输入联系人姓名：");
		String adname = sc.next();
		boolean adflag = true;
		for(int i=0;i<personList.size();i++) {
			Person ps = personList.get(i);
			if(ps.getName().equals(adname)) {
				adflag = false;
				System.out.print("已经有这个人了！");
				break;
			}
		}
		if(adflag) {
			System.out.print("请输入电话号码：");
			String adnumber = sc.next();
			System.out.print("请输入单位：");
			String adunit = sc.next();
			Person person = new Person(adname,adnumber,adunit);
			personList.add(person);
		}
	}
}

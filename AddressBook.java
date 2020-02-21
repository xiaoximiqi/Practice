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
		//��������ļ������ھ��½������ļ�
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
	//��ȡָ���ļ�
	public void getListFromFile() {
		try {
				FileReader fr = new FileReader(this.f);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				//ѭ����ȡ
				while(true) {
					//��ȡÿһ�����ݣ���ŵ��ַ�����
					line = br.readLine();
				if(line!=null) {
					//�ָ�ÿһ������
					String[] split = line.split("\\|");
					//�����ݷ�װ�ɶ�����ӵ�������
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
//					System.out.println("�½��ļ���");
			}
		}
	//д��ָ���ļ�
	public void writerFileFromList() {
		try {
				FileWriter fw = new FileWriter(this.f);
				for(Person son:this.personList) {
					String line = "����:"+son.getName()+";"+
								  "�绰����:"+son.getNumber()+";"+
								  "��λ:"+son.getUnit()+"\n";
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
		System.out.println("ͨ��¼����ϵͳ"+
						   "\n<1>�����ϵ����Ϣ"+
						   "\n<2>ɾ����ϵ����Ϣ"+
				           "\n<3>�޸���ϵ����Ϣ"+
		                   "\n<4>��ѯ��ϵ����Ϣ"+
		                   "\n<5>��ʾȫ����ϵ����Ϣ"+
						   "\n<0>�˳�");
		Scanner sc = new Scanner(System.in);
		out:while(true) {
			System.out.print("������");
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
	//��ʾȫ����ϵ����Ϣ
	public void printPerson() {
		System.out.println("-----��ϵ����Ϣ-----");
		for(int i=0;i<personList.size();i++) {
			System.out.println(personList.get(i));
		}
	}
	//��ѯ��ϵ����Ϣ
	public void selectPerson(Scanner sc) {
		System.out.print("��������ϵ�˵�������");
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
			System.out.println("û������ˣ�");
		}
	}
	//�޸���ϵ����Ϣ
	public void modifyPerson(Scanner sc) {
		System.out.print("�����޸�˭����Ϣ��");
		String mpname = sc.next();
		boolean mpflag = true;
		for(int i=0;i<personList.size();i++) {
			Person person = personList.get(i);
			if(person.getName().equals(mpname)) {
				System.out.print("�޸ĺ���ϵ��������");
				String name = sc.next();
				person.setName(name);
				System.out.print("�޸ĺ���ϵ�˵绰���룺");
				String mnumber = sc.next();
				person.setNumber(mnumber);
				System.out.print("�޸ĺ���ϵ�˵�λ��");
				String unit = sc.next();
				person.setUnit(unit);
				System.out.println("�޸ĳɹ���");
				mpflag = false;
				break;
			}
		}
		if(mpflag) {
			System.out.println("�޸�ʧ�ܣ�");
		}
	}
	//ɾ����ϵ����Ϣ
	public void deletePerson(Scanner sc) {
		System.out.print("����ɾ��˭����Ϣ��");
		String dpname = sc.next();
		boolean dpflag = true;
		for(int i=0;i<personList.size();i++) {
			Person person = personList.get(i);
			if(person.getName().equals(dpname)) {
				personList.remove(person);
				System.out.println("ɾ���ɹ���");
				dpflag = false;
				break;
			}
		}
		if(dpflag) {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}
	//�����ϵ����Ϣ
	public void addPerson(Scanner sc) {
		System.out.print("��������ϵ��������");
		String adname = sc.next();
		boolean adflag = true;
		for(int i=0;i<personList.size();i++) {
			Person ps = personList.get(i);
			if(ps.getName().equals(adname)) {
				adflag = false;
				System.out.print("�Ѿ���������ˣ�");
				break;
			}
		}
		if(adflag) {
			System.out.print("������绰���룺");
			String adnumber = sc.next();
			System.out.print("�����뵥λ��");
			String adunit = sc.next();
			Person person = new Person(adname,adnumber,adunit);
			personList.add(person);
		}
	}
}

package work_test;

public class Person {
	private String name;
	private String number;
	private String unit;
	public Person(String name,String number,String unit) {
		this.name = name;
		this.number = number;
		this.unit = unit;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "姓名："+name+"\t电话号码："+number+"\t单位："+unit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime*result+((name==null)?0:name.hashCode());
		result = prime*result+((number==null)?0:number.hashCode());
		result = prime*result+((unit==null)?0:unit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Person other = (Person) obj;
		if(name==null) {
			if(other.name!=null)
				return false;
		}else if(!name.equals(other.name))
			return false;
		if(number==null) {
			if(other.number!=null)
				return false;
		}else if(!number.equals(other.number))
			return false;
		if(unit==null) {
			if(other.unit!=null)
				return false;
		}else if(!unit.equals(other.unit))
			return false;
		return true;
	}
}

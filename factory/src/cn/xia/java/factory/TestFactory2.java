package cn.xia.java.factory;

interface Fruit {
	public abstract String eat();
}

class Apple implements Fruit {
	public String eat() {
		return "³ÔÆ»¹û";
	}
}

class Orange implements Fruit {
	public String eat() {
		return "³ÔéÙ×Ó";
	}
}

class Factory {
	public static Fruit getInstance(String name) {
		if ("apple".equals(name)) {
			return new Apple();
		} else if("orange".equals(name)) {
			return new Orange();
		} else {
			return null;
		}
	}
}

public class TestFactory2 {
	public static void main(String[] args) {
		Fruit f = Factory.getInstance(args[0]);
		if(f != null) {
			System.out.println(f.eat());
		}
	}
}

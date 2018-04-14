package cn.xia.java.factory;

import cn.xia.java.link.Link;

interface Goods {
	public abstract String getName();
	public abstract double getPrice();
}

class Computer implements Goods {
	private String name;
	private double price;
	public Computer() {}
	public Computer(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public String toString() {
		return "【电脑信息】名称：" + this.name + "，价格：" + this.price;
	}
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Computer)) {
			return false;
		}
		Computer com = (Computer)obj;
		if (this.name.equals(com.name)
				&& this.price == com.price) {
			return true;
		}
		return false;
	}
}

class Cup implements Goods {
	private String name;
	private double price;
	public Cup() {}
	public Cup(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public String toString() {
		return "【杯子信息】名称：" + this.name + "，价格：" + this.price;
	}
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cup)) {
			return false;
		}
		Cup cup = (Cup)obj;
		if (this.name.equals(cup.name)
				&& this.price == cup.price) {
			return true;
		}
		return false;
	}
}

class SuperMarket {
	private Link goods;
	public SuperMarket() {
		this.goods = new Link();
	}
	public Link getGoods() {
		return this.goods;
	}
	public void add(Goods g) {
		this.goods.add(g);
	}
	public void delete(Goods g) {
		this.goods.remove(g);
	}
	public Link search(String keyWord) {
		Link result = new Link();
		Object obj[] = this.goods.toArray();
		for(int x = 0; x < obj.length; x++) {
			Goods g = (Goods)obj[x];
			if (g.getName().contains(keyWord)) {
				result.add(obj[x]);
			}
		}
		return result;
	}
}

public class TestFactory {

	public static void main(String[] args) {
		SuperMarket sm = new SuperMarket();
		sm.add(new Cup("卡通杯", 28.0));
		sm.add(new Computer("苹果电脑", 12000.0));
		sm.add(new Computer("卡通电脑", 5000.0));
		sm.add(new Cup("卡通杯", 28.0));
		sm.add(new Computer("苹果电脑", 12000.0));
		sm.delete(new Computer("苹果电脑", 12000.0));
		
		Object result[] = sm.search("卡通").toArray();
		for(int x = 0; x < result.length; x++) {
			System.out.println(result[x]);
		}
	}
}

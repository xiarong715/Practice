package cn.xia.java.usb;

abstract interface Usb {
	public abstract void work();
	public abstract void exit();
}

class Flash implements Usb {
	public void work() {
		System.out.println("Flash work");
	}
	public void exit() {
		System.out.println("Flash exit");
	}
}

class HardDisk implements Usb {
	public void work() {
		System.out.println("Hard Disk work");
	}
	public void exit() {
		System.out.println("Hard Disk exit");
	}
}

class Computer {
	public void plugin(Usb usb) {
		usb.work();
		usb.exit();
	}
}

public class UsbTest {
	public static void main(String args[]) {
		Computer computer = new Computer();
		computer.plugin(new Flash());
		computer.plugin(new HardDisk());
	}
}

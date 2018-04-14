package cn.xia.java.delegate;

abstract interface Network {
	public abstract void browse(String url);
}

class RealNetwork implements Network {
	public void browse(String url) {
		System.out.println("�����ҳ" + url);
	}
}

class DelegateNetwork implements Network {
	private RealNetwork realNetwork;
	public DelegateNetwork(RealNetwork realNetwork) {
		this.realNetwork = realNetwork;
	}
	public boolean check(String url) {
		if (url.contains("����")) {
			return false;
		}
		return true;
	}
	public void record(String url) {
		System.out.println("�����¼" + url);
	}
	public void browse(String url) {
		if (check(url)) {
			realNetwork.browse(url);
		}
		record(url);
	}
}

public class TestDelegate {

	public static void main(String[] args) {
		DelegateNetwork delegateNetwork = new DelegateNetwork(new RealNetwork());
		delegateNetwork.browse("www.���˵�Ӱ.com");
		delegateNetwork.browse("www.��̫��.com");
	}

}

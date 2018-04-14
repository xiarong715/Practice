package cn.xia.java.delegate;

abstract interface Network {
	public abstract void browse(String url);
}

class RealNetwork implements Network {
	public void browse(String url) {
		System.out.println("浏览网页" + url);
	}
}

class DelegateNetwork implements Network {
	private RealNetwork realNetwork;
	public DelegateNetwork(RealNetwork realNetwork) {
		this.realNetwork = realNetwork;
	}
	public boolean check(String url) {
		if (url.contains("成人")) {
			return false;
		}
		return true;
	}
	public void record(String url) {
		System.out.println("浏览记录" + url);
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
		delegateNetwork.browse("www.成人电影.com");
		delegateNetwork.browse("www.灰太狼.com");
	}

}

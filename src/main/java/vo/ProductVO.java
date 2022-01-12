package vo;

public class ProductVO {
	private int apple_cnt;
	private int banana_cnt;
	private int hanra_cnt;
	public int getApple_cnt() {
		return apple_cnt;
	}
	public void setApple_cnt(int apple_cnt) {
		this.apple_cnt += apple_cnt;
	}
	public int getBanana_cnt() {
		return banana_cnt;
	}
	public void setBanana_cnt(int banana_cnt) {
		this.banana_cnt += banana_cnt;
	}
	public int getHanra_cnt() {
		return hanra_cnt;
	}
	public void setHanra_cnt(int hanra_cnt) {
		this.hanra_cnt = hanra_cnt;
	}
}

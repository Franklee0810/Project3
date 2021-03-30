package bean;

public class Ad { 
	private int no;
	private String title;
	private String created_at; // 일부로 String으로 함 
	private int read_at;
	private String ad_type;
	private String image;
	private String thumbImg;
	
	 
	public Ad() {};
	
	
	public Ad(int no, String title, String created_at, int read_at, String ad_type, String image, String thumbImg) {
		super();
		this.no = no;
		this.title = title;
		this.created_at = created_at;
		this.read_at = read_at;
		this.ad_type = ad_type;
		this.image = image;
		this.thumbImg = thumbImg;
	}
	@Override
	public String toString() {
		return "Ad [no=" + no + ", title=" + title + ", created_at=" + created_at + ", read_at=" + read_at
				+ ", ad_type=" + ad_type + ", image=" + image + ", thumbImg=" + thumbImg + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getRead_at() {
		return read_at;
	}
	public void setRead_at(int read_at) {
		this.read_at = read_at;
	}
	public String getAd_type() {
		return ad_type;
	}
	public void setAd_type(String ad_type) {
		this.ad_type = ad_type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getThumbImg() {
		return thumbImg;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
 
	
	
}

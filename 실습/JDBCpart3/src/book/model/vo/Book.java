package book.model.vo;

public class Book {
	private int bid; // 도서 아이디
	private String title; // 도서명
	private String author; // 작가명
	private String pub; // 출판사명
	private String pubDate; // 출판일
	private int price; // 가격
	
	// 기본 생성자
	public Book() {}

	// 매개변수 있는 생성자(bid 제외)
	public Book(String title, String author, String pub, String pubDate, int price) {
		super();
		this.title = title;
		this.author = author;
		this.pub = pub;
		this.pubDate = pubDate;
		this.price = price;
	}

	// getter and setter
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 필드 확인용 toString Overriding
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", pub=" + pub + ", pubDate=" + pubDate
				+ ", price=" + price + "]";
	}
	
}

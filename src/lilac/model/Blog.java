package lilac.model;

import java.util.List;

public class Blog {
	private String url;

	private List<Board> boards;

	public Blog(String url) {
		super();
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		return "Shop [url=" + url + "]";
	}
}

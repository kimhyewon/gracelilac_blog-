package lilac.service;

import java.util.List;

import lilac.dao.ArticleDao;
import lilac.dao.BlogDao;
import lilac.dao.BoardDao;
import lilac.model.Article;
import lilac.model.Blog;
import lilac.model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogService {
//	@Autowired
//	private BlogDao blogDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private ArticleDao articleDao;
	
	
//	public Blog getBlogByUrl(String url, String userId) {
//		Blog blog = getBlogByUrl(url);
//		
//		return blog;
//	}
//
//	public Blog getBlogByUrl(String url) {
//		Blog blog = blogDao.selectByUrl(url);
//		blog.setBoards(boardDao.selectAllByUrl(blog.getUrl()));
//		return blog;
//	}
	
	public void boardDelete(Board board) {
		int countOfArticle = boardDao.countArticles(board.getId());
		if (countOfArticle == 0) {
			boardDao.remove(board.getId());
		}
	}

	public void boardInsert(List<String> boards, String shopUrl) {
		for (String boardName : boards) {
			// TODO boardName 이 같으면, null이면 어떻게 할까? client 에서 확인합시다
			boardDao.insert(new Board(boardName));
		}
	}

	public List<Article> getArticles(int boardId) {
		return articleDao.selectAllByBoard(boardId);
	}

	public Board getBoard(Integer boardId, List<Board> list) {
		for (Board board : list) {
			if (boardId.equals(board.getId())) {
				return board;
			}
		}
		return null;
	}
}

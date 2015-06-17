package lilac.service;

import java.util.List;

import lilac.dao.ArticleCommentDao;
import lilac.dao.ArticleDao;
import lilac.dao.BoardDao;
import lilac.model.Article;
import lilac.model.ArticleComment;
import lilac.model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private ArticleCommentDao articleCommentDao;

	public void insertArticle(Article article) {
		articleDao.insert(article);
	}

	public List<Article> getArticles(int boardId) {
		return articleDao.selectAllByBoard(boardId);
	}

	public Board getBoard(int boardId) {
		return boardDao.selectByPk(boardId);
	}

	public Article getArticle(int articleId) {
		return articleDao.selectByPk(articleId);
	}

	public List<ArticleComment> getComments(int articleId) {
		return articleCommentDao.findByArticle(articleId);
	}

	public void insertArticleCommnet(ArticleComment articleComment) {
		articleCommentDao.insert(articleComment);
	}

	public void deleteArticleComment(int articleId, String userId, String commentTime) {
		articleCommentDao.remove(articleId, userId, commentTime);
	}

	public void deleteArticle(int articleId) {
		articleDao.remove(articleId);
	}

	public void updateArticle(Article article) {
		Article articleFromDao = articleDao.selectByPk(article.getId());
		
		articleDao.update(articleFromDao);
	}

	public void deleteArticleComment(ArticleComment articleComment) {
		articleCommentDao.removeByPk(articleComment);
	}
}

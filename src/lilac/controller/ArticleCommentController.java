package lilac.controller;

import java.util.List;

import lilac.model.ArticleComment;
import lilac.service.ArticleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/article")
public class ArticleCommentController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCommentController.class);

	@Autowired
	ArticleService articleService;

	// 글에 댓글 등록 구현
	@RequestMapping(value = "/comment/create", method = RequestMethod.POST)
	public List<ArticleComment> commentPost(ArticleComment articleComment) {
		
		articleService.insertArticleCommnet(articleComment);
		
		return articleService.getComments(articleComment.getArticleId());
	}
	
	// 글에 댓글 삭제 구현
	@RequestMapping(value = "/comment/delete", method = RequestMethod.POST)
	public List<ArticleComment> commentDeletePost(ArticleComment articleComment) {
		logger.debug("delete. {}", articleComment.getArticleId());
		try {
			articleService.deleteArticleComment(articleComment);
		} catch (Exception e) {
			logger.debug("failed"+e.getMessage());
			return null;
		}
		List<ArticleComment> a = articleService.getComments(articleComment.getArticleId());
		logger.debug("delete: {}");
		return a;
	}
}

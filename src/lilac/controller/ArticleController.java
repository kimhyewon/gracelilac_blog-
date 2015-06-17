package lilac.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import lilac.model.Article;
import lilac.model.ArticleComment;
import lilac.model.Board;
import lilac.service.ArticleService;
import lilac.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/blog/article")
public class ArticleController {
	private BlogService blogService; 
	private ArticleService articleService; 
	
	// article 보여주기
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
	public String listGet(Model model, @PathVariable("articleId") String articleId, HttpSession session) {
		Article article = articleService.getArticle(Integer.parseInt(articleId));
		List<ArticleComment> comments = articleService.getComments(article.getId());
//		Board board = blogService.getBoard(article.getBoardId(), blog.getBoards());
		
//		model.addAttribute("board", board);
		model.addAttribute("article", article);
		model.addAttribute("comments", comments);
		return "showArticle";
	}
}
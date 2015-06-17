package lilac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import lilac.model.Article;
import lilac.model.Blog;
import lilac.model.Board;
import lilac.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String showBoard(Model model,
			HttpSession session)
			throws ServletException, IOException {
//		Blog blog = blogService.getBlogByUrl(url);
//		
//		List<Article> articles = blogService.getArticles(Integer
//				.parseInt(boardId));
//
//		Board board = blogService.getBoard(Integer.parseInt(boardId), blog.getBoards());
//		
//		
//		model.addAttribute("articles", articles);
		return "board";
	}
	
	// 블로그 페이지에서 board명 클릭시 article list 보여줌
//	@RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET)
//	public String showArticleList(Model model,
//			@PathVariable("boardId") String boardId, HttpSession session)
//			throws ServletException, IOException {
//		List<Article> articles = blogService.getArticles(Integer
//				.parseInt(boardId));
//
//		model.addAttribute("articles", articles);
//		return "board";
//	}
}

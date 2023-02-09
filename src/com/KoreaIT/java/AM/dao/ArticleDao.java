package com.KoreaIT.java.AM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.AM.dto.Article;

public class ArticleDao extends Dao {
	private List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId++;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public List<Article> getArticles(String searchKeyword) {
		List<Article> forPrintArticles = new ArrayList<>();
		if (searchKeyword != null && searchKeyword.length() != 0) {
			if (searchKeyword.length() > 0) {

				for (Article article : articles) {
					if (article.title.contains(searchKeyword)) {
						forPrintArticles.add(article);
					}
				}

			}
			return forPrintArticles;
		}
		return articles;
	}

}

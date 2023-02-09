package com.KoreaIT.java.AM.container;

import com.KoreaIT.java.AM.dao.ArticleDao;
import com.KoreaIT.java.AM.dao.MemberDao;
import com.KoreaIT.java.AM.service.ArticleService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
	}
}

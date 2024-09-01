package com.sl.listeners;

import java.util.Date;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArticleListeners {
	private static final Logger logger = LogManager.getLogger(ArticleListeners.class);

	@PrePersist
	public void beforePersist(Article article) {
		logger.info("\n>>> Before persisting the object...");
		article.setDate(new Date());
	}

	@PostPersist
	public void afterPersist(Article article) {
		logger.info("\n>>> Post persisting the object...");
	}

}

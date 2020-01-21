package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.DeleteArticleUseCase;
import org.hibernate.Session;

public class DeleteArticleUseCaseImpl implements DeleteArticleUseCase {
    @Override
    public Boolean delete(Article articleForDelete) {
        if (articleForDelete == null) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! Article Error.\n");
            return false;
        }

        Session session = HibernateUtil.getSession();

        session.remove(articleForDelete);

        if (session.load(Article.class , articleForDelete.getId()) == null) {
            System.out.println("\t\u2714 Article successfully Deleted.\n");
            return true;
        } else {
            System.out.println("\t\u274c Delete Article Failed!\n");
            return false;
        }
    }
}

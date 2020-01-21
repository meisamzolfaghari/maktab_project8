package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.ChangeArticleContentUseCase;
import org.hibernate.Session;

import java.util.Date;

public class ChangeArticleContentUseCaseImpl implements ChangeArticleContentUseCase {
    @Override
    public Article change(Article articleForEdit, String newContent , Date currentDate) {


        if (articleForEdit == null) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! Article Error.\n");
            return null;
        }
        if (newContent == null || newContent.isEmpty()) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! New Content Error.\n");
            return null;
        }
        if (currentDate == null){
            System.out.println("\t\u274c Failed to Edit Articles Brief! Current Date Error.\n");
            return null;
        }

        articleForEdit.setContent(newContent);
        articleForEdit.setLastUpdateDate(currentDate);
        Session session = HibernateUtil.getSession();

        session.update(articleForEdit);

        Article editedArticle = session.load(Article.class , articleForEdit.getId());

        if (editedArticle.getContent().equals(articleForEdit.getContent())
                && editedArticle.getLastUpdateDate().equals(currentDate))
            System.out.println("\t\u2714 Article's Content successfully Edited.\n");
        else
            System.out.println("\t\u274c Failed to Edit Articles Content!\n");

        return editedArticle;
    }
}

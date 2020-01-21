package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.AddArticleByUserUseCase;
import org.hibernate.Session;

import java.util.Date;

public class AddArticlesByUserUseCaseImpl implements AddArticleByUserUseCase {

    @Override
    public Article add(String title, String brief, String content, Date currentDate
            , User user, Category category) {
        if (title == null || title.isEmpty()) {
            System.out.println("\t\u274c Failed to Add Article! Title Error.\n");
            return null;
        }
        if (brief == null || brief.isEmpty()){
            System.out.println("\t\u274c Failed to Add Article!Brief Error.\n");
            return null;
        }
        if (content == null || content.isEmpty()){
            System.out.println("\t\u274c Failed to Add Article! Content Error.\n");
            return null;
        }
        if (currentDate == null){
            System.out.println("\t\u274c Failed to Add Article! Current Date Error.\n");
            return null;
        }
        if (user == null){
            System.out.println("\t\u274c Failed to Add Article! User Error.\n");
            return null;
        }
        if (category == null){
            System.out.println("\t\u274c Failed to Add Article! Category Error.\n");
            return null;
        }

        Session session = HibernateUtil.getSession();
        Article articleToAdd = new Article(null ,title , brief , content , currentDate
        ,null ,null ,false, user, category);
        articleToAdd.setId((Integer) session.save(articleToAdd));

        Article addedArticle = session.load(Article.class,articleToAdd.getId());

        if (addedArticle != null)
            System.out.println("\t\u2714 Article successfully Added.\n");
        else
            System.out.println("\t\u274c Failed to Add Article!\n");

        return addedArticle;
    }
}

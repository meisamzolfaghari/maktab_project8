package ir.maktab.hibernate.projects.article.core.takefromuser;

import ir.maktab.hibernate.projects.article.core.menus.CategoryMenu;
import ir.maktab.hibernate.projects.article.core.menus.Menu;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.Date;
import java.util.Scanner;

public class TakeArticleToAdd {
    public static Article take(){
        Scanner in = new Scanner(System.in);

        CategoryMenu categoryMenu = new CategoryMenu();

        Article article = new Article();
        Date currentTime = new Date(System.currentTimeMillis());

        categoryMenu.execute();

        article.setCategory(categoryMenu.getChosenCategory());

        System.out.print("\t\u29bf Title : ");
        article.setTitle(in.nextLine());

        System.out.print("\t\u29bf Brief : ");
        article.setBrief(in.nextLine());

        System.out.print("\t\u29bf Content : ");
        article.setContent(in.nextLine());

        article.setCreateDate(currentTime);
        article.setLastUpdateDate(null);

        article.setPublished(false);
        article.setPublishDate(null);

        System.out.print("\t\u29bf do yo want to publish?(y for Yes and anything for No): ");
        if (in.next().charAt(0) == 'y') {
            article.setPublished(true);
            article.setPublishDate(currentTime);
        }

        article.setUser(AuthenticationService.getInstance().getLoginUser());

        return article;
    }
}

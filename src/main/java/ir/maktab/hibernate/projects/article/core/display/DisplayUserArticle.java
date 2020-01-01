package ir.maktab.hibernate.projects.article.core.display;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.List;

public class DisplayUserArticle {
    public static void displayShortVersion(List<Article> articles) {

        if (articles.isEmpty()) return;

        System.out.println("                              Articles");
        articles.forEach(article -> System.out.println(
                ""
                        + "------------------------------------------------------------------------------------"
                        + "\nID= " + article.getId()
                        + " , Category= '" + article.getCategory().getTitle()
                        + "' , Title= '"+ article.getTitle()
                        + "' , Brief= '" + article.getBrief()
                        + "'\n------------------------------------------------------------------------------------"));
    }

    public static void displayFullVersion(Article article) {

        if (article == null) return;

        String publishStatus = (article.isPublished())? "Published" : "Not Published";
        System.out.println(
                ""
                        + "------------------------------------------------------------------------------------"
                        + "\n    ID= " + article.getId()
                        + "\n    Category= '" + article.getCategory().getTitle()
                        + "'\n    Title= '"+ article.getTitle()
                        + "'\n    Brief= '" + article.getBrief()
                        + "'\n    Content= '" + article.getContent()
                        + "'\n    Create Date= " + article.getCreateDate()
                        + "\n    Last Update Date= " + article.getLastUpdateDate()
                        + "\n    Publish Date= " + article.getPublishDate()
                        + "\n    Publish Status= '" + publishStatus
                        + "'\n    User= '" + article.getUser().getUsername()
                        + "'\n------------------------------------------------------------------------------------");
    }
}

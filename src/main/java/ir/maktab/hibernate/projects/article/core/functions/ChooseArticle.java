package ir.maktab.hibernate.projects.article.core.functions;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.List;
import java.util.Scanner;

public class ChooseArticle {

    public static Article choose(List<Article> articles ){

        if (articles.isEmpty()) return null;

        Scanner in = new Scanner(System.in);

        Integer id;

        do {
            System.out.print("\t\u29bf ID : ");
            id = in.nextInt();
            for (Article article : articles)
                if (id.equals(article.getId()))
                    return article;

            System.out.println("\t\u26a0 Invalid ID! Try again...\n");

        } while (true);
    }

}

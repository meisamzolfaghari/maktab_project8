package ir.maktab.hibernate.projects.article.core.takefromuser;

import ir.maktab.hibernate.projects.article.entities.Category;

import java.util.Scanner;

public class TakeCategoryToAdd {

    public static Category take() {
        Scanner in = new Scanner(System.in);
        Category category = new Category();

        System.out.print("\t\u29bf Title : ");
        category.setTitle(in.nextLine());

        System.out.print("\t\u29bf Description : ");
        category.setDescription(in.nextLine());

        return category;
    }

}

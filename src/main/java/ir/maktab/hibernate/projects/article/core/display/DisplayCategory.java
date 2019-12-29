package ir.maktab.hibernate.projects.article.core.display;

import ir.maktab.hibernate.projects.article.entities.Category;

import java.util.List;

public class DisplayCategory {
    public static void display(List<Category> categories) {
        if (categories.isEmpty()) return;
        System.out.println("                        Categories");
        categories.forEach(category -> System.out.println(
                ""
                        + "------------------------------------------------------------------------------------"
                        + "\n ID= " + category.getId()
                        + " , Category Title= '" + category.getTitle()
                        + "' , description= '" + category.getDescription()
                        + "'\n------------------------------------------------------------------------------------"));
    }

}

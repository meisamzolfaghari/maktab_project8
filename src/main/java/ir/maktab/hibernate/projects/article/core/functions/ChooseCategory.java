package ir.maktab.hibernate.projects.article.core.functions;

import ir.maktab.hibernate.projects.article.entities.Category;

import java.util.List;
import java.util.Scanner;

public class ChooseCategory {
    public static Category choose(List<Category> categories ){

        if (categories.isEmpty()) return null;

        Scanner in = new Scanner(System.in);

        Integer id;

        do {
            System.out.print("\t\u29bf ID : ");
            id = in.nextInt();
            for (Category category : categories)
                if (id.equals(category.getId()))
                    return category;

            System.out.println("\t\u26a0 Invalid ID! Try again...\n");

        } while (true);
    }
}

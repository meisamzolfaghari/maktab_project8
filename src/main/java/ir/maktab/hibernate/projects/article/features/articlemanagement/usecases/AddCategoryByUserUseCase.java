package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Category;

public interface AddCategoryByUserUseCase {
    Category add(Category category);
}

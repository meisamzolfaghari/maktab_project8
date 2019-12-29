package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Category;

import java.util.List;

public interface FindAllCategoriesUseCase {
    List<Category> list();
}

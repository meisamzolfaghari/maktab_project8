package ir.maktab.hibernate.projects.article.features.categorymanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Category;

import java.util.List;

public interface FindCategoryByTitleUseCase {
    List<Category> list(String title);
}

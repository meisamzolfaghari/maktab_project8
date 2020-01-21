package ir.maktab.hibernate.projects.article.features.categorymanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Category;

public interface AddCategoryUseCase {
    Category add(String title, String description);
}

package ir.maktab.hibernate.projects.article.features.categorymanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Category;

public interface DeleteCategoryUseCase {
    Boolean delete(Category category);
}

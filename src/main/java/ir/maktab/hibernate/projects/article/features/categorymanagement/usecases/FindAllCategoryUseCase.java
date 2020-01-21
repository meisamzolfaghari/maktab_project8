package ir.maktab.hibernate.projects.article.features.categorymanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Category;

import java.util.List;

public interface FindAllCategoryUseCase{
    List<Category> list();
}

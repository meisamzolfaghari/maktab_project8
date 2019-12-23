package ir.maktab.hibernate.projects.article.features.usermanagement.usecases;

import java.util.Date;

public interface RegisterUseCase {
    Integer register(String username , String nationalCode , Date birthDay , String password);
}

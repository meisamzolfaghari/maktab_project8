package ir.maktab.hibernate.projects.article.entities;

import com.sun.istack.Nullable;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;

    private String nationalCode;
    private Date birthDay;

    @Column(nullable = false)
    private String password;



}

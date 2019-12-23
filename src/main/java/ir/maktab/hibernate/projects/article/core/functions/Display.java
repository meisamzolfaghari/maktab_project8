package ir.maktab.hibernate.projects.article.core.functions;

public class Display {

    public static void firstMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                      First Menu                               |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  login           ---->    Login.                              |");
        System.out.println("\t|  articles        ---->    See all of Articles.                |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void userMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                      User Menu                                |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  myarticles      ---->    Your Articles.                      |");
        System.out.println("\t|  articles        ---->    See all of Articles.                |");
        System.out.println("\t|  profile         ---->    See your Profile.                   |");
        System.out.println("\t|  logout          ---->    Logout.                             |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void articleMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                      Article Menu                             |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  see             ---->    See your Article.                   |");
        System.out.println("\t|  edit            ---->    Edit your Article.                  |");
        System.out.println("\t|  add             ---->    Insert a new Article.               |");
        System.out.println("\t|  logout          ---->    Logout.                             |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void profileMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                     Profile Menu                              |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  see             ---->    See your Profile.                   |");
        System.out.println("\t|  edit            ---->    Edit your Profile.                  |");
        System.out.println("\t|  logout          ---->    Logout.                             |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void categoryMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Category Menu                           |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  choose          ---->    choose a category.                  |");
        System.out.println("\t|  add             ---->    add a category.                     |");
        System.out.println("\t|  logout          ---->    Logout.                             |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

}

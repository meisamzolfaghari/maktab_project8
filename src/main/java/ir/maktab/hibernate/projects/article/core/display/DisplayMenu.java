package ir.maktab.hibernate.projects.article.core.display;

public class DisplayMenu {

    public static void firstMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                      First Menu                               |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  articles        ---->    See all of Articles.                |");
        System.out.println("\t|  login           ---->    Login.                              |");
        System.out.println("\t|  register        ---->    Register.                           |");
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
        System.out.println("\t|                    Article Menu                               |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  see             ---->    See your Article.                   |");
        System.out.println("\t|  back            ---->    Back to User Menu.                  |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void userArticleMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                    User Article Menu                          |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  see             ---->    See your Article.                   |");
        System.out.println("\t|  edit            ---->    Edit your Article.                  |");
        System.out.println("\t|  add             ---->    Insert a new Article.               |");
        System.out.println("\t|  back            ---->    Back to User Menu.                  |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void profileMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                     Profile Menu                              |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  edit            ---->    Edit your Profile.                  |");
        System.out.println("\t|  back            ---->    Back to User Menu.                  |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void categoryMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Category Menu                           |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  choose          ---->    choose a category.                  |");
        System.out.println("\t|  add             ---->    add a category.                     |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void editArticleMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Edit Article Menu                       |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  publish         ---->    Publish chosen Article.             |");
        System.out.println("\t|  unpublish       ---->    Unpublish chosen Article.           |");
        System.out.println("\t|  title           ---->    Edit Title.                         |");
        System.out.println("\t|  brief           ---->    Edit Brief.                         |");
        System.out.println("\t|  content         ---->    Edit Content.                       |");
        System.out.println("\t|  back            ---->    Back to Article Menu.               |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void editProfileMenu(){
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Edit Profile Menu                       |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  username        ---->    Edit Username.                      |");
        System.out.println("\t|  nationcode      ---->    Edit National Code .                |");
        System.out.println("\t|  birthday        ---->    Edit Birthday.                      |");
        System.out.println("\t|  password        ---->    Edit Password.                      |");
        System.out.println("\t|  back            ---->    Back to Profile Menu.               |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    public static void finalMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  back            ---->    Back to last Menu.                  |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

}

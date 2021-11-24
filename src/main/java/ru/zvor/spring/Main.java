package ru.zvor.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.zvor.spring.service.repo.AuthorService;
import ru.zvor.spring.service.repo.BookService;
import ru.zvor.spring.service.repo.CommentService;
import ru.zvor.spring.service.repo.GenreService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    AuthorService authorService;
    GenreService genreService;
    CommentService commentService;
    BookService bookService;

    public Main(AuthorService authorService, GenreService genreService, CommentService commentService, BookService bookService) {
        this.authorService = authorService;
        this.genreService = genreService;
        this.commentService = commentService;
        this.bookService = bookService;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class);
        //Console.main(args);
        }


        @PostConstruct
        public void init(){
            authorService.saveNewAuthor("Лев Толстой");
            authorService.saveNewAuthor("Александр Пушкин");
            authorService.saveNewAuthor("Михаил Булгаков");
            authorService.saveNewAuthor("Джон Толкиэн");
            authorService.saveNewAuthor("Анджей Сапковски");
            authorService.saveNewAuthor("Рей Бредбери");
            authorService.saveNewAuthor("Стивен Кинг");
            authorService.saveNewAuthor("Роджер Желязны");
            authorService.saveNewAuthor("Леонид Каганов");
            authorService.saveNewAuthor("Алексей Пехов");
            authorService.saveNewAuthor("Дэниэл Киз");

            System.out.println("-------------");

            genreService.saveNewGenre("Роман");
            genreService.saveNewGenre("Детектив");
            genreService.saveNewGenre("Фентези");
            genreService.saveNewGenre("рассказ");
            genreService.saveNewGenre("повесть");
            genreService.saveNewGenre("драма");
            genreService.saveNewGenre("хоррор");
            genreService.saveNewGenre("триллер");

            System.out.println("-------------");

            commentService.saveNewComment("отличная книга");
            commentService.saveNewComment("супер");
            commentService.saveNewComment("не понравилась");
            commentService.saveNewComment("так себе, сюжет слабоват");
            commentService.saveNewComment("советую к прочтению");
            commentService.saveNewComment("уже 3 раза перечитал");
            commentService.saveNewComment("хотелось бы продолжения");


            System.out.println("-------------");




            System.out.println("-------------");
            System.out.println("-------------");
            System.out.println("-------------");
            System.out.println(authorService.findAllAuthor());
            authorService.removeAuthorByName("Лев Толстой");
            authorService.updateNameAuthorById(2L, "Александр Сергеевич Пушкин");
            System.out.println(authorService.findAllAuthor());
            commentService.updateCommentNameById("не понравилась совсем", 3L);
            commentService.getCommentById(3L).stream().map(a -> "getMethod: " + a.getCommentName()).forEach(System.out::println);
            commentService.deleteCommentById(5L);
            commentService.deleteCommentById(15L);
            commentService.findAllComment().stream().map(a -> "id: " + a.getId() + ". Комментарий: "+ a.getCommentName()).forEach(System.out::println);

        }

}

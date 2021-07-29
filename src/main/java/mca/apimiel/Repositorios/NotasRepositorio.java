package mca.apimiel.Repositorios;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import mca.apimiel.Entidades.Post;
import org.springframework.data.jpa.repository.Query;

public interface NotasRepositorio extends JpaRepository<Post, Integer> {
    
    @Query("SELECT post FROM Post post WHERE post.fechaModificacion>=?1")
    List <Post> getPostAfterFecha(Date fechaCorte);

}

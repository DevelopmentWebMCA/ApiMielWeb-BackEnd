package mca.apimiel.Controladores.AppMovil;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mca.apimiel.Entidades.Asociacion;
import mca.apimiel.Entidades.Producto;
import mca.apimiel.Repositorios.AsociacionesRepositorio;
import mca.apimiel.Repositorios.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/apimiel/movil")
public class RequestController {
    @Autowired
    AsociacionesRepositorio asociacionesRepositorio;
    ProductosRepositorio productosRepositorio;

     //Petición de las asociaciones con una fecha de corte
    @GetMapping(value = "/asociaciones/{fechaCorte}")
    public List<Asociacion> getAsociacionesAferFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error de aqui " + e.getMessage());
        }
        System.out.println(fechaCorte);
        return asociacionesRepositorio.getAsociacionesAfterFecha(d);
    }

    //Petición de los productos con una fecha de corte

    @GetMapping(value = "/productos/{fechaCorte}")
    public List<Producto> getProductosAfterFecha(@PathVariable("fechaCorte") String fechaCorte){
        Date d = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        fechaCorte = fechaCorte.replace('-','/');
        try
        { d = formato.parse(fechaCorte); }
        catch(ParseException e){
            System.out.println("error de aqui " + e.getMessage());
        }
        return productosRepositorio.getProductosAfterFecha(d);
    }


    //Petición de los apicultores con una fecha de corte


    //Petición de las áreas de floración con una fecha de corte


    //Petición para guardar la producción de un apicultor
}

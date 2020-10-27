package com.example.carroproductos.dao;

import com.example.carroproductos.dto.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosDAOLista implements ProductosDAO{
    //Patron singleton:
    //1. Instancia como atributo estatico de si misma
    //2. El constructor debe ser privado
    //3. Debe existir un método que verifique la existencia de la única instancia
    //(getInstance)
    private static List<Producto> productos = new ArrayList<>();
    private static ProductosDAOLista instancia;
    public static ProductosDAOLista getInstance(){
        if(instancia==null){
            instancia = new ProductosDAOLista();
        }
        return instancia;
    }
    private ProductosDAOLista(){
        Producto p = new Producto();
        p.setNombre("Coca Cola Zero");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sed turpis quis lectus suscipit tincidunt. Suspendisse luctus vulputate scelerisque. Cras lobortis, ante sit amet cursus porta, diam sem convallis ante, vel tincidunt augue magna vitae est. Duis eleifend justo et metus imperdiet, accumsan maximus lectus blandit. Integer mollis convallis sollicitudin. Aenean nec sodales neque, in interdum est. Nullam aliquet dictum ipsum vitae malesuada. Maecenas sed elementum lorem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec egestas neque ac massa pellentesque venenatis. Proin ultrices congue interdum.");
        p.setPrecio(1000);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/222681/1259964.jpg?v=636548056172700000");
        productos.add(p);
        p = new Producto();
        p.setNombre("Mantecol");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sed turpis quis lectus suscipit tincidunt. Suspendisse luctus vulputate scelerisque. Cras lobortis, ante sit amet cursus porta, diam sem convallis ante, vel tincidunt augue magna vitae est. Duis eleifend justo et metus imperdiet, accumsan maximus lectus blandit. Integer mollis convallis sollicitudin. Aenean nec sodales neque, in interdum est. Nullam aliquet dictum ipsum vitae malesuada. Maecenas sed elementum lorem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec egestas neque ac massa pellentesque venenatis. Proin ultrices congue interdum.");
        p.setPrecio(800);
        p.setFoto("https://www.confiterialamundial.cl/media/confiteria-la-mundial-mantecol-110-gr.jpg");
        productos.add(p);
        p = new Producto();
        p.setNombre("Galletas Ricochoc");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sed turpis quis lectus suscipit tincidunt. Suspendisse luctus vulputate scelerisque. Cras lobortis, ante sit amet cursus porta, diam sem convallis ante, vel tincidunt augue magna vitae est. Duis eleifend justo et metus imperdiet, accumsan maximus lectus blandit. Integer mollis convallis sollicitudin. Aenean nec sodales neque, in interdum est. Nullam aliquet dictum ipsum vitae malesuada. Maecenas sed elementum lorem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec egestas neque ac massa pellentesque venenatis. Proin ultrices congue interdum.");
        p.setPrecio(1200);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/174186/462227.jpg?v=636376973472130000");
        productos.add(p);
    }

    @Override
    public Producto add(Producto p) {
        productos.add(p);
        return p;
    }

    @Override
    public List<Producto> getAll() {
        return productos;
    }
}

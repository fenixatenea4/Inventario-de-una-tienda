package vaadin.demo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Route;

@Route("Tienda")
public class InventarioTienda extends VerticalLayout {

public InventarioTienda() {
        H1 titulo = new H1("Donde Miguel");
        
        TabSheet pestanas = new TabSheet(); // pestañas de la tabla principal
        
        VerticalLayout vistaProductos = new VerticalLayout();
        H2 tituloProductos = new H2("Secciones y Productos");
        HorizontalLayout botonesProductos = new HorizontalLayout();

        VerticalLayout canastaFamiliar = new VerticalLayout();
        Button botonCanasta = new Button("Canasta familiar");
        Span stockCanasta = new Span("Stock: Normal");
        stockCanasta.getElement().getThemeList().add("badge");
        canastaFamiliar.add(botonCanasta, stockCanasta);
        
        VerticalLayout confiteria = new VerticalLayout();
        Button botonConfiteria = new Button("Confitería");
        Span stockConfiteria = new Span("Stock: Normal");
        stockConfiteria.getElement().getThemeList().add("badge");
        confiteria.add(botonConfiteria, stockConfiteria);
        
        VerticalLayout mascotas = new VerticalLayout();
        Button botonMascotas = new Button("Mascotas");
        Span stockMascotas = new Span("Stock: Normal");
        stockMascotas.getElement().getThemeList().add("badge");
        mascotas.add(botonMascotas, stockMascotas);
        
        VerticalLayout aseo = new VerticalLayout();
        Button botonAseo = new Button("Aseo general");
        Span stockAseo = new Span("Stock: Normal");
        stockAseo.getElement().getThemeList().add("badge");
        aseo.add(botonAseo, stockAseo);
        
        botonesProductos.add(canastaFamiliar, confiteria, mascotas, aseo);
        vistaProductos.add(tituloProductos, botonesProductos);
        
        VerticalLayout vistaBodegas = new VerticalLayout();
        H2 tituloBodegas = new H2("Registro bodegas");
        HorizontalLayout botonesBodegas = new HorizontalLayout();
        Button botonSurtimiento = new Button("Registrar Surtimiento");
        Button botonEnvios = new Button("Registrar Envíos");
        Button botonMovimientos = new Button("Consultar Movimientos");
        botonesBodegas.add(botonSurtimiento, botonEnvios, botonMovimientos);
        vistaBodegas.add(tituloBodegas, botonesBodegas);
        
        VerticalLayout vistaValores = new VerticalLayout();
        H2 tituloValores = new H2("Valores inventario");
        Grid<String> tablaInventario = new Grid<>();
        tablaInventario.addColumn(valor -> "").setHeader("Canasta familiar $");
        tablaInventario.addColumn(valor -> "").setHeader("Confitería $");
        tablaInventario.addColumn(valor -> "").setHeader("Mascotas $");
        tablaInventario.addColumn(valor -> "").setHeader("Aseo general $");
        tablaInventario.addColumn(valor -> "").setHeader("Total $");
        
        Button botonKardex = new Button("Kárdex");
        vistaValores.add(tituloValores, tablaInventario, botonKardex);
        
        pestanas.add("Productos", vistaProductos);
        pestanas.add("Movimientos", vistaBodegas);
        pestanas.add("Reportes", vistaValores);
        
        add(titulo, pestanas);
    }

}

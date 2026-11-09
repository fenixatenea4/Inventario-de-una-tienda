package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("mascotas")
public class MascotasView extends VerticalLayout {

    public static int stockPerrarinaAdultos = 20;
    public Span textoStockPerrarinaAdultos;

     public static int stockPerrarinaCachorros = 15;
    public Span textoStockPerrarinaCachorros;

     public static int stockGatarinaAdultos = 25;
    public Span textoStockGatarinaAdultos;

     public static int stockGatarinaCachorros = 10;
    public Span textoStockGatarinaCachorros;

     public static int stockHuesitos = 50;
    public Span textoStockHuesitos;

     public static int stockGalletasPerro = 30;
    public Span textoStockGalletasPerro;

     public static int stockLataCarnePerro = 40;
    public Span textoStockLataCarnePerro;

     public static int stockLataAtunGato = 35;
    public Span textoStockLataAtunGato;

     public static int stockShampooAntipulgas = 12;
    public Span textoStockShampooAntipulgas;

     public static int stockJabonPerro = 18;
    public Span textoStockJabonPerro;

     public static int stockAntipulgasPipeta = 22;
    public Span textoStockAntipulgasPipeta;

     public static int stockDesparasitante = 14;
    public Span textoStockDesparasitante;

     public static int stockCollarSimple = 16;
    public Span textoStockCollarSimple;

     public static int stockCollarAntipulgas = 8;
    public Span textoStockCollarAntipulgas;

     public static int stockCorreaRetractil = 9;
    public Span textoStockCorreaRetractil;

     public static int stockPlatoComedero = 25;
    public Span textoStockPlatoComedero;

     public static int stockPlatoBebedero = 20;
    public Span textoStockPlatoBebedero;

     public static int stockCamaMediana = 6;
    public Span textoStockCamaMediana;

     public static int stockJuguetePelota = 30;
    public Span textoStockJuguetePelota;

     public static int stockJugueteHueso = 28;
    public Span textoStockJugueteHueso;

     public static int stockRascadorGato = 5;
    public Span textoStockRascadorGato;

     public static int stockArenaSanitaria = 18;
    public Span textoStockArenaSanitaria;

     public static int stockHierbaGatera = 12;
    public Span textoStockHierbaGatera;

     public static int stockRopaMascota = 15;
    public Span textoStockRopaMascota;

     public static int stockBozal = 10;
    public Span textoStockBozal;

    public MascotasView() {
        H1 titulo = new H1("Sección de Mascotas");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        VerticalLayout producto1 = new VerticalLayout();
        H2 nombre1 = new H2("Perrarina Adultos");
        Span precio1 = new Span("Precio: $45.000");
        textoStockPerrarinaAdultos = new Span("Cantidad: " + stockPerrarinaAdultos);
        textoStockPerrarinaAdultos.getElement().getThemeList().add("badge");
        producto1.add(nombre1, precio1, textoStockPerrarinaAdultos);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombre2 = new H2("Perrarina Cachorros");
        Span precio2 = new Span("Precio: $48.000");
        textoStockPerrarinaCachorros = new Span("Cantidad: " + stockPerrarinaCachorros);
        textoStockPerrarinaCachorros.getElement().getThemeList().add("badge");
        producto2.add(nombre2, precio2, textoStockPerrarinaCachorros);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombre3 = new H2("Gatarina Adultos");
        Span precio3 = new Span("Precio: $40.000");
        textoStockGatarinaAdultos = new Span("Cantidad: " + stockGatarinaAdultos);
        textoStockGatarinaAdultos.getElement().getThemeList().add("badge");
        producto3.add(nombre3, precio3, textoStockGatarinaAdultos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombre4 = new H2("Gatarina Cachorros");
        Span precio4 = new Span("Precio: $42.000");
        textoStockGatarinaCachorros = new Span("Cantidad: " + stockGatarinaCachorros);
        textoStockGatarinaCachorros.getElement().getThemeList().add("badge");
        producto4.add(nombre4, precio4, textoStockGatarinaCachorros);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombre5 = new H2("Huesitos de Premio");
        Span precio5 = new Span("Precio: $5.500");
        textoStockHuesitos = new Span("Cantidad: " + stockHuesitos);
        textoStockHuesitos.getElement().getThemeList().add("badge");
        producto5.add(nombre5, precio5, textoStockHuesitos);

        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        VerticalLayout producto6 = new VerticalLayout();
        H2 nombre6 = new H2("Galletas para Perro");
        Span precio6 = new Span("Precio: $8.000");
        textoStockGalletasPerro = new Span("Cantidad: " + stockGalletasPerro);
        textoStockGalletasPerro.getElement().getThemeList().add("badge");
        producto6.add(nombre6, precio6, textoStockGalletasPerro);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombre7 = new H2("Lata Carne Perro");
        Span precio7 = new Span("Precio: $12.000");
        textoStockLataCarnePerro = new Span("Cantidad: " + stockLataCarnePerro);
        textoStockLataCarnePerro.getElement().getThemeList().add("badge");
        producto7.add(nombre7, precio7, textoStockLataCarnePerro);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombre8 = new H2("Lata Atún Gato");
        Span precio8 = new Span("Precio: $11.500");
        textoStockLataAtunGato = new Span("Cantidad: " + stockLataAtunGato);
        textoStockLataAtunGato.getElement().getThemeList().add("badge");
        producto8.add(nombre8, precio8, textoStockLataAtunGato);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombre9 = new H2("Shampoo Antipulgas");
        Span precio9 = new Span("Precio: $18.000");
        textoStockShampooAntipulgas = new Span("Cantidad: " + stockShampooAntipulgas);
        textoStockShampooAntipulgas.getElement().getThemeList().add("badge");
        producto9.add(nombre9, precio9, textoStockShampooAntipulgas);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombre10 = new H2("Jabón para Perro");
        Span precio10 = new Span("Precio: $9.000");
        textoStockJabonPerro = new Span("Cantidad: " + stockJabonPerro);
        textoStockJabonPerro.getElement().getThemeList().add("badge");
        producto10.add(nombre10, precio10, textoStockJabonPerro);

        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        VerticalLayout producto11 = new VerticalLayout();
        H2 nombre11 = new H2("Pipeta Antipulgas");
        Span precio11 = new Span("Precio: $25.000");
        textoStockAntipulgasPipeta = new Span("Cantidad: " + stockAntipulgasPipeta);
        textoStockAntipulgasPipeta.getElement().getThemeList().add("badge");
        producto11.add(nombre11, precio11, textoStockAntipulgasPipeta);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombre12 = new H2("Desparasitante");
        Span precio12 = new Span("Precio: $15.000");
        textoStockDesparasitante = new Span("Cantidad: " + stockDesparasitante);
        textoStockDesparasitante.getElement().getThemeList().add("badge");
        producto12.add(nombre12, precio12, textoStockDesparasitante);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombre13 = new H2("Collar Simple");
        Span precio13 = new Span("Precio: $10.000");
        textoStockCollarSimple = new Span("Cantidad: " + stockCollarSimple);
        textoStockCollarSimple.getElement().getThemeList().add("badge");
        producto13.add(nombre13, precio13, textoStockCollarSimple);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombre14 = new H2("Collar Antipulgas");
        Span precio14 = new Span("Precio: $35.000");
        textoStockCollarAntipulgas = new Span("Cantidad: " + stockCollarAntipulgas);
        textoStockCollarAntipulgas.getElement().getThemeList().add("badge");
        producto14.add(nombre14, precio14, textoStockCollarAntipulgas);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombre15 = new H2("Correa Retráctil");
        Span precio15 = new Span("Precio: $28.000");
        textoStockCorreaRetractil = new Span("Cantidad: " + stockCorreaRetractil);
        textoStockCorreaRetractil.getElement().getThemeList().add("badge");
        producto15.add(nombre15, precio15, textoStockCorreaRetractil);

        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        VerticalLayout producto16 = new VerticalLayout();
        H2 nombre16 = new H2("Plato Comedero");
        Span precio16 = new Span("Precio: $12.500");
        textoStockPlatoComedero = new Span("Cantidad: " + stockPlatoComedero);
        textoStockPlatoComedero.getElement().getThemeList().add("badge");
        producto16.add(nombre16, precio16, textoStockPlatoComedero);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombre17 = new H2("Plato Bebedero");
        Span precio17 = new Span("Precio: $12.500");
        textoStockPlatoBebedero = new Span("Cantidad: " + stockPlatoBebedero);
        textoStockPlatoBebedero.getElement().getThemeList().add("badge");
        producto17.add(nombre17, precio17, textoStockPlatoBebedero);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombre18 = new H2("Cama Mediana");
        Span precio18 = new Span("Precio: $65.000");
        textoStockCamaMediana = new Span("Cantidad: " + stockCamaMediana);
        textoStockCamaMediana.getElement().getThemeList().add("badge");
        producto18.add(nombre18, precio18, textoStockCamaMediana);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombre19 = new H2("Pelota de Juguete");
        Span precio19 = new Span("Precio: $6.000");
        textoStockJuguetePelota = new Span("Cantidad: " + stockJuguetePelota);
        textoStockJuguetePelota.getElement().getThemeList().add("badge");
        producto19.add(nombre19, precio19, textoStockJuguetePelota);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombre20 = new H2("Hueso de Juguete");
        Span precio20 = new Span("Precio: $7.500");
        textoStockJugueteHueso = new Span("Cantidad: " + stockJugueteHueso);
        textoStockJugueteHueso.getElement().getThemeList().add("badge");
        producto20.add(nombre20, precio20, textoStockJugueteHueso);

        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        VerticalLayout producto21 = new VerticalLayout();
        H2 nombre21 = new H2("Rascador de Gato");
        Span precio21 = new Span("Precio: $45.000");
        textoStockRascadorGato = new Span("Cantidad: " + stockRascadorGato);
        textoStockRascadorGato.getElement().getThemeList().add("badge");
        producto21.add(nombre21, precio21, textoStockRascadorGato);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombre22 = new H2("Arena Sanitaria");
        Span precio22 = new Span("Precio: $22.000");
        textoStockArenaSanitaria = new Span("Cantidad: " + stockArenaSanitaria);
        textoStockArenaSanitaria.getElement().getThemeList().add("badge");
        producto22.add(nombre22, precio22, textoStockArenaSanitaria);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombre23 = new H2("Hierba Gatera");
        Span precio23 = new Span("Precio: $14.000");
        textoStockHierbaGatera = new Span("Cantidad: " + stockHierbaGatera);
        textoStockHierbaGatera.getElement().getThemeList().add("badge");
        producto23.add(nombre23, precio23, textoStockHierbaGatera);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombre24 = new H2("Ropa para Mascota");
        Span precio24 = new Span("Precio: $30.000");
        textoStockRopaMascota = new Span("Cantidad: " + stockRopaMascota);
        textoStockRopaMascota.getElement().getThemeList().add("badge");
        producto24.add(nombre24, precio24, textoStockRopaMascota);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombre25 = new H2("Bozal");
        Span precio25 = new Span("Precio: $18.500");
        textoStockBozal = new Span("Cantidad: " + stockBozal);
        textoStockBozal.getElement().getThemeList().add("badge");
        producto25.add(nombre25, precio25, textoStockBozal);

        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }
}
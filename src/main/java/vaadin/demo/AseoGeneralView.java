package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("aseo")
public class AseoGeneralView extends VerticalLayout {

     public static int stockBlanqueador = 20;
    public Span textoStockBlanqueador;

     public static int stockJabonPolvo = 15;
    public Span textoStockJabonPolvo;

     public static int stockLimpiadorPisos = 25;
    public Span textoStockLimpiadorPisos;

     public static int stockLavaloza = 30;
    public Span textoStockLavaloza;

     public static int stockSuavizante = 18;
    public Span textoStockSuavizante;

     public static int stockEsponjaBrillo = 40;
    public Span textoStockEsponjaBrillo;

     public static int stockEscoba = 12;
    public Span textoStockEscoba;

     public static int stockTrapero = 14;
    public Span textoStockTrapero;

     public static int stockDesinfectante = 22;
    public Span textoStockDesinfectante;

     public static int stockLimpiavidrios = 16;
    public Span textoStockLimpiavidrios;

     public static int stockJabonBarra = 35;
    public Span textoStockJabonBarra;

     public static int stockBolsaBasuraPequena = 50;
    public Span textoStockBolsaBasuraPequena;

     public static int stockBolsaMediana = 45;
    public Span textoStockBolsaMediana;

     public static int stockBolsaGrande = 30;
    public Span textoStockBolsaGrande;

     public static int stockGuantesCaucho = 25;
    public Span textoStockGuantesCaucho;

     public static int stockToallasPapel = 28;
    public Span textoStockToallasPapel;

     public static int stockPapelHigienico = 60;
    public Span textoStockPapelHigienico;

     public static int stockLimpiadorBanos = 19;
    public Span textoStockLimpiadorBanos;

     public static int stockAntisaro = 10;
    public Span textoStockAntisaro;

     public static int stockAmbientador = 24;
    public Span textoStockAmbientador;

     public static int stockPastillaTanque = 33;
    public Span textoStockPastillaTanque;

     public static int stockCepilloMano = 15;
    public Span textoStockCepilloMano;

     public static int stockVirutaAcero = 38;
    public Span textoStockVirutaAcero;

     public static int stockAlcohol = 42;
    public Span textoStockAlcohol;

     public static int stockLustramuebles = 11;
    public Span textoStockLustramuebles;

    public AseoGeneralView() {
        H1 titulo = new H1("Sección de Aseo General");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        VerticalLayout producto1 = new VerticalLayout();
        H2 nombre1 = new H2("Blanqueador");
        Span precio1 = new Span("Precio: $4.500");
        textoStockBlanqueador = new Span("Cantidad: " + stockBlanqueador);
        textoStockBlanqueador.getElement().getThemeList().add("badge");
        producto1.add(nombre1, precio1, textoStockBlanqueador);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombre2 = new H2("Jabón en Polvo");
        Span precio2 = new Span("Precio: $8.000");
        textoStockJabonPolvo = new Span("Cantidad: " + stockJabonPolvo);
        textoStockJabonPolvo.getElement().getThemeList().add("badge");
        producto2.add(nombre2, precio2, textoStockJabonPolvo);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombre3 = new H2("Limpiador de Pisos");
        Span precio3 = new Span("Precio: $5.200");
        textoStockLimpiadorPisos = new Span("Cantidad: " + stockLimpiadorPisos);
        textoStockLimpiadorPisos.getElement().getThemeList().add("badge");
        producto3.add(nombre3, precio3, textoStockLimpiadorPisos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombre4 = new H2("Lavaloza Líquido");
        Span precio4 = new Span("Precio: $6.000");
        textoStockLavaloza = new Span("Cantidad: " + stockLavaloza);
        textoStockLavaloza.getElement().getThemeList().add("badge");
        producto4.add(nombre4, precio4, textoStockLavaloza);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombre5 = new H2("Suavizante de Telas");
        Span precio5 = new Span("Precio: $7.500");
        textoStockSuavizante = new Span("Cantidad: " + stockSuavizante);
        textoStockSuavizante.getElement().getThemeList().add("badge");
        producto5.add(nombre5, precio5, textoStockSuavizante);

        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        VerticalLayout producto6 = new VerticalLayout();
        H2 nombre6 = new H2("Esponja de Brillo");
        Span precio6 = new Span("Precio: $1.200");
        textoStockEsponjaBrillo = new Span("Cantidad: " + stockEsponjaBrillo);
        textoStockEsponjaBrillo.getElement().getThemeList().add("badge");
        producto6.add(nombre6, precio6, textoStockEsponjaBrillo);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombre7 = new H2("Escoba");
        Span precio7 = new Span("Precio: $12.000");
        textoStockEscoba = new Span("Cantidad: " + stockEscoba);
        textoStockEscoba.getElement().getThemeList().add("badge");
        producto7.add(nombre7, precio7, textoStockEscoba);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombre8 = new H2("Trapero");
        Span precio8 = new Span("Precio: $14.000");
        textoStockTrapero = new Span("Cantidad: " + stockTrapero);
        textoStockTrapero.getElement().getThemeList().add("badge");
        producto8.add(nombre8, precio8, textoStockTrapero);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombre9 = new H2("Desinfectante Multiusos");
        Span precio9 = new Span("Precio: $9.000");
        textoStockDesinfectante = new Span("Cantidad: " + stockDesinfectante);
        textoStockDesinfectante.getElement().getThemeList().add("badge");
        producto9.add(nombre9, precio9, textoStockDesinfectante);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombre10 = new H2("Limpiavidrios");
        Span precio10 = new Span("Precio: $6.500");
        textoStockLimpiavidrios = new Span("Cantidad: " + stockLimpiavidrios);
        textoStockLimpiavidrios.getElement().getThemeList().add("badge");
        producto10.add(nombre10, precio10, textoStockLimpiavidrios);

        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        VerticalLayout producto11 = new VerticalLayout();
        H2 nombre11 = new H2("Jabón de Barra");
        Span precio11 = new Span("Precio: $3.000");
        textoStockJabonBarra = new Span("Cantidad: " + stockJabonBarra);
        textoStockJabonBarra.getElement().getThemeList().add("badge");
        producto11.add(nombre11, precio11, textoStockJabonBarra);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombre12 = new H2("Bolsa Basura Pequeña");
        Span precio12 = new Span("Precio: $2.500");
        textoStockBolsaBasuraPequena = new Span("Cantidad: " + stockBolsaBasuraPequena);
        textoStockBolsaBasuraPequena.getElement().getThemeList().add("badge");
        producto12.add(nombre12, precio12, textoStockBolsaBasuraPequena);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombre13 = new H2("Bolsa Basura Mediana");
        Span precio13 = new Span("Precio: $3.500");
        textoStockBolsaMediana = new Span("Cantidad: " + stockBolsaMediana);
        textoStockBolsaMediana.getElement().getThemeList().add("badge");
        producto13.add(nombre13, precio13, textoStockBolsaMediana);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombre14 = new H2("Bolsa Basura Grande");
        Span precio14 = new Span("Precio: $4.500");
        textoStockBolsaGrande = new Span("Cantidad: " + stockBolsaGrande);
        textoStockBolsaGrande.getElement().getThemeList().add("badge");
        producto14.add(nombre14, precio14, textoStockBolsaGrande);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombre15 = new H2("Guantes de Caucho");
        Span precio15 = new Span("Precio: $5.000");
        textoStockGuantesCaucho = new Span("Cantidad: " + stockGuantesCaucho);
        textoStockGuantesCaucho.getElement().getThemeList().add("badge");
        producto15.add(nombre15, precio15, textoStockGuantesCaucho);

        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        VerticalLayout producto16 = new VerticalLayout();
        H2 nombre16 = new H2("Toallas de Papel");
        Span precio16 = new Span("Precio: $4.200");
        textoStockToallasPapel = new Span("Cantidad: " + stockToallasPapel);
        textoStockToallasPapel.getElement().getThemeList().add("badge");
        producto16.add(nombre16, precio16, textoStockToallasPapel);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombre17 = new H2("Papel Higiénico");
        Span precio17 = new Span("Precio: $18.000");
        textoStockPapelHigienico = new Span("Cantidad: " + stockPapelHigienico);
        textoStockPapelHigienico.getElement().getThemeList().add("badge");
        producto17.add(nombre17, precio17, textoStockPapelHigienico);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombre18 = new H2("Limpiador de Baños");
        Span precio18 = new Span("Precio: $8.500");
        textoStockLimpiadorBanos = new Span("Cantidad: " + stockLimpiadorBanos);
        textoStockLimpiadorBanos.getElement().getThemeList().add("badge");
        producto18.add(nombre18, precio18, textoStockLimpiadorBanos);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombre19 = new H2("Antisarro");
        Span precio19 = new Span("Precio: $10.000");
        textoStockAntisaro = new Span("Cantidad: " + stockAntisaro);
        textoStockAntisaro.getElement().getThemeList().add("badge");
        producto19.add(nombre19, precio19, textoStockAntisaro);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombre20 = new H2("Ambientador");
        Span precio20 = new Span("Precio: $11.000");
        textoStockAmbientador = new Span("Cantidad: " + stockAmbientador);
        textoStockAmbientador.getElement().getThemeList().add("badge");
        producto20.add(nombre20, precio20, textoStockAmbientador);

        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        VerticalLayout producto21 = new VerticalLayout();
        H2 nombre21 = new H2("Pastilla para Tanque");
        Span precio21 = new Span("Precio: $2.000");
        textoStockPastillaTanque = new Span("Cantidad: " + stockPastillaTanque);
        textoStockPastillaTanque.getElement().getThemeList().add("badge");
        producto21.add(nombre21, precio21, textoStockPastillaTanque);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombre22 = new H2("Cepillo de Mano");
        Span precio22 = new Span("Precio: $4.000");
        textoStockCepilloMano = new Span("Cantidad: " + stockCepilloMano);
        textoStockCepilloMano.getElement().getThemeList().add("badge");
        producto22.add(nombre22, precio22, textoStockCepilloMano);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombre23 = new H2("Viruta de Acero");
        Span precio23 = new Span("Precio: $1.500");
        textoStockVirutaAcero = new Span("Cantidad: " + stockVirutaAcero);
        textoStockVirutaAcero.getElement().getThemeList().add("badge");
        producto23.add(nombre23, precio23, textoStockVirutaAcero);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombre24 = new H2("Alcohol Antiséptico");
        Span precio24 = new Span("Precio: $3.800");
        textoStockAlcohol = new Span("Cantidad: " + stockAlcohol);
        textoStockAlcohol.getElement().getThemeList().add("badge");
        producto24.add(nombre24, precio24, textoStockAlcohol);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombre25 = new H2("Lustramuebles");
        Span precio25 = new Span("Precio: $12.500");
        textoStockLustramuebles = new Span("Cantidad: " + stockLustramuebles);
        textoStockLustramuebles.getElement().getThemeList().add("badge");
        producto25.add(nombre25, precio25, textoStockLustramuebles);

        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }
}
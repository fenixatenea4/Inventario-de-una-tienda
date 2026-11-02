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

    public int stockBlanqueador = 20;
    public Span textoStockBlanqueador;

    public int stockJabonPolvo = 15;
    public Span textoStockJabonPolvo;

    public int stockLimpiadorPisos = 25;
    public Span textoStockLimpiadorPisos;

    public int stockLavaloza = 30;
    public Span textoStockLavaloza;

    public int stockSuavizante = 18;
    public Span textoStockSuavizante;

    public int stockEsponjaBrillo = 40;
    public Span textoStockEsponjaBrillo;

    public int stockEscoba = 12;
    public Span textoStockEscoba;

    public int stockTrapiadora = 14;
    public Span textoStockTrapiadora;

    public int stockDesinfectante = 22;
    public Span textoStockDesinfectante;

    public int stockLimpiavidrios = 16;
    public Span textoStockLimpiavidrios;

    public int stockJabonBarra = 35;
    public Span textoStockJabonBarra;

    public int stockBolsaBasuraPequeña = 50;
    public Span textoStockBolsaBasuraPequeña;

    public int stockBolsaBasuraMediana = 45;
    public Span textoStockBolsaMediana;

    public int stockBolsaBasuraGrande = 30;
    public Span textoStockBolsaGrande;

    public int stockGuantesCaucho = 25;
    public Span textoStockGuantesCaucho;

    public int stockToallasPapel = 28;
    public Span textoStockToallasPapel;

    public int stockPapelHigienico = 60;
    public Span textoStockPapelHigienico;

    public int stockLimpiadorBanos = 19;
    public Span textoStockLimpiadorBanos;

    public int stockAntisaro = 10;
    public Span textoStockAntisaro;

    public int stockAmbientador = 24;
    public Span textoStockAmbientador;

    public int stockPastillaTanque = 33;
    public Span textoStockPastillaTanque;

    public int stockCepilloMano = 15;
    public Span textoStockCepilloMano;

    public int stockVirutaAcero = 38;
    public Span textoStockVirutaAcero;

    public int stockAlcohol = 42;
    public Span textoStockAlcohol;

    public int stockLustramuebles = 11;
    public Span textoStockLustramuebles;

    public AseoGeneralView() {
        H1 titulo = new H1("Sección de Aseo General");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1 (Productos 1 a 5)
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombre1 = new H2("Blanqueador");
        textoStockBlanqueador = new Span("Cantidad: " + stockBlanqueador);
        textoStockBlanqueador.getElement().getThemeList().add("badge");
        producto1.add(nombre1, textoStockBlanqueador);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombre2 = new H2("Jabón en Polvo");
        textoStockJabonPolvo = new Span("Cantidad: " + stockJabonPolvo);
        textoStockJabonPolvo.getElement().getThemeList().add("badge");
        producto2.add(nombre2, textoStockJabonPolvo);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombre3 = new H2("Limpiador de Pisos");
        textoStockLimpiadorPisos = new Span("Cantidad: " + stockLimpiadorPisos);
        textoStockLimpiadorPisos.getElement().getThemeList().add("badge");
        producto3.add(nombre3, textoStockLimpiadorPisos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombre4 = new H2("Lavaloza Líquido");
        textoStockLavaloza = new Span("Cantidad: " + stockLavaloza);
        textoStockLavaloza.getElement().getThemeList().add("badge");
        producto4.add(nombre4, textoStockLavaloza);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombre5 = new H2("Suavizante de Telas");
        textoStockSuavizante = new Span("Cantidad: " + stockSuavizante);
        textoStockSuavizante.getElement().getThemeList().add("badge");
        producto5.add(nombre5, textoStockSuavizante);

        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2 (Productos 6 a 10)
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombre6 = new H2("Esponja de Brillo");
        textoStockEsponjaBrillo = new Span("Cantidad: " + stockEsponjaBrillo);
        textoStockEsponjaBrillo.getElement().getThemeList().add("badge");
        producto6.add(nombre6, textoStockEsponjaBrillo);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombre7 = new H2("Escoba");
        textoStockEscoba = new Span("Cantidad: " + stockEscoba);
        textoStockEscoba.getElement().getThemeList().add("badge");
        producto7.add(nombre7, textoStockEscoba);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombre8 = new H2("Trapiadora");
        textoStockTrapiadora = new Span("Cantidad: " + stockTrapiadora);
        textoStockTrapiadora.getElement().getThemeList().add("badge");
        producto8.add(nombre8, textoStockTrapiadora);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombre9 = new H2("Desinfectante Multiusos");
        textoStockDesinfectante = new Span("Cantidad: " + stockDesinfectante);
        textoStockDesinfectante.getElement().getThemeList().add("badge");
        producto9.add(nombre9, textoStockDesinfectante);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombre10 = new H2("Limpiavidrios");
        textoStockLimpiavidrios = new Span("Cantidad: " + stockLimpiavidrios);
        textoStockLimpiavidrios.getElement().getThemeList().add("badge");
        producto10.add(nombre10, textoStockLimpiavidrios);

        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3 (Productos 11 a 15)
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombre11 = new H2("Jabón de Barra");
        textoStockJabonBarra = new Span("Cantidad: " + stockJabonBarra);
        textoStockJabonBarra.getElement().getThemeList().add("badge");
        producto11.add(nombre11, textoStockJabonBarra);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombre12 = new H2("Bolsa Basura Pequeña");
        textoStockBolsaBasuraPequeña = new Span("Cantidad: " + stockBolsaBasuraPequeña);
        textoStockBolsaBasuraPequeña.getElement().getThemeList().add("badge");
        producto12.add(nombre12, textoStockBolsaBasuraPequeña);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombre13 = new H2("Bolsa Basura Mediana");
        textoStockBolsaMediana = new Span("Cantidad: " + stockBolsaBasuraMediana);
        textoStockBolsaMediana.getElement().getThemeList().add("badge");
        producto13.add(nombre13, textoStockBolsaMediana);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombre14 = new H2("Bolsa Basura Grande");
        textoStockBolsaGrande = new Span("Cantidad: " + stockBolsaBasuraGrande);
        textoStockBolsaGrande.getElement().getThemeList().add("badge");
        producto14.add(nombre14, textoStockBolsaGrande);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombre15 = new H2("Guantes de Caucho");
        textoStockGuantesCaucho = new Span("Cantidad: " + stockGuantesCaucho);
        textoStockGuantesCaucho.getElement().getThemeList().add("badge");
        producto15.add(nombre15, textoStockGuantesCaucho);

        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4 (Productos 16 a 20)
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombre16 = new H2("Toallas de Papel");
        textoStockToallasPapel = new Span("Cantidad: " + stockToallasPapel);
        textoStockToallasPapel.getElement().getThemeList().add("badge");
        producto16.add(nombre16, textoStockToallasPapel);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombre17 = new H2("Papel Higiénico");
        textoStockPapelHigienico = new Span("Cantidad: " + stockPapelHigienico);
        textoStockPapelHigienico.getElement().getThemeList().add("badge");
        producto17.add(nombre17, textoStockPapelHigienico);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombre18 = new H2("Limpiador de Baños");
        textoStockLimpiadorBanos = new Span("Cantidad: " + stockLimpiadorBanos);
        textoStockLimpiadorBanos.getElement().getThemeList().add("badge");
        producto18.add(nombre18, textoStockLimpiadorBanos);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombre19 = new H2("Antisarro");
        textoStockAntisaro = new Span("Cantidad: " + stockAntisaro);
        textoStockAntisaro.getElement().getThemeList().add("badge");
        producto19.add(nombre19, textoStockAntisaro);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombre20 = new H2("Ambientador");
        textoStockAmbientador = new Span("Cantidad: " + stockAmbientador);
        textoStockAmbientador.getElement().getThemeList().add("badge");
        producto20.add(nombre20, textoStockAmbientador);

        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        // Fila 5 (Productos 21 a 25)
        VerticalLayout producto21 = new VerticalLayout();
        H2 nombre21 = new H2("Pastilla para Tanque");
        textoStockPastillaTanque = new Span("Cantidad: " + stockPastillaTanque);
        textoStockPastillaTanque.getElement().getThemeList().add("badge");
        producto21.add(nombre21, textoStockPastillaTanque);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombre22 = new H2("Cepillo de Mano");
        textoStockCepilloMano = new Span("Cantidad: " + stockCepilloMano);
        textoStockCepilloMano.getElement().getThemeList().add("badge");
        producto22.add(nombre22, textoStockCepilloMano);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombre23 = new H2("Viruta de Acero");
        textoStockVirutaAcero = new Span("Cantidad: " + stockVirutaAcero);
        textoStockVirutaAcero.getElement().getThemeList().add("badge");
        producto23.add(nombre23, textoStockVirutaAcero);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombre24 = new H2("Alcohol Antiséptico");
        textoStockAlcohol = new Span("Cantidad: " + stockAlcohol);
        textoStockAlcohol.getElement().getThemeList().add("badge");
        producto24.add(nombre24, textoStockAlcohol);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombre25 = new H2("Lustramuebles");
        textoStockLustramuebles = new Span("Cantidad: " + stockLustramuebles);
        textoStockLustramuebles.getElement().getThemeList().add("badge");
        producto25.add(nombre25, textoStockLustramuebles);

        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }
}
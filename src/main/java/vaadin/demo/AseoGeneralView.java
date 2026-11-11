package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("aseo-general")
public class AseoGeneralView extends VerticalLayout {

    public static int stockBlanqueador = 15;
    public static double precioBlanqueador = 5500.0;
    public Span textoStockBlanqueador;

    public static int stockJabonPolvo = 8;
    public static double precioJabonPolvo = 9000.0;
    public Span textoStockJabonPolvo;

    public static int stockLimpiadorPisos = 12;
    public static double precioLimpiadorPisos = 6500.0;
    public Span textoStockLimpiadorPisos;

    public static int stockLavaloza = 25;
    public static double precioLavaloza = 4800.0;
    public Span textoStockLavaloza;

    public static int stockSuavizante = 10;
    public static double precioSuavizante = 7500.0;
    public Span textoStockSuavizante;

    public static int stockEsponjaBrillo = 30;
    public static double precioEsponjaBrillo = 1500.0;
    public Span textoStockEsponjaBrillo;

    public static int stockEscoba = 6;
    public static double precioEscoba = 12000.0;
    public Span textoStockEscoba;

    public static int stockTrapero = 7;
    public static double precioTrapero = 14000.0;
    public Span textoStockTrapero;

    public static int stockDesinfectante = 14;
    public static double precioDesinfectante = 8500.0;
    public Span textoStockDesinfectante;

    public static int stockLimpiavidrios = 9;
    public static double precioLimpiavidrios = 7000.0;
    public Span textoStockLimpiavidrios;

    public static int stockJabonBarra = 22;
    public static double precioJabonBarra = 3200.0;
    public Span textoStockJabonBarra;

    public static int stockBolsaBasuraPequena = 40;
    public static double precioBolsaBasuraPequena = 3500.0;
    public Span textoStockBolsaBasuraPequena;

    public static int stockBolsaMediana = 35;
    public static double precioBolsaMediana = 5000.0;
    public Span textoStockBolsaMediana;

    public static int stockBolsaGrande = 20;
    public static double precioBolsaGrande = 7500.0;
    public Span textoStockBolsaGrande;

    public static int stockGuantesCaucho = 11;
    public static double precioGuantesCaucho = 6000.0;
    public Span textoStockGuantesCaucho;

    public static int stockToallasPapel = 18;
    public static double precioToallasPapel = 4500.0;
    public Span textoStockToallasPapel;

    public static int stockPapelHigienico = 50;
    public static double precioPapelHigienico = 16000.0;
    public Span textoStockPapelHigienico;

    public static int stockLimpiadorBanos = 13;
    public static double precioLimpiadorBanos = 8000.0;
    public Span textoStockLimpiadorBanos;

    public static int stockAntisaro = 5;
    public static double precioAntisaro = 9500.0;
    public Span textoStockAntisaro;

    public static int stockAmbientador = 16;
    public static double precioAmbientador = 7800.0;
    public Span textoStockAmbientador;

    public static int stockPastillaTanque = 12;
    public static double precioPastillaTanque = 4000.0;
    public Span textoStockPastillaTanque;

    public static int stockCepilloMano = 8;
    public static double precioCepilloMano = 3500.0;
    public Span textoStockCepilloMano;

    public static int stockVirutaAcero = 24;
    public static double precioVirutaAcero = 2000.0;
    public Span textoStockVirutaAcero;

    public static int stockAlcohol = 19;
    public static double precioAlcohol = 6500.0;
    public Span textoStockAlcohol;

    public static int stockLustramuebles = 7;
    public static double precioLustramuebles = 11000.0;
    public Span textoStockLustramuebles;

    public AseoGeneralView() {
        getStyle().set("background-color", "blue");
        H1 titulo = new H1("Aseo General");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombreBlanqueador = new H2("Blanqueador");
        Span textoPrecioBlanqueador = new Span("Precio: $" + precioBlanqueador);
        textoStockBlanqueador = new Span("Cantidad: " + stockBlanqueador);
        textoStockBlanqueador.getElement().getThemeList().add("badge");
        Span estadoBlanqueador = crearEtiquetaEstado(stockBlanqueador);
        producto1.add(nombreBlanqueador, textoPrecioBlanqueador, textoStockBlanqueador, estadoBlanqueador);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombreJabonPolvo = new H2("Jabón en Polvo");
        Span textoPrecioJabonPolvo = new Span("Precio: $" + precioJabonPolvo);
        textoStockJabonPolvo = new Span("Cantidad: " + stockJabonPolvo);
        textoStockJabonPolvo.getElement().getThemeList().add("badge");
        Span estadoJabonPolvo = crearEtiquetaEstado(stockJabonPolvo);
        producto2.add(nombreJabonPolvo, textoPrecioJabonPolvo, textoStockJabonPolvo, estadoJabonPolvo);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreLimpiadorPisos = new H2("Limpiador de Pisos");
        Span textoPrecioLimpiadorPisos = new Span("Precio: $" + precioLimpiadorPisos);
        textoStockLimpiadorPisos = new Span("Cantidad: " + stockLimpiadorPisos);
        textoStockLimpiadorPisos.getElement().getThemeList().add("badge");
        Span estadoLimpiadorPisos = crearEtiquetaEstado(stockLimpiadorPisos);
        producto3.add(nombreLimpiadorPisos, textoPrecioLimpiadorPisos, textoStockLimpiadorPisos, estadoLimpiadorPisos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreLavaloza = new H2("Lavaloza Líquido");
        Span textoPrecioLavaloza = new Span("Precio: $" + precioLavaloza);
        textoStockLavaloza = new Span("Cantidad: " + stockLavaloza);
        textoStockLavaloza.getElement().getThemeList().add("badge");
        Span estadoLavaloza = crearEtiquetaEstado(stockLavaloza);
        producto4.add(nombreLavaloza, textoPrecioLavaloza, textoStockLavaloza, estadoLavaloza);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombreSuavizante = new H2("Suavizante de Telas");
        Span textoPrecioSuavizante = new Span("Precio: $" + precioSuavizante);
        textoStockSuavizante = new Span("Cantidad: " + stockSuavizante);
        textoStockSuavizante.getElement().getThemeList().add("badge");
        Span estadoSuavizante = crearEtiquetaEstado(stockSuavizante);
        producto5.add(nombreSuavizante, textoPrecioSuavizante, textoStockSuavizante, estadoSuavizante);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreEsponjaBrillo = new H2("Esponja de Brillo");
        Span textoPrecioEsponjaBrillo = new Span("Precio: $" + precioEsponjaBrillo);
        textoStockEsponjaBrillo = new Span("Cantidad: " + stockEsponjaBrillo);
        textoStockEsponjaBrillo.getElement().getThemeList().add("badge");
        Span estadoEsponjaBrillo = crearEtiquetaEstado(stockEsponjaBrillo);
        producto6.add(nombreEsponjaBrillo, textoPrecioEsponjaBrillo, textoStockEsponjaBrillo, estadoEsponjaBrillo);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombreEscoba = new H2("Escoba");
        Span textoPrecioEscoba = new Span("Precio: $" + precioEscoba);
        textoStockEscoba = new Span("Cantidad: " + stockEscoba);
        textoStockEscoba.getElement().getThemeList().add("badge");
        Span estadoEscoba = crearEtiquetaEstado(stockEscoba);
        producto7.add(nombreEscoba, textoPrecioEscoba, textoStockEscoba, estadoEscoba);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreTrapero = new H2("Trapero");
        Span textoPrecioTrapero = new Span("Precio: $" + precioTrapero);
        textoStockTrapero = new Span("Cantidad: " + stockTrapero);
        textoStockTrapero.getElement().getThemeList().add("badge");
        Span estadoTrapero = crearEtiquetaEstado(stockTrapero);
        producto8.add(nombreTrapero, textoPrecioTrapero, textoStockTrapero, estadoTrapero);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreDesinfectante = new H2("Desinfectante Multiusos");
        Span textoPrecioDesinfectante = new Span("Precio: $" + precioDesinfectante);
        textoStockDesinfectante = new Span("Cantidad: " + stockDesinfectante);
        textoStockDesinfectante.getElement().getThemeList().add("badge");
        Span estadoDesinfectante = crearEtiquetaEstado(stockDesinfectante);
        producto9.add(nombreDesinfectante, textoPrecioDesinfectante, textoStockDesinfectante, estadoDesinfectante);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreLimpiavidrios = new H2("Limpiavidrios");
        Span textoPrecioLimpiavidrios = new Span("Precio: $" + precioLimpiavidrios);
        textoStockLimpiavidrios = new Span("Cantidad: " + stockLimpiavidrios);
        textoStockLimpiavidrios.getElement().getThemeList().add("badge");
        Span estadoLimpiavidrios = crearEtiquetaEstado(stockLimpiavidrios);
        producto10.add(nombreLimpiavidrios, textoPrecioLimpiavidrios, textoStockLimpiavidrios, estadoLimpiavidrios);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreJabonBarra = new H2("Jabón de Barra");
        Span textoPrecioJabonBarra = new Span("Precio: $" + precioJabonBarra);
        textoStockJabonBarra = new Span("Cantidad: " + stockJabonBarra);
        textoStockJabonBarra.getElement().getThemeList().add("badge");
        Span estadoJabonBarra = crearEtiquetaEstado(stockJabonBarra);
        producto11.add(nombreJabonBarra, textoPrecioJabonBarra, textoStockJabonBarra, estadoJabonBarra);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreBolsaBasuraPequena = new H2("Bolsa Basura Pequeña");
        Span textoPrecioBolsaBasuraPequena = new Span("Precio: $" + precioBolsaBasuraPequena);
        textoStockBolsaBasuraPequena = new Span("Cantidad: " + stockBolsaBasuraPequena);
        textoStockBolsaBasuraPequena.getElement().getThemeList().add("badge");
        Span estadoBolsaBasuraPequena = crearEtiquetaEstado(stockBolsaBasuraPequena);
        producto12.add(nombreBolsaBasuraPequena, textoPrecioBolsaBasuraPequena, textoStockBolsaBasuraPequena, estadoBolsaBasuraPequena);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreBolsaMediana = new H2("Bolsa Basura Mediana");
        Span textoPrecioBolsaMediana = new Span("Precio: $" + precioBolsaMediana);
        textoStockBolsaMediana = new Span("Cantidad: " + stockBolsaMediana);
        textoStockBolsaMediana.getElement().getThemeList().add("badge");
        Span estadoBolsaMediana = crearEtiquetaEstado(stockBolsaMediana);
        producto13.add(nombreBolsaMediana, textoPrecioBolsaMediana, textoStockBolsaMediana, estadoBolsaMediana);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreBolsaGrande = new H2("Bolsa Basura Grande");
        Span textoPrecioBolsaGrande = new Span("Precio: $" + precioBolsaGrande);
        textoStockBolsaGrande = new Span("Cantidad: " + stockBolsaGrande);
        textoStockBolsaGrande.getElement().getThemeList().add("badge");
        Span estadoBolsaGrande = crearEtiquetaEstado(stockBolsaGrande);
        producto14.add(nombreBolsaGrande, textoPrecioBolsaGrande, textoStockBolsaGrande, estadoBolsaGrande);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreGuantesCaucho = new H2("Guantes de Caucho");
        Span textoPrecioGuantesCaucho = new Span("Precio: $" + precioGuantesCaucho);
        textoStockGuantesCaucho = new Span("Cantidad: " + stockGuantesCaucho);
        textoStockGuantesCaucho.getElement().getThemeList().add("badge");
        Span estadoGuantesCaucho = crearEtiquetaEstado(stockGuantesCaucho);
        producto15.add(nombreGuantesCaucho, textoPrecioGuantesCaucho, textoStockGuantesCaucho, estadoGuantesCaucho);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombreToallasPapel = new H2("Toallas de Papel");
        Span textoPrecioToallasPapel = new Span("Precio: $" + precioToallasPapel);
        textoStockToallasPapel = new Span("Cantidad: " + stockToallasPapel);
        textoStockToallasPapel.getElement().getThemeList().add("badge");
        Span estadoToallasPapel = crearEtiquetaEstado(stockToallasPapel);
        producto16.add(nombreToallasPapel, textoPrecioToallasPapel, textoStockToallasPapel, estadoToallasPapel);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombrePapelHigienico = new H2("Papel Higiénico");
        Span textoPrecioPapelHigienico = new Span("Precio: $" + precioPapelHigienico);
        textoStockPapelHigienico = new Span("Cantidad: " + stockPapelHigienico);
        textoStockPapelHigienico.getElement().getThemeList().add("badge");
        Span estadoPapelHigienico = crearEtiquetaEstado(stockPapelHigienico);
        producto17.add(nombrePapelHigienico, textoPrecioPapelHigienico, textoStockPapelHigienico, estadoPapelHigienico);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreLimpiadorBanos = new H2("Limpiador de Baños");
        Span textoPrecioLimpiadorBanos = new Span("Precio: $" + precioLimpiadorBanos);
        textoStockLimpiadorBanos = new Span("Cantidad: " + stockLimpiadorBanos);
        textoStockLimpiadorBanos.getElement().getThemeList().add("badge");
        Span estadoLimpiadorBanos = crearEtiquetaEstado(stockLimpiadorBanos);
        producto18.add(nombreLimpiadorBanos, textoPrecioLimpiadorBanos, textoStockLimpiadorBanos, estadoLimpiadorBanos);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreAntisaro = new H2("Antisarro");
        Span textoPrecioAntisaro = new Span("Precio: $" + precioAntisaro);
        textoStockAntisaro = new Span("Cantidad: " + stockAntisaro);
        textoStockAntisaro.getElement().getThemeList().add("badge");
        Span estadoAntisaro = crearEtiquetaEstado(stockAntisaro);
        producto19.add(nombreAntisaro, textoPrecioAntisaro, textoStockAntisaro, estadoAntisaro);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreAmbientador = new H2("Ambientador");
        Span textoPrecioAmbientador = new Span("Precio: $" + precioAmbientador);
        textoStockAmbientador = new Span("Cantidad: " + stockAmbientador);
        textoStockAmbientador.getElement().getThemeList().add("badge");
        Span estadoAmbientador = crearEtiquetaEstado(stockAmbientador);
        producto20.add(nombreAmbientador, textoPrecioAmbientador, textoStockAmbientador, estadoAmbientador);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        // Fila 5
        VerticalLayout producto21 = new VerticalLayout();
        H2 nombrePastillaTanque = new H2("Pastilla para Tanque");
        Span textoPrecioPastillaTanque = new Span("Precio: $" + precioPastillaTanque);
        textoStockPastillaTanque = new Span("Cantidad: " + stockPastillaTanque);
        textoStockPastillaTanque.getElement().getThemeList().add("badge");
        Span estadoPastillaTanque = crearEtiquetaEstado(stockPastillaTanque);
        producto21.add(nombrePastillaTanque, textoPrecioPastillaTanque, textoStockPastillaTanque, estadoPastillaTanque);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombreCepilloMano = new H2("Cepillo de Mano");
        Span textoPrecioCepilloMano = new Span("Precio: $" + precioCepilloMano);
        textoStockCepilloMano = new Span("Cantidad: " + stockCepilloMano);
        textoStockCepilloMano.getElement().getThemeList().add("badge");
        Span estadoCepilloMano = crearEtiquetaEstado(stockCepilloMano);
        producto22.add(nombreCepilloMano, textoPrecioCepilloMano, textoStockCepilloMano, estadoCepilloMano);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombreVirutaAcero = new H2("Viruta de Acero");
        Span textoPrecioVirutaAcero = new Span("Precio: $" + precioVirutaAcero);
        textoStockVirutaAcero = new Span("Cantidad: " + stockVirutaAcero);
        textoStockVirutaAcero.getElement().getThemeList().add("badge");
        Span estadoVirutaAcero = crearEtiquetaEstado(stockVirutaAcero);
        producto23.add(nombreVirutaAcero, textoPrecioVirutaAcero, textoStockVirutaAcero, estadoVirutaAcero);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombreAlcohol = new H2("Alcohol Antiséptico");
        Span textoPrecioAlcohol = new Span("Precio: $" + precioAlcohol);
        textoStockAlcohol = new Span("Cantidad: " + stockAlcohol);
        textoStockAlcohol.getElement().getThemeList().add("badge");
        Span estadoAlcohol = crearEtiquetaEstado(stockAlcohol);
        producto24.add(nombreAlcohol, textoPrecioAlcohol, textoStockAlcohol, estadoAlcohol);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombreLustramuebles = new H2("Lustramuebles");
        Span textoPrecioLustramuebles = new Span("Precio: $" + precioLustramuebles);
        textoStockLustramuebles = new Span("Cantidad: " + stockLustramuebles);
        textoStockLustramuebles.getElement().getThemeList().add("badge");
        Span estadoLustramuebles = crearEtiquetaEstado(stockLustramuebles);
        producto25.add(nombreLustramuebles, textoPrecioLustramuebles, textoStockLustramuebles, estadoLustramuebles);
        
        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }

    // Método auxiliar privado para evaluar el stock y retornar la etiqueta formateada
    private Span crearEtiquetaEstado(int stock) {
        Span etiqueta = new Span();
        if (stock < 10) {
            etiqueta.setText("Ooco stock");
            etiqueta.getStyle().set("color", "red");
            etiqueta.getStyle().set("font-weight", "bold");
        } else {
            etiqueta.setText("Bien surtido");
            etiqueta.getStyle().set("color", "green");
            etiqueta.getStyle().set("font-weight", "bold");
        }
        return etiqueta;
    }
}
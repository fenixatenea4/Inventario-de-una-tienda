package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("canasta")
public class CanastaFamiliarView extends VerticalLayout {

    public static int stockArroz = 15;
    public static double precioArroz = 3500.0;
    public Span textoStockArroz;

    public static int stockFrijoles = 8;
    public static double precioFrijoles = 4800.0;
    public Span textoStockFrijoles;

    public static int stockHuevos = 30;
    public static double precioHuevos = 18000.0;
    public Span textoStockHuevos;

    public static int stockLeche = 12;
    public static double precioLeche = 3200.0;
    public Span textoStockLeche;

    public static int stockCarne = 5;
    public static double precioCarne = 25000.0;
    public Span textoStockCarne;

    public static int stockAtun = 20;
    public static double precioAtun = 6500.0;
    public Span textoStockAtun;

    public static int stockPan = 10;
    public static double precioPan = 4000.0;
    public Span textoStockPan;

    public static int stockQueso = 6;
    public static double precioQueso = 9500.0;
    public Span textoStockQueso;

    public static int stockYogurt = 15;
    public static double precioYogurt = 2200.0;
    public Span textoStockYogurt;

    public static int stockArepas = 8;
    public static double precioArepas = 3000.0;
    public Span textoStockArepas;

    public static int stockLentejas = 14;
    public static double precioLentejas = 4200.0;
    public Span textoStockLentejas;

    public static int stockBolsaSal = 25;
    public static double precioBolsaSal = 1500.0;
    public Span textoStockBolsaSal;

    public static int stockSalKilo = 18;
    public static double precioSalKilo = 2000.0;
    public Span textoStockSalKilo;

    public static int stockAzucarKilo = 22;
    public static double precioAzucarKilo = 3800.0;
    public Span textoStockAzucarKilo;

    public static int stockJamon = 11;
    public static double precioJamon = 12000.0;
    public Span textoStockJamon;

    public static int stockAceite = 35;
    public static double precioAceite = 15000.0;
    public Span textoStockAceite;

    public static int stockPasta = 40;
    public static double precioPasta = 2500.0;
    public Span textoStockPasta;

    public static int stockMantequilla = 13;
    public static double precioMantequilla = 4500.0;
    public Span textoStockMantequilla;

    public static int stockCafe = 28;
    public static double precioCafe = 20000.0;
    public Span textoStockCafe;

    public static int stockQuesito = 10;
    public static double precioQuesito = 6000.0;
    public Span textoStockQuesito;

    public CanastaFamiliarView() {
        getStyle().set("background-color", "brown");
        H1 titulo = new H1("Canasta Familiar");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombreArroz = new H2("Arroz x Kilo");
        Span textoPrecioArroz = new Span("Precio: $" + precioArroz);
        textoStockArroz = new Span("Cantidad: " + stockArroz);
        textoStockArroz.getElement().getThemeList().add("badge");
        Span estadoArroz = crearEtiquetaEstado(stockArroz);
        producto1.add(nombreArroz, textoPrecioArroz, textoStockArroz, estadoArroz);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombreFrijoles = new H2("Frijoles x Kilo");
        Span textoPrecioFrijoles = new Span("Precio: $" + precioFrijoles);
        textoStockFrijoles = new Span("Cantidad: " + stockFrijoles);
        textoStockFrijoles.getElement().getThemeList().add("badge");
        Span estadoFrijoles = crearEtiquetaEstado(stockFrijoles);
        producto2.add(nombreFrijoles, textoPrecioFrijoles, textoStockFrijoles, estadoFrijoles);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreHuevos = new H2("Cubeta de Huevos");
        Span textoPrecioHuevos = new Span("Precio: $" + precioHuevos);
        textoStockHuevos = new Span("Cantidad: " + stockHuevos);
        textoStockHuevos.getElement().getThemeList().add("badge");
        Span estadoHuevos = crearEtiquetaEstado(stockHuevos);
        producto3.add(nombreHuevos, textoPrecioHuevos, textoStockHuevos, estadoHuevos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreLeche = new H2("Bolsa de Leche");
        Span textoPrecioLeche = new Span("Precio: $" + precioLeche);
        textoStockLeche = new Span("Cantidad: " + stockLeche);
        textoStockLeche.getElement().getThemeList().add("badge");
        Span estadoLeche = crearEtiquetaEstado(stockLeche);
        producto4.add(nombreLeche, textoPrecioLeche, textoStockLeche, estadoLeche);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombreCarne = new H2("Carne de Res x Kilo");
        Span textoPrecioCarne = new Span("Precio: $" + precioCarne);
        textoStockCarne = new Span("Cantidad: " + stockCarne);
        textoStockCarne.getElement().getThemeList().add("badge");
        Span estadoCarne = crearEtiquetaEstado(stockCarne);
        producto5.add(nombreCarne, textoPrecioCarne, textoStockCarne, estadoCarne);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreAtun = new H2("Lata de Atún");
        Span textoPrecioAtun = new Span("Precio: $" + precioAtun);
        textoStockAtun = new Span("Cantidad: " + stockAtun);
        textoStockAtun.getElement().getThemeList().add("badge");
        Span estadoAtun = crearEtiquetaEstado(stockAtun);
        producto6.add(nombreAtun, textoPrecioAtun, textoStockAtun, estadoAtun);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombrePan = new H2("Pan Tajado");
        Span textoPrecioPan = new Span("Precio: $" + precioPan);
        textoStockPan = new Span("Cantidad: " + stockPan);
        textoStockPan.getElement().getThemeList().add("badge");
        Span estadoPan = crearEtiquetaEstado(stockPan);
        producto7.add(nombrePan, textoPrecioPan, textoStockPan, estadoPan);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreQueso = new H2("Bloque de Queso");
        Span textoPrecioQueso = new Span("Precio: $" + precioQueso);
        textoStockQueso = new Span("Cantidad: " + stockQueso);
        textoStockQueso.getElement().getThemeList().add("badge");
        Span estadoQueso = crearEtiquetaEstado(stockQueso);
        producto8.add(nombreQueso, textoPrecioQueso, textoStockQueso, estadoQueso);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreYogurt = new H2("Yogurt en Bolsa");
        Span textoPrecioYogurt = new Span("Precio: $" + precioYogurt);
        textoStockYogurt = new Span("Cantidad: " + stockYogurt);
        textoStockYogurt.getElement().getThemeList().add("badge");
        Span estadoYogurt = crearEtiquetaEstado(stockYogurt);
        producto9.add(nombreYogurt, textoPrecioYogurt, textoStockYogurt, estadoYogurt);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreArepas = new H2("Paquete de Arepas");
        Span textoPrecioArepas = new Span("Precio: $" + precioArepas);
        textoStockArepas = new Span("Cantidad: " + stockArepas);
        textoStockArepas.getElement().getThemeList().add("badge");
        Span estadoArepas = crearEtiquetaEstado(stockArepas);
        producto10.add(nombreArepas, textoPrecioArepas, textoStockArepas, estadoArepas);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreLentejas = new H2("Lentejas x Kilo");
        Span textoPrecioLentejas = new Span("Precio: $" + precioLentejas);
        textoStockLentejas = new Span("Cantidad: " + stockLentejas);
        textoStockLentejas.getElement().getThemeList().add("badge");
        Span estadoLentejas = crearEtiquetaEstado(stockLentejas);
        producto11.add(nombreLentejas, textoPrecioLentejas, textoStockLentejas, estadoLentejas);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreBolsaSal = new H2("Bolsa de Sal");
        Span textoPrecioBolsaSal = new Span("Precio: $" + precioBolsaSal);
        textoStockBolsaSal = new Span("Cantidad: " + stockBolsaSal);
        textoStockBolsaSal.getElement().getThemeList().add("badge");
        Span estadoBolsaSal = crearEtiquetaEstado(stockBolsaSal);
        producto12.add(nombreBolsaSal, textoPrecioBolsaSal, textoStockBolsaSal, estadoBolsaSal);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreSalKilo = new H2("Sal x Kilo");
        Span textoPrecioSalKilo = new Span("Precio: $" + precioSalKilo);
        textoStockSalKilo = new Span("Cantidad: " + stockSalKilo);
        textoStockSalKilo.getElement().getThemeList().add("badge");
        Span estadoSalKilo = crearEtiquetaEstado(stockSalKilo);
        producto13.add(nombreSalKilo, textoPrecioSalKilo, textoStockSalKilo, estadoSalKilo);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreAzucarKilo = new H2("Azúcar x Kilo");
        Span textoPrecioAzucarKilo = new Span("Precio: $" + precioAzucarKilo);
        textoStockAzucarKilo = new Span("Cantidad: " + stockAzucarKilo);
        textoStockAzucarKilo.getElement().getThemeList().add("badge");
        Span estadoAzucarKilo = crearEtiquetaEstado(stockAzucarKilo);
        producto14.add(nombreAzucarKilo, textoPrecioAzucarKilo, textoStockAzucarKilo, estadoAzucarKilo);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreJamon = new H2("Jamón");
        Span textoPrecioJamon = new Span("Precio: $" + precioJamon);
        textoStockJamon = new Span("Cantidad: " + stockJamon);
        textoStockJamon.getElement().getThemeList().add("badge");
        Span estadoJamon = crearEtiquetaEstado(stockJamon);
        producto15.add(nombreJamon, textoPrecioJamon, textoStockJamon, estadoJamon);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombreAceite = new H2("Aceite");
        Span textoPrecioAceite = new Span("Precio: $" + precioAceite);
        textoStockAceite = new Span("Cantidad: " + stockAceite);
        textoStockAceite.getElement().getThemeList().add("badge");
        Span estadoAceite = crearEtiquetaEstado(stockAceite);
        producto16.add(nombreAceite, textoPrecioAceite, textoStockAceite, estadoAceite);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombrePasta = new H2("Pasta");
        Span textoPrecioPasta = new Span("Precio: $" + precioPasta);
        textoStockPasta = new Span("Cantidad: " + stockPasta);
        textoStockPasta.getElement().getThemeList().add("badge");
        Span estadoPasta = crearEtiquetaEstado(stockPasta);
        producto17.add(nombrePasta, textoPrecioPasta, textoStockPasta, estadoPasta);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreMantequilla = new H2("Mantequilla");
        Span textoPrecioMantequilla = new Span("Precio: $" + precioMantequilla);
        textoStockMantequilla = new Span("Cantidad: " + stockMantequilla);
        textoStockMantequilla.getElement().getThemeList().add("badge");
        Span estadoMantequilla = crearEtiquetaEstado(stockMantequilla);
        producto18.add(nombreMantequilla, textoPrecioMantequilla, textoStockMantequilla, estadoMantequilla);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreCafe = new H2("Café");
        Span textoPrecioCafe = new Span("Precio: $" + precioCafe);
        textoStockCafe = new Span("Cantidad: " + stockCafe);
        textoStockCafe.getElement().getThemeList().add("badge");
        Span estadoCafe = crearEtiquetaEstado(stockCafe);
        producto19.add(nombreCafe, textoPrecioCafe, textoStockCafe, estadoCafe);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreQuesito = new H2("Quesito");
        Span textoPrecioQuesito = new Span("Precio: $" + precioQuesito);
        textoStockQuesito = new Span("Cantidad: " + stockQuesito);
        textoStockQuesito.getElement().getThemeList().add("badge");
        Span estadoQuesito = crearEtiquetaEstado(stockQuesito);
        producto20.add(nombreQuesito, textoPrecioQuesito, textoStockQuesito, estadoQuesito);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4);
    }

    // Método auxiliar privado para evaluar el stock y retornar la etiqueta formateada
    private Span crearEtiquetaEstado(int stock) {
        Span etiqueta = new Span();
        if (stock < 10) {
            etiqueta.setText("Poco stock");
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
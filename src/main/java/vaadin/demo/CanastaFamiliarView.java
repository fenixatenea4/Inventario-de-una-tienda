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
    public Span textoStockArroz;

     public static int stockFrijoles = 8;
    public Span textoStockFrijoles;

     public static int stockHuevos = 30;
    public Span textoStockHuevos;

     public static int stockLeche = 12;
    public Span textoStockLeche;

     public static int stockCarne = 5;
    public Span textoStockCarne;

     public static int stockAtun = 20;
    public Span textoStockAtun;

     public static int stockPan = 10;
    public Span textoStockPan;

     public static int stockQueso = 6;
    public Span textoStockQueso;

     public static int stockYogurt = 15;
    public Span textoStockYogurt;

     public static int stockArepas = 8;
    public Span textoStockArepas;

     public static int stockLentejas = 14;
    public Span textoStockLentejas;

     public static int stockBolsaSal = 25;
    public Span textoStockBolsaSal;

     public static int stockSalKilo = 18;
    public Span textoStockSalKilo;

     public static int stockAzucarKilo = 22;
    public Span textoStockAzucarKilo;

     public static int stockJamon = 11;
    public Span textoStockJamon;

     public static int stockAceite = 35;
    public Span textoStockAceite;

     public static int stockPasta = 40;
    public Span textoStockPasta;

     public static int stockMantequilla = 13;
    public Span textoStockMantequilla;

     public static int stockCafe = 28;
    public Span textoStockCafe;

     public static int stockQuesito = 10;
    public Span textoStockQuesito;

    public CanastaFamiliarView() {
        H1 titulo = new H1("Canasta Familiar");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombreArroz = new H2("Arroz x Kilo");
        Span precioArroz = new Span("Precio: $3.500");
        textoStockArroz = new Span("Cantidad: " + stockArroz);
        textoStockArroz.getElement().getThemeList().add("badge");
        producto1.add(nombreArroz, precioArroz, textoStockArroz);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombreFrijoles = new H2("Frijoles x Kilo");
        Span precioFrijoles = new Span("Precio: $4.800");
        textoStockFrijoles = new Span("Cantidad: " + stockFrijoles);
        textoStockFrijoles.getElement().getThemeList().add("badge");
        producto2.add(nombreFrijoles, precioFrijoles, textoStockFrijoles);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreHuevos = new H2("Cubeta de Huevos");
        Span precioHuevos = new Span("Precio: $18.000");
        textoStockHuevos = new Span("Cantidad: " + stockHuevos);
        textoStockHuevos.getElement().getThemeList().add("badge");
        producto3.add(nombreHuevos, precioHuevos, textoStockHuevos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreLeche = new H2("Bolsa de Leche");
        Span precioLeche = new Span("Precio: $3.200");
        textoStockLeche = new Span("Cantidad: " + stockLeche);
        textoStockLeche.getElement().getThemeList().add("badge");
        producto4.add(nombreLeche, precioLeche, textoStockLeche);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombreCarne = new H2("Carne de Res x Kilo");
        Span precioCarne = new Span("Precio: $25.000");
        textoStockCarne = new Span("Cantidad: " + stockCarne);
        textoStockCarne.getElement().getThemeList().add("badge");
        producto5.add(nombreCarne, precioCarne, textoStockCarne);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreAtun = new H2("Lata de Atún");
        Span precioAtun = new Span("Precio: $6.500");
        textoStockAtun = new Span("Cantidad: " + stockAtun);
        textoStockAtun.getElement().getThemeList().add("badge");
        producto6.add(nombreAtun, precioAtun, textoStockAtun);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombrePan = new H2("Pan Tajado");
        Span precioPan = new Span("Precio: $4.000");
        textoStockPan = new Span("Cantidad: " + stockPan);
        textoStockPan.getElement().getThemeList().add("badge");
        producto7.add(nombrePan, precioPan, textoStockPan);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreQueso = new H2("Bloque de Queso");
        Span precioQueso = new Span("Precio: $9.500");
        textoStockQueso = new Span("Cantidad: " + stockQueso);
        textoStockQueso.getElement().getThemeList().add("badge");
        producto8.add(nombreQueso, precioQueso, textoStockQueso);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreYogurt = new H2("Yogurt en Bolsa");
        Span precioYogurt = new Span("Precio: $2.200");
        textoStockYogurt = new Span("Cantidad: " + stockYogurt);
        textoStockYogurt.getElement().getThemeList().add("badge");
        producto9.add(nombreYogurt, precioYogurt, textoStockYogurt);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreArepas = new H2("Paquete de Arepas");
        Span precioArepas = new Span("Precio: $3.000");
        textoStockArepas = new Span("Cantidad: " + stockArepas);
        textoStockArepas.getElement().getThemeList().add("badge");
        producto10.add(nombreArepas, precioArepas, textoStockArepas);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreLentejas = new H2("Lentejas x Kilo");
        Span precioLentejas = new Span("Precio: $4.200");
        textoStockLentejas = new Span("Cantidad: " + stockLentejas);
        textoStockLentejas.getElement().getThemeList().add("badge");
        producto11.add(nombreLentejas, precioLentejas, textoStockLentejas);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreBolsaSal = new H2("Bolsa de Sal");
        Span precioBolsaSal = new Span("Precio: $1.500");
        textoStockBolsaSal = new Span("Cantidad: " + stockBolsaSal);
        textoStockBolsaSal.getElement().getThemeList().add("badge");
        producto12.add(nombreBolsaSal, precioBolsaSal, textoStockBolsaSal);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreSalKilo = new H2("Sal x Kilo");
        Span precioSalKilo = new Span("Precio: $2.000");
        textoStockSalKilo = new Span("Cantidad: " + stockSalKilo);
        textoStockSalKilo.getElement().getThemeList().add("badge");
        producto13.add(nombreSalKilo, precioSalKilo, textoStockSalKilo);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreAzucarKilo = new H2("Azúcar x Kilo");
        Span precioAzucar = new Span("Precio: $3.800");
        textoStockAzucarKilo = new Span("Cantidad: " + stockAzucarKilo);
        textoStockAzucarKilo.getElement().getThemeList().add("badge");
        producto14.add(nombreAzucarKilo, precioAzucar, textoStockAzucarKilo);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreJamon = new H2("Jamón");
        Span precioJamon = new Span("Precio: $12.000");
        textoStockJamon = new Span("Cantidad: " + stockJamon);
        textoStockJamon.getElement().getThemeList().add("badge");
        producto15.add(nombreJamon, precioJamon, textoStockJamon);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombreAceite = new H2("Aceite");
        Span precioAceite = new Span("Precio: $15.000");
        textoStockAceite = new Span("Cantidad: " + stockAceite);
        textoStockAceite.getElement().getThemeList().add("badge");
        producto16.add(nombreAceite, precioAceite, textoStockAceite);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombrePasta = new H2("Pasta");
        Span precioPasta = new Span("Precio: $2.500");
        textoStockPasta = new Span("Cantidad: " + stockPasta);
        textoStockPasta.getElement().getThemeList().add("badge");
        producto17.add(nombrePasta, precioPasta, textoStockPasta);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreMantequilla = new H2("Mantequilla");
        Span precioMantequilla = new Span("Precio: $4.500");
        textoStockMantequilla = new Span("Cantidad: " + stockMantequilla);
        textoStockMantequilla.getElement().getThemeList().add("badge");
        producto18.add(nombreMantequilla, precioMantequilla, textoStockMantequilla);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreCafe = new H2("Café");
        Span precioCafe = new Span("Precio: $20.000");
        textoStockCafe = new Span("Cantidad: " + stockCafe);
        textoStockCafe.getElement().getThemeList().add("badge");
        producto19.add(nombreCafe, precioCafe, textoStockCafe);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreQuesito = new H2("Quesito");
        Span precioQuesito = new Span("Precio: $6.000");
        textoStockQuesito = new Span("Cantidad: " + stockQuesito);
        textoStockQuesito.getElement().getThemeList().add("badge");
        producto20.add(nombreQuesito, precioQuesito, textoStockQuesito);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4);
    }
}
package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("confiteria")
public class ConfiteriaView extends VerticalLayout {

     public static int stockChocolatina = 45;
    public Span textoStockChocolatina;

     public static int stockBombon = 80;
    public Span textoStockBombon;

     public static int stockGomitas = 35;
    public Span textoStockGomitas;

     public static int stockGalletas = 50;
    public Span textoStockGalletas;

     public static int stockPapasMargarita = 25;
    public Span textoStockPapasMargarita;

     public static int stockCheetos = 30;
    public Span textoStockCheetos;

     public static int stockDoritos = 20;
    public Span textoStockDoritos;

     public static int stockChicles = 100;
    public Span textoStockChicles;

     public static int stockMasmelo = 40;
    public Span textoStockMasmelo;

     public static int stockMani = 15;
    public Span textoStockMani;

     public static int stockMenta = 120;
    public Span textoStockMenta;

     public static int stockChupeta = 60;
    public Span textoStockChupeta;

     public static int stockBarrilete = 55;
    public Span textoStockBarrilete;

     public static int stockChoclitos = 22;
    public Span textoStockChoclitos;

     public static int stockDetodito = 18;
    public Span textoStockDetodito;

     public static int stockTostacos = 28;
    public Span textoStockTostacos;

     public static int stockTrululu = 33;
    public Span textoStockTrululu;

     public static int stockFrunas = 75;
    public Span textoStockFrunas;

     public static int stockNucita = 48;
    public Span textoStockNucita;

     public static int stockOreo = 42;
    public Span textoStockOreo;

     public static int stockFestival = 38;
    public Span textoStockFestival;

     public static int stockBurbuja = 65;
    public Span textoStockBurbuja;

     public static int stockQuipitos = 85;
    public Span textoStockQuipitos;

     public static int stockSparkies = 52;
    public Span textoStockSparkies;

     public static int stockChocoBreak = 70;
    public Span textoStockChocoBreak;

    public ConfiteriaView() {
        H1 titulo = new H1("Confitería, Paquetes y Dulces");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        VerticalLayout producto1 = new VerticalLayout();
        H2 nombreChocolatina = new H2("Chocolatina Jumbo");
        Span precioChocolatina = new Span("Precio: $2.500");
        textoStockChocolatina = new Span("Cantidad: " + stockChocolatina);
        textoStockChocolatina.getElement().getThemeList().add("badge");
        producto1.add(nombreChocolatina, precioChocolatina, textoStockChocolatina);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombreBombon = new H2("Bon Bon Bum");
        Span precioBombon = new Span("Precio: $500");
        textoStockBombon = new Span("Cantidad: " + stockBombon);
        textoStockBombon.getElement().getThemeList().add("badge");
        producto2.add(nombreBombon, precioBombon, textoStockBombon);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreGomitas = new H2("Gomitas Grissly");
        Span precioGomitas = new Span("Precio: $1.200");
        textoStockGomitas = new Span("Cantidad: " + stockGomitas);
        textoStockGomitas.getElement().getThemeList().add("badge");
        producto3.add(nombreGomitas, precioGomitas, textoStockGomitas);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreGalletas = new H2("Galletas Saltín");
        Span precioGalletas = new Span("Precio: $1.500");
        textoStockGalletas = new Span("Cantidad: " + stockGalletas);
        textoStockGalletas.getElement().getThemeList().add("badge");
        producto4.add(nombreGalletas, precioGalletas, textoStockGalletas);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombrePapasMargarita = new H2("Papas Margarita");
        Span precioPapasMargarita = new Span("Precio: $3.000");
        textoStockPapasMargarita = new Span("Cantidad: " + stockPapasMargarita);
        textoStockPapasMargarita.getElement().getThemeList().add("badge");
        producto5.add(nombrePapasMargarita, precioPapasMargarita, textoStockPapasMargarita);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreCheetos = new H2("Cheetos");
        Span precioCheetos = new Span("Precio: $2.000");
        textoStockCheetos = new Span("Cantidad: " + stockCheetos);
        textoStockCheetos.getElement().getThemeList().add("badge");
        producto6.add(nombreCheetos, precioCheetos, textoStockCheetos);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombreDoritos = new H2("Doritos");
        Span precioDoritos = new Span("Precio: $3.500");
        textoStockDoritos = new Span("Cantidad: " + stockDoritos);
        textoStockDoritos.getElement().getThemeList().add("badge");
        producto7.add(nombreDoritos, precioDoritos, textoStockDoritos);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreChicles = new H2("Chicles Adams");
        Span precioChicles = new Span("Precio: $300");
        textoStockChicles = new Span("Cantidad: " + stockChicles);
        textoStockChicles.getElement().getThemeList().add("badge");
        producto8.add(nombreChicles, precioChicles, textoStockChicles);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreMasmelo = new H2("Masmelos Millows");
        Span precioMasmelo = new Span("Precio: $2.500");
        textoStockMasmelo = new Span("Cantidad: " + stockMasmelo);
        textoStockMasmelo.getElement().getThemeList().add("badge");
        producto9.add(nombreMasmelo, precioMasmelo, textoStockMasmelo);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreMani = new H2("Maní Moto");
        Span precioMani = new Span("Precio: $1.800");
        textoStockMani = new Span("Cantidad: " + stockMani);
        textoStockMani.getElement().getThemeList().add("badge");
        producto10.add(nombreMani, precioMani, textoStockMani);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreMenta = new H2("Mentas Chao");
        Span precioMenta = new Span("Precio: $100");
        textoStockMenta = new Span("Cantidad: " + stockMenta);
        textoStockMenta.getElement().getThemeList().add("badge");
        producto11.add(nombreMenta, precioMenta, textoStockMenta);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreChupeta = new H2("Chupeta Pin Pop");
        Span precioChupeta = new Span("Precio: $700");
        textoStockChupeta = new Span("Cantidad: " + stockChupeta);
        textoStockChupeta.getElement().getThemeList().add("badge");
        producto12.add(nombreChupeta, precioChupeta, textoStockChupeta);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreBarrilete = new H2("Barrilete");
        Span precioBarrilete = new Span("Precio: $400");
        textoStockBarrilete = new Span("Cantidad: " + stockBarrilete);
        textoStockBarrilete.getElement().getThemeList().add("badge");
        producto13.add(nombreBarrilete, precioBarrilete, textoStockBarrilete);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreChoclitos = new H2("Choclitos");
        Span precioChoclitos = new Span("Precio: $1.500");
        textoStockChoclitos = new Span("Cantidad: " + stockChoclitos);
        textoStockChoclitos.getElement().getThemeList().add("badge");
        producto14.add(nombreChoclitos, precioChoclitos, textoStockChoclitos);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreDetodito = new H2("De Todito");
        Span precioDetodito = new Span("Precio: $3.800");
        textoStockDetodito = new Span("Cantidad: " + stockDetodito);
        textoStockDetodito.getElement().getThemeList().add("badge");
        producto15.add(nombreDetodito, precioDetodito, textoStockDetodito);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        VerticalLayout producto16 = new VerticalLayout();
        H2 nombreTostacos = new H2("Tostacos");
        Span precioTostacos = new Span("Precio: $1.200");
        textoStockTostacos = new Span("Cantidad: " + stockTostacos);
        textoStockTostacos.getElement().getThemeList().add("badge");
        producto16.add(nombreTostacos, precioTostacos, textoStockTostacos);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombreTrululu = new H2("Trululú");
        Span precioTrululu = new Span("Precio: $1.500");
        textoStockTrululu = new Span("Cantidad: " + stockTrululu);
        textoStockTrululu.getElement().getThemeList().add("badge");
        producto17.add(nombreTrululu, precioTrululu, textoStockTrululu);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreFrunas = new H2("Frunas");
        Span precioFrunas = new Span("Precio: $200");
        textoStockFrunas = new Span("Cantidad: " + stockFrunas);
        textoStockFrunas.getElement().getThemeList().add("badge");
        producto18.add(nombreFrunas, precioFrunas, textoStockFrunas);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreNucita = new H2("Nucita");
        Span precioNucita = new Span("Precio: $800");
        textoStockNucita = new Span("Cantidad: " + stockNucita);
        textoStockNucita.getElement().getThemeList().add("badge");
        producto19.add(nombreNucita, precioNucita, textoStockNucita);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreOreo = new H2("Galletas Oreo");
        Span precioOreo = new Span("Precio: $2.200");
        textoStockOreo = new Span("Cantidad: " + stockOreo);
        textoStockOreo.getElement().getThemeList().add("badge");
        producto20.add(nombreOreo, precioOreo, textoStockOreo);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        VerticalLayout producto21 = new VerticalLayout();
        H2 nombreFestival = new H2("Galletas Festival");
        Span precioFestival = new Span("Precio: $1.400");
        textoStockFestival = new Span("Cantidad: " + stockFestival);
        textoStockFestival.getElement().getThemeList().add("badge");
        producto21.add(nombreFestival, precioFestival, textoStockFestival);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombreBurbuja = new H2("Burbuja Jet");
        Span precioBurbuja = new Span("Precio: $600");
        textoStockBurbuja = new Span("Cantidad: " + stockBurbuja);
        textoStockBurbuja.getElement().getThemeList().add("badge");
        producto22.add(nombreBurbuja, precioBurbuja, textoStockBurbuja);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombreQuipitos = new H2("Quipitos");
        Span precioQuipitos = new Span("Precio: $500");
        textoStockQuipitos = new Span("Cantidad: " + stockQuipitos);
        textoStockQuipitos.getElement().getThemeList().add("badge");
        producto23.add(nombreQuipitos, precioQuipitos, textoStockQuipitos);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombreSparkies = new H2("Sparkies");
        Span precioSparkies = new Span("Precio: $800");
        textoStockSparkies = new Span("Cantidad: " + stockSparkies);
        textoStockSparkies.getElement().getThemeList().add("badge");
        producto24.add(nombreSparkies, precioSparkies, textoStockSparkies);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombreChocoBreak = new H2("Choco Break");
        Span precioChocoBreak = new Span("Precio: $300");
        textoStockChocoBreak = new Span("Cantidad: " + stockChocoBreak);
        textoStockChocoBreak.getElement().getThemeList().add("badge");
        producto25.add(nombreChocoBreak, precioChocoBreak, textoStockChocoBreak);
        
        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }
}
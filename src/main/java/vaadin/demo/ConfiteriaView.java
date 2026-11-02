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

    public int stockChocolatina = 45;
    public Span textoStockChocolatina;

    public int stockBombon = 80;
    public Span textoStockBombon;

    public int stockGomitas = 35;
    public Span textoStockGomitas;

    public int stockGalletas = 50;
    public Span textoStockGalletas;

    public int stockPapasMargarita = 25;
    public Span textoStockPapasMargarita;

    public int stockCheetos = 30;
    public Span textoStockCheetos;

    public int stockDoritos = 20;
    public Span textoStockDoritos;

    public int stockChicles = 100;
    public Span textoStockChicles;

    public int stockMasmelo = 40;
    public Span textoStockMasmelo;

    public int stockMani = 15;
    public Span textoStockMani;

    public int stockMenta = 120;
    public Span textoStockMenta;

    public int stockChupeta = 60;
    public Span textoStockChupeta;

    public int stockBarrilete = 55;
    public Span textoStockBarrilete;

    public int stockChoclitos = 22;
    public Span textoStockChoclitos;

    public int stockDetodito = 18;
    public Span textoStockDetodito;

    public int stockTostacos = 28;
    public Span textoStockTostacos;

    public int stockTrululu = 33;
    public Span textoStockTrululu;

    public int stockFrunas = 75;
    public Span textoStockFrunas;

    public int stockNucita = 48;
    public Span textoStockNucita;

    public int stockOreo = 42;
    public Span textoStockOreo;

    public int stockFestival = 38;
    public Span textoStockFestival;

    public int stockBurbuja = 65;
    public Span textoStockBurbuja;

    public int stockQuipitos = 85;
    public Span textoStockQuipitos;

    public int stockSparkies = 52;
    public Span textoStockSparkies;

    public int stockChocoBreak = 70;
    public Span textoStockChocoBreak;

    public ConfiteriaView() {
        H1 titulo = new H1("Confitería, Paquetes y Dulces");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Productos 1 a 5
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombreChocolatina = new H2("Chocolatina Jumbo");
        textoStockChocolatina = new Span("Cantidad: " + stockChocolatina);
        textoStockChocolatina.getElement().getThemeList().add("badge");
        producto1.add(nombreChocolatina, textoStockChocolatina);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombreBombon = new H2("Bon Bon Bum");
        textoStockBombon = new Span("Cantidad: " + stockBombon);
        textoStockBombon.getElement().getThemeList().add("badge");
        producto2.add(nombreBombon, textoStockBombon);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreGomitas = new H2("Gomitas Grissly");
        textoStockGomitas = new Span("Cantidad: " + stockGomitas);
        textoStockGomitas.getElement().getThemeList().add("badge");
        producto3.add(nombreGomitas, textoStockGomitas);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreGalletas = new H2("Galletas Saltín");
        textoStockGalletas = new Span("Cantidad: " + stockGalletas);
        textoStockGalletas.getElement().getThemeList().add("badge");
        producto4.add(nombreGalletas, textoStockGalletas);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombrePapasMargarita = new H2("Papas Margarita");
        textoStockPapasMargarita = new Span("Cantidad: " + stockPapasMargarita);
        textoStockPapasMargarita.getElement().getThemeList().add("badge");
        producto5.add(nombrePapasMargarita, textoStockPapasMargarita);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Productos 6 a 10
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreCheetos = new H2("Cheetos");
        textoStockCheetos = new Span("Cantidad: " + stockCheetos);
        textoStockCheetos.getElement().getThemeList().add("badge");
        producto6.add(nombreCheetos, textoStockCheetos);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombreDoritos = new H2("Doritos");
        textoStockDoritos = new Span("Cantidad: " + stockDoritos);
        textoStockDoritos.getElement().getThemeList().add("badge");
        producto7.add(nombreDoritos, textoStockDoritos);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreChicles = new H2("Chicles Adams");
        textoStockChicles = new Span("Cantidad: " + stockChicles);
        textoStockChicles.getElement().getThemeList().add("badge");
        producto8.add(nombreChicles, textoStockChicles);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreMasmelo = new H2("Masmelos Millows");
        textoStockMasmelo = new Span("Cantidad: " + stockMasmelo);
        textoStockMasmelo.getElement().getThemeList().add("badge");
        producto9.add(nombreMasmelo, textoStockMasmelo);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreMani = new H2("Maní Moto");
        textoStockMani = new Span("Cantidad: " + stockMani);
        textoStockMani.getElement().getThemeList().add("badge");
        producto10.add(nombreMani, textoStockMani);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Productos 11 a 15
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreMenta = new H2("Mentas Chao");
        textoStockMenta = new Span("Cantidad: " + stockMenta);
        textoStockMenta.getElement().getThemeList().add("badge");
        producto11.add(nombreMenta, textoStockMenta);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreChupeta = new H2("Chupeta Pin Pop");
        textoStockChupeta = new Span("Cantidad: " + stockChupeta);
        textoStockChupeta.getElement().getThemeList().add("badge");
        producto12.add(nombreChupeta, textoStockChupeta);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreBarrilete = new H2("Barrilete");
        textoStockBarrilete = new Span("Cantidad: " + stockBarrilete);
        textoStockBarrilete.getElement().getThemeList().add("badge");
        producto13.add(nombreBarrilete, textoStockBarrilete);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreChoclitos = new H2("Choclitos");
        textoStockChoclitos = new Span("Cantidad: " + stockChoclitos);
        textoStockChoclitos.getElement().getThemeList().add("badge");
        producto14.add(nombreChoclitos, textoStockChoclitos);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreDetodito = new H2("De Todito");
        textoStockDetodito = new Span("Cantidad: " + stockDetodito);
        textoStockDetodito.getElement().getThemeList().add("badge");
        producto15.add(nombreDetodito, textoStockDetodito);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Productos 16 a 20
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombreTostacos = new H2("Tostacos");
        textoStockTostacos = new Span("Cantidad: " + stockTostacos);
        textoStockTostacos.getElement().getThemeList().add("badge");
        producto16.add(nombreTostacos, textoStockTostacos);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombreTrululu = new H2("Trululú");
        textoStockTrululu = new Span("Cantidad: " + stockTrululu);
        textoStockTrululu.getElement().getThemeList().add("badge");
        producto17.add(nombreTrululu, textoStockTrululu);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreFrunas = new H2("Frunas");
        textoStockFrunas = new Span("Cantidad: " + stockFrunas);
        textoStockFrunas.getElement().getThemeList().add("badge");
        producto18.add(nombreFrunas, textoStockFrunas);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreNucita = new H2("Nucita");
        textoStockNucita = new Span("Cantidad: " + stockNucita);
        textoStockNucita.getElement().getThemeList().add("badge");
        producto19.add(nombreNucita, textoStockNucita);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreOreo = new H2("Galletas Oreo");
        textoStockOreo = new Span("Cantidad: " + stockOreo);
        textoStockOreo.getElement().getThemeList().add("badge");
        producto20.add(nombreOreo, textoStockOreo);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        // Productos 21 a 25
        VerticalLayout producto21 = new VerticalLayout();
        H2 nombreFestival = new H2("Galletas Festival");
        textoStockFestival = new Span("Cantidad: " + stockFestival);
        textoStockFestival.getElement().getThemeList().add("badge");
        producto21.add(nombreFestival, textoStockFestival);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombreBurbuja = new H2("Burbuja Jet");
        textoStockBurbuja = new Span("Cantidad: " + stockBurbuja);
        textoStockBurbuja.getElement().getThemeList().add("badge");
        producto22.add(nombreBurbuja, textoStockBurbuja);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombreQuipitos = new H2("Quipitos");
        textoStockQuipitos = new Span("Cantidad: " + stockQuipitos);
        textoStockQuipitos.getElement().getThemeList().add("badge");
        producto23.add(nombreQuipitos, textoStockQuipitos);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombreSparkies = new H2("Sparkies");
        textoStockSparkies = new Span("Cantidad: " + stockSparkies);
        textoStockSparkies.getElement().getThemeList().add("badge");
        producto24.add(nombreSparkies, textoStockSparkies);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombreChocoBreak = new H2("Choco Break");
        textoStockChocoBreak = new Span("Cantidad: " + stockChocoBreak);
        textoStockChocoBreak.getElement().getThemeList().add("badge");
        producto25.add(nombreChocoBreak, textoStockChocoBreak);
        
        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }
}
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

    public static int stockChocolatina = 25;
    public static double precioChocolatina = 4000.0;
    public Span textoStockChocolatina;

    public static int stockBombon = 8;
    public static double precioBombon = 600.0;
    public Span textoStockBombon;

    public static int stockGomitas = 15;
    public static double precioGomitas = 2500.0;
    public Span textoStockGomitas;

    public static int stockGalletas = 30;
    public static double precioGalletas = 1800.0;
    public Span textoStockGalletas;

    public static int stockPapasMargarita = 12;
    public static double precioPapasMargarita = 2800.0;
    public Span textoStockPapasMargarita;

    public static int stockCheetos = 5;
    public static double precioCheetos = 2500.0;
    public Span textoStockCheetos;

    public static int stockDoritos = 18;
    public static double precioDoritos = 3000.0;
    public Span textoStockDoritos;

    public static int stockChicles = 40;
    public static double precioChicles = 500.0;
    public Span textoStockChicles;

    public static int stockMasmelo = 14;
    public static double precioMasmelo = 2000.0;
    public Span textoStockMasmelo;

    public static int stockMani = 22;
    public static double precioMani = 2200.0;
    public Span textoStockMani;

    public static int stockMenta = 35;
    public static double precioMenta = 300.0;
    public Span textoStockMenta;

    public static int stockChupeta = 7;
    public static double precioChupeta = 800.0;
    public Span textoStockChupeta;

    public static int stockBarrilete = 50;
    public static double precioBarrilete = 400.0;
    public Span textoStockBarrilete;

    public static int stockChoclitos = 16;
    public static double precioChoclitos = 2500.0;
    public Span textoStockChoclitos;

    public static int stockDetodito = 9;
    public static double precioDetodito = 3500.0;
    public Span textoStockDetodito;

    public static int stockTostacos = 11;
    public static double precioTostacos = 2500.0;
    public Span textoStockTostacos;

    public static int stockTrululu = 20;
    public static double precioTrululu = 1500.0;
    public Span textoStockTrululu;

    public static int stockFrunas = 45;
    public static double precioFrunas = 300.0;
    public Span textoStockFrunas;

    public static int stockNucita = 13;
    public static double precioNucita = 1200.0;
    public Span textoStockNucita;

    public static int stockOreo = 25;
    public static double precioOreo = 2000.0;
    public Span textoStockOreo;

    public static int stockFestival = 30;
    public static double precioFestival = 1200.0;
    public Span textoStockFestival;

    public static int stockBurbuja = 19;
    public static double precioBurbuja = 1500.0;
    public Span textoStockBurbuja;

    public static int stockQuipitos = 6;
    public static double precioQuipitos = 1000.0;
    public Span textoStockQuipitos;

    public static int stockSparkies = 40;
    public static double precioSparkies = 400.0;
    public Span textoStockSparkies;

    public static int stockChocoBreak = 22;
    public static double precioChocoBreak = 500.0;
    public Span textoStockChocoBreak;

    public ConfiteriaView() {
        getStyle().set("background-color", "pink");
        H1 titulo = new H1("Confitería");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombreChocolatina = new H2("Chocolatina Jumbo");
        Span textoPrecioChocolatina = new Span("Precio: $" + precioChocolatina);
        textoStockChocolatina = new Span("Cantidad: " + stockChocolatina);
        textoStockChocolatina.getElement().getThemeList().add("badge");
        Span estadoChocolatina = crearEtiquetaEstado(stockChocolatina);
        producto1.add(nombreChocolatina, textoPrecioChocolatina, textoStockChocolatina, estadoChocolatina);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombreBombon = new H2("Bon Bon Bum");
        Span textoPrecioBombon = new Span("Precio: $" + precioBombon);
        textoStockBombon = new Span("Cantidad: " + stockBombon);
        textoStockBombon.getElement().getThemeList().add("badge");
        Span estadoBombon = crearEtiquetaEstado(stockBombon);
        producto2.add(nombreBombon, textoPrecioBombon, textoStockBombon, estadoBombon);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreGomitas = new H2("Gomitas Grissly");
        Span textoPrecioGomitas = new Span("Precio: $" + precioGomitas);
        textoStockGomitas = new Span("Cantidad: " + stockGomitas);
        textoStockGomitas.getElement().getThemeList().add("badge");
        Span estadoGomitas = crearEtiquetaEstado(stockGomitas);
        producto3.add(nombreGomitas, textoPrecioGomitas, textoStockGomitas, estadoGomitas);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreGalletas = new H2("Galletas Saltín");
        Span textoPrecioGalletas = new Span("Precio: $" + precioGalletas);
        textoStockGalletas = new Span("Cantidad: " + stockGalletas);
        textoStockGalletas.getElement().getThemeList().add("badge");
        Span estadoGalletas = crearEtiquetaEstado(stockGalletas);
        producto4.add(nombreGalletas, textoPrecioGalletas, textoStockGalletas, estadoGalletas);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombrePapasMargarita = new H2("Papas Margarita");
        Span textoPrecioPapasMargarita = new Span("Precio: $" + precioPapasMargarita);
        textoStockPapasMargarita = new Span("Cantidad: " + stockPapasMargarita);
        textoStockPapasMargarita.getElement().getThemeList().add("badge");
        Span estadoPapasMargarita = crearEtiquetaEstado(stockPapasMargarita);
        producto5.add(nombrePapasMargarita, textoPrecioPapasMargarita, textoStockPapasMargarita, estadoPapasMargarita);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreCheetos = new H2("Cheetos");
        Span textoPrecioCheetos = new Span("Precio: $" + precioCheetos);
        textoStockCheetos = new Span("Cantidad: " + stockCheetos);
        textoStockCheetos.getElement().getThemeList().add("badge");
        Span estadoCheetos = crearEtiquetaEstado(stockCheetos);
        producto6.add(nombreCheetos, textoPrecioCheetos, textoStockCheetos, estadoCheetos);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombreDoritos = new H2("Doritos");
        Span textoPrecioDoritos = new Span("Precio: $" + precioDoritos);
        textoStockDoritos = new Span("Cantidad: " + stockDoritos);
        textoStockDoritos.getElement().getThemeList().add("badge");
        Span estadoDoritos = crearEtiquetaEstado(stockDoritos);
        producto7.add(nombreDoritos, textoPrecioDoritos, textoStockDoritos, estadoDoritos);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreChicles = new H2("Chicles Adams");
        Span textoPrecioChicles = new Span("Precio: $" + precioChicles);
        textoStockChicles = new Span("Cantidad: " + stockChicles);
        textoStockChicles.getElement().getThemeList().add("badge");
        Span estadoChicles = crearEtiquetaEstado(stockChicles);
        producto8.add(nombreChicles, textoPrecioChicles, textoStockChicles, estadoChicles);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreMasmelo = new H2("Masmelos Millows");
        Span textoPrecioMasmelo = new Span("Precio: $" + precioMasmelo);
        textoStockMasmelo = new Span("Cantidad: " + stockMasmelo);
        textoStockMasmelo.getElement().getThemeList().add("badge");
        Span estadoMasmelo = crearEtiquetaEstado(stockMasmelo);
        producto9.add(nombreMasmelo, textoPrecioMasmelo, textoStockMasmelo, estadoMasmelo);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreMani = new H2("Maní Moto");
        Span textoPrecioMani = new Span("Precio: $" + precioMani);
        textoStockMani = new Span("Cantidad: " + stockMani);
        textoStockMani.getElement().getThemeList().add("badge");
        Span estadoMani = crearEtiquetaEstado(stockMani);
        producto10.add(nombreMani, textoPrecioMani, textoStockMani, estadoMani);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreMenta = new H2("Mentas Chao");
        Span textoPrecioMenta = new Span("Precio: $" + precioMenta);
        textoStockMenta = new Span("Cantidad: " + stockMenta);
        textoStockMenta.getElement().getThemeList().add("badge");
        Span estadoMenta = crearEtiquetaEstado(stockMenta);
        producto11.add(nombreMenta, textoPrecioMenta, textoStockMenta, estadoMenta);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreChupeta = new H2("Chupeta Pin Pop");
        Span textoPrecioChupeta = new Span("Precio: $" + precioChupeta);
        textoStockChupeta = new Span("Cantidad: " + stockChupeta);
        textoStockChupeta.getElement().getThemeList().add("badge");
        Span estadoChupeta = crearEtiquetaEstado(stockChupeta);
        producto12.add(nombreChupeta, textoPrecioChupeta, textoStockChupeta, estadoChupeta);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreBarrilete = new H2("Barrilete");
        Span textoPrecioBarrilete = new Span("Precio: $" + precioBarrilete);
        textoStockBarrilete = new Span("Cantidad: " + stockBarrilete);
        textoStockBarrilete.getElement().getThemeList().add("badge");
        Span estadoBarrilete = crearEtiquetaEstado(stockBarrilete);
        producto13.add(nombreBarrilete, textoPrecioBarrilete, textoStockBarrilete, estadoBarrilete);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreChoclitos = new H2("Choclitos");
        Span textoPrecioChoclitos = new Span("Precio: $" + precioChoclitos);
        textoStockChoclitos = new Span("Cantidad: " + stockChoclitos);
        textoStockChoclitos.getElement().getThemeList().add("badge");
        Span estadoChoclitos = crearEtiquetaEstado(stockChoclitos);
        producto14.add(nombreChoclitos, textoPrecioChoclitos, textoStockChoclitos, estadoChoclitos);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreDetodito = new H2("De Todito");
        Span textoPrecioDetodito = new Span("Precio: $" + precioDetodito);
        textoStockDetodito = new Span("Cantidad: " + stockDetodito);
        textoStockDetodito.getElement().getThemeList().add("badge");
        Span estadoDetodito = crearEtiquetaEstado(stockDetodito);
        producto15.add(nombreDetodito, textoPrecioDetodito, textoStockDetodito, estadoDetodito);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombreTostacos = new H2("Tostacos");
        Span textoPrecioTostacos = new Span("Precio: $" + precioTostacos);
        textoStockTostacos = new Span("Cantidad: " + stockTostacos);
        textoStockTostacos.getElement().getThemeList().add("badge");
        Span estadoTostacos = crearEtiquetaEstado(stockTostacos);
        producto16.add(nombreTostacos, textoPrecioTostacos, textoStockTostacos, estadoTostacos);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombreTrululu = new H2("Trululú");
        Span textoPrecioTrululu = new Span("Precio: $" + precioTrululu);
        textoStockTrululu = new Span("Cantidad: " + stockTrululu);
        textoStockTrululu.getElement().getThemeList().add("badge");
        Span estadoTrululu = crearEtiquetaEstado(stockTrululu);
        producto17.add(nombreTrululu, textoPrecioTrululu, textoStockTrululu, estadoTrululu);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreFrunas = new H2("Frunas");
        Span textoPrecioFrunas = new Span("Precio: $" + precioFrunas);
        textoStockFrunas = new Span("Cantidad: " + stockFrunas);
        textoStockFrunas.getElement().getThemeList().add("badge");
        Span estadoFrunas = crearEtiquetaEstado(stockFrunas);
        producto18.add(nombreFrunas, textoPrecioFrunas, textoStockFrunas, estadoFrunas);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreNucita = new H2("Nucita");
        Span textoPrecioNucita = new Span("Precio: $" + precioNucita);
        textoStockNucita = new Span("Cantidad: " + stockNucita);
        textoStockNucita.getElement().getThemeList().add("badge");
        Span estadoNucita = crearEtiquetaEstado(stockNucita);
        producto19.add(nombreNucita, textoPrecioNucita, textoStockNucita, estadoNucita);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreOreo = new H2("Galletas Oreo");
        Span textoPrecioOreo = new Span("Precio: $" + precioOreo);
        textoStockOreo = new Span("Cantidad: " + stockOreo);
        textoStockOreo.getElement().getThemeList().add("badge");
        Span estadoOreo = crearEtiquetaEstado(stockOreo);
        producto20.add(nombreOreo, textoPrecioOreo, textoStockOreo, estadoOreo);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        // Fila 5
        VerticalLayout producto21 = new VerticalLayout();
        H2 nombreFestival = new H2("Galletas Festival");
        Span textoPrecioFestival = new Span("Precio: $" + precioFestival);
        textoStockFestival = new Span("Cantidad: " + stockFestival);
        textoStockFestival.getElement().getThemeList().add("badge");
        Span estadoFestival = crearEtiquetaEstado(stockFestival);
        producto21.add(nombreFestival, textoPrecioFestival, textoStockFestival, estadoFestival);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombreBurbuja = new H2("Burbuja Jet");
        Span textoPrecioBurbuja = new Span("Precio: $" + precioBurbuja);
        textoStockBurbuja = new Span("Cantidad: " + stockBurbuja);
        textoStockBurbuja.getElement().getThemeList().add("badge");
        Span estadoBurbuja = crearEtiquetaEstado(stockBurbuja);
        producto22.add(nombreBurbuja, textoPrecioBurbuja, textoStockBurbuja, estadoBurbuja);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombreQuipitos = new H2("Quipitos");
        Span textoPrecioQuipitos = new Span("Precio: $" + precioQuipitos);
        textoStockQuipitos = new Span("Cantidad: " + stockQuipitos);
        textoStockQuipitos.getElement().getThemeList().add("badge");
        Span estadoQuipitos = crearEtiquetaEstado(stockQuipitos);
        producto23.add(nombreQuipitos, textoPrecioQuipitos, textoStockQuipitos, estadoQuipitos);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombreSparkies = new H2("Sparkies");
        Span textoPrecioSparkies = new Span("Precio: $" + precioSparkies);
        textoStockSparkies = new Span("Cantidad: " + stockSparkies);
        textoStockSparkies.getElement().getThemeList().add("badge");
        Span estadoSparkies = crearEtiquetaEstado(stockSparkies);
        producto24.add(nombreSparkies, textoPrecioSparkies, textoStockSparkies, estadoSparkies);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombreChocoBreak = new H2("Choco Break");
        Span textoPrecioChocoBreak = new Span("Precio: $" + precioChocoBreak);
        textoStockChocoBreak = new Span("Cantidad: " + stockChocoBreak);
        textoStockChocoBreak.getElement().getThemeList().add("badge");
        Span estadoChocoBreak = crearEtiquetaEstado(stockChocoBreak);
        producto25.add(nombreChocoBreak, textoPrecioChocoBreak, textoStockChocoBreak, estadoChocoBreak);
        
        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
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
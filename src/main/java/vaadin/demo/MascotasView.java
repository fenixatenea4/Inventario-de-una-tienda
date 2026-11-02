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

    public int stockPerrarinaAdultos = 20;
    public Span textoStockPerrarinaAdultos;

    public int stockPerrarinaCachorros = 15;
    public Span textoStockPerrarinaCachorros;

    public int stockGatarinaAdultos = 25;
    public Span textoStockGatarinaAdultos;

    public int stockGatarinaCachorros = 10;
    public Span textoStockGatarinaCachorros;

    public int stockHuesitos = 50;
    public Span textoStockHuesitos;

    public int stockGalletasPerro = 30;
    public Span textoStockGalletasPerro;

    public int stockLataCarnePerro = 40;
    public Span textoStockLataCarnePerro;

    public int stockLataAtunGato = 35;
    public Span textoStockLataAtunGato;

    public int stockShampooAntipulgas = 12;
    public Span textoStockShampooAntipulgas;

    public int stockJabonPerro = 18;
    public Span textoStockJabonPerro;

    public int stockAntipulgasPipeta = 22;
    public Span textoStockAntipulgasPipeta;

    public int stockDesparasitante = 14;
    public Span textoStockDesparasitante;

    public int stockCollarSimple = 16;
    public Span textoStockCollarSimple;

    public int stockCollarAntipulgas = 8;
    public Span textoStockCollarAntipulgas;

    public int stockCorreaRetractil = 9;
    public Span textoStockCorreaRetractil;

    public int stockPlatoComedero = 25;
    public Span textoStockPlatoComedero;

    public int stockPlatoBebedero = 20;
    public Span textoStockPlatoBebedero;

    public int stockCamaMediana = 6;
    public Span textoStockCamaMediana;

    public int stockJuguetePelota = 30;
    public Span textoStockJuguetePelota;

    public int stockJugueteHueso = 28;
    public Span textoStockJugueteHueso;

    public int stockRascadorGato = 5;
    public Span textoStockRascadorGato;

    public int stockArenaSanitaria = 18;
    public Span textoStockArenaSanitaria;

    public int stockHierbaGatera = 12;
    public Span textoStockHierbaGatera;

    public int stockRopaMascota = 15;
    public Span textoStockRopaMascota;

    public int stockBozal = 10;
    public Span textoStockBozal;

    public MascotasView() {
        H1 titulo = new H1("Sección de Mascotas");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1 (Productos 1 a 5)
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombre1 = new H2("Perrarina Adultos");
        textoStockPerrarinaAdultos = new Span("Cantidad: " + stockPerrarinaAdultos);
        textoStockPerrarinaAdultos.getElement().getThemeList().add("badge");
        producto1.add(nombre1, textoStockPerrarinaAdultos);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombre2 = new H2("Perrarina Cachorros");
        textoStockPerrarinaCachorros = new Span("Cantidad: " + stockPerrarinaCachorros);
        textoStockPerrarinaCachorros.getElement().getThemeList().add("badge");
        producto2.add(nombre2, textoStockPerrarinaCachorros);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombre3 = new H2("Gatarina Adultos");
        textoStockGatarinaAdultos = new Span("Cantidad: " + stockGatarinaAdultos);
        textoStockGatarinaAdultos.getElement().getThemeList().add("badge");
        producto3.add(nombre3, textoStockGatarinaAdultos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombre4 = new H2("Gatarina Cachorros");
        textoStockGatarinaCachorros = new Span("Cantidad: " + stockGatarinaCachorros);
        textoStockGatarinaCachorros.getElement().getThemeList().add("badge");
        producto4.add(nombre4, textoStockGatarinaCachorros);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombre5 = new H2("Huesitos de Premio");
        textoStockHuesitos = new Span("Cantidad: " + stockHuesitos);
        textoStockHuesitos.getElement().getThemeList().add("badge");
        producto5.add(nombre5, textoStockHuesitos);

        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2 (Productos 6 a 10)
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombre6 = new H2("Galletas para Perro");
        textoStockGalletasPerro = new Span("Cantidad: " + stockGalletasPerro);
        textoStockGalletasPerro.getElement().getThemeList().add("badge");
        producto6.add(nombre6, textoStockGalletasPerro);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombre7 = new H2("Lata Carne Perro");
        textoStockLataCarnePerro = new Span("Cantidad: " + stockLataCarnePerro);
        textoStockLataCarnePerro.getElement().getThemeList().add("badge");
        producto7.add(nombre7, textoStockLataCarnePerro);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombre8 = new H2("Lata Atún Gato");
        textoStockLataAtunGato = new Span("Cantidad: " + stockLataAtunGato);
        textoStockLataAtunGato.getElement().getThemeList().add("badge");
        producto8.add(nombre8, textoStockLataAtunGato);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombre9 = new H2("Shampoo Antipulgas");
        textoStockShampooAntipulgas = new Span("Cantidad: " + stockShampooAntipulgas);
        textoStockShampooAntipulgas.getElement().getThemeList().add("badge");
        producto9.add(nombre9, textoStockShampooAntipulgas);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombre10 = new H2("Jabón para Perro");
        textoStockJabonPerro = new Span("Cantidad: " + stockJabonPerro);
        textoStockJabonPerro.getElement().getThemeList().add("badge");
        producto10.add(nombre10, textoStockJabonPerro);

        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3 (Productos 11 a 15)
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombre11 = new H2("Pipeta Antipulgas");
        textoStockAntipulgasPipeta = new Span("Cantidad: " + stockAntipulgasPipeta);
        textoStockAntipulgasPipeta.getElement().getThemeList().add("badge");
        producto11.add(nombre11, textoStockAntipulgasPipeta);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombre12 = new H2("Desparasitante");
        textoStockDesparasitante = new Span("Cantidad: " + stockDesparasitante);
        textoStockDesparasitante.getElement().getThemeList().add("badge");
        producto12.add(nombre12, textoStockDesparasitante);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombre13 = new H2("Collar Simple");
        textoStockCollarSimple = new Span("Cantidad: " + stockCollarSimple);
        textoStockCollarSimple.getElement().getThemeList().add("badge");
        producto13.add(nombre13, textoStockCollarSimple);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombre14 = new H2("Collar Antipulgas");
        textoStockCollarAntipulgas = new Span("Cantidad: " + stockCollarAntipulgas);
        textoStockCollarAntipulgas.getElement().getThemeList().add("badge");
        producto14.add(nombre14, textoStockCollarAntipulgas);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombre15 = new H2("Correa Retráctil");
        textoStockCorreaRetractil = new Span("Cantidad: " + stockCorreaRetractil);
        textoStockCorreaRetractil.getElement().getThemeList().add("badge");
        producto15.add(nombre15, textoStockCorreaRetractil);

        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4 (Productos 16 a 20)
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombre16 = new H2("Plato Comedero");
        textoStockPlatoComedero = new Span("Cantidad: " + stockPlatoComedero);
        textoStockPlatoComedero.getElement().getThemeList().add("badge");
        producto16.add(nombre16, textoStockPlatoComedero);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombre17 = new H2("Plato Bebedero");
        textoStockPlatoBebedero = new Span("Cantidad: " + stockPlatoBebedero);
        textoStockPlatoBebedero.getElement().getThemeList().add("badge");
        producto17.add(nombre17, textoStockPlatoBebedero);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombre18 = new H2("Cama Mediana");
        textoStockCamaMediana = new Span("Cantidad: " + stockCamaMediana);
        textoStockCamaMediana.getElement().getThemeList().add("badge");
        producto18.add(nombre18, textoStockCamaMediana);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombre19 = new H2("Pelota de Juguete");
        textoStockJuguetePelota = new Span("Cantidad: " + stockJuguetePelota);
        textoStockJuguetePelota.getElement().getThemeList().add("badge");
        producto19.add(nombre19, textoStockJuguetePelota);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombre20 = new H2("Hueso de Juguete");
        textoStockJugueteHueso = new Span("Cantidad: " + stockJugueteHueso);
        textoStockJugueteHueso.getElement().getThemeList().add("badge");
        producto20.add(nombre20, textoStockJugueteHueso);

        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        // Fila 5 (Productos 21 a 25)
        VerticalLayout producto21 = new VerticalLayout();
        H2 nombre21 = new H2("Rascador de Gato");
        textoStockRascadorGato = new Span("Cantidad: " + stockRascadorGato);
        textoStockRascadorGato.getElement().getThemeList().add("badge");
        producto21.add(nombre21, textoStockRascadorGato);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombre22 = new H2("Arena Sanitaria");
        textoStockArenaSanitaria = new Span("Cantidad: " + stockArenaSanitaria);
        textoStockArenaSanitaria.getElement().getThemeList().add("badge");
        producto22.add(nombre22, textoStockArenaSanitaria);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombre23 = new H2("Hierba Gatera");
        textoStockHierbaGatera = new Span("Cantidad: " + stockHierbaGatera);
        textoStockHierbaGatera.getElement().getThemeList().add("badge");
        producto23.add(nombre23, textoStockHierbaGatera);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombre24 = new H2("Ropa para Mascota");
        textoStockRopaMascota = new Span("Cantidad: " + stockRopaMascota);
        textoStockRopaMascota.getElement().getThemeList().add("badge");
        producto24.add(nombre24, textoStockRopaMascota);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombre25 = new H2("Bozal");
        textoStockBozal = new Span("Cantidad: " + stockBozal);
        textoStockBozal.getElement().getThemeList().add("badge");
        producto25.add(nombre25, textoStockBozal);

        HorizontalLayout fila5 = new HorizontalLayout(producto21, producto22, producto23, producto24, producto25);
        fila5.setWidthFull();

        add(titulo, botonVolver, fila1, fila2, fila3, fila4, fila5);
    }
}
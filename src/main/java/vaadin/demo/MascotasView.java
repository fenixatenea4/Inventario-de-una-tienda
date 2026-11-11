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

    public static int stockPerrarinaAdultos = 15;
    public static double precioPerrarinaAdultos = 45000.0;
    public Span textoStockPerrarinaAdultos;

    public static int stockPerrarinaCachorros = 8;
    public static double precioPerrarinaCachorros = 48000.0;
    public Span textoStockPerrarinaCachorros;

    public static int stockGatarinaAdultos = 12;
    public static double precioGatarinaAdultos = 42000.0;
    public Span textoStockGatarinaAdultos;

    public static int stockGatarinaCachorros = 6;
    public static double precioGatarinaCachorros = 46000.0;
    public Span textoStockGatarinaCachorros;

    public static int stockHuesitos = 25;
    public static double precioHuesitos = 5000.0;
    public Span textoStockHuesitos;

    public static int stockGalletasPerro = 20;
    public static double precioGalletasPerro = 7000.0;
    public Span textoStockGalletasPerro;

    public static int stockLataCarnePerro = 14;
    public static double precioLataCarnePerro = 6500.0;
    public Span textoStockLataCarnePerro;

    public static int stockLataAtunGato = 18;
    public static double precioLataAtunGato = 6000.0;
    public Span textoStockLataAtunGato;

    public static int stockShampooAntipulgas = 7;
    public static double precioShampooAntipulgas = 18000.0;
    public Span textoStockShampooAntipulgas;

    public static int stockJabonPerro = 11;
    public static double precioJabonPerro = 8000.0;
    public Span textoStockJabonPerro;

    public static int stockAntipulgasPipeta = 9;
    public static double precioAntipulgasPipeta = 25000.0;
    public Span textoStockAntipulgasPipeta;

    public static int stockDesparasitante = 5;
    public static double precioDesparasitante = 22000.0;
    public Span textoStockDesparasitante;

    public static int stockCollarSimple = 15;
    public static double precioCollarSimple = 12000.0;
    public Span textoStockCollarSimple;

    public static int stockCollarAntipulgas = 10;
    public static double precioCollarAntipulgas = 20000.0;
    public Span textoStockCollarAntipulgas;

    public static int stockCorreaRetractil = 8;
    public static double precioCorreaRetractil = 35000.0;
    public Span textoStockCorreaRetractil;

    public static int stockPlatoComedero = 16;
    public static double precioPlatoComedero = 15000.0;
    public Span textoStockPlatoComedero;

    public static int stockPlatoBebedero = 13;
    public static double precioPlatoBebedero = 14000.0;
    public Span textoStockPlatoBebedero;

    public static int stockCamaMediana = 4;
    public static double precioCamaMediana = 60000.0;
    public Span textoStockCamaMediana;

    public static int stockJuguetePelota = 22;
    public static double precioJuguetePelota = 6000.0;
    public Span textoStockJuguetePelota;

    public static int stockJugueteHueso = 19;
    public static double precioJugueteHueso = 8000.0;
    public Span textoStockJugueteHueso;

    public static int stockRascadorGato = 6;
    public static double precioRascadorGato = 75000.0;
    public Span textoStockRascadorGato;

    public static int stockArenaSanitaria = 30;
    public static double precioArenaSanitaria = 28000.0;
    public Span textoStockArenaSanitaria;

    public static int stockHierbaGatera = 11;
    public static double precioHierbaGatera = 9000.0;
    public Span textoStockHierbaGatera;

    public static int stockRopaMascota = 10;
    public static double precioRopaMascota = 25000.0;
    public Span textoStockRopaMascota;

    public static int stockBozal = 7;
    public static double precioBozal = 16000.0;
    public Span textoStockBozal;

    public MascotasView() {
        getStyle().set("background-color", "purple");
        H1 titulo = new H1("Mascotas");
        Button botonVolver = new Button("Volver al inicio", e -> UI.getCurrent().navigate(InventarioTienda.class));

        // Fila 1
        VerticalLayout producto1 = new VerticalLayout();
        H2 nombrePerrarinaAdultos = new H2("Perrarina Adultos");
        Span textoPrecioPerrarinaAdultos = new Span("Precio: $" + precioPerrarinaAdultos);
        textoStockPerrarinaAdultos = new Span("Cantidad: " + stockPerrarinaAdultos);
        textoStockPerrarinaAdultos.getElement().getThemeList().add("badge");
        Span estadoPerrarinaAdultos = crearEtiquetaEstado(stockPerrarinaAdultos);
        producto1.add(nombrePerrarinaAdultos, textoPrecioPerrarinaAdultos, textoStockPerrarinaAdultos, estadoPerrarinaAdultos);

        VerticalLayout producto2 = new VerticalLayout();
        H2 nombrePerrarinaCachorros = new H2("Perrarina Cachorros");
        Span textoPrecioPerrarinaCachorros = new Span("Precio: $" + precioPerrarinaCachorros);
        textoStockPerrarinaCachorros = new Span("Cantidad: " + stockPerrarinaCachorros);
        textoStockPerrarinaCachorros.getElement().getThemeList().add("badge");
        Span estadoPerrarinaCachorros = crearEtiquetaEstado(stockPerrarinaCachorros);
        producto2.add(nombrePerrarinaCachorros, textoPrecioPerrarinaCachorros, textoStockPerrarinaCachorros, estadoPerrarinaCachorros);

        VerticalLayout producto3 = new VerticalLayout();
        H2 nombreGatarinaAdultos = new H2("Gatarina Adultos");
        Span textoPrecioGatarinaAdultos = new Span("Precio: $" + precioGatarinaAdultos);
        textoStockGatarinaAdultos = new Span("Cantidad: " + stockGatarinaAdultos);
        textoStockGatarinaAdultos.getElement().getThemeList().add("badge");
        Span estadoGatarinaAdultos = crearEtiquetaEstado(stockGatarinaAdultos);
        producto3.add(nombreGatarinaAdultos, textoPrecioGatarinaAdultos, textoStockGatarinaAdultos, estadoGatarinaAdultos);

        VerticalLayout producto4 = new VerticalLayout();
        H2 nombreGatarinaCachorros = new H2("Gatarina Cachorros");
        Span textoPrecioGatarinaCachorros = new Span("Precio: $" + precioGatarinaCachorros);
        textoStockGatarinaCachorros = new Span("Cantidad: " + stockGatarinaCachorros);
        textoStockGatarinaCachorros.getElement().getThemeList().add("badge");
        Span estadoGatarinaCachorros = crearEtiquetaEstado(stockGatarinaCachorros);
        producto4.add(nombreGatarinaCachorros, textoPrecioGatarinaCachorros, textoStockGatarinaCachorros, estadoGatarinaCachorros);

        VerticalLayout producto5 = new VerticalLayout();
        H2 nombreHuesitos = new H2("Huesitos de Premio");
        Span textoPrecioHuesitos = new Span("Precio: $" + precioHuesitos);
        textoStockHuesitos = new Span("Cantidad: " + stockHuesitos);
        textoStockHuesitos.getElement().getThemeList().add("badge");
        Span estadoHuesitos = crearEtiquetaEstado(stockHuesitos);
        producto5.add(nombreHuesitos, textoPrecioHuesitos, textoStockHuesitos, estadoHuesitos);
        
        HorizontalLayout fila1 = new HorizontalLayout(producto1, producto2, producto3, producto4, producto5);
        fila1.setWidthFull();

        // Fila 2
        VerticalLayout producto6 = new VerticalLayout();
        H2 nombreGalletasPerro = new H2("Galletas para Perro");
        Span textoPrecioGalletasPerro = new Span("Precio: $" + precioGalletasPerro);
        textoStockGalletasPerro = new Span("Cantidad: " + stockGalletasPerro);
        textoStockGalletasPerro.getElement().getThemeList().add("badge");
        Span estadoGalletasPerro = crearEtiquetaEstado(stockGalletasPerro);
        producto6.add(nombreGalletasPerro, textoPrecioGalletasPerro, textoStockGalletasPerro, estadoGalletasPerro);

        VerticalLayout producto7 = new VerticalLayout();
        H2 nombreLataCarnePerro = new H2("Lata Carne Perro");
        Span textoPrecioLataCarnePerro = new Span("Precio: $" + precioLataCarnePerro);
        textoStockLataCarnePerro = new Span("Cantidad: " + stockLataCarnePerro);
        textoStockLataCarnePerro.getElement().getThemeList().add("badge");
        Span estadoLataCarnePerro = crearEtiquetaEstado(stockLataCarnePerro);
        producto7.add(nombreLataCarnePerro, textoPrecioLataCarnePerro, textoStockLataCarnePerro, estadoLataCarnePerro);

        VerticalLayout producto8 = new VerticalLayout();
        H2 nombreLataAtunGato = new H2("Lata Atún Gato");
        Span textoPrecioLataAtunGato = new Span("Precio: $" + precioLataAtunGato);
        textoStockLataAtunGato = new Span("Cantidad: " + stockLataAtunGato);
        textoStockLataAtunGato.getElement().getThemeList().add("badge");
        Span estadoLataAtunGato = crearEtiquetaEstado(stockLataAtunGato);
        producto8.add(nombreLataAtunGato, textoPrecioLataAtunGato, textoStockLataAtunGato, estadoLataAtunGato);

        VerticalLayout producto9 = new VerticalLayout();
        H2 nombreShampooAntipulgas = new H2("Shampoo Antipulgas");
        Span textoPrecioShampooAntipulgas = new Span("Precio: $" + precioShampooAntipulgas);
        textoStockShampooAntipulgas = new Span("Cantidad: " + stockShampooAntipulgas);
        textoStockShampooAntipulgas.getElement().getThemeList().add("badge");
        Span estadoShampooAntipulgas = crearEtiquetaEstado(stockShampooAntipulgas);
        producto9.add(nombreShampooAntipulgas, textoPrecioShampooAntipulgas, textoStockShampooAntipulgas, estadoShampooAntipulgas);

        VerticalLayout producto10 = new VerticalLayout();
        H2 nombreJabonPerro = new H2("Jabón para Perro");
        Span textoPrecioJabonPerro = new Span("Precio: $" + precioJabonPerro);
        textoStockJabonPerro = new Span("Cantidad: " + stockJabonPerro);
        textoStockJabonPerro.getElement().getThemeList().add("badge");
        Span estadoJabonPerro = crearEtiquetaEstado(stockJabonPerro);
        producto10.add(nombreJabonPerro, textoPrecioJabonPerro, textoStockJabonPerro, estadoJabonPerro);
        
        HorizontalLayout fila2 = new HorizontalLayout(producto6, producto7, producto8, producto9, producto10);
        fila2.setWidthFull();

        // Fila 3
        VerticalLayout producto11 = new VerticalLayout();
        H2 nombreAntipulgasPipeta = new H2("Pipeta Antipulgas");
        Span textoPrecioAntipulgasPipeta = new Span("Precio: $" + precioAntipulgasPipeta);
        textoStockAntipulgasPipeta = new Span("Cantidad: " + stockAntipulgasPipeta);
        textoStockAntipulgasPipeta.getElement().getThemeList().add("badge");
        Span estadoAntipulgasPipeta = crearEtiquetaEstado(stockAntipulgasPipeta);
        producto11.add(nombreAntipulgasPipeta, textoPrecioAntipulgasPipeta, textoStockAntipulgasPipeta, estadoAntipulgasPipeta);

        VerticalLayout producto12 = new VerticalLayout();
        H2 nombreDesparasitante = new H2("Desparasitante");
        Span textoPrecioDesparasitante = new Span("Precio: $" + precioDesparasitante);
        textoStockDesparasitante = new Span("Cantidad: " + stockDesparasitante);
        textoStockDesparasitante.getElement().getThemeList().add("badge");
        Span estadoDesparasitante = crearEtiquetaEstado(stockDesparasitante);
        producto12.add(nombreDesparasitante, textoPrecioDesparasitante, textoStockDesparasitante, estadoDesparasitante);

        VerticalLayout producto13 = new VerticalLayout();
        H2 nombreCollarSimple = new H2("Collar Simple");
        Span textoPrecioCollarSimple = new Span("Precio: $" + precioCollarSimple);
        textoStockCollarSimple = new Span("Cantidad: " + stockCollarSimple);
        textoStockCollarSimple.getElement().getThemeList().add("badge");
        Span estadoCollarSimple = crearEtiquetaEstado(stockCollarSimple);
        producto13.add(nombreCollarSimple, textoPrecioCollarSimple, textoStockCollarSimple, estadoCollarSimple);

        VerticalLayout producto14 = new VerticalLayout();
        H2 nombreCollarAntipulgas = new H2("Collar Antipulgas");
        Span textoPrecioCollarAntipulgas = new Span("Precio: $" + precioCollarAntipulgas);
        textoStockCollarAntipulgas = new Span("Cantidad: " + stockCollarAntipulgas);
        textoStockCollarAntipulgas.getElement().getThemeList().add("badge");
        Span estadoCollarAntipulgas = crearEtiquetaEstado(stockCollarAntipulgas);
        producto14.add(nombreCollarAntipulgas, textoPrecioCollarAntipulgas, textoStockCollarAntipulgas, estadoCollarAntipulgas);

        VerticalLayout producto15 = new VerticalLayout();
        H2 nombreCorreaRetractil = new H2("Correa Retráctil");
        Span textoPrecioCorreaRetractil = new Span("Precio: $" + precioCorreaRetractil);
        textoStockCorreaRetractil = new Span("Cantidad: " + stockCorreaRetractil);
        textoStockCorreaRetractil.getElement().getThemeList().add("badge");
        Span estadoCorreaRetractil = crearEtiquetaEstado(stockCorreaRetractil);
        producto15.add(nombreCorreaRetractil, textoPrecioCorreaRetractil, textoStockCorreaRetractil, estadoCorreaRetractil);
        
        HorizontalLayout fila3 = new HorizontalLayout(producto11, producto12, producto13, producto14, producto15);
        fila3.setWidthFull();

        // Fila 4
        VerticalLayout producto16 = new VerticalLayout();
        H2 nombrePlatoComedero = new H2("Plato Comedero");
        Span textoPrecioPlatoComedero = new Span("Precio: $" + precioPlatoComedero);
        textoStockPlatoComedero = new Span("Cantidad: " + stockPlatoComedero);
        textoStockPlatoComedero.getElement().getThemeList().add("badge");
        Span estadoPlatoComedero = crearEtiquetaEstado(stockPlatoComedero);
        producto16.add(nombrePlatoComedero, textoPrecioPlatoComedero, textoStockPlatoComedero, estadoPlatoComedero);

        VerticalLayout producto17 = new VerticalLayout();
        H2 nombrePlatoBebedero = new H2("Plato Bebedero");
        Span textoPrecioPlatoBebedero = new Span("Precio: $" + precioPlatoBebedero);
        textoStockPlatoBebedero = new Span("Cantidad: " + stockPlatoBebedero);
        textoStockPlatoBebedero.getElement().getThemeList().add("badge");
        Span estadoPlatoBebedero = crearEtiquetaEstado(stockPlatoBebedero);
        producto17.add(nombrePlatoBebedero, textoPrecioPlatoBebedero, textoStockPlatoBebedero, estadoPlatoBebedero);

        VerticalLayout producto18 = new VerticalLayout();
        H2 nombreCamaMediana = new H2("Cama Mediana");
        Span textoPrecioCamaMediana = new Span("Precio: $" + precioCamaMediana);
        textoStockCamaMediana = new Span("Cantidad: " + stockCamaMediana);
        textoStockCamaMediana.getElement().getThemeList().add("badge");
        Span estadoCamaMediana = crearEtiquetaEstado(stockCamaMediana);
        producto18.add(nombreCamaMediana, textoPrecioCamaMediana, textoStockCamaMediana, estadoCamaMediana);

        VerticalLayout producto19 = new VerticalLayout();
        H2 nombreJuguetePelota = new H2("Pelota de Juguete");
        Span textoPrecioJuguetePelota = new Span("Precio: $" + precioJuguetePelota);
        textoStockJuguetePelota = new Span("Cantidad: " + stockJuguetePelota);
        textoStockJuguetePelota.getElement().getThemeList().add("badge");
        Span estadoJuguetePelota = crearEtiquetaEstado(stockJuguetePelota);
        producto19.add(nombreJuguetePelota, textoPrecioJuguetePelota, textoStockJuguetePelota, estadoJuguetePelota);

        VerticalLayout producto20 = new VerticalLayout();
        H2 nombreJugueteHueso = new H2("Hueso de Juguete");
        Span textoPrecioJugueteHueso = new Span("Precio: $" + precioJugueteHueso);
        textoStockJugueteHueso = new Span("Cantidad: " + stockJugueteHueso);
        textoStockJugueteHueso.getElement().getThemeList().add("badge");
        Span estadoJugueteHueso = crearEtiquetaEstado(stockJugueteHueso);
        producto20.add(nombreJugueteHueso, textoPrecioJugueteHueso, textoStockJugueteHueso, estadoJugueteHueso);
        
        HorizontalLayout fila4 = new HorizontalLayout(producto16, producto17, producto18, producto19, producto20);
        fila4.setWidthFull();

        // Fila 5
        VerticalLayout producto21 = new VerticalLayout();
        H2 nombreRascadorGato = new H2("Rascador de Gato");
        Span textoPrecioRascadorGato = new Span("Precio: $" + precioRascadorGato);
        textoStockRascadorGato = new Span("Cantidad: " + stockRascadorGato);
        textoStockRascadorGato.getElement().getThemeList().add("badge");
        Span estadoRascadorGato = crearEtiquetaEstado(stockRascadorGato);
        producto21.add(nombreRascadorGato, textoPrecioRascadorGato, textoStockRascadorGato, estadoRascadorGato);

        VerticalLayout producto22 = new VerticalLayout();
        H2 nombreArenaSanitaria = new H2("Arena Sanitaria");
        Span textoPrecioArenaSanitaria = new Span("Precio: $" + precioArenaSanitaria);
        textoStockArenaSanitaria = new Span("Cantidad: " + stockArenaSanitaria);
        textoStockArenaSanitaria.getElement().getThemeList().add("badge");
        Span estadoArenaSanitaria = crearEtiquetaEstado(stockArenaSanitaria);
        producto22.add(nombreArenaSanitaria, textoPrecioArenaSanitaria, textoStockArenaSanitaria, estadoArenaSanitaria);

        VerticalLayout producto23 = new VerticalLayout();
        H2 nombreHierbaGatera = new H2("Hierba Gatera");
        Span textoPrecioHierbaGatera = new Span("Precio: $" + precioHierbaGatera);
        textoStockHierbaGatera = new Span("Cantidad: " + stockHierbaGatera);
        textoStockHierbaGatera.getElement().getThemeList().add("badge");
        Span estadoHierbaGatera = crearEtiquetaEstado(stockHierbaGatera);
        producto23.add(nombreHierbaGatera, textoPrecioHierbaGatera, textoStockHierbaGatera, estadoHierbaGatera);

        VerticalLayout producto24 = new VerticalLayout();
        H2 nombreRopaMascota = new H2("Ropa para Mascota");
        Span textoPrecioRopaMascota = new Span("Precio: $" + precioRopaMascota);
        textoStockRopaMascota = new Span("Cantidad: " + stockRopaMascota);
        textoStockRopaMascota.getElement().getThemeList().add("badge");
        Span estadoRopaMascota = crearEtiquetaEstado(stockRopaMascota);
        producto24.add(nombreRopaMascota, textoPrecioRopaMascota, textoStockRopaMascota, estadoRopaMascota);

        VerticalLayout producto25 = new VerticalLayout();
        H2 nombreBozal = new H2("Bozal");
        Span textoPrecioBozal = new Span("Precio: $" + precioBozal);
        textoStockBozal = new Span("Cantidad: " + stockBozal);
        textoStockBozal.getElement().getThemeList().add("badge");
        Span estadoBozal = crearEtiquetaEstado(stockBozal);
        producto25.add(nombreBozal, textoPrecioBozal, textoStockBozal, estadoBozal);
        
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
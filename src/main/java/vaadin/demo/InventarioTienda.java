package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route("")
public class InventarioTienda extends VerticalLayout {

    public static List<String> listaMovimientos = new ArrayList<>();
    public static List<ReporteInventario> listaHistorialReportes = new ArrayList<>();
    public static List<ItemKardex> listaKardex = new ArrayList<>();
    
    // Mapas para llevar el control del Costo Promedio Ponderado y el Stock por producto
    public static Map<String, Double> costosPromedioActuales = new HashMap<>();
    public static Map<String, Integer> stockActualKardex = new HashMap<>();

    public InventarioTienda() {
        getStyle().set("background-color", "yellow");

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();

        VerticalLayout contenedorPrincipal = new VerticalLayout();
        contenedorPrincipal.getStyle().set("background-color", "#ffffff");
        contenedorPrincipal.getStyle().set("border", "2px solid #ccc");
        contenedorPrincipal.getStyle().set("border-radius", "15px");
        contenedorPrincipal.getStyle().set("padding", "30px");
        contenedorPrincipal.getStyle().set("box-shadow", "0 4px 15px rgba(0,0,0,0.1)");
        contenedorPrincipal.setAlignItems(Alignment.CENTER);
        contenedorPrincipal.setWidth("950px");

        H1 titulo = new H1("Donde Miguel");
        titulo.getStyle().set("color", "#2c3e50");

        TabSheet pestanas = new TabSheet();
        pestanas.setWidthFull();

        // --- VISTA PRODUCTOS ---
        VerticalLayout vistaProductos = new VerticalLayout();
        H2 tituloProductos = new H2("Secciones y Productos");
        HorizontalLayout botonesProductos = new HorizontalLayout();

        VerticalLayout canastaFamiliar = crearTarjetaSeccion("Canasta familiar", CanastaFamiliarView.class, "green");
        VerticalLayout confiteria = crearTarjetaSeccion("Confitería", ConfiteriaView.class, "pink");
        VerticalLayout mascotas = crearTarjetaSeccion("Mascotas", MascotasView.class, "red");
        VerticalLayout aseo = crearTarjetaSeccion("Aseo general", AseoGeneralView.class, "blue");

        botonesProductos.add(canastaFamiliar, confiteria, mascotas, aseo);
        vistaProductos.add(tituloProductos, botonesProductos);
        vistaProductos.setAlignItems(Alignment.CENTER);

        // --- VISTA BODEGAS ---
        VerticalLayout vistaBodegas = new VerticalLayout();
        H2 tituloBodegas = new H2("Registro bodegas");
        HorizontalLayout botonesBodegas = new HorizontalLayout();

        VerticalLayout historialMovimientos = new VerticalLayout();
        historialMovimientos.getStyle().set("background", "#f8f9fa");
        historialMovimientos.getStyle().set("border", "1px solid #ddd");
        historialMovimientos.getStyle().set("border-radius", "8px");
        historialMovimientos.getStyle().set("padding", "15px");
        historialMovimientos.setWidthFull();

        Button botonSurtimiento = new Button("Registrar Surtimiento");
        botonSurtimiento.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Dialog dialogoSurtimiento = new Dialog();
        dialogoSurtimiento.setHeaderTitle("Registrar Surtimiento");

        VerticalLayout contenedorCamposSurtimiento = new VerticalLayout();
        TextField[] productosSurtir = new TextField[10];
        NumberField[] cantidadesSurtir = new NumberField[10];
        NumberField[] costosSurtir = new NumberField[10];

        for (int indice = 0; indice < 10; indice++) {
            productosSurtir[indice] = new TextField("Producto " + (indice + 1));
            cantidadesSurtir[indice] = new NumberField("Cantidad " + (indice + 1));
            cantidadesSurtir[indice].setMin(1);
            costosSurtir[indice] = new NumberField("Costo Unit. " + (indice + 1));
            costosSurtir[indice].setMin(0);
            
            HorizontalLayout filaCampos = new HorizontalLayout(productosSurtir[indice], cantidadesSurtir[indice], costosSurtir[indice]);
            contenedorCamposSurtimiento.add(filaCampos);
        }

        Grid<ReporteInventario> tablaInventario = new Grid<>(ReporteInventario.class, false);
        tablaInventario.addColumn(ReporteInventario::getCanastaFamiliar).setHeader("Canasta familiar $").setAutoWidth(true).setFlexGrow(1);
        tablaInventario.addColumn(ReporteInventario::getConfiteria).setHeader("Confitería $").setAutoWidth(true).setFlexGrow(1);
        tablaInventario.addColumn(ReporteInventario::getMascotas).setHeader("Mascotas $").setAutoWidth(true).setFlexGrow(1);
        tablaInventario.addColumn(ReporteInventario::getAseoGeneral).setHeader("Aseo general $").setAutoWidth(true).setFlexGrow(1);
        tablaInventario.addColumn(ReporteInventario::getTotal).setHeader("Total $").setAutoWidth(true).setFlexGrow(1);
        tablaInventario.setWidthFull();

        Button confirmarSurtimiento = new Button("Confirmar", e -> {
            boolean seRegistroAlgo = false;
            DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            for (int indice = 0; indice < 10; indice++) {
                if (!productosSurtir[indice].isEmpty() && cantidadesSurtir[indice].getValue() != null && costosSurtir[indice].getValue() != null) {
                    String nombreSurtir = productosSurtir[indice].getValue().trim();
                    int cantidadNueva = cantidadesSurtir[indice].getValue().intValue();
                    double costoNuevo = costosSurtir[indice].getValue();
                    boolean encontrado = true;

                    if (nombreSurtir.equalsIgnoreCase("Arroz x Kilo")) { CanastaFamiliarView.stockArroz += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Frijoles x Kilo")) { CanastaFamiliarView.stockFrijoles += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Cubeta de Huevos")) { CanastaFamiliarView.stockHuevos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bolsa de Leche")) { CanastaFamiliarView.stockLeche += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Carne de Res x Kilo")) { CanastaFamiliarView.stockCarne += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Lata de Atún")) { CanastaFamiliarView.stockAtun += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Pan Tajado")) { CanastaFamiliarView.stockPan += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bloque de Queso")) { CanastaFamiliarView.stockQueso += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Yogurt en Bolsa")) { CanastaFamiliarView.stockYogurt += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Paquete de Arepas")) { CanastaFamiliarView.stockArepas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Lentejas x Kilo")) { CanastaFamiliarView.stockLentejas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bolsa de Sal")) { CanastaFamiliarView.stockBolsaSal += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Sal x Kilo")) { CanastaFamiliarView.stockSalKilo += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Azúcar x Kilo")) { CanastaFamiliarView.stockAzucarKilo += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Jamón")) { CanastaFamiliarView.stockJamon += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Aceite")) { CanastaFamiliarView.stockAceite += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Pasta")) { CanastaFamiliarView.stockPasta += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Mantequilla")) { CanastaFamiliarView.stockMantequilla += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Café") || nombreSurtir.equalsIgnoreCase("Cafe")) { CanastaFamiliarView.stockCafe += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Quesito")) { CanastaFamiliarView.stockQuesito += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Chocolatina Jumbo")) { ConfiteriaView.stockChocolatina += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bon Bon Bum")) { ConfiteriaView.stockBombon += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Gomitas Grissly")) { ConfiteriaView.stockGomitas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Galletas Saltín")) { ConfiteriaView.stockGalletas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Papas Margarita")) { ConfiteriaView.stockPapasMargarita += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Cheetos")) { ConfiteriaView.stockCheetos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Doritos")) { ConfiteriaView.stockDoritos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Chicles Adams")) { ConfiteriaView.stockChicles += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Masmelos Millows")) { ConfiteriaView.stockMasmelo += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Maní Moto")) { ConfiteriaView.stockMani += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Mentas Chao")) { ConfiteriaView.stockMenta += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Chupeta Pin Pop")) { ConfiteriaView.stockChupeta += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Barrilete")) { ConfiteriaView.stockBarrilete += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Choclitos")) { ConfiteriaView.stockChoclitos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("De Todito")) { ConfiteriaView.stockDetodito += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Tostacos")) { ConfiteriaView.stockTostacos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Trululú")) { ConfiteriaView.stockTrululu += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Frunas")) { ConfiteriaView.stockFrunas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Nucita")) { ConfiteriaView.stockNucita += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Galletas Oreo")) { ConfiteriaView.stockOreo += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Galletas Festival")) { ConfiteriaView.stockFestival += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Burbuja Jet")) { ConfiteriaView.stockBurbuja += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Quipitos")) { ConfiteriaView.stockQuipitos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Sparkies")) { ConfiteriaView.stockSparkies += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Choco Break")) { ConfiteriaView.stockChocoBreak += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Perrarina Adultos")) { MascotasView.stockPerrarinaAdultos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Perrarina Cachorros")) { MascotasView.stockPerrarinaCachorros += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Gatarina Adultos")) { MascotasView.stockGatarinaAdultos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Gatarina Cachorros")) { MascotasView.stockGatarinaCachorros += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Huesitos de Premio")) { MascotasView.stockHuesitos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Galletas para Perro")) { MascotasView.stockGalletasPerro += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Lata Carne Perro")) { MascotasView.stockLataCarnePerro += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Lata Atún Gato")) { MascotasView.stockLataAtunGato += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Shampoo Antipulgas")) { MascotasView.stockShampooAntipulgas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Jabón para Perro")) { MascotasView.stockJabonPerro += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Pipeta Antipulgas")) { MascotasView.stockAntipulgasPipeta += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Desparasitante")) { MascotasView.stockDesparasitante += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Collar Simple")) { MascotasView.stockCollarSimple += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Collar Antipulgas")) { MascotasView.stockCollarAntipulgas += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Correa Retráctil")) { MascotasView.stockCorreaRetractil += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Plato Comedero")) { MascotasView.stockPlatoComedero += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Plato Bebedero")) { MascotasView.stockPlatoBebedero += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Cama Mediana")) { MascotasView.stockCamaMediana += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Pelota de Juguete")) { MascotasView.stockJuguetePelota += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Hueso de Juguete")) { MascotasView.stockJugueteHueso += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Rascador de Gato")) { MascotasView.stockRascadorGato += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Arena Sanitaria")) { MascotasView.stockArenaSanitaria += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Hierba Gatera")) { MascotasView.stockHierbaGatera += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Ropa para Mascota")) { MascotasView.stockRopaMascota += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bozal")) { MascotasView.stockBozal += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Blanqueador")) { AseoGeneralView.stockBlanqueador += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Jabón en Polvo")) { AseoGeneralView.stockJabonPolvo += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Limpiador de Pisos")) { AseoGeneralView.stockLimpiadorPisos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Lavaloza Líquido")) { AseoGeneralView.stockLavaloza += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Suavizante de Telas")) { AseoGeneralView.stockSuavizante += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Esponja de Brillo")) { AseoGeneralView.stockEsponjaBrillo += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Escoba")) { AseoGeneralView.stockEscoba += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Trapero")) { AseoGeneralView.stockTrapero += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Desinfectante Multiusos")) { AseoGeneralView.stockDesinfectante += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Limpiavidrios")) { AseoGeneralView.stockLimpiavidrios += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Jabón de Barra")) { AseoGeneralView.stockJabonBarra += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bolsa Basura Pequeña")) { AseoGeneralView.stockBolsaBasuraPequena += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bolsa Basura Mediana")) { AseoGeneralView.stockBolsaMediana += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Bolsa Basura Grande")) { AseoGeneralView.stockBolsaGrande += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Guantes de Caucho")) { AseoGeneralView.stockGuantesCaucho += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Toallas de Papel")) { AseoGeneralView.stockToallasPapel += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Papel Higiénico")) { AseoGeneralView.stockPapelHigienico += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Limpiador de Baños")) { AseoGeneralView.stockLimpiadorBanos += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Antisarro")) { AseoGeneralView.stockAntisaro += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Ambientador")) { AseoGeneralView.stockAmbientador += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Pastilla para Tanque")) { AseoGeneralView.stockPastillaTanque += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Cepillo de Mano")) { AseoGeneralView.stockCepilloMano += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Viruta de Acero")) { AseoGeneralView.stockVirutaAcero += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Alcohol Antiséptico")) { AseoGeneralView.stockAlcohol += cantidadNueva; }
                    else if (nombreSurtir.equalsIgnoreCase("Lustramuebles")) { AseoGeneralView.stockLustramuebles += cantidadNueva; }
                    else {
                        encontrado = false;
                        Notification.show("Producto no encontrado: " + nombreSurtir);
                    }

                    if (encontrado) {
                        String claveProducto = nombreSurtir.toLowerCase();
                        
                        double costoActual = costosPromedioActuales.getOrDefault(claveProducto, 0.0);
                        int stockPrevio = stockActualKardex.getOrDefault(claveProducto, cantidadNueva);
                        
                        double costoPromedioPonderado;
                        if (stockPrevio == cantidadNueva && costoActual == 0.0) {
                            costoPromedioPonderado = costoNuevo;
                        } else {
                            costoPromedioPonderado = ((stockPrevio * costoActual) + (cantidadNueva * costoNuevo)) / (stockPrevio + cantidadNueva);
                        }

                        costosPromedioActuales.put(claveProducto, costoPromedioPonderado);
                        stockActualKardex.put(claveProducto, stockPrevio + cantidadNueva);

                        String fechaHoraActual = LocalDateTime.now().format(formateadorFecha);
                        String textoMovimiento = "[" + fechaHoraActual + "] Entrada: +" + cantidadNueva + " de " + nombreSurtir;
                        historialMovimientos.add(new Span(textoMovimiento));
                        listaMovimientos.add(textoMovimiento);

                        String costoUnitarioFormateado = String.format("$%.2f", costoPromedioPonderado);
                        String totalFormateado = String.format("$%.2f", cantidadNueva * costoPromedioPonderado);

                        listaKardex.add(new ItemKardex(fechaHoraActual, nombreSurtir, "Entrada", cantidadNueva, costoUnitarioFormateado, totalFormateado));

                        productosSurtir[indice].clear();
                        cantidadesSurtir[indice].clear();
                        costosSurtir[indice].clear();
                        seRegistroAlgo = true;
                    }
                }
            }

            if (seRegistroAlgo) {
                actualizarValoresReportesGrid(tablaInventario);
                Notification.show("Surtimiento procesado con éxito");
                dialogoSurtimiento.close();
            } else {
                Notification.show("No se ingresaron datos válidos");
            }
        });

        Button cancelarSurtimiento = new Button("Cancelar", e -> dialogoSurtimiento.close());
        dialogoSurtimiento.getFooter().add(cancelarSurtimiento, confirmarSurtimiento);
        dialogoSurtimiento.add(contenedorCamposSurtimiento);
        botonSurtimiento.addClickListener(e -> dialogoSurtimiento.open());

        Button botonEnvios = new Button("Registrar Envíos");
        botonEnvios.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Dialog dialogoEnvios = new Dialog();
        dialogoEnvios.setHeaderTitle("Registrar Envío");

        VerticalLayout contenedorCamposEnvios = new VerticalLayout();
        TextField[] productosEnviar = new TextField[10];
        NumberField[] cantidadesEnviar = new NumberField[10];

        for (int indice = 0; indice < 10; indice++) {
            productosEnviar[indice] = new TextField("Producto " + (indice + 1));
            cantidadesEnviar[indice] = new NumberField("Cantidad " + (indice + 1));
            cantidadesEnviar[indice].setMin(1);
            HorizontalLayout filaCampos = new HorizontalLayout(productosEnviar[indice], cantidadesEnviar[indice]);
            contenedorCamposEnvios.add(filaCampos);
        }

        Button confirmarEnvio = new Button("Confirmar", e -> {
            boolean seRegistroAlgo = false;
            DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            for (int indice = 0; indice < 10; indice++) {
                if (!productosEnviar[indice].isEmpty() && cantidadesEnviar[indice].getValue() != null) {
                    String nombreEnviar = productosEnviar[indice].getValue().trim();
                    int cantidadRestar = cantidadesEnviar[indice].getValue().intValue();
                    boolean encontrado = true;
                    boolean stockSuficiente = true;

                    if (nombreEnviar.equalsIgnoreCase("Arroz x Kilo")) {
                        if (CanastaFamiliarView.stockArroz >= cantidadRestar) { CanastaFamiliarView.stockArroz -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Frijoles x Kilo")) {
                        if (CanastaFamiliarView.stockFrijoles >= cantidadRestar) { CanastaFamiliarView.stockFrijoles -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Cubeta de Huevos")) {
                        if (CanastaFamiliarView.stockHuevos >= cantidadRestar) { CanastaFamiliarView.stockHuevos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa de Leche")) {
                        if (CanastaFamiliarView.stockLeche >= cantidadRestar) { CanastaFamiliarView.stockLeche -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Carne de Res x Kilo")) {
                        if (CanastaFamiliarView.stockCarne >= cantidadRestar) { CanastaFamiliarView.stockCarne -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Lata de Atún")) {
                        if (CanastaFamiliarView.stockAtun >= cantidadRestar) { CanastaFamiliarView.stockAtun -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Pan Tajado")) {
                        if (CanastaFamiliarView.stockPan >= cantidadRestar) { CanastaFamiliarView.stockPan -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bloque de Queso")) {
                        if (CanastaFamiliarView.stockQueso >= cantidadRestar) { CanastaFamiliarView.stockQueso -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Yogurt en Bolsa")) {
                        if (CanastaFamiliarView.stockYogurt >= cantidadRestar) { CanastaFamiliarView.stockYogurt -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Paquete de Arepas")) {
                        if (CanastaFamiliarView.stockArepas >= cantidadRestar) { CanastaFamiliarView.stockArepas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Lentejas x Kilo")) {
                        if (CanastaFamiliarView.stockLentejas >= cantidadRestar) { CanastaFamiliarView.stockLentejas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa de Sal")) {
                        if (CanastaFamiliarView.stockBolsaSal >= cantidadRestar) { CanastaFamiliarView.stockBolsaSal -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Sal x Kilo")) {
                        if (CanastaFamiliarView.stockSalKilo >= cantidadRestar) { CanastaFamiliarView.stockSalKilo -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Azúcar x Kilo")) {
                        if (CanastaFamiliarView.stockAzucarKilo >= cantidadRestar) { CanastaFamiliarView.stockAzucarKilo -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Jamón")) {
                        if (CanastaFamiliarView.stockJamon >= cantidadRestar) { CanastaFamiliarView.stockJamon -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Aceite")) {
                        if (CanastaFamiliarView.stockAceite >= cantidadRestar) { CanastaFamiliarView.stockAceite -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Pasta")) {
                        if (CanastaFamiliarView.stockPasta >= cantidadRestar) { CanastaFamiliarView.stockPasta -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Mantequilla")) {
                        if (CanastaFamiliarView.stockMantequilla >= cantidadRestar) { CanastaFamiliarView.stockMantequilla -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Café") || nombreEnviar.equalsIgnoreCase("Cafe")) {
                        if (CanastaFamiliarView.stockCafe >= cantidadRestar) { CanastaFamiliarView.stockCafe -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Quesito")) {
                        if (CanastaFamiliarView.stockQuesito >= cantidadRestar) { CanastaFamiliarView.stockQuesito -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Chocolatina Jumbo")) {
                        if (ConfiteriaView.stockChocolatina >= cantidadRestar) { ConfiteriaView.stockChocolatina -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bon Bon Bum")) {
                        if (ConfiteriaView.stockBombon >= cantidadRestar) { ConfiteriaView.stockBombon -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Gomitas Grissly")) {
                        if (ConfiteriaView.stockGomitas >= cantidadRestar) { ConfiteriaView.stockGomitas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas Saltín")) {
                        if (ConfiteriaView.stockGalletas >= cantidadRestar) { ConfiteriaView.stockGalletas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Papas Margarita")) {
                        if (ConfiteriaView.stockPapasMargarita >= cantidadRestar) { ConfiteriaView.stockPapasMargarita -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Cheetos")) {
                        if (ConfiteriaView.stockCheetos >= cantidadRestar) { ConfiteriaView.stockCheetos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Doritos")) {
                        if (ConfiteriaView.stockDoritos >= cantidadRestar) { ConfiteriaView.stockDoritos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Chicles Adams")) {
                        if (ConfiteriaView.stockChicles >= cantidadRestar) { ConfiteriaView.stockChicles -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Masmelos Millows")) {
                        if (ConfiteriaView.stockMasmelo >= cantidadRestar) { ConfiteriaView.stockMasmelo -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Maní Moto")) {
                        if (ConfiteriaView.stockMani >= cantidadRestar) { ConfiteriaView.stockMani -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Mentas Chao")) {
                        if (ConfiteriaView.stockMenta >= cantidadRestar) { ConfiteriaView.stockMenta -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Chupeta Pin Pop")) {
                        if (ConfiteriaView.stockChupeta >= cantidadRestar) { ConfiteriaView.stockChupeta -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Barrilete")) {
                        if (ConfiteriaView.stockBarrilete >= cantidadRestar) { ConfiteriaView.stockBarrilete -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Choclitos")) {
                        if (ConfiteriaView.stockChoclitos >= cantidadRestar) { ConfiteriaView.stockChoclitos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("De Todito")) {
                        if (ConfiteriaView.stockDetodito >= cantidadRestar) { ConfiteriaView.stockDetodito -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Tostacos")) {
                        if (ConfiteriaView.stockTostacos >= cantidadRestar) { ConfiteriaView.stockTostacos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Trululú")) {
                        if (ConfiteriaView.stockTrululu >= cantidadRestar) { ConfiteriaView.stockTrululu -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Frunas")) {
                        if (ConfiteriaView.stockFrunas >= cantidadRestar) { ConfiteriaView.stockFrunas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Nucita")) {
                        if (ConfiteriaView.stockNucita >= cantidadRestar) { ConfiteriaView.stockNucita -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas Oreo")) {
                        if (ConfiteriaView.stockOreo >= cantidadRestar) { ConfiteriaView.stockOreo -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas Festival")) {
                        if (ConfiteriaView.stockFestival >= cantidadRestar) { ConfiteriaView.stockFestival -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Burbuja Jet")) {
                        if (ConfiteriaView.stockBurbuja >= cantidadRestar) { ConfiteriaView.stockBurbuja -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Quipitos")) {
                        if (ConfiteriaView.stockQuipitos >= cantidadRestar) { ConfiteriaView.stockQuipitos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Sparkies")) {
                        if (ConfiteriaView.stockSparkies >= cantidadRestar) { ConfiteriaView.stockSparkies -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Choco Break")) {
                        if (ConfiteriaView.stockChocoBreak >= cantidadRestar) { ConfiteriaView.stockChocoBreak -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Perrarina Adultos")) {
                        if (MascotasView.stockPerrarinaAdultos >= cantidadRestar) { MascotasView.stockPerrarinaAdultos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Perrarina Cachorros")) {
                        if (MascotasView.stockPerrarinaCachorros >= cantidadRestar) { MascotasView.stockPerrarinaCachorros -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Gatarina Adultos")) {
                        if (MascotasView.stockGatarinaAdultos >= cantidadRestar) { MascotasView.stockGatarinaAdultos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Gatarina Cachorros")) {
                        if (MascotasView.stockGatarinaCachorros >= cantidadRestar) { MascotasView.stockGatarinaCachorros -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Huesitos de Premio")) {
                        if (MascotasView.stockHuesitos >= cantidadRestar) { MascotasView.stockHuesitos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas para Perro")) {
                        if (MascotasView.stockGalletasPerro >= cantidadRestar) { MascotasView.stockGalletasPerro -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Lata Carne Perro")) {
                        if (MascotasView.stockLataCarnePerro >= cantidadRestar) { MascotasView.stockLataCarnePerro -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Lata Atún Gato")) {
                        if (MascotasView.stockLataAtunGato >= cantidadRestar) { MascotasView.stockLataAtunGato -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Shampoo Antipulgas")) {
                        if (MascotasView.stockShampooAntipulgas >= cantidadRestar) { MascotasView.stockShampooAntipulgas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Jabón para Perro")) {
                        if (MascotasView.stockJabonPerro >= cantidadRestar) { MascotasView.stockJabonPerro -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Pipeta Antipulgas")) {
                        if (MascotasView.stockAntipulgasPipeta >= cantidadRestar) { MascotasView.stockAntipulgasPipeta -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Desparasitante")) {
                        if (MascotasView.stockDesparasitante >= cantidadRestar) { MascotasView.stockDesparasitante -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Collar Simple")) {
                        if (MascotasView.stockCollarSimple >= cantidadRestar) { MascotasView.stockCollarSimple -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Collar Antipulgas")) {
                        if (MascotasView.stockCollarAntipulgas >= cantidadRestar) { MascotasView.stockCollarAntipulgas -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Correa Retráctil")) {
                        if (MascotasView.stockCorreaRetractil >= cantidadRestar) { MascotasView.stockCorreaRetractil -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Plato Comedero")) {
                        if (MascotasView.stockPlatoComedero >= cantidadRestar) { MascotasView.stockPlatoComedero -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Plato Bebedero")) {
                        if (MascotasView.stockPlatoBebedero >= cantidadRestar) { MascotasView.stockPlatoBebedero -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Cama Mediana")) {
                        if (MascotasView.stockCamaMediana >= cantidadRestar) { MascotasView.stockCamaMediana -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Pelota de Juguete")) {
                        if (MascotasView.stockJuguetePelota >= cantidadRestar) { MascotasView.stockJuguetePelota -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Hueso de Juguete")) {
                        if (MascotasView.stockJugueteHueso >= cantidadRestar) { MascotasView.stockJugueteHueso -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Rascador de Gato")) {
                        if (MascotasView.stockRascadorGato >= cantidadRestar) { MascotasView.stockRascadorGato -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Arena Sanitaria")) {
                        if (MascotasView.stockArenaSanitaria >= cantidadRestar) { MascotasView.stockArenaSanitaria -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Hierba Gatera")) {
                        if (MascotasView.stockHierbaGatera >= cantidadRestar) { MascotasView.stockHierbaGatera -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Ropa para Mascota")) {
                        if (MascotasView.stockRopaMascota >= cantidadRestar) { MascotasView.stockRopaMascota -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bozal")) {
                        if (MascotasView.stockBozal >= cantidadRestar) { MascotasView.stockBozal -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Blanqueador")) {
                        if (AseoGeneralView.stockBlanqueador >= cantidadRestar) { AseoGeneralView.stockBlanqueador -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Jabón en Polvo")) {
                        if (AseoGeneralView.stockJabonPolvo >= cantidadRestar) { AseoGeneralView.stockJabonPolvo -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Limpiador de Pisos")) {
                        if (AseoGeneralView.stockLimpiadorPisos >= cantidadRestar) { AseoGeneralView.stockLimpiadorPisos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Lavaloza Líquido")) {
                        if (AseoGeneralView.stockLavaloza >= cantidadRestar) { AseoGeneralView.stockLavaloza -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Suavizante de Telas")) {
                        if (AseoGeneralView.stockSuavizante >= cantidadRestar) { AseoGeneralView.stockSuavizante -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Esponja de Brillo")) {
                        if (AseoGeneralView.stockEsponjaBrillo >= cantidadRestar) { AseoGeneralView.stockEsponjaBrillo -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Escoba")) {
                        if (AseoGeneralView.stockEscoba >= cantidadRestar) { AseoGeneralView.stockEscoba -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Trapero")) {
                        if (AseoGeneralView.stockTrapero >= cantidadRestar) { AseoGeneralView.stockTrapero -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Desinfectante Multiusos")) {
                        if (AseoGeneralView.stockDesinfectante >= cantidadRestar) { AseoGeneralView.stockDesinfectante -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Limpiavidrios")) {
                        if (AseoGeneralView.stockLimpiavidrios >= cantidadRestar) { AseoGeneralView.stockLimpiavidrios -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Jabón de Barra")) {
                        if (AseoGeneralView.stockJabonBarra >= cantidadRestar) { AseoGeneralView.stockJabonBarra -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa Basura Pequeña")) {
                        if (AseoGeneralView.stockBolsaBasuraPequena >= cantidadRestar) { AseoGeneralView.stockBolsaBasuraPequena -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa Basura Mediana")) {
                        if (AseoGeneralView.stockBolsaMediana >= cantidadRestar) { AseoGeneralView.stockBolsaMediana -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa Basura Grande")) {
                        if (AseoGeneralView.stockBolsaGrande >= cantidadRestar) { AseoGeneralView.stockBolsaGrande -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Guantes de Caucho")) {
                        if (AseoGeneralView.stockGuantesCaucho >= cantidadRestar) { AseoGeneralView.stockGuantesCaucho -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Toallas de Papel")) {
                        if (AseoGeneralView.stockToallasPapel >= cantidadRestar) { AseoGeneralView.stockToallasPapel -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Papel Higiénico")) {
                        if (AseoGeneralView.stockPapelHigienico >= cantidadRestar) { AseoGeneralView.stockPapelHigienico -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Limpiador de Baños")) {
                        if (AseoGeneralView.stockLimpiadorBanos >= cantidadRestar) { AseoGeneralView.stockLimpiadorBanos -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Antisarro")) {
                        if (AseoGeneralView.stockAntisaro >= cantidadRestar) { AseoGeneralView.stockAntisaro -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Ambientador")) {
                        if (AseoGeneralView.stockAmbientador >= cantidadRestar) { AseoGeneralView.stockAmbientador -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Pastilla para Tanque")) {
                        if (AseoGeneralView.stockPastillaTanque >= cantidadRestar) { AseoGeneralView.stockPastillaTanque -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Cepillo de Mano")) {
                        if (AseoGeneralView.stockCepilloMano >= cantidadRestar) { AseoGeneralView.stockCepilloMano -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Viruta de Acero")) {
                        if (AseoGeneralView.stockVirutaAcero >= cantidadRestar) { AseoGeneralView.stockVirutaAcero -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Alcohol Antiséptico")) {
                        if (AseoGeneralView.stockAlcohol >= cantidadRestar) { AseoGeneralView.stockAlcohol -= cantidadRestar; } else { stockSuficiente = false; }
                    } else if (nombreEnviar.equalsIgnoreCase("Lustramuebles")) {
                        if (AseoGeneralView.stockLustramuebles >= cantidadRestar) { AseoGeneralView.stockLustramuebles -= cantidadRestar; } else { stockSuficiente = false; }
                    } else {
                        encontrado = false;
                        Notification.show("Producto no encontrado: " + nombreEnviar);
                    }

                    if (encontrado && !stockSuficiente) {
                        Notification.show("No hay suficiente stock para: " + nombreEnviar);
                    } else if (encontrado && stockSuficiente) {
                        String claveProducto = nombreEnviar.toLowerCase();
                        double costoPromedioVigente = costosPromedioActuales.getOrDefault(claveProducto, 0.0);
                        
                        int stockActual = stockActualKardex.getOrDefault(claveProducto, cantidadRestar);
                        stockActualKardex.put(claveProducto, Math.max(0, stockActual - cantidadRestar));

                        String fechaHoraActual = LocalDateTime.now().format(formateadorFecha);
                        String textoMovimiento = "[" + fechaHoraActual + "] Salida: -" + cantidadRestar + " de " + nombreEnviar;
                        historialMovimientos.add(new Span(textoMovimiento));
                        listaMovimientos.add(textoMovimiento);

                        String costoUnitarioFormateado = String.format("$%.2f", costoPromedioVigente);
                        String totalFormateado = String.format("$%.2f", cantidadRestar * costoPromedioVigente);

                        listaKardex.add(new ItemKardex(fechaHoraActual, nombreEnviar, "Salida", cantidadRestar, costoUnitarioFormateado, totalFormateado));

                        productosEnviar[indice].clear();
                        cantidadesEnviar[indice].clear();
                        seRegistroAlgo = true;
                    }
                }
            }

            if (seRegistroAlgo) {
                actualizarValoresReportesGrid(tablaInventario);
                Notification.show("Envíos procesados con éxito");
                dialogoEnvios.close();
            } else {
                Notification.show("No se ingresaron datos válidos");
            }
        });

        Button cancelarEnvio = new Button("Cancelar", e -> dialogoEnvios.close());
        dialogoEnvios.getFooter().add(cancelarEnvio, confirmarEnvio);
        dialogoEnvios.add(contenedorCamposEnvios);
        botonEnvios.addClickListener(e -> dialogoEnvios.open());

        Button botonMovimientos = new Button("Consultar Movimientos");
        Dialog dialogoMovimientos = new Dialog();
        dialogoMovimientos.setHeaderTitle("Últimos Movimientos");
        VerticalLayout contenidoDialogoMovimientos = new VerticalLayout();
        Button cerrarDialogoMovimientos = new Button("Cerrar", e -> dialogoMovimientos.close());
        dialogoMovimientos.getFooter().add(cerrarDialogoMovimientos);
        dialogoMovimientos.add(contenidoDialogoMovimientos);

        botonMovimientos.addClickListener(e -> {
            contenidoDialogoMovimientos.removeAll();
            int inicio = Math.max(0, listaMovimientos.size() - 5);
            for (int indice = inicio; indice < listaMovimientos.size(); indice++) {
                contenidoDialogoMovimientos.add(new Span(listaMovimientos.get(indice)));
            }
            if (listaMovimientos.isEmpty()) {
                contenidoDialogoMovimientos.add(new Span("No hay movimientos registrados."));
            }
            dialogoMovimientos.open();
        });

        botonesBodegas.add(botonSurtimiento, botonEnvios, botonMovimientos);
        vistaBodegas.add(tituloBodegas, botonesBodegas, historialMovimientos);

        // --- VISTA REPORTES ---
        VerticalLayout vistaValores = new VerticalLayout();
        H2 tituloValores = new H2("Valores inventario");

        actualizarValoresReportesGrid(tablaInventario);

        Dialog dialogoKardex = new Dialog();
        dialogoKardex.setHeaderTitle("Kárdex - Costo Promedio Ponderado");
        dialogoKardex.setWidth("800px");

        Grid<ItemKardex> tablaKardex = new Grid<>(ItemKardex.class, false);
        tablaKardex.addColumn(ItemKardex::getFecha).setHeader("Fecha").setAutoWidth(true);
        tablaKardex.addColumn(ItemKardex::getProducto).setHeader("Producto").setAutoWidth(true);
        tablaKardex.addColumn(ItemKardex::getMovimiento).setHeader("Movimiento").setAutoWidth(true);
        tablaKardex.addColumn(ItemKardex::getCantidad).setHeader("Cantidad").setAutoWidth(true);
        tablaKardex.addColumn(ItemKardex::getCostoUnitario).setHeader("Costo Unitario").setAutoWidth(true);
        tablaKardex.addColumn(ItemKardex::getTotal).setHeader("Total $").setAutoWidth(true);
        tablaKardex.setWidthFull();

        Button cerrarKardex = new Button("Cerrar", e -> dialogoKardex.close());
        dialogoKardex.getFooter().add(cerrarKardex);
        
        VerticalLayout contenedorKardexModal = new VerticalLayout(tablaKardex);
        contenedorKardexModal.setWidthFull();
        dialogoKardex.add(contenedorKardexModal);

        Button botonKardex = new Button("Kárdex", e -> {
            tablaKardex.setItems(listaKardex);
            dialogoKardex.open();
        });
        botonKardex.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        vistaValores.add(tituloValores, tablaInventario, botonKardex);
        vistaValores.setAlignItems(Alignment.CENTER);

        pestanas.add("Productos", vistaProductos);
        pestanas.add("Movimientos", vistaBodegas);
        pestanas.add("Reportes", vistaValores);

        contenedorPrincipal.add(titulo, pestanas);
        add(contenedorPrincipal);
    }

    private VerticalLayout crearTarjetaSeccion(String nombre, Class<? extends com.vaadin.flow.component.Component> vistaDestino, String colorBorde) {
        VerticalLayout tarjeta = new VerticalLayout();
        tarjeta.getStyle().set("border", "2px solid " + colorBorde);
        tarjeta.getStyle().set("border-radius", "10px");
        tarjeta.getStyle().set("background", "#ffffff");
        tarjeta.getStyle().set("padding", "15px");
        tarjeta.setAlignItems(Alignment.CENTER);

        Button boton = new Button(nombre);
        boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton.addClickListener(event -> UI.getCurrent().navigate(vistaDestino));

        Span stockBadge = new Span("Stock: Normal");
        stockBadge.getElement().getThemeList().add("badge success");
        
        tarjeta.add(boton, stockBadge);
        return tarjeta;
    }

    public void actualizarValoresReportesGrid(Grid<ReporteInventario> tabla) {
        double totalCanasta = 
            (CanastaFamiliarView.stockArroz * CanastaFamiliarView.precioArroz) +
            (CanastaFamiliarView.stockFrijoles * CanastaFamiliarView.precioFrijoles) +
            (CanastaFamiliarView.stockHuevos * CanastaFamiliarView.precioHuevos) +
            (CanastaFamiliarView.stockLeche * CanastaFamiliarView.precioLeche) +
            (CanastaFamiliarView.stockCarne * CanastaFamiliarView.precioCarne) +
            (CanastaFamiliarView.stockAtun * CanastaFamiliarView.precioAtun) +
            (CanastaFamiliarView.stockPan * CanastaFamiliarView.precioPan) +
            (CanastaFamiliarView.stockQueso * CanastaFamiliarView.precioQueso) +
            (CanastaFamiliarView.stockYogurt * CanastaFamiliarView.precioYogurt) +
            (CanastaFamiliarView.stockArepas * CanastaFamiliarView.precioArepas) +
            (CanastaFamiliarView.stockLentejas * CanastaFamiliarView.precioLentejas) +
            (CanastaFamiliarView.stockBolsaSal * CanastaFamiliarView.precioBolsaSal) +
            (CanastaFamiliarView.stockSalKilo * CanastaFamiliarView.precioSalKilo) +
            (CanastaFamiliarView.stockAzucarKilo * CanastaFamiliarView.precioAzucarKilo) +
            (CanastaFamiliarView.stockJamon * CanastaFamiliarView.precioJamon) +
            (CanastaFamiliarView.stockAceite * CanastaFamiliarView.precioAceite) +
            (CanastaFamiliarView.stockPasta * CanastaFamiliarView.precioPasta) +
            (CanastaFamiliarView.stockMantequilla * CanastaFamiliarView.precioMantequilla) +
            (CanastaFamiliarView.stockCafe * CanastaFamiliarView.precioCafe) +
            (CanastaFamiliarView.stockQuesito * CanastaFamiliarView.precioQuesito);

        double totalConfiteria = 
            (ConfiteriaView.stockChocolatina * ConfiteriaView.precioChocolatina) +
            (ConfiteriaView.stockBombon * ConfiteriaView.precioBombon) +
            (ConfiteriaView.stockGomitas * ConfiteriaView.precioGomitas) +
            (ConfiteriaView.stockGalletas * ConfiteriaView.precioGalletas) +
            (ConfiteriaView.stockPapasMargarita * ConfiteriaView.precioPapasMargarita) +
            (ConfiteriaView.stockCheetos * ConfiteriaView.precioCheetos) +
            (ConfiteriaView.stockDoritos * ConfiteriaView.precioDoritos) +
            (ConfiteriaView.stockChicles * ConfiteriaView.precioChicles) +
            (ConfiteriaView.stockMasmelo * ConfiteriaView.precioMasmelo) +
            (ConfiteriaView.stockMani * ConfiteriaView.precioMani) +
            (ConfiteriaView.stockMenta * ConfiteriaView.precioMenta) +
            (ConfiteriaView.stockChupeta * ConfiteriaView.precioChupeta) +
            (ConfiteriaView.stockBarrilete * ConfiteriaView.precioBarrilete) +
            (ConfiteriaView.stockChoclitos * ConfiteriaView.precioChoclitos) +
            (ConfiteriaView.stockDetodito * ConfiteriaView.precioDetodito) +
            (ConfiteriaView.stockTostacos * ConfiteriaView.precioTostacos) +
            (ConfiteriaView.stockTrululu * ConfiteriaView.precioTrululu) +
            (ConfiteriaView.stockFrunas * ConfiteriaView.precioFrunas) +
            (ConfiteriaView.stockNucita * ConfiteriaView.precioNucita) +
            (ConfiteriaView.stockOreo * ConfiteriaView.precioOreo) +
            (ConfiteriaView.stockFestival * ConfiteriaView.precioFestival) +
            (ConfiteriaView.stockBurbuja * ConfiteriaView.precioBurbuja) +
            (ConfiteriaView.stockQuipitos * ConfiteriaView.precioQuipitos) +
            (ConfiteriaView.stockSparkies * ConfiteriaView.precioSparkies) +
            (ConfiteriaView.stockChocoBreak * ConfiteriaView.precioChocoBreak);

        double totalMascotas = 
            (MascotasView.stockPerrarinaAdultos * MascotasView.precioPerrarinaAdultos) +
            (MascotasView.stockPerrarinaCachorros * MascotasView.precioPerrarinaCachorros) +
            (MascotasView.stockGatarinaAdultos * MascotasView.precioGatarinaAdultos) +
            (MascotasView.stockGatarinaCachorros * MascotasView.precioGatarinaCachorros) +
            (MascotasView.stockHuesitos * MascotasView.precioHuesitos) +
            (MascotasView.stockGalletasPerro * MascotasView.precioGalletasPerro) +
            (MascotasView.stockLataCarnePerro * MascotasView.precioLataCarnePerro) +
            (MascotasView.stockLataAtunGato * MascotasView.precioLataAtunGato) +
            (MascotasView.stockShampooAntipulgas * MascotasView.precioShampooAntipulgas) +
            (MascotasView.stockJabonPerro * MascotasView.precioJabonPerro) +
            (MascotasView.stockAntipulgasPipeta * MascotasView.precioAntipulgasPipeta) +
            (MascotasView.stockDesparasitante * MascotasView.precioDesparasitante) +
            (MascotasView.stockCollarSimple * MascotasView.precioCollarSimple) +
            (MascotasView.stockCollarAntipulgas * MascotasView.precioCollarAntipulgas) +
            (MascotasView.stockCorreaRetractil * MascotasView.precioCorreaRetractil) +
            (MascotasView.stockPlatoComedero * MascotasView.precioPlatoComedero) +
            (MascotasView.stockPlatoBebedero * MascotasView.precioPlatoBebedero) +
            (MascotasView.stockCamaMediana * MascotasView.precioCamaMediana) +
            (MascotasView.stockJuguetePelota * MascotasView.precioJuguetePelota) +
            (MascotasView.stockJugueteHueso * MascotasView.precioJugueteHueso) +
            (MascotasView.stockRascadorGato * MascotasView.precioRascadorGato) +
            (MascotasView.stockArenaSanitaria * MascotasView.precioArenaSanitaria) +
            (MascotasView.stockHierbaGatera * MascotasView.precioHierbaGatera) +
            (MascotasView.stockRopaMascota * MascotasView.precioRopaMascota) +
            (MascotasView.stockBozal * MascotasView.precioBozal);

        double totalAseo = 
            (AseoGeneralView.stockBlanqueador * AseoGeneralView.precioBlanqueador) +
            (AseoGeneralView.stockJabonPolvo * AseoGeneralView.precioJabonPolvo) +
            (AseoGeneralView.stockLimpiadorPisos * AseoGeneralView.precioLimpiadorPisos) +
            (AseoGeneralView.stockLavaloza * AseoGeneralView.precioLavaloza) +
            (AseoGeneralView.stockSuavizante * AseoGeneralView.precioSuavizante) +
            (AseoGeneralView.stockEsponjaBrillo * AseoGeneralView.precioEsponjaBrillo) +
            (AseoGeneralView.stockEscoba * AseoGeneralView.precioEscoba) +
            (AseoGeneralView.stockTrapero * AseoGeneralView.precioTrapero) +
            (AseoGeneralView.stockDesinfectante * AseoGeneralView.precioDesinfectante) +
            (AseoGeneralView.stockLimpiavidrios * AseoGeneralView.precioLimpiavidrios) +
            (AseoGeneralView.stockJabonBarra * AseoGeneralView.precioJabonBarra) +
            (AseoGeneralView.stockBolsaBasuraPequena * AseoGeneralView.precioBolsaBasuraPequena) +
            (AseoGeneralView.stockBolsaMediana * AseoGeneralView.precioBolsaMediana) +
            (AseoGeneralView.stockBolsaGrande * AseoGeneralView.precioBolsaGrande) +
            (AseoGeneralView.stockGuantesCaucho * AseoGeneralView.precioGuantesCaucho) +
            (AseoGeneralView.stockToallasPapel * AseoGeneralView.precioToallasPapel) +
            (AseoGeneralView.stockPapelHigienico * AseoGeneralView.precioPapelHigienico) +
            (AseoGeneralView.stockLimpiadorBanos * AseoGeneralView.precioLimpiadorBanos) +
            (AseoGeneralView.stockAntisaro * AseoGeneralView.precioAntisaro) +
            (AseoGeneralView.stockAmbientador * AseoGeneralView.precioAmbientador) +
            (AseoGeneralView.stockPastillaTanque * AseoGeneralView.precioPastillaTanque) +
            (AseoGeneralView.stockCepilloMano * AseoGeneralView.precioCepilloMano) +
            (AseoGeneralView.stockVirutaAcero * AseoGeneralView.precioVirutaAcero) +
            (AseoGeneralView.stockAlcohol * AseoGeneralView.precioAlcohol) +
            (AseoGeneralView.stockLustramuebles * AseoGeneralView.precioLustramuebles);

        double totalGeneral = totalCanasta + totalConfiteria + totalMascotas + totalAseo;

        ReporteInventario reporte = new ReporteInventario(
            String.format("$%.2f", totalCanasta),
            String.format("$%.2f", totalConfiteria),
            String.format("$%.2f", totalMascotas),
            String.format("$%.2f", totalAseo),
            String.format("$%.2f", totalGeneral)
        );

        listaHistorialReportes.add(reporte);
        tabla.setItems(listaHistorialReportes);

        // Actualiza de forma automática el archivo de texto en la raíz del proyecto
        exportarReporteATexto(reporte);
    }

    private void exportarReporteATexto(ReporteInventario reporte) {
        String nombreArchivo = "reporte_inventario.txt";
        
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            escritor.println("=== REPORTE FINANCIERO DE INVENTARIO - DONDE MIGUEL ===");
            escritor.println("Fecha de corte: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            escritor.println("---------------------------------------------------------");
            escritor.println("Canasta Familiar: " + reporte.getCanastaFamiliar());
            escritor.println("Confitería:        " + reporte.getConfiteria());
            escritor.println("Mascotas:          " + reporte.getMascotas());
            escritor.println("Aseo General:      " + reporte.getAseoGeneral());
            escritor.println("---------------------------------------------------------");
            escritor.println("TOTAL GENERAL:     " + reporte.getTotal());
            escritor.println("=========================================================");
        } catch (IOException e) {
            Notification.show("Error al actualizar el archivo de texto del reporte.");
            e.printStackTrace();
        }
    }

    public static class ReporteInventario {
        private String canastaFamiliar;
        private String confiteria;
        private String mascotas;
        private String aseoGeneral;
        private String total;

        public ReporteInventario(String canastaFamiliar, String confiteria, String mascotas, String aseoGeneral, String total) {
            this.canastaFamiliar = canastaFamiliar;
            this.confiteria = confiteria;
            this.mascotas = mascotas;
            this.aseoGeneral = aseoGeneral;
            this.total = total;
        }

        public String getCanastaFamiliar() { return canastaFamiliar; }
        public String getConfiteria() { return confiteria; }
        public String getMascotas() { return mascotas; }
        public String getAseoGeneral() { return aseoGeneral; }
        public String getTotal() { return total; }
    }

    public static class ItemKardex {
        private String fecha;
        private String producto;
        private String movimiento;
        private int cantidad;
        private String costoUnitario;
        private String total;

        public ItemKardex(String fecha, String producto, String movimiento, int cantidad, String costoUnitario, String total) {
            this.fecha = fecha;
            this.producto = producto;
            this.movimiento = movimiento;
            this.cantidad = cantidad;
            this.costoUnitario = costoUnitario;
            this.total = total;
        }

        public String getFecha() { return fecha; }
        public String getProducto() { return producto; }
        public String getMovimiento() { return movimiento; }
        public int getCantidad() { return cantidad; }
        public String getCostoUnitario() { return costoUnitario; }
        public String getTotal() { return total; }
    }
}
package vaadin.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
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
import java.util.ArrayList;
import java.util.List;

@Route("")
public class InventarioTienda extends VerticalLayout {

    public static List<String> listaMovimientos = new ArrayList<>();

    public InventarioTienda() {
        H1 titulo = new H1("Donde Miguel");

        TabSheet pestanas = new TabSheet();

        VerticalLayout vistaProductos = new VerticalLayout();
        H2 tituloProductos = new H2("Secciones y Productos");

        HorizontalLayout botonesProductos = new HorizontalLayout();

        VerticalLayout canastaFamiliar = new VerticalLayout();
        Button botonCanasta = new Button("Canasta familiar");
        botonCanasta.addClickListener(event -> UI.getCurrent().navigate(CanastaFamiliarView.class));
        Span stockCanasta = new Span("Stock: Normal");
        stockCanasta.getElement().getThemeList().add("badge");
        canastaFamiliar.add(botonCanasta, stockCanasta);

        VerticalLayout confiteria = new VerticalLayout();
        Button botonConfiteria = new Button("Confitería");
        botonConfiteria.addClickListener(event -> UI.getCurrent().navigate(ConfiteriaView.class));
        Span stockConfiteria = new Span("Stock: Normal");
        stockConfiteria.getElement().getThemeList().add("badge");
        confiteria.add(botonConfiteria, stockConfiteria);

        VerticalLayout mascotas = new VerticalLayout();
        Button botonMascotas = new Button("Mascotas");
        botonMascotas.addClickListener(event -> UI.getCurrent().navigate(MascotasView.class));
        Span stockMascotas = new Span("Stock: Normal");
        stockMascotas.getElement().getThemeList().add("badge");
        mascotas.add(botonMascotas, stockMascotas);

        VerticalLayout aseo = new VerticalLayout();
        Button botonAseo = new Button("Aseo general");
        botonAseo.addClickListener(event -> UI.getCurrent().navigate(AseoGeneralView.class));
        Span stockAseo = new Span("Stock: Normal");
        stockAseo.getElement().getThemeList().add("badge");
        aseo.add(botonAseo, stockAseo);

        botonesProductos.add(canastaFamiliar, confiteria, mascotas, aseo);
        vistaProductos.add(tituloProductos, botonesProductos);

        VerticalLayout vistaBodegas = new VerticalLayout();
        H2 tituloBodegas = new H2("Registro bodegas");
        HorizontalLayout botonesBodegas = new HorizontalLayout();
        
        VerticalLayout historialMovimientos = new VerticalLayout();

        Button botonSurtimiento = new Button("Registrar Surtimiento");
        Dialog dialogoSurtimiento = new Dialog();
        dialogoSurtimiento.setHeaderTitle("Registrar Surtimiento");
        
        VerticalLayout contenedorCamposSurtimiento = new VerticalLayout();
        TextField[] productosSurtir = new TextField[10];
        NumberField[] cantidadesSurtir = new NumberField[10];
        
        for (int indice = 0; indice < 10; indice++) {
            productosSurtir[indice] = new TextField("Producto " + (indice + 1));
            cantidadesSurtir[indice] = new NumberField("Cantidad " + (indice + 1));
            cantidadesSurtir[indice].setMin(1);
            HorizontalLayout filaCampos = new HorizontalLayout(productosSurtir[indice], cantidadesSurtir[indice]);
            contenedorCamposSurtimiento.add(filaCampos);
        }
        
        Button confirmarSurtimiento = new Button("Confirmar", e -> {
            boolean seRegistroAlgo = false;
            
            for (int indice = 0; indice < 10; indice++) {
                if (!productosSurtir[indice].isEmpty() && !cantidadesSurtir[indice].isEmpty()) {
                    String nombreSurtir = productosSurtir[indice].getValue().trim();
                    int cantidadSumar = cantidadesSurtir[indice].getValue().intValue();
                    boolean encontrado = true;

                    if (nombreSurtir.equalsIgnoreCase("Arroz x Kilo")) {
                        CanastaFamiliarView.stockArroz += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Frijoles x Kilo")) {
                        CanastaFamiliarView.stockFrijoles += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Cubeta de Huevos")) {
                        CanastaFamiliarView.stockHuevos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bolsa de Leche")) {
                        CanastaFamiliarView.stockLeche += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Carne de Res x Kilo")) {
                        CanastaFamiliarView.stockCarne += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Lata de Atún")) {
                        CanastaFamiliarView.stockAtun += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Pan Tajado")) {
                        CanastaFamiliarView.stockPan += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bloque de Queso")) {
                        CanastaFamiliarView.stockQueso += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Yogurt en Bolsa")) {
                        CanastaFamiliarView.stockYogurt += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Paquete de Arepas")) {
                        CanastaFamiliarView.stockArepas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Lentejas x Kilo")) {
                        CanastaFamiliarView.stockLentejas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bolsa de Sal")) {
                        CanastaFamiliarView.stockBolsaSal += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Sal x Kilo")) {
                        CanastaFamiliarView.stockSalKilo += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Azúcar x Kilo")) {
                        CanastaFamiliarView.stockAzucarKilo += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Jamón")) {
                        CanastaFamiliarView.stockJamon += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Aceite")) {
                        CanastaFamiliarView.stockAceite += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Pasta")) {
                        CanastaFamiliarView.stockPasta += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Mantequilla")) {
                        CanastaFamiliarView.stockMantequilla += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Café") || nombreSurtir.equalsIgnoreCase("Cafe")) {
                        CanastaFamiliarView.stockCafe += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Quesito")) {
                        CanastaFamiliarView.stockQuesito += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Chocolatina Jumbo")) {
                        ConfiteriaView.stockChocolatina += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bon Bon Bum")) {
                        ConfiteriaView.stockBombon += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Gomitas Grissly")) {
                        ConfiteriaView.stockGomitas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Galletas Saltín")) {
                        ConfiteriaView.stockGalletas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Papas Margarita")) {
                        ConfiteriaView.stockPapasMargarita += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Cheetos")) {
                        ConfiteriaView.stockCheetos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Doritos")) {
                        ConfiteriaView.stockDoritos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Chicles Adams")) {
                        ConfiteriaView.stockChicles += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Masmelos Millows")) {
                        ConfiteriaView.stockMasmelo += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Maní Moto")) {
                        ConfiteriaView.stockMani += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Mentas Chao")) {
                        ConfiteriaView.stockMenta += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Chupeta Pin Pop")) {
                        ConfiteriaView.stockChupeta += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Barrilete")) {
                        ConfiteriaView.stockBarrilete += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Choclitos")) {
                        ConfiteriaView.stockChoclitos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("De Todito")) {
                        ConfiteriaView.stockDetodito += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Tostacos")) {
                        ConfiteriaView.stockTostacos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Trululú")) {
                        ConfiteriaView.stockTrululu += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Frunas")) {
                        ConfiteriaView.stockFrunas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Nucita")) {
                        ConfiteriaView.stockNucita += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Galletas Oreo")) {
                        ConfiteriaView.stockOreo += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Galletas Festival")) {
                        ConfiteriaView.stockFestival += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Burbuja Jet")) {
                        ConfiteriaView.stockBurbuja += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Quipitos")) {
                        ConfiteriaView.stockQuipitos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Sparkies")) {
                        ConfiteriaView.stockSparkies += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Choco Break")) {
                        ConfiteriaView.stockChocoBreak += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Perrarina Adultos")) {
                        MascotasView.stockPerrarinaAdultos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Perrarina Cachorros")) {
                        MascotasView.stockPerrarinaCachorros += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Gatarina Adultos")) {
                        MascotasView.stockGatarinaAdultos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Gatarina Cachorros")) {
                        MascotasView.stockGatarinaCachorros += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Huesitos de Premio")) {
                        MascotasView.stockHuesitos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Galletas para Perro")) {
                        MascotasView.stockGalletasPerro += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Lata Carne Perro")) {
                        MascotasView.stockLataCarnePerro += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Lata Atún Gato")) {
                        MascotasView.stockLataAtunGato += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Shampoo Antipulgas")) {
                        MascotasView.stockShampooAntipulgas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Jabón para Perro")) {
                        MascotasView.stockJabonPerro += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Pipeta Antipulgas")) {
                        MascotasView.stockAntipulgasPipeta += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Desparasitante")) {
                        MascotasView.stockDesparasitante += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Collar Simple")) {
                        MascotasView.stockCollarSimple += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Collar Antipulgas")) {
                        MascotasView.stockCollarAntipulgas += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Correa Retráctil")) {
                        MascotasView.stockCorreaRetractil += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Plato Comedero")) {
                        MascotasView.stockPlatoComedero += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Plato Bebedero")) {
                        MascotasView.stockPlatoBebedero += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Cama Mediana")) {
                        MascotasView.stockCamaMediana += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Pelota de Juguete")) {
                        MascotasView.stockJuguetePelota += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Hueso de Juguete")) {
                        MascotasView.stockJugueteHueso += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Rascador de Gato")) {
                        MascotasView.stockRascadorGato += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Arena Sanitaria")) {
                        MascotasView.stockArenaSanitaria += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Hierba Gatera")) {
                        MascotasView.stockHierbaGatera += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Ropa para Mascota")) {
                        MascotasView.stockRopaMascota += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bozal")) {
                        MascotasView.stockBozal += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Blanqueador")) {
                        AseoGeneralView.stockBlanqueador += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Jabón en Polvo")) {
                        AseoGeneralView.stockJabonPolvo += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Limpiador de Pisos")) {
                        AseoGeneralView.stockLimpiadorPisos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Lavaloza Líquido")) {
                        AseoGeneralView.stockLavaloza += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Suavizante de Telas")) {
                        AseoGeneralView.stockSuavizante += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Esponja de Brillo")) {
                        AseoGeneralView.stockEsponjaBrillo += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Escoba")) {
                        AseoGeneralView.stockEscoba += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Trapero")) {
                        AseoGeneralView.stockTrapero += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Desinfectante Multiusos")) {
                        AseoGeneralView.stockDesinfectante += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Limpiavidrios")) {
                        AseoGeneralView.stockLimpiavidrios += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Jabón de Barra")) {
                        AseoGeneralView.stockJabonBarra += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bolsa Basura Pequeña")) {
                        AseoGeneralView.stockBolsaBasuraPequena += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bolsa Basura Mediana")) {
                        AseoGeneralView.stockBolsaMediana += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Bolsa Basura Grande")) {
                        AseoGeneralView.stockBolsaGrande += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Guantes de Caucho")) {
                        AseoGeneralView.stockGuantesCaucho += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Toallas de Papel")) {
                        AseoGeneralView.stockToallasPapel += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Papel Higiénico")) {
                        AseoGeneralView.stockPapelHigienico += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Limpiador de Baños")) {
                        AseoGeneralView.stockLimpiadorBanos += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Antisarro")) {
                        AseoGeneralView.stockAntisaro += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Ambientador")) {
                        AseoGeneralView.stockAmbientador += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Pastilla para Tanque")) {
                        AseoGeneralView.stockPastillaTanque += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Cepillo de Mano")) {
                        AseoGeneralView.stockCepilloMano += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Viruta de Acero")) {
                        AseoGeneralView.stockVirutaAcero += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Alcohol Antiséptico")) {
                        AseoGeneralView.stockAlcohol += cantidadSumar;
                    } else if (nombreSurtir.equalsIgnoreCase("Lustramuebles")) {
                        AseoGeneralView.stockLustramuebles += cantidadSumar;
                    } else {
                        encontrado = false;
                        Notification.show("Producto no encontrado: " + nombreSurtir);
                    }

                    if (encontrado) {
                        String textoMovimiento = "Entrada: +" + cantidadSumar + " de " + nombreSurtir;
                        Span registro = new Span(textoMovimiento);
                        historialMovimientos.add(registro);
                        listaMovimientos.add(textoMovimiento);
                        productosSurtir[indice].clear();
                        cantidadesSurtir[indice].clear();
                        seRegistroAlgo = true;
                    }
                }
            }
            
            if (seRegistroAlgo) {
                Notification.show("Surtimiento procesado");
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
            
            for (int indice = 0; indice < 10; indice++) {
                if (!productosEnviar[indice].isEmpty() && !cantidadesEnviar[indice].isEmpty()) {
                    String nombreEnviar = productosEnviar[indice].getValue().trim();
                    int cantidadRestar = cantidadesEnviar[indice].getValue().intValue();
                    boolean encontrado = true;
                    boolean stockSuficiente = true;

                    if (nombreEnviar.equalsIgnoreCase("Arroz x Kilo")) {
                        if (CanastaFamiliarView.stockArroz >= cantidadRestar) {
                            CanastaFamiliarView.stockArroz -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Frijoles x Kilo")) {
                        if (CanastaFamiliarView.stockFrijoles >= cantidadRestar) {
                            CanastaFamiliarView.stockFrijoles -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Cubeta de Huevos")) {
                        if (CanastaFamiliarView.stockHuevos >= cantidadRestar) {
                            CanastaFamiliarView.stockHuevos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa de Leche")) {
                        if (CanastaFamiliarView.stockLeche >= cantidadRestar) {
                            CanastaFamiliarView.stockLeche -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Carne de Res x Kilo")) {
                        if (CanastaFamiliarView.stockCarne >= cantidadRestar) {
                            CanastaFamiliarView.stockCarne -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Lata de Atún")) {
                        if (CanastaFamiliarView.stockAtun >= cantidadRestar) {
                            CanastaFamiliarView.stockAtun -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Pan Tajado")) {
                        if (CanastaFamiliarView.stockPan >= cantidadRestar) {
                            CanastaFamiliarView.stockPan -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bloque de Queso")) {
                        if (CanastaFamiliarView.stockQueso >= cantidadRestar) {
                            CanastaFamiliarView.stockQueso -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Yogurt en Bolsa")) {
                        if (CanastaFamiliarView.stockYogurt >= cantidadRestar) {
                            CanastaFamiliarView.stockYogurt -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Paquete de Arepas")) {
                        if (CanastaFamiliarView.stockArepas >= cantidadRestar) {
                            CanastaFamiliarView.stockArepas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Lentejas x Kilo")) {
                        if (CanastaFamiliarView.stockLentejas >= cantidadRestar) {
                            CanastaFamiliarView.stockLentejas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa de Sal")) {
                        if (CanastaFamiliarView.stockBolsaSal >= cantidadRestar) {
                            CanastaFamiliarView.stockBolsaSal -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Sal x Kilo")) {
                        if (CanastaFamiliarView.stockSalKilo >= cantidadRestar) {
                            CanastaFamiliarView.stockSalKilo -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Azúcar x Kilo")) {
                        if (CanastaFamiliarView.stockAzucarKilo >= cantidadRestar) {
                            CanastaFamiliarView.stockAzucarKilo -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Jamón")) {
                        if (CanastaFamiliarView.stockJamon >= cantidadRestar) {
                            CanastaFamiliarView.stockJamon -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Aceite")) {
                        if (CanastaFamiliarView.stockAceite >= cantidadRestar) {
                            CanastaFamiliarView.stockAceite -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Pasta")) {
                        if (CanastaFamiliarView.stockPasta >= cantidadRestar) {
                            CanastaFamiliarView.stockPasta -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Mantequilla")) {
                        if (CanastaFamiliarView.stockMantequilla >= cantidadRestar) {
                            CanastaFamiliarView.stockMantequilla -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Café") || nombreEnviar.equalsIgnoreCase("Cafe")) {
                        if (CanastaFamiliarView.stockCafe >= cantidadRestar) {
                            CanastaFamiliarView.stockCafe -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Quesito")) {
                        if (CanastaFamiliarView.stockQuesito >= cantidadRestar) {
                            CanastaFamiliarView.stockQuesito -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Chocolatina Jumbo")) {
                        if (ConfiteriaView.stockChocolatina >= cantidadRestar) {
                            ConfiteriaView.stockChocolatina -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bon Bon Bum")) {
                        if (ConfiteriaView.stockBombon >= cantidadRestar) {
                            ConfiteriaView.stockBombon -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Gomitas Grissly")) {
                        if (ConfiteriaView.stockGomitas >= cantidadRestar) {
                            ConfiteriaView.stockGomitas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas Saltín")) {
                        if (ConfiteriaView.stockGalletas >= cantidadRestar) {
                            ConfiteriaView.stockGalletas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Papas Margarita")) {
                        if (ConfiteriaView.stockPapasMargarita >= cantidadRestar) {
                            ConfiteriaView.stockPapasMargarita -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Cheetos")) {
                        if (ConfiteriaView.stockCheetos >= cantidadRestar) {
                            ConfiteriaView.stockCheetos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Doritos")) {
                        if (ConfiteriaView.stockDoritos >= cantidadRestar) {
                            ConfiteriaView.stockDoritos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Chicles Adams")) {
                        if (ConfiteriaView.stockChicles >= cantidadRestar) {
                            ConfiteriaView.stockChicles -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Masmelos Millows")) {
                        if (ConfiteriaView.stockMasmelo >= cantidadRestar) {
                            ConfiteriaView.stockMasmelo -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Maní Moto")) {
                        if (ConfiteriaView.stockMani >= cantidadRestar) {
                            ConfiteriaView.stockMani -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Mentas Chao")) {
                        if (ConfiteriaView.stockMenta >= cantidadRestar) {
                            ConfiteriaView.stockMenta -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Chupeta Pin Pop")) {
                        if (ConfiteriaView.stockChupeta >= cantidadRestar) {
                            ConfiteriaView.stockChupeta -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Barrilete")) {
                        if (ConfiteriaView.stockBarrilete >= cantidadRestar) {
                            ConfiteriaView.stockBarrilete -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Choclitos")) {
                        if (ConfiteriaView.stockChoclitos >= cantidadRestar) {
                            ConfiteriaView.stockChoclitos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("De Todito")) {
                        if (ConfiteriaView.stockDetodito >= cantidadRestar) {
                            ConfiteriaView.stockDetodito -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Tostacos")) {
                        if (ConfiteriaView.stockTostacos >= cantidadRestar) {
                            ConfiteriaView.stockTostacos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Trululú")) {
                        if (ConfiteriaView.stockTrululu >= cantidadRestar) {
                            ConfiteriaView.stockTrululu -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Frunas")) {
                        if (ConfiteriaView.stockFrunas >= cantidadRestar) {
                            ConfiteriaView.stockFrunas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Nucita")) {
                        if (ConfiteriaView.stockNucita >= cantidadRestar) {
                            ConfiteriaView.stockNucita -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas Oreo")) {
                        if (ConfiteriaView.stockOreo >= cantidadRestar) {
                            ConfiteriaView.stockOreo -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas Festival")) {
                        if (ConfiteriaView.stockFestival >= cantidadRestar) {
                            ConfiteriaView.stockFestival -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Burbuja Jet")) {
                        if (ConfiteriaView.stockBurbuja >= cantidadRestar) {
                            ConfiteriaView.stockBurbuja -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Quipitos")) {
                        if (ConfiteriaView.stockQuipitos >= cantidadRestar) {
                            ConfiteriaView.stockQuipitos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Sparkies")) {
                        if (ConfiteriaView.stockSparkies >= cantidadRestar) {
                            ConfiteriaView.stockSparkies -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Choco Break")) {
                        if (ConfiteriaView.stockChocoBreak >= cantidadRestar) {
                            ConfiteriaView.stockChocoBreak -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Perrarina Adultos")) {
                        if (MascotasView.stockPerrarinaAdultos >= cantidadRestar) {
                            MascotasView.stockPerrarinaAdultos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Perrarina Cachorros")) {
                        if (MascotasView.stockPerrarinaCachorros >= cantidadRestar) {
                            MascotasView.stockPerrarinaCachorros -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Gatarina Adultos")) {
                        if (MascotasView.stockGatarinaAdultos >= cantidadRestar) {
                            MascotasView.stockGatarinaAdultos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Gatarina Cachorros")) {
                        if (MascotasView.stockGatarinaCachorros >= cantidadRestar) {
                            MascotasView.stockGatarinaCachorros -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Huesitos de Premio")) {
                        if (MascotasView.stockHuesitos >= cantidadRestar) {
                            MascotasView.stockHuesitos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Galletas para Perro")) {
                        if (MascotasView.stockGalletasPerro >= cantidadRestar) {
                            MascotasView.stockGalletasPerro -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Lata Carne Perro")) {
                        if (MascotasView.stockLataCarnePerro >= cantidadRestar) {
                            MascotasView.stockLataCarnePerro -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Lata Atún Gato")) {
                        if (MascotasView.stockLataAtunGato >= cantidadRestar) {
                            MascotasView.stockLataAtunGato -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Shampoo Antipulgas")) {
                        if (MascotasView.stockShampooAntipulgas >= cantidadRestar) {
                            MascotasView.stockShampooAntipulgas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Jabón para Perro")) {
                        if (MascotasView.stockJabonPerro >= cantidadRestar) {
                            MascotasView.stockJabonPerro -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Pipeta Antipulgas")) {
                        if (MascotasView.stockAntipulgasPipeta >= cantidadRestar) {
                            MascotasView.stockAntipulgasPipeta -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Desparasitante")) {
                        if (MascotasView.stockDesparasitante >= cantidadRestar) {
                            MascotasView.stockDesparasitante -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Collar Simple")) {
                        if (MascotasView.stockCollarSimple >= cantidadRestar) {
                            MascotasView.stockCollarSimple -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Collar Antipulgas")) {
                        if (MascotasView.stockCollarAntipulgas >= cantidadRestar) {
                            MascotasView.stockCollarAntipulgas -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Correa Retráctil")) {
                        if (MascotasView.stockCorreaRetractil >= cantidadRestar) {
                            MascotasView.stockCorreaRetractil -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Plato Comedero")) {
                        if (MascotasView.stockPlatoComedero >= cantidadRestar) {
                            MascotasView.stockPlatoComedero -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Plato Bebedero")) {
                        if (MascotasView.stockPlatoBebedero >= cantidadRestar) {
                            MascotasView.stockPlatoBebedero -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Cama Mediana")) {
                        if (MascotasView.stockCamaMediana >= cantidadRestar) {
                            MascotasView.stockCamaMediana -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Pelota de Juguete")) {
                        if (MascotasView.stockJuguetePelota >= cantidadRestar) {
                            MascotasView.stockJuguetePelota -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Hueso de Juguete")) {
                        if (MascotasView.stockJugueteHueso >= cantidadRestar) {
                            MascotasView.stockJugueteHueso -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Rascador de Gato")) {
                        if (MascotasView.stockRascadorGato >= cantidadRestar) {
                            MascotasView.stockRascadorGato -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Arena Sanitaria")) {
                        if (MascotasView.stockArenaSanitaria >= cantidadRestar) {
                            MascotasView.stockArenaSanitaria -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Hierba Gatera")) {
                        if (MascotasView.stockHierbaGatera >= cantidadRestar) {
                            MascotasView.stockHierbaGatera -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Ropa para Mascota")) {
                        if (MascotasView.stockRopaMascota >= cantidadRestar) {
                            MascotasView.stockRopaMascota -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bozal")) {
                        if (MascotasView.stockBozal >= cantidadRestar) {
                            MascotasView.stockBozal -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Blanqueador")) {
                        if (AseoGeneralView.stockBlanqueador >= cantidadRestar) {
                            AseoGeneralView.stockBlanqueador -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Jabón en Polvo")) {
                        if (AseoGeneralView.stockJabonPolvo >= cantidadRestar) {
                            AseoGeneralView.stockJabonPolvo -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Limpiador de Pisos")) {
                        if (AseoGeneralView.stockLimpiadorPisos >= cantidadRestar) {
                            AseoGeneralView.stockLimpiadorPisos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Lavaloza Líquido")) {
                        if (AseoGeneralView.stockLavaloza >= cantidadRestar) {
                            AseoGeneralView.stockLavaloza -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Suavizante de Telas")) {
                        if (AseoGeneralView.stockSuavizante >= cantidadRestar) {
                            AseoGeneralView.stockSuavizante -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Esponja de Brillo")) {
                        if (AseoGeneralView.stockEsponjaBrillo >= cantidadRestar) {
                            AseoGeneralView.stockEsponjaBrillo -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Escoba")) {
                        if (AseoGeneralView.stockEscoba >= cantidadRestar) {
                            AseoGeneralView.stockEscoba -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Trapero")) {
                        if (AseoGeneralView.stockTrapero >= cantidadRestar) {
                            AseoGeneralView.stockTrapero -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Desinfectante Multiusos")) {
                        if (AseoGeneralView.stockDesinfectante >= cantidadRestar) {
                            AseoGeneralView.stockDesinfectante -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Limpiavidrios")) {
                        if (AseoGeneralView.stockLimpiavidrios >= cantidadRestar) {
                            AseoGeneralView.stockLimpiavidrios -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Jabón de Barra")) {
                        if (AseoGeneralView.stockJabonBarra >= cantidadRestar) {
                            AseoGeneralView.stockJabonBarra -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa Basura Pequeña")) {
                        if (AseoGeneralView.stockBolsaBasuraPequena >= cantidadRestar) {
                            AseoGeneralView.stockBolsaBasuraPequena -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa Basura Mediana")) {
                        if (AseoGeneralView.stockBolsaMediana >= cantidadRestar) {
                            AseoGeneralView.stockBolsaMediana -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Bolsa Basura Grande")) {
                        if (AseoGeneralView.stockBolsaGrande >= cantidadRestar) {
                            AseoGeneralView.stockBolsaGrande -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Guantes de Caucho")) {
                        if (AseoGeneralView.stockGuantesCaucho >= cantidadRestar) {
                            AseoGeneralView.stockGuantesCaucho -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Toallas de Papel")) {
                        if (AseoGeneralView.stockToallasPapel >= cantidadRestar) {
                            AseoGeneralView.stockToallasPapel -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Papel Higiénico")) {
                        if (AseoGeneralView.stockPapelHigienico >= cantidadRestar) {
                            AseoGeneralView.stockPapelHigienico -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Limpiador de Baños")) {
                        if (AseoGeneralView.stockLimpiadorBanos >= cantidadRestar) {
                            AseoGeneralView.stockLimpiadorBanos -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Antisarro")) {
                        if (AseoGeneralView.stockAntisaro >= cantidadRestar) {
                            AseoGeneralView.stockAntisaro -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Ambientador")) {
                        if (AseoGeneralView.stockAmbientador >= cantidadRestar) {
                            AseoGeneralView.stockAmbientador -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Pastilla para Tanque")) {
                        if (AseoGeneralView.stockPastillaTanque >= cantidadRestar) {
                            AseoGeneralView.stockPastillaTanque -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Cepillo de Mano")) {
                        if (AseoGeneralView.stockCepilloMano >= cantidadRestar) {
                            AseoGeneralView.stockCepilloMano -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Viruta de Acero")) {
                        if (AseoGeneralView.stockVirutaAcero >= cantidadRestar) {
                            AseoGeneralView.stockVirutaAcero -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Alcohol Antiséptico")) {
                        if (AseoGeneralView.stockAlcohol >= cantidadRestar) {
                            AseoGeneralView.stockAlcohol -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else if (nombreEnviar.equalsIgnoreCase("Lustramuebles")) {
                        if (AseoGeneralView.stockLustramuebles >= cantidadRestar) {
                            AseoGeneralView.stockLustramuebles -= cantidadRestar;
                        } else {
                            stockSuficiente = false;
                        }
                    } else {
                        encontrado = false;
                        Notification.show("Producto no encontrado: " + nombreEnviar);
                    }

                    if (encontrado && !stockSuficiente) {
                        Notification.show("No hay suficiente stock para: " + nombreEnviar);
                    } else if (encontrado && stockSuficiente) {
                        String textoMovimiento = "Salida: -" + cantidadRestar + " de " + nombreEnviar;
                        Span registro = new Span(textoMovimiento);
                        historialMovimientos.add(registro);
                        listaMovimientos.add(textoMovimiento);
                        productosEnviar[indice].clear();
                        cantidadesEnviar[indice].clear();
                        seRegistroAlgo = true;
                    }
                }
            }
            
            if (seRegistroAlgo) {
                Notification.show("Envíos procesados");
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

        VerticalLayout vistaValores = new VerticalLayout();
        H2 tituloValores = new H2("Valores inventario");

        Grid<String> tablaInventario = new Grid<>();
        tablaInventario.addColumn(valor -> "").setHeader("Canasta familiar $");
        tablaInventario.addColumn(valor -> "").setHeader("Confitería $");
        tablaInventario.addColumn(valor -> "").setHeader("Mascotas $");
        tablaInventario.addColumn(valor -> "").setHeader("Aseo general $");
        tablaInventario.addColumn(valor -> "").setHeader("Total $");

        Button botonKardex = new Button("Kárdex");
        vistaValores.add(tituloValores, tablaInventario, botonKardex);

        pestanas.add("Productos", vistaProductos);
        pestanas.add("Movimientos", vistaBodegas);
        pestanas.add("Reportes", vistaValores);

        add(titulo, pestanas);
    }
}
package com.miapi.proyectoIntegrador.config;
 
import com.miapi.proyectoIntegrador.modelo.Catalogo;
import com.miapi.proyectoIntegrador.repositorio.RDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
 
@Component
public class DatosIniciales implements CommandLineRunner {
 
    @Autowired
    private RDeCatalogo catalogoRepositorio;
 
    @Override
    public void run(String... args) {
        if (catalogoRepositorio.count() == 0) {
            catalogoRepositorio.save(new Catalogo("Cactus", "Planta resistente que requiere poca agua y mucha luz",
                    "https://gardenerspath.com/wp-content/uploads/2024/11/How-to-Water-Cactus-Feature.jpg", 5, 1, 5, 3, 1));
            catalogoRepositorio.save(new Catalogo("Rosa", "Planta ornamental con flores llamativas que requiere cuidados frecuentes",
                    "https://biblioteca.acropolis.org/wp-content/uploads/2019/07/Rosa-Mister_Lincoln.jpg", 3, 5, 3, 5, 4));
            catalogoRepositorio.save(new Catalogo("Helecho", "Planta de interior que necesita humedad y poca luz directa",
                    "https://cdn0.ecologiaverde.com/es/posts/8/9/1/helechos_de_interior_tipos_cuidados_y_como_regarlos_5198_1200.jpg", 2, 5, 3, 1, 3));
            catalogoRepositorio.save(new Catalogo("Suculenta", "Planta fácil de cuidar, almacena agua en sus hojas",
                    "https://services.meteored.com/img/article/sol-y-suculentas-como-evitar-quemaduras-y-lograr-plantas-mas-fuertes-en-verano-1770009091401_512.jpg", 4, 2, 5, 3, 1));
            catalogoRepositorio.save(new Catalogo("Orquidea", "Planta delicada con flores exóticas, requiere cuidados específicos",
                    "https://floreshoy.co/wp-content/uploads/2023/06/pexels-maciej-cisowski-11138718-1-825x510.jpg", 3, 3, 3, 2, 5));
            catalogoRepositorio.save(new Catalogo("Palma", "Planta decorativa de mayor tamaño ideal para espacios amplios",
                    "https://tropicalia.garden/wp-content/uploads/2023/09/sabalpalmeto-palmeto-comprar-palmera-precio-tropicaliagarden-scaled.webp", 5, 3, 5, 5, 3));
            catalogoRepositorio.save(new Catalogo("Aloe Vera", "Planta medicinal resistente y fácil de cuidar",
                    "https://www.almanac.com/sites/default/files/styles/or/public/image_nodes/aloe-vera-white-pot_sunwand24-ss_edit_0.jpg?itok=uOJaHAeR", 4, 2, 5, 3, 1));
            catalogoRepositorio.save(new Catalogo("Lavanda", "Planta aromática que necesita sol y poco riego",
                    "https://www.produccionornamental.com/fotoscatalogo/AROMATICAS/A00088%20Lavanda%20Dentata%20%C3%9824/Lavanda%20Dentata%20%C3%9824%202%2028-06-2023%20(V).jpeg", 5, 2, 4, 5, 2));
            catalogoRepositorio.save(new Catalogo("Bambu", "Planta de rápido crecimiento y fácil mantenimiento",
                    "https://cdn.wikifarmer.com/images/detailed/2023/10/Interesting-facts-uses-and-types-of-Bamboo-2048x1365-1.jpg", 3, 4, 4, 3, 2));
            catalogoRepositorio.save(new Catalogo("Hiedra", "Planta trepadora ideal para interiores y exteriores",
                    "https://image.tuasaude.com/media/article/on/lc/hiedra_19500.jpg?width=686&height=487", 2, 3, 3, 2, 2));
            catalogoRepositorio.save(new Catalogo("Begonia", "Planta decorativa con hojas y flores coloridas",
                    "https://miarevista.okdiario.com/wp-content/uploads/sites/3/2022/07/27/62e171a4af62e.jpeg", 3, 4, 3, 2, 3));
            catalogoRepositorio.save(new Catalogo("Girasol", "Planta que requiere mucho sol y crece rápidamente",
                    "https://www.kukyflor.com/blog/wp-content/uploads/2018/01/girasol.jpg", 5, 3, 5, 5, 2));
            catalogoRepositorio.save(new Catalogo("Menta", "Planta aromática de crecimiento rápido y fácil cuidado",
                    "https://www.clarin.com/img/2024/01/04/F4DQRcS5o_2000x1500__1.jpg", 3, 4, 3, 2, 1));
            catalogoRepositorio.save(new Catalogo("Tomate", "Planta frutal que requiere sol y riego constante",
                    "https://agrosemval.com/wp-content/uploads/2020/05/tomate-chonto-santa-clara-ipc-01.jpg", 5, 4, 4, 5, 3));
            catalogoRepositorio.save(new Catalogo("Lirio", "Planta ornamental elegante con flores grandes",
                    "https://cdn0.ecologiaverde.com/es/posts/9/3/8/lirios_cuidados_839_600.jpg", 3, 4, 3, 2, 3));
            catalogoRepositorio.save(new Catalogo("Ficus", "Planta de interior popular y resistente",
                    "https://mygarden.com.co/wp-content/uploads/2020/05/PLANTA-FICUS-ELASTICA-TINEKE.jpg", 3, 3, 3, 1, 2));
            catalogoRepositorio.save(new Catalogo("Calathea", "Planta decorativa que requiere humedad y sombra",
                    "https://www.gardenia.net/wp-content/uploads/2024/02/shutterstock_2221039849.jpg", 2, 5, 3, 1, 4));
            catalogoRepositorio.save(new Catalogo("Geranio", "Planta de exterior con flores resistentes",
                    "https://www.picturethisai.com/image-handle/website_cmsname/image/1080/347094560811679744.jpeg?x-oss-process=image/format,webp/resize,s_800&v=1.0", 4, 3, 4, 5, 2));
            catalogoRepositorio.save(new Catalogo("Crisantemo", "Planta ornamental de flores abundantes",
                    "https://media.floresfrescasonline.com/product/crisantemos-flor-grande-800x800.jpeg?width=1200", 4, 4, 3, 5, 3));
            catalogoRepositorio.save(new Catalogo("Pothos", "Planta de interior muy resistente y fácil de cuidar",
                    "https://www.inkbird.com/cdn/shop/articles/pothos-plant-care_74b75b4e-7f00-4c8d-b4fe-5094fdb75d45.jpg?v=1764574719", 2, 3, 3, 1, 1));
 
            System.out.println("✅ Catálogo cargado con 20 plantas.");
        } else {
            System.out.println("ℹ️ El catálogo ya tiene datos, no se insertaron duplicados.");
        }
    }
}
 

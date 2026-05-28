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
                    "https://images.unsplash.com/photo-1513704519535-f5c81aa78d0d?q=80&w=500", 3, 1, 5, 5, 1));
            catalogoRepositorio.save(new Catalogo("Rosa", "Planta ornamental con flores llamativas que requiere cuidados frecuentes",
                    "https://images.unsplash.com/photo-1518895312237-a9e23508077d?q=80&w=500", 3, 5, 3, 5, 4));
            catalogoRepositorio.save(new Catalogo("Helecho", "Planta de interior que necesita humedad y poca luz directa",
                    "https://images.unsplash.com/photo-1597305877032-0668b3c6413a?q=80&w=500", 2, 5, 3, 1, 3));
            catalogoRepositorio.save(new Catalogo("Suculenta", "Planta fácil de cuidar, almacena agua en sus hojas",
                    "https://images.unsplash.com/photo-1509423350716-97f9360b4e09?q=80&w=500", 4, 2, 5, 3, 1));
            catalogoRepositorio.save(new Catalogo("Orquidea", "Planta delicada con flores exóticas, requiere cuidados específicos",
                    "https://images.unsplash.com/photo-1534885391148-39328a6f238f?q=80&w=500", 3, 3, 3, 2, 5));
            catalogoRepositorio.save(new Catalogo("Palma", "Planta decorativa de mayor tamaño ideal para espacios amplios",
                    "https://images.unsplash.com/photo-1512428813824-f713cb752935?q=80&w=500", 5, 3, 5, 5, 3));
            catalogoRepositorio.save(new Catalogo("Aloe Vera", "Planta medicinal resistente y fácil de cuidar",
                    "https://images.unsplash.com/photo-1567331711402-509c2ca91307?q=80&w=500", 4, 2, 5, 3, 1));
            catalogoRepositorio.save(new Catalogo("Lavanda", "Planta aromática que necesita sol y poco riego",
                    "https://images.unsplash.com/photo-1528733918455-5a59687cedf0?q=80&w=500", 5, 2, 4, 5, 2));
            catalogoRepositorio.save(new Catalogo("Bambu", "Planta de rápido crecimiento y fácil mantenimiento",
                    "https://images.unsplash.com/photo-1537243958045-81498fcc704e?q=80&w=500", 3, 4, 4, 3, 2));
            catalogoRepositorio.save(new Catalogo("Hiedra", "Planta trepadora ideal para interiores y exteriores",
                    "https://images.unsplash.com/photo-1622325357833-28669e46a58f?q=80&w=500", 2, 3, 3, 2, 2));
            catalogoRepositorio.save(new Catalogo("Begonia", "Planta decorativa con hojas y flores coloridas",
                    "https://images.unsplash.com/photo-1525310238806-e1a4458f0003?q=80&w=500", 3, 4, 3, 2, 3));
            catalogoRepositorio.save(new Catalogo("Girasol", "Planta que requiere mucho sol y crece rápidamente",
                    "https://images.unsplash.com/photo-1470509037663-253afd7f0f51?q=80&w=500", 5, 3, 5, 5, 2));
            catalogoRepositorio.save(new Catalogo("Menta", "Planta aromática de crecimiento rápido y fácil cuidado",
                    "https://images.unsplash.com/photo-1603033157247-49d29064c632?q=80&w=500", 3, 4, 3, 2, 1));
            catalogoRepositorio.save(new Catalogo("Tomate", "Planta frutal que requiere sol y riego constante",
                    "https://images.unsplash.com/photo-1592841200221-a6898f307baa?q=80&w=500", 5, 4, 4, 5, 3));
            catalogoRepositorio.save(new Catalogo("Lirio", "Planta ornamental elegante con flores grandes",
                    "https://images.unsplash.com/photo-1593691509543-c55fb32e7355?q=80&w=500", 3, 4, 3, 2, 3));
            catalogoRepositorio.save(new Catalogo("Ficus", "Planta de interior popular y resistente",
                    "https://images.unsplash.com/photo-1614594975525-e45190c55d0b?q=80&w=500", 3, 3, 3, 1, 2));
            catalogoRepositorio.save(new Catalogo("Calathea", "Planta decorativa que requiere humedad y sombra",
                    "https://images.unsplash.com/photo-1637967886160-fd78dc3ce3f5?q=80&w=500", 2, 5, 3, 1, 4));
            catalogoRepositorio.save(new Catalogo("Geranio", "Planta de exterior con flores resistentes",
                    "https://images.unsplash.com/photo-1557090495-ac9312e77b4e?q=80&w=500", 4, 3, 4, 5, 2));
            catalogoRepositorio.save(new Catalogo("Crisantemo", "Planta ornamental de flores abundantes",
                    "https://images.unsplash.com/photo-1603503527239-01255394086e?q=80&w=500", 4, 4, 3, 5, 3));
            catalogoRepositorio.save(new Catalogo("Pothos", "Planta de interior muy resistente y fácil de cuidar",
                    "https://images.unsplash.com/photo-1632207691143-643e23961367?q=80&w=500", 2, 3, 3, 1, 1));

            System.out.println("✅ Catálogo cargado con 20 plantas.");
        } else {
            System.out.println("ℹ️ El catálogo ya tiene datos, no se insertaron duplicados.");
        }
    }
}

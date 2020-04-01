package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, CatalogUtil.InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "/Users/adelinamihai/IdeaProjects/catalog.ser");

        Document doc =
                new Document("Java", "Java Course ", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");

        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws CatalogUtil.InvalidCatalogException, IOException, FileNotFoundException {
        Catalog catalog = (Catalog) CatalogUtil.load("/Users/adelinamihai/IdeaProjects/catalog.ser");

        Document doc = catalog.findById("java");
        CatalogUtil.view(doc);
    }
}

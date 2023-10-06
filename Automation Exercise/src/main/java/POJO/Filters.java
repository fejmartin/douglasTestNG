package POJO;

public class Filters {
    private String Highlights;
    private String Marke;
    private String Produktart;
    private String Geschenk_fur;
    private String Fur_Wen;

    public Filters(String highlights, String marke, String produktart, String geschenk_fur, String fur_wen) {
        setHighlights(highlights);
        setMarke(marke);
        setProduktart(produktart);
        setGeschenk_fur(geschenk_fur);
        setFur_Wen(fur_wen);

    }

    public void setHighlights(String highlights) {
        Highlights = highlights;
    }

    public void setMarke(String marke) {
        Marke = marke;
    }

    public void setProduktart(String produktart) {
        Produktart = produktart;
    }

    public void setGeschenk_fur(String geschenk_fur) {
        Geschenk_fur = geschenk_fur;
    }

    public void setFur_Wen(String fur_Wen) {
        Fur_Wen = fur_Wen;
    }

    public String getHighlights() {
        return Highlights;
    }

    public String getMarke() {
        return Marke;
    }

    public String getGeschenk_fur() {
        return Geschenk_fur;
    }

    public String getFur_Wen() {
        return Fur_Wen;
    }

    public String getProduktart() {
        return Produktart;
    }
}

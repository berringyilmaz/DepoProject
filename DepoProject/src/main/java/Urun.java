public class Urun {

    private int id;
    private String urunIsmi;
    private String uretici;
    private double miktar = 0; // başlangıçta 0
    private String birim;
    private String raf = "-"; // başlangıçta tanımlı değil

    public Urun(int id, String urunIsmi, String uretici, String birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public String getBirim() {
        return birim;
    }

    public double getMiktar() {
        return miktar;
    }

    public String getUretici() {
        return uretici;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }

}
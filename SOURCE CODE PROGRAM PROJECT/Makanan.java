public abstract class Makanan {
    private String nama;
    private int hargaProduksi;

    public Makanan(String nama, int hargaProduksi) {
        this.nama = nama;
        this.hargaProduksi = hargaProduksi;
    }

    public String getNama() {
        return nama;
    }

    public int getHargaProduksi() {
        return hargaProduksi;
    }

    public abstract int getHargaJual(); 
    public abstract String getKategori(); 
}

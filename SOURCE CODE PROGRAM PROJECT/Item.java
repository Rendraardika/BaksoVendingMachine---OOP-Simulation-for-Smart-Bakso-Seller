public class Item extends Makanan {
    private int hargaJual;
    private boolean terjual;

    // isi lengkap
    public Item(String nama, int hargaProduksi, int hargaJual) {
        super(nama, hargaProduksi);
        this.hargaJual = hargaJual;
        this.terjual = false;
    }

    //nama
    public Item(String nama) {
        super(nama, getHargaProduksiDefault(nama));
        this.hargaJual = getHargaJualDefault(nama);
        this.terjual = false;
    }

    //default harga
    private static int getHargaProduksiDefault(String nama) {
        switch (nama) {
            case "Bakso Halus":
            case "Bakso Urat":
            case "Bakso Telur Puyuh":
                return 2000;
            case "Bakwan":
                return 1000;
            case "Tahu":
            case "Mie Bihun":
                return 500;
            case "Kuah":
                return 0;
            default:
                return 0;
        }
    }

    private static int getHargaJualDefault(String nama) {
        switch (nama) {
            case "Bakso Halus":
                return 3000;
            case "Bakso Urat":
                return 3500;
            case "Bakso Telur Puyuh":
                return 4000;
            case "Bakwan":
                return 2000;
            case "Tahu":
            case "Mie Bihun":
                return 1000;
            case "Kuah":
                return 0;
            default:
                return 0;
        }
    }

    public boolean isTerjual() {
        return terjual;
    }

    public void setTerjual(boolean terjual) {
        this.terjual = terjual;
    }

    @Override
    public int getHargaJual() {
        return hargaJual;
    }

    @Override
    public String getKategori() {
        return getNama().contains("Bakso") ? "Bakso" : "Pelengkap";
    }

    public String toString() {
        return getNama() + " - Rp " + hargaJual;
    }
}

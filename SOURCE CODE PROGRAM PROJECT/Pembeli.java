public class Pembeli {
    private Item[] keranjang;
    private int jumlahItem;

    public Pembeli() {
        keranjang = new Item[100]; // item 100
        jumlahItem = 0;
    }

    public void pilihItem(VendingMachine mesin, String nama, int jumlah) {
        Item[] beli = mesin.beliItem(nama, jumlah); 

        for (int i = 0; i < beli.length; i++) {
            keranjang[jumlahItem] = beli[i];
            jumlahItem++;
        }
    }

    public void tampilkanBelanjaan() {
        System.out.println("=== ITEM YANG ANDA BELI ===");
        int total = 0;
        for (int i = 0; i < jumlahItem; i++) {
            System.out.println(keranjang[i]);
            total += keranjang[i].getHargaJual();
        }
        System.out.println("Total Bayar: Rp " + total);
    }
}

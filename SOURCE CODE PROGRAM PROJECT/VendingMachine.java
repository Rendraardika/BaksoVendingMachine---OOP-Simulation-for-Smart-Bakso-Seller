public class VendingMachine {
    private String[] daftarItem = {
        "Bakso Halus", "Bakso Urat", "Bakso Telur Puyuh",
        "Bakwan", "Tahu", "Mie Bihun", "Kuah"
    };

    private Item[][] stok = new Item[daftarItem.length][100]; // stok  100
    private int[] stokTersisa = new int[daftarItem.length]; // jumlah stok yang ada
    private Item[] penjualan = new Item[1000]; //  item yang terjual
    private int jumlahTerjual = 0;

    public VendingMachine() {
        for (int i = 0; i < daftarItem.length; i++) {
            for (int j = 0; j < 100; j++) {
                stok[i][j] = new Item(daftarItem[i]);
            }
            stokTersisa[i] = 100;
        }
    }

    public void tampilkanMenu() {
        System.out.println("=== MENU BAKSO ===");
        for (int i = 0; i < daftarItem.length; i++) {
            if (stokTersisa[i] > 0) {
                System.out.println(daftarItem[i] + " - Rp " + stok[i][0].getHargaJual() + " (Stok: " + stokTersisa[i] + ")");
            } else {
                System.out.println(daftarItem[i] + " - HABIS");
            }
        }
    }

    private int cariIndexItem(String nama) {
        for (int i = 0; i < daftarItem.length; i++) {
            if (daftarItem[i].equals(nama)) {
                return i;
            }
        }
        return -1; 
    }

    public Item[] beliItem(String nama, int jumlah) {
        int index = cariIndexItem(nama);

        if (index == -1 || stokTersisa[index] < jumlah) {
            System.out.println("Stok untuk " + nama + " tidak cukup!");
            return new Item[0];
        }

        Item[] hasil = new Item[jumlah];
        for (int i = 0; i < jumlah; i++) {
            stokTersisa[index]--;
            Item item = stok[index][stokTersisa[index]];
            stok[index][stokTersisa[index]] = null;
            item.setTerjual(true);
            hasil[i] = item;
            penjualan[jumlahTerjual++] = item;
        }

        return hasil;
    }

    public void tampilkanItemTerjual() {
        System.out.println("=== ITEM TERJUAL ===");
        for (int i = 0; i < jumlahTerjual; i++) {
            System.out.println(penjualan[i]);
        }
    }

    public void tampilkanItemSisa() {
        System.out.println("=== ITEM BELUM TERJUAL ===");
        for (int i = 0; i < daftarItem.length; i++) {
            System.out.println(daftarItem[i] + ": " + stokTersisa[i] + " item");
        }
    }

    public int hitungKeuntungan() {
        int modal = 0;
        int pemasukan = 0;
        for (int i = 0; i < jumlahTerjual; i++) {
            modal += penjualan[i].getHargaProduksi();
            pemasukan += penjualan[i].getHargaJual();
        }
        return pemasukan - modal;
    }
}

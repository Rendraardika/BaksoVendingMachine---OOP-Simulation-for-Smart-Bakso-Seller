public class Main {
    public static void main(String[] args) {
        VendingMachine mesin = new VendingMachine();
        mesin.tampilkanMenu();

        Pembeli pembeli1 = new Pembeli();
        pembeli1.pilihItem(mesin, "Bakso Halus", 3);
        pembeli1.pilihItem(mesin, "Bakwan", 2);
        pembeli1.pilihItem(mesin, "Kuah", 1);
        pembeli1.tampilkanBelanjaan();

        mesin.tampilkanItemTerjual();
        mesin.tampilkanItemSisa();

        System.out.println("Total Keuntungan: Rp " + mesin.hitungKeuntungan());
    }
}


import java.util.Scanner;

public class SIGTA {
    static Scanner sig = new Scanner(System.in);
    static int user = 0;
    static boolean registrationCompleted = false;
    static boolean loginuser = false;
    static boolean logoutuser = false;
    static String[][] userGudang = new String[10][2];
    static String[] namaBarang = new String[10];
    static int pemasukan[][] = new int[2][10];
    static int itemcount = 0;
    static String[] laporanBarang = new String[20]; // Array untuk laporan
    static int jumlahLaporan = 0;

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int pilih = sig.nextInt();
            sig.nextLine();
            switchMenu(pilih);
        }
    }

    static void showMenu() {
        System.out.println("|===========================================================|");
        System.out.println("|             SELAMAT DATANG DI INVENTARIS GUDANG           |");
        System.out.println("|===========================================================|");
        System.out.println("| Silahkan Pilih Menu :                                     |");
        System.out.println("|----------------------                                     |");

        if (!registrationCompleted) {
            System.out.println("|1. DAFTAR PENGGUNA                                         |");
        }
        if (!loginuser) {
            System.out.println("|2. LOGIN PENGGUNA                                          |");
        }
            System.out.println("|3. Input data barang di Gudang                             |");
            System.out.println("|4. Display data barang di Gudang                           |");
            System.out.println("|5. Update Transaksi                                        |");
            System.out.println("|6. Laporan Barang Rusak / Catatan                          |");
            System.out.println("|7. Tampilkan Laporan Barang Rusak                          |");
            System.out.println("|8. LOGOUT                                                  |");
            System.out.println("|9. Keluar                                                  |");
            System.out.println("|===========================================================|");
            System.out.println("Pilih Menu :");
        }

    

    static void switchMenu(int pilih) {
        switch (pilih) {
            case 1:
                if (!registrationCompleted) {
                    registerUser();
                } else {
                    System.out.println("Anda sudah melakukan registrasi sebelumnya.");
                }
                break;
            case 2:
                loginUser();
                break;
            case 3:
                inputDataBarang();
                break;
            case 4:
                displayDataBarang();
                break;
            case 5:
                updateTransaksi();
                break;
            case 6:
                laporanBarangRusak();
                break;
            case 7:
                tampilkanLaporanBarangRusak();
                break;
            case 8:
                logout();
                break;
            case 9:
                System.out.println(" ");
                System.out.println("Anda berhasil keluar");
                System.out.println(" ");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan anda tidak valid, silahkan coba lagi !");
        }
    }

    // Implementasi fungsi lainnya
    // ...

    static void registerUser() {
        System.out.println(" ");
        System.out.println("|===========================================================|");
        System.out.println("|                      DAFTAR PENGGUNA                      |");
        System.out.println("|===========================================================|");
        System.out.println("|Masukkan username :                                        |");
        String username = sig.nextLine();
        System.out.println("|Masukkan password :                                        |");
        String password = sig.nextLine();
        System.out.println("|===========================================================|");
        System.out.println(" ");

        if (user < userGudang.length) {
            userGudang[user][0] = username;
            userGudang[user][1] = password;
            user++;
            registrationCompleted = true;
            System.out.println(" ");
            System.out.println("Username dan password berhasil di daftarkan!");
            System.out.println(" ");
        } else {
            System.out.println("Pendaftaran penuh, Silahkan coba lagi!");
        }
    }

    static void loginUser() {
        if (user == 0) {
            System.out.println(" ");
            System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
        } else {
            System.out.println("|===========================================================|");
            System.out.println("|                       LOGIN PENGGUNA                      |");
            System.out.println("|===========================================================|");
            System.out.println("|Masukkan username :                                        |");
            String loginUsername = sig.nextLine();
            System.out.println("|Masukkan password :                                        |");
            String loginPassword = sig.nextLine();
            System.out.println("|===========================================================|");

            boolean userFound = false;
            for (int i = 0; i < user; i++) {
                if (userGudang[i][0].equals(loginUsername) && userGudang[i][1].equals(loginPassword)) {
                    System.out.println(" ");
                    System.out.println(" Login berhasil ! Silahkan Masuk," + loginUsername + "!");
                    System.out.println(" ");
                    userFound = true;
                    loginuser = true;
                    logoutuser = true;
                    break;
                }
            }
            if (!userFound) {
                System.out.println(" ");
                System.out.println("Login Gagal, Username atau Password belum terdaftar");
                System.out.println(" ");
            }
        }
    }

    static void inputDataBarang() {
        if (user == 0) {
            System.out.println(" ");
            System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
        }else{
            if (!loginuser){
                System.out.println(" ");
                System.out.println("Maaf, Anda harus login terlebih dahulu !");
                System.out.println(" ");
                return;
            }
        boolean dataBaru = true;
        while (dataBaru) {
            System.out.println("|=======================================|");
            System.out.println("|      INPUT DATA BARANG DI GUDANG      |");
            System.out.println("|=======================================|");
            System.out.println("|Jumlah barang yang akan dimasukkan:    |");
            int jumlahBarang = sig.nextInt();
            sig.nextLine();

            for (int r = 0; r < jumlahBarang; r++) {
                System.out.println("|---------------------------------------| ");
                System.out.println("|Barang ke-" + (r + 1) + "              | ");
                System.out.println("|---------------------------------------| ");
                System.out.println("|Masukan nama barang      :             | ");
                namaBarang[r] = sig.nextLine();
                System.out.println("|Masukan jumlah barang    :             |");
                pemasukan[1][itemcount] = sig.nextInt();
                sig.nextLine();
                System.out.println("|=======================================|");
            }

            System.out.println("Barang Berhasil Ditambah");
            pemasukan[0][itemcount] = jumlahBarang;
            itemcount++;

            System.out.println("Apakah ada barang yang ingin anda tambahkan? (y/n)");
            char newData = sig.next().charAt(0);
            if (newData == 'n') {
                dataBaru = false;
            }
        }}
    }

    static void displayDataBarang() {
        if (user == 0) {
            System.out.println(" ");
            System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
        }else{
            if (!loginuser){
                System.out.println(" ");
                System.out.println("Maaf, Anda harus login terlebih dahulu !");
                System.out.println(" ");
                return;
            }
        System.out.println(" ");
        System.out.println("=======================================");
        System.out.println("       DISPLAY BARANG DI GUDANG        ");
        System.out.println("=======================================");
        System.out.println("Data Barang yang Telah Dimasukkan :    ");
        System.out.println("---------------------------------------");

        for (int i = 0; i < itemcount; i++) {
            System.out.println("Transaksi ke-" + (i + 1));
            System.out.println("---------------------------------------");
            for (int r = 0; r < pemasukan[0][i]; r++) {
                System.out.println("Nama Barang  : " + namaBarang[r]);
                System.out.println("Jumlah       : " + pemasukan[1][i]);
            }
            System.out.println("---------------------------------------");
            System.out.println(" ");
        }}
    }

    static void updateTransaksi() {
        if (user == 0) {
            System.out.println(" ");
            System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
        }else{
            if (!loginuser){
                System.out.println(" ");
                System.out.println("Maaf, Anda harus login terlebih dahulu !");
                System.out.println(" ");
                return;
            }
        if (itemcount > 0) {
            System.out.println(" ");
            System.out.println("================================================");
            System.out.println("       UPDATE TRANSAKSI DI GUDANG               ");
            System.out.println("================================================");
            System.out.println("Pilih nomor transaksi yang ingin diubah:        ");
            int nomorTransaksi = sig.nextInt();

            if (nomorTransaksi > 0 && nomorTransaksi <= itemcount) {
                System.out.println("------------------------------------------------");
                System.out.println("Data Barang pada transaksi ke-" + nomorTransaksi + ":");
                System.out.println("------------------------------------------------");
                for (int r = 0; r < pemasukan[0][nomorTransaksi - 1]; r++) {
                    System.out.println((r + 1) + ". Nama Barang: " + namaBarang[r]);
                    System.out.println("Jumlah: " + pemasukan[1][nomorTransaksi - 1]);
                }

                System.out.println("------------------------------------------------");
                System.out.println("Pilih nomor barang yang ingin diubah jumlahnya: ");
                int nomorBarang = sig.nextInt();

                if (nomorBarang > 0 && nomorBarang <= pemasukan[0][nomorTransaksi - 1]) {
                    System.out.println("------------------------------------------------");
                    System.out.println("Masukkan jumlah baru untuk barang " + namaBarang[nomorBarang - 1] + ":");
                    int jumlahBaru = sig.nextInt();

                    if (jumlahBaru >= 0) {
                        pemasukan[1][nomorTransaksi - 1] = jumlahBaru;
                        System.out.println("Jumlah barang berhasil diubah menjadi " + jumlahBaru);
                        System.out.println("================================================");
                        System.out.println(" ");
                    } else {
                        System.out.println("Jumlah barang baru tidak valid");
                    }
                } else {
                    System.out.println("Nomor barang tidak valid");
                }
            } else {
                System.out.println("Nomor transaksi tidak valid");
            }
        } else {
            System.out.println("Belum ada data barang yang dimasukkan");
        }}
    }

    static void laporanBarangRusak() {
        if (user == 0) {
            System.out.println(" ");
            System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
        }else{
            if (!loginuser){
                System.out.println(" ");
                System.out.println("Maaf, Anda harus login terlebih dahulu !");
                System.out.println(" ");
                return;
            }

        if (jumlahLaporan < laporanBarang.length) {
            System.out.println("|=======================================|");
            System.out.println("|     LAPORAN BARANG RUSAK / CATATAN    |");
            System.out.println("|=======================================|");
            System.out.println("|Masukkan detail barang rusak / catatan:|");
            String detail = sig.nextLine();
            System.out.println("|=======================================|");

            laporanBarang[jumlahLaporan] = detail;
            jumlahLaporan++;

            System.out.println("Laporan berhasil disimpan!");
            System.out.println(" ");
        } else {
            System.out.println("Kapasitas laporan sudah penuh, tidak bisa menambahkan laporan baru.");
        }}
        System.out.println(" ");
    }

    static void tampilkanLaporanBarangRusak() {
        if (user == 0) {
            System.out.println(" ");
            System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
        }else{
            if (!loginuser){
                System.out.println(" ");
                System.out.println("Maaf, Anda harus login terlebih dahulu !");
                System.out.println(" ");
                return;
            }
        System.out.println(" ");
        System.out.println("|====================================================|");
        System.out.println("|    LAPORAN BARANG RUSAK / CATATAN YANG TERSIMPAN   |");
        System.out.println("|====================================================|");
        System.out.println(" ");

        if (jumlahLaporan == 0) {
            System.out.println("Tidak ada laporan yang tersimpan.");
        } else {
            for (int i = 0; i < jumlahLaporan; i++) {
                System.out.println("Laporan " + (i + 1) + ": " + laporanBarang[i]);
                System.out.println("|====================================================|");
            }
        }}

        System.out.println(" ");
    }
    
    static void logout() {
        System.out.println(" ");
        System.out.println("Anda telah logout dari sistem !");
        System.out.println(" ");
        logoutuser = false;
        registrationCompleted = false;
        loginuser = false;
    }
}

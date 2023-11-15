import java.util.Scanner;
import java.util.Arrays;

public class SIGTA{
    public static void main(String[] args) {
        Scanner sig = new Scanner(System.in);
        int user = 0;
        boolean loginuser = false;
        String[][] userGudang = new String[10][2];
        String[][] namaBarang = new String[10][10];
        int[][] pemasukan = new int[2][10];
        int itemcount = 0;

        while (true) {
            System.out.println("|===========================================================|");
            System.out.println("|             SELAMAT DATANG DI INVENTARIS GUDANG           |");
            System.out.println("|===========================================================|");
            System.out.println("| Silahkan Pilih Menu :                                     |");
            System.out.println("|----------------------                                     |");
            System.out.println("|1. DAFTAR PENGGUNA                                         |");
            System.out.println("|2. LOGIN PENGGUNA                                          |");
            System.out.println("|3. Input data barang di Gudang                             |");
            System.out.println("|4. Display data barang di Gudang                           |");
            System.out.println("|5. LOGOUT                                                  |");
            System.out.println("|6. KELUAR                                                  |");

            System.out.println("Pilih Menu :");
            int pilih = sig.nextInt();
            sig.nextLine();

            // Tambahkan kondisi untuk memastikan pengguna harus login setelah logout
            if (!loginuser && pilih >= 3 && pilih <= 6) {
                System.out.println(" ");
                System.out.println("Anda harus login terlebih dahulu !");
                System.out.println(" ");
                continue;
            }

            switch (pilih) {
                case 1:
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
                        System.out.println(" ");
                        System.out.println("Username dan password berhasil didaftarkan!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Pendaftaran penuh, Silahkan coba lagi!");
                    }
                    break;

                case 2:
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
                            loginuser = true;
                            System.out.println(" ");
                            System.out.println("Login berhasil! Silahkan Masuk, " + loginUsername + "!");
                            System.out.println(" ");
                            userFound = true;
                            break;
                        }
                    }
                    if (!userFound) {
                        System.out.println(" ");
                        System.out.println("Login Gagal, Username atau Password belum terdaftar");
                        System.out.println(" ");
                    }
                    break;

                case 3:
                    if (user == 0) {
                        System.out.println(" ");
                        System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                        System.out.println(" ");
                    } else {
                        if (!loginuser) {
                            System.out.println(" ");
                            System.out.println("Maaf, Anda harus login terlebih dahulu !");
                            System.out.println(" ");
                            break;
                        }
                        boolean dataBaru = false;
                        while (!dataBaru) {
                            System.out.println("Jumlah barang yang akan dimasukkan: ");
                            pemasukan[0][itemcount] = sig.nextInt();
                            for (int r = 0; r < pemasukan[0][itemcount]; r++) {
                                System.out.println("Barang ke-" + (r + 1));
                                System.out.println("Masukan nama barang:");
                                namaBarang[itemcount][r] = sig.next(); // Memperbarui nama barang sesuai dengan transaksi saat ini
                                System.out.println("Masukan jumlah barang");
                                pemasukan[1][itemcount] = sig.nextInt();
                            }
                            System.out.println("barang berhasil ditambah");
                            itemcount++;
                            System.out.println("apakah ada barang yang ingin anda tambahkan? (y/n)");
                            char newData = sig.next().charAt(0);
                            if (newData != 'y') {
                                dataBaru = true;
                            }
                        }
                    }
                    break;

                case 4:
                    if (user == 0) {
                        System.out.println(" ");
                        System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                        System.out.println(" ");
                    } else {
                        if (!loginuser) {
                            System.out.println(" ");
                            System.out.println("Maaf, Anda harus login terlebih dahulu !");
                            System.out.println(" ");
                            break;
                        }
                        System.out.println("\nData Barang yang Telah Dimasukkan:");
                        for (int i = 0; i < itemcount; i++) {
                            System.out.println("Transaksi ke-" + (i + 1) + ":");
                            for (int r = 0; r < pemasukan[0][i]; r++) {
                                System.out.println("  - Nama Barang: " + namaBarang[i][r] + " - Jumlah: " + pemasukan[1][i]);
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(" ");
                    System.out.println("Anda telah logout dari sistem !");
                    System.out.println(" ");
                    loginuser = false; // Setelah logout, reset nilai loginuser menjadi false
                    break;

                case 6:
                    System.out.println(" ");
                    System.out.println("Anda berhasil keluar");
                    System.out.println(" ");
                    System.exit(0);

                default:
                    System.out.println("Pilihan anda tidak valid, silahkan coba lagi !");
            }
        }
    }
}

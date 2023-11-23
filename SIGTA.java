import java.util.Scanner;
import java.util.Arrays;

public class SIGTA {
    public static void main(String[] args) {
        Scanner sig = new Scanner(System.in);
        int user = 0;
        int brg = 0;
        boolean loginuser = false;
        boolean logoutuser = false;
        String[][] userGudang = new String[10][2]; // menggunakan array 2 dimensi untuk membatasi pengguna yang mendaftar
        String[]namaBarang = new String[10];
        int pemasukan[][] = new int[2][10]; // menghitung jumlah transaksi
        int itemcount = 0; // int items

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
            System.out.println("|5. Update Transaksi                                        |");
            System.out.println("|6. LOGOUT                                                  |");
            System.out.println("|7. Keluar                                                  |");
            System.out.println("|===========================================================|");

            System.out.println("Pilih Menu :");
            int pilih = sig.nextInt();
            sig.nextLine();

            switch (pilih) {
                case 1:
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

                    if (user < userGudang.length) { // untuk menyimpan username dan password yang telah ditambahkan
                        userGudang[user][0] = username;
                        userGudang[user][1] = password;
                        user++;
                        System.out.println(" ");
                        System.out.println("Username dan password berhasil di daftarkan!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Pendaftaran penuh, Silahkan coba lagi!");
                    }
                    break;

                case 2:
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

                        } else {
                            if (!logoutuser) {
                                System.out.println(" ");
                                System.out.println("Anda sudah logout, silahkan login terlebih dahulu ! !");
                                System.out.println(" ");
                                break;
                            }
                            boolean dataBaru = true;
                            while (dataBaru) {
                                System.out.println("|=======================================|");
                                System.out.println("|      INPUT DATA BARANG DI GUDANG      |");
                                System.out.println("|=======================================|");
                                System.out.println("|Jumlah barang yang akan dimasukkan:    |");
                                int jumlahBarang = sig.nextInt();
                                sig.nextLine(); // Membersihkan input buffer

                                for (int r = 0; r < jumlahBarang; r++) {
                                    System.out.println("|---------------------------------------| ");
                                    System.out.println(  "|Barang ke-" + (r + 1) + "              | ");
                                    System.out.println("|---------------------------------------| ");
                                    System.out.println("|Masukan nama barang      :             | ");
                                    namaBarang[r] = sig.nextLine(); // Menggunakan nextLine untuk nama barang
                                    System.out.println("|Masukan jumlah barang    :             |");
                                    pemasukan[1][itemcount] = sig.nextInt(); // Mengambil jumlah barang yang benar
                                    sig.nextLine(); // Membersihkan input buffer
                                    System.out.println("|=======================================|");
                                    brg++;
                                }

                                System.out.println("Barang Berhasil Ditambah");
                                pemasukan[0][itemcount] = jumlahBarang;
                                itemcount++;

                                System.out.println("Apakah ada barang yang ingin anda tambahkan? (y/n)");
                                char newData = sig.next().charAt(0);
                                if (newData == 'n') {
                                    dataBaru = false;
                                }
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
                        } else {
                            if (!logoutuser) {
                                System.out.println(" ");
                                System.out.println("Anda sudah logout, silahkan login terlebih dahulu ! !");
                                System.out.println(" ");
                                break;
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
                            }
                        }
                    }
                    break;

                case 5:
                    if (user == 0) {
                        System.out.println(" ");
                        System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                        System.out.println(" ");
                    } else {
                        if (!loginuser) {
                            System.out.println(" ");
                            System.out.println("Maaf, Anda harus login terlebih dahulu !");
                            System.out.println(" ");
                        } else {
                            if (!logoutuser) {
                                System.out.println(" ");
                                System.out.println("Anda sudah logout, silahkan login terlebih dahulu ! !");
                                System.out.println(" ");
                                break;
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
                                        System.out.println(
                                                (r + 1) + ". Nama Barang: " + namaBarang[r]);
                                        System.out.println("Jumlah: " + pemasukan[1][nomorTransaksi - 1]);
                                    }

                                    // Pilih nomor barang yang ingin diubah jumlahnya
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Pilih nomor barang yang ingin diubah jumlahnya: ");
                                    int nomorBarang = sig.nextInt();

                                    if (nomorBarang > 0 && nomorBarang <= pemasukan[0][nomorTransaksi - 1]) {
                                        System.out.println("------------------------------------------------");
                                        System.out.println("Masukkan jumlah baru untuk barang "
                                                + namaBarang[nomorBarang - 1] + ":");
                                        int jumlahBaru = sig.nextInt();

                                        if (jumlahBaru >= 0) {
                                            // Ubah jumlah barang
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
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println(" ");
                    System.out.println("Anda telah logout dari sistem !");
                    System.out.println(" ");
                    logoutuser = false;
                    break;

                case 7:
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

import java.util.Scanner;

    public class SIGTA {
        static Scanner sig = new Scanner(System.in);
        static int user = 0;
        static boolean registrationCompleted = false;
        static boolean loginuser = false;
        static boolean logoutuser = false;
        static String[][] userGudang = new String[10][2];
        static String[] namaBarang = new String[10];
        static String[] tipeBarang = new String[10]; // Sesuaikan ukuran array sesuai kebutuhan
        static int pemasukan[][] = new int[2][10];
        static int rusakBarang[][] = new int [2][10];
        static int itemcount = 0;
        static int notaCounter = 1;
        static String[] laporanBarang = new String[20]; // Array untuk laporan
        static int jumlahLaporan = 0;
        static int brgRsk = 1;
        static boolean isEnglish = true; // Flag untuk melacak bahasa yang dipilih
        String bahasa;

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
            System.out.println("|5. Update Nota                                             |");
            System.out.println("|6. Cari Barang                                             |");
            System.out.println("|7. Laporan Barang Rusak / Catatan                          |");
            System.out.println("|8. Tampilkan Laporan Barang Rusak                          |");
            System.out.println("|9. LOGOUT                                                  |");
            System.out.println("|10. Keluar                                                 |");
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
                    updateNota();
                    break;
                case 6:
                    cariBarang();
                    ;
                    break;
                case 7:
                    laporanBarangRusak();
                    break;
                case 8:
                    tampilkanLaporanBarangRusak();
                    break;
                case 9:
                    logout();
                    break;
                case 10:
                    System.out.println(" ");
                    System.out.println("Anda berhasil keluar");
                    System.out.println(" ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan anda tidak valid, silahkan coba lagi !");
            }
        }

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
                System.out.println(" ");
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
                System.out.println(" ");
            } else {
                if (!loginuser) {
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
                        namaBarang[itemcount + r] = sig.nextLine(); // Menggunakan itemcount + r sebagai indeks
                        System.out.println("|Masukan tipe barang      :             | ");
                        tipeBarang[itemcount + r] = sig.nextLine(); // Tambahkan input untuk tipe barang
                        System.out.println("|Masukan jumlah barang    :             |");
                        pemasukan[1][itemcount + r] = sig.nextInt();
                        sig.nextLine();
                        System.out.println("|=======================================|");
                    }

                    System.out.println("Barang Berhasil Ditambah");
                    pemasukan[0][itemcount] = jumlahBarang;
                    itemcount += jumlahBarang; // Menambahkan jumlah barang yang baru dimasukkan ke itemcount
                    notaCounter++;

                    System.out.println("Apakah ada barang yang ingin anda tambahkan? (y/n)");
                    char newData = sig.next().charAt(0);
                    if (newData == 'n') {
                        dataBaru = false;
                    }
                }
            }
        }


        static void displayDataBarang() {
            if (user == 0) {
                System.out.println(" ");
                System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                System.out.println(" ");
            } else {
                if (!loginuser) {
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

                int notaCounter = 1;
                int barangCounter = 0;

                while (barangCounter < itemcount) {
                    System.out.println("=======================================");
                    System.out.println("Nota ke-" + notaCounter);
                    System.out.println("=======================================");

                    int jumlahBarangNota = pemasukan[0][barangCounter];
                    for (int r = 0; r < jumlahBarangNota; r++) {
                        int nomorBarang = r + 1;
                        System.out.println("---------------------------------------");
                        System.out.println("Barang ke-" + nomorBarang);
                        System.out.println("---------------------------------------");
                        System.out.println("Nama Barang     : " + namaBarang[barangCounter]);
                        System.out.println("Tipe Barang     : " + tipeBarang[barangCounter]); // Menampilkan tipe barang
                        System.out.println("Jumlah          : " + pemasukan[1][barangCounter]);
                        barangCounter++;
                    }

                    System.out.println("---------------------------------------");
                    System.out.println(" ");
                    notaCounter++; // Increment notaCounter here
                }
            }
        }

        static void updateNota() {
            if (user == 0) {
                System.out.println(" ");
                System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                System.out.println(" ");
            } else {
                if (!loginuser) {
                    System.out.println(" ");
                    System.out.println("Maaf, Anda harus login terlebih dahulu !");
                    System.out.println(" ");
                    return;
                }
                if (itemcount > 0) {
                    System.out.println(" ");
                    System.out.println("================================================");
                    System.out.println("       UPDATE BARANG DI GUDANG               ");
                    System.out.println("================================================");
                    System.out.println("Pilih nomor nota yang ingin diubah:        ");
                    int nomorNota = sig.nextInt();
                    sig.nextLine();

                    int counter = 0;
                    int currentNota = 1;
                    while (counter < itemcount) {
                        if (currentNota == nomorNota) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Data Barang pada nota ke-" + nomorNota + ":");
                            System.out.println("------------------------------------------------");

                            int jumlahBarangNota = pemasukan[0][counter];
                            for (int r = 0; r < jumlahBarangNota; r++) {
                                System.out.println((r + 1) + ". Nama Barang: " + namaBarang[counter]);
                                System.out.println("Jumlah: " + pemasukan[1][counter]);
                                counter++;
                            }

                            System.out.println("------------------------------------------------");
                            System.out.println("Pilih nomor barang yang ingin diubah jumlahnya: ");
                            int nomorBarang = sig.nextInt();

                            if (nomorBarang > 0 && nomorBarang <= jumlahBarangNota) {
                                System.out.println("------------------------------------------------");
                                System.out.println("Masukkan jumlah baru untuk barang "
                                        + namaBarang[counter - jumlahBarangNota + nomorBarang - 1] + ":");
                                int jumlahBaru = sig.nextInt();

                                if (jumlahBaru >= 0) {
                                    pemasukan[1][counter - jumlahBarangNota + nomorBarang - 1] = jumlahBaru;
                                    System.out.println("Jumlah barang berhasil diubah menjadi " + jumlahBaru);
                                    System.out.println("================================================");
                                    System.out.println(" ");
                                } else {
                                    System.out.println("Jumlah barang baru tidak valid");
                                }
                            } else {
                                System.out.println("Nomor barang tidak valid");
                            }
                            break;
                        }
                        int jumlahBarangNota = pemasukan[0][counter];
                        counter += jumlahBarangNota;
                        currentNota++;
                    }

                    if (currentNota > nomorNota) {
                        System.out.println("Nomor nota tidak valid");
                    }
                } else {
                    System.out.println("Belum ada data barang yang dimasukkan");
                }
            }
        }

        static void laporanBarangRusak() {
            if (user == 0) {
                System.out.println(" ");
                System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                System.out.println(" ");
            } else {
                if (!loginuser) {
                    System.out.println(" ");
                    System.out.println("Maaf, Anda harus login terlebih dahulu !");
                    System.out.println(" ");
                    return;
                }

                boolean laporanBaru = true;
                while (laporanBaru) {
                    System.out.println("|=======================================|");
                    System.out.println("|     INPUT LAPORAN BARANG RUSAK        |");
                    System.out.println("|=======================================|");
                    System.out.println("|Jumlah barang rusak :                  |");
                    int jumlahBarangRusak = sig.nextInt();
                    sig.nextLine();

                    for (int a = 0; a < jumlahBarangRusak; a++) {
                        System.out.println("|---------------------------------------| ");
                        System.out.println("|Barang Rusak ke-" + (a + 1) + "           | ");
                        System.out.println("|---------------------------------------| ");
                        System.out.println("|Masukan nama barang rusak  :           | ");
                        String namaBarangRusak = sig.nextLine();
                        System.out.println("|Masukan detail kerusakan   :           |");
                        String detailKerusakan = sig.nextLine();
                        System.out.println("| Masukan jumlah Barang Rusak:          | ");
                        rusakBarang[1][itemcount + a] = sig.nextInt();
                        sig.nextLine();
                        System.out.println("|=======================================|");


                        // Simpan data laporan barang rusak ke array laporanBarang
                        laporanBarang[jumlahLaporan] = "Barang: " + namaBarangRusak + "\n Detail Kerusakan: "
                                + detailKerusakan + "\n jumlah  kerusakan barang: "+ rusakBarang[1][itemcount + a];
                        jumlahLaporan++;
                    }

                         System.out.println("Barang rusak berhasil di input");
                    rusakBarang[1][itemcount] = jumlahBarangRusak;
                    itemcount += jumlahBarangRusak; // Menambahkan jumlah barang yang baru dimasukkan ke itemcount
                    brgRsk++;

                    System.out.println("Laporan Barang Rusak Berhasil Ditambah");
                    System.out.println("Apakah ada laporan barang rusak yang ingin anda tambahkan? (y/n)");
                    char newData = sig.next().charAt(0);
                    if (newData == 'n') {
                        laporanBaru = false;
                    }
                }
            }
        }

        static void tampilkanLaporanBarangRusak() {
            if (user == 0) {
                System.out.println(" ");
                System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                System.out.println(" ");
            } else {
                if (!loginuser) {
                    System.out.println(" ");
                    System.out.println("Maaf, Anda harus login terlebih dahulu !");
                    System.out.println(" ");
                    return;
                }
                System.out.println(" ");
                System.out.println("|====================================================|");
                System.out.println("|    LAPORAN BARANG RUSAK / CATATAN YANG TERSIMPAN   |");
                System.out.println("|====================================================|");

                if (jumlahLaporan == 0) {
                    System.out.println("Tidak ada laporan barang rusak yang tersimpan.");
                } else {
                    for (int p = 0; p < jumlahLaporan; p++) {
                        System.out.println("|====================================================|");
                      System.out.println("Laporan " + (p + 1) + ": " + laporanBarang[p]);
                    }

                   
                }
            }

            System.out.println(" ");
        }

        static void cariBarang() {
            if (user == 0) {
                System.out.println(" ");
                System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
                System.out.println(" ");
            } else {
                if (!loginuser) {
                    System.out.println(" ");
                    System.out.println("Maaf, Anda harus login terlebih dahulu !");
                    System.out.println(" ");
                    return;
                }

                System.out.println("|====================================================|");
                System.out.println("|                CARI BARANG                         |");
                System.out.println("|====================================================|");
                System.out.println("| Masukkan nama barang yang ingin dicari:            |");
                String keyword = sig.nextLine();

                boolean barangDitemukan = false;
                int resultCounter = 1;
                System.out.println("|----------------------------------------------------|");
                System.out.println("Hasil pencarian untuk '" + keyword + "':");
                System.out.println("---------------------------------------              |");

                for (int i = 0; i < itemcount; i++) {
                    if (namaBarang[i].toLowerCase().equals(keyword.toLowerCase())) {
                        if (!barangDitemukan) {
                            barangDitemukan = true;
                        }
                        System.out.println("Nota ke-" + (notaCounter - 1));
                        System.out.println("---------------------------------------              |");
                        System.out.println("Nama Barang  : " + namaBarang[i]);
                        System.out.println("Tipe Barang  : " + tipeBarang[i]);
                        System.out.println("Jumlah       : " + pemasukan[1][i]);
                        System.out.println("|====================================================|");
                        resultCounter++;
                    }
                }

                // Tambahkan pencarian barang rusak
                for (int i = 0; i < jumlahLaporan; i++) {
                    if (laporanBarang[i].toLowerCase().contains(keyword.toLowerCase())) {
                        if (!barangDitemukan) {
                            barangDitemukan = true;
                        }
                        System.out.println("Laporan Rusak " + resultCounter + ": \n" + laporanBarang[i]);
                        System.out.println("|====================================================|");
                        resultCounter++;
                    }
                }

                if (!barangDitemukan) {
                    System.out.println("Barang tidak ditemukan.");
                }

                System.out.println(" ");
            }
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
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
    static int currentNota = 1;
    static int notaCounter = 1;

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
            System.out.println("|6. Laporan Barang Rusak / Catatan                          |");
            System.out.println("|7. Tampilkan Laporan Barang Rusak                          |");
            System.out.println("|8. LOGOUT                                                  |");
            System.out.println("|9. Keluar                                                  |");
            System.out.println("|10. Cari Barang                                            |");
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
            case 10:
                cariBarang();
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
                    String namaBarangInput = sig.nextLine();
                    System.out.println("|Masukan tipe barang      :             | ");
                    String tipeBarangInput = sig.nextLine();
                    System.out.println("|Masukan jumlah barang    :             |");
                    int jumlahBarangInput = sig.nextInt();
                    sig.nextLine();
                    System.out.println("|=======================================|");

                    boolean barangSudahAda = false;
                    for (int i = 0; i < itemcount; i++) {
                        if (namaBarang[i].equalsIgnoreCase(namaBarangInput) && tipeBarangInput.equalsIgnoreCase(userGudang[i][1])) {
                            pemasukan[1][i] += jumlahBarangInput;
                            barangSudahAda = true;
                            break;
                        }
                    }

                    if (!barangSudahAda) {
                        namaBarang[itemcount] = namaBarangInput;
                        userGudang[itemcount][1] = tipeBarangInput;
                        pemasukan[1][itemcount] = jumlahBarangInput;
                        itemcount++;
                    }
                }

                System.out.println("Barang Berhasil Ditambah");
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
            System.out.println("---------------------------------------");
    
            int currentNota = 1;
            int currentBarang = 0;
    
            while (currentBarang < itemcount) {
                System.out.println("Nota ke-" + currentNota);
                System.out.println("---------------------------------------");
    
                for (int i = 0; i < 2; i++) {
                    if (currentBarang < itemcount) {
                        System.out.println("Barang ke-" + (i + 1));
                        System.out.println("---------------------------------------");
                        System.out.println("Nama Barang  : " + namaBarang[currentBarang]);
                        System.out.println("Tipe Barang  : " + userGudang[currentBarang][1]);
                        System.out.println("Jumlah       : " + pemasukan[1][currentBarang]);
                        System.out.println("---------------------------------------");
                        currentBarang++;
                    }
                }
    
                currentNota++;
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
                
                if (nomorNota >= 1 && nomorNota <= notaCounter) {
    
                    int counter = 0;
                    currentNota = 1;
                    while (currentNota <= nomorNota) {
                        if (currentNota == nomorNota) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Data Barang pada nota ke-" + nomorNota + ":");
                            System.out.println("------------------------------------------------");
    
                            int jumlahBarangNota =0;
                            for (int r = 0; r < jumlahBarangNota; r++) {
                                if (counter >= itemcount) {
                                    break;
                                }
                                System.out.println((r + 1) + ". Nama Barang: " + namaBarang[counter]);
                                System.out.println("Jumlah: " + pemasukan[1][counter]);
                                counter++;
                            }
    
                            System.out.println("------------------------------------------------");
                            System.out.println("Pilih nomor barang yang ingin diubah jumlahnya: ");
                            int nomorBarang = sig.nextInt();
    
                            if (nomorBarang > 0 && nomorBarang <= jumlahBarangNota) {
                                System.out.println("------------------------------------------------");
                                System.out.println("Masukkan jumlah baru untuk barang " + namaBarang[counter - jumlahBarangNota + nomorBarang - 1] + ":");
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
                        int jumlahBarangNota = pemasukan[1][counter];
                        counter += jumlahBarangNota;
                        currentNota++;
                    }
    
                } else {        
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
    
                for (int r = 0; r < jumlahBarangRusak; r++) {
                    System.out.println("|---------------------------------------| ");
                    System.out.println("|Barang Rusak ke-" + (r + 1) + "           | ");
                    System.out.println("|---------------------------------------| ");
                    System.out.println("|Masukan nama barang rusak  :           | ");
                    String namaBarangRusak = sig.nextLine();
                    System.out.println("|Masukan detail kerusakan   :           |");
                    String detailKerusakan = sig.nextLine();
                    System.out.println("|=======================================|");
                    
                    // Simpan data laporan barang rusak ke array laporanBarang
                    laporanBarang[jumlahLaporan] = "Barang: " + namaBarangRusak + ", Detail Kerusakan: " + detailKerusakan;
                    jumlahLaporan++;
                }
    
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
            System.out.println("Hasil pencarian untuk '" + keyword + "':");
    
            for (int i = 0; i < itemcount; i++) {
                for (int r = 0; r < pemasukan[0][i]; r++) {
                    if (namaBarang[r].toLowerCase().contains(keyword.toLowerCase())) {
                        barangDitemukan = true;
                        System.out.println("Nota ke-" + (i + 1));
                        System.out.println("Nama Barang  : " + namaBarang[r]);
                        System.out.println("Jumlah       : " + pemasukan[1][i]);
                        System.out.println("---------------------------------------");
                    }
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

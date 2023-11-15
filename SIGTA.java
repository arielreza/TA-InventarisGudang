import java.util.Scanner;
import java.util.Arrays;

public class SIGTA{
    public static void main(String[] args) {
        Scanner sig = new Scanner (System.in);
        int user=0;
        String[][]userGudang = new String[10][2]; // menggunakan array 2 dimensi untuk membatasi pengguna yang mendaftar

        while(true){
        System.out.println("|===========================================================|");
        System.out.println("|             SELAMAT DATANG DI INVENTARIS GUDANG           |");
        System.out.println("|===========================================================|");
        System.out.println("| Silahkan Pilih Menu :                                     |");
        System.out.println("|----------------------                                     |");
        System.out.println("|1. DAFTAR PENGGUNA                                         |");
        System.out.println("|2. LOGIN PENGGUNA                                          |");
        System.out.println("|3. LOGOUT                                                  |");
        System.out.println("|4. KELUAR                                                  |");

        System.out.println("Pilih Menu :");
        int pilih = sig.nextInt();
        sig.nextLine();

        switch (pilih){
            case 1:
            System.out.println("|===========================================================|");
            System.out.println("|                      DAFTAR PENGGUNA                      |");
            System.out.println("|===========================================================|");
            System.out.println("|Masukkan username :                                        |");
            String username = sig.nextLine();
            System.out.println("|Masukkan password :                                        |");
            String password = sig.nextLine();
            System.out.println("|===========================================================|");
            
            if(user< userGudang.length){ //untuk menyimpan username dan password yang telah ditambahkan
                userGudang[user][0] = username;
                userGudang[user][1] = password;
                user++;
                System.out.println(" ");
                System.out.println("Username dan password berhasil di daftarkan!");
                System.out.println(" ");
            }else{
                System.out.println("Pendaftaran penuh, Silahkan coba lagi!");
            }
            break;

            case 2:
            if (user==0){
                System.out.println("Maaf anda belum daftar, Silahkan daftar terlebih dahulu!");
            }else{
            System.out.println("|===========================================================|");
            System.out.println("|                       LOGIN PENGGUNA                      |");
            System.out.println("|===========================================================|");
            System.out.println("|Masukkan username :                                        |");
            String loginUsername = sig.nextLine();
            System.out.println("|Masukkan password :                                        |");
            String loginPassword = sig.nextLine();
            System.out.println("|===========================================================|");

            boolean userFound = false;
            for (int i = 0; i< user; i++){
                if(userGudang[i][0].equals(loginUsername) && userGudang[i][1].equals(loginPassword)){
                    System.out.println(" Login berhasil ! Silahkan Masuk," + loginUsername + "!");
                    userFound=true;
                    break;
                }
            }
            if (!userFound){
                System.out.println("Login Gagal, Username atau Password belum terdaftar");
            }}
            break;

            case 3:
            System.out.println(" ");
            System.out.println("Anda telah logout dari sistem !");
            System.out.println(" ");
            break;

            case 4:
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

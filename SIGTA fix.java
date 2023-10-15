import java.util.Scanner;
public class SIGTA {
 public static void main(String[] args) {
    Scanner sig = new Scanner(System.in);
    Scanner sig1 = new Scanner(System.in);
    
    // login dulu gasih
    String email, password;

    // minta login dong sam
    System.out.println("Masukan email: ");
     email = sig.nextLine();
    System.out.println("Masukan pw: ");
    password = sig.nextLine();

    // priksa dulu ya ges ya
    if (email.equals("iki@gmail.wkwkwk") && password.equals("bandung")){
        
    
    System.out.println("login bisa, masuk sana ");
    System.out.println("nih ta kasih choice");

    int pilihan = 100;
    // anjay bisa login nih, sok atuh dipilih
    do { 
         pilihan = 100;
        int  jmlRistokBarang, jmlBarangKeluar, jmlTambahBarang,stokawal,stokkeluar;
        String  namaProduk, barangInputan, produkTambahan, namaBarang,kodeBarang,messege;
        double sisastok;
        System.out.println("1. pencarian barang");
        System.out.println("2. ristok barang ");
        System.out.println("3. penambahan produk baru ");
        System.out.println("4. barang keluar ");
        System.out.println("5. keluar");
        System.out.println("Pilih nih menu (1/2/3/4/5 ");
         pilihan = sig.nextInt();



         switch (pilihan) {
            case 1:
            System.out.println("=========================");
            System.out.println("Masukkan nama barang: ");
            namaBarang=sig1.nextLine();
            System.out.println("Masukkan kode barang: ");
            kodeBarang=sig1.nextLine();
    
            if(namaBarang.equals("sapu") && kodeBarang.equals("a01")){
                System.out.println("Nama barang        : Sapu");
                System.out.println("Kode barang        : A01");
                stokawal=500;
                stokkeluar=300;
                sisastok=stokawal-stokkeluar;
                System.out.println("Stok sapu digudang : "+sisastok);
            }else if (namaBarang.equals("helm") && (kodeBarang.equals("a02"))){
                System.out.println("Nama barang        : Helm");
                System.out.println("Kode barang        : A02");
                stokawal=500;
                stokkeluar=100;
                sisastok=stokawal-stokkeluar;
                System.out.println("Stok sapu digudang : "+sisastok);
            }else if(namaBarang.equals("sikat gigi")&& (kodeBarang.equals("a03"))){
                System.out.println("Nama barang        : Sikat Gigi");
                System.out.println("Kode barang        : A03");
                stokawal=500;
                stokkeluar=490;
                sisastok=stokawal-stokkeluar;
                System.out.println("Stok sikat gigi digudang : "+sisastok);
            }else{
                System.out.println("Barang tidak ditemukan");
            }
                break;


            case 2:
            System.out.println("masukkan kode barang yang ingin di ristok: " );
            kodeBarang = sig1.nextLine();
            System.out.println(" jumlah barang yang ingin diristok: ");
            jmlRistokBarang = sig1.nextInt();

            if (kodeBarang.equals("b04")){
                messege = ("sapu");
            }else if (kodeBarang.equals("b03")){
                messege = ("gayung");
            }else if (kodeBarang.equals("b01")){
                messege = ("laptop");
            }else if (kodeBarang.equals("b02")){
                messege = ("CD");
            }else if (kodeBarang.equals("b00")){
                messege = ("kutang");
            }   else {
                messege = ("handuk");
            }    
            System.out.println("barang " + messege +  " dengan jumlah = " + jmlRistokBarang); 
        
            break; 

        case 3:
            System.out.println("Masukan produk baru yang ingin ditambah: ");
             produkTambahan= sig1.nextLine();
             System.out.println("Masukan jumlah yang ingin ditambah: ");
             jmlTambahBarang = sig1.nextInt();
            System.out.println( produkTambahan   + " berhasil ditambahkan sebanyakiki " + jmlTambahBarang );
            break;

            case 4:
            System.out.println("Masukan nama barang yang keluar saiki: ");
            namaBarang = sig1.nextLine();
            System.out.println("jumlah barang yang keluar: ");
            jmlBarangKeluar = sig1.nextInt();
            System.out.println("Barang yang keluar " + namaBarang + " dengan jumlah = " + jmlBarangKeluar);
            break;

            case 5:
            System.out.println("yahhh keluar ga asik ");
        System.out.println("anda diDO java, tetap semangat ada jobsheet lain :)");

        }
         
         } while (pilihan != 4);
        }else {
            System.out.println("dih salah");
        }
 }
} 

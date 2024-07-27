package com.widat;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean isChoiceValid = false;

        do {

            String vehicle="";
            String state="";
            int year=0;
            int loanTotal=0;
            int loanTenor=0;
            int downPayment=0;
            boolean isYearValid = false;
            boolean isLoanTotalValid = false;
            boolean isLoadTenorValid = false;
            boolean isDownPaymentValid = false;
            boolean isTryAgainValid = false;

            try {

                System.out.println("Menu:");
                System.out.println("1. Simulasi Kredit");
                System.out.println("2. Keluar");
                System.out.print("Pilih (1/2) : ");

                choice = Integer.parseInt(scanner.nextLine());

                if(choice >= 1 && choice <= 2){
                    isChoiceValid = true;
                }

                if (choice == 1) {

                    do {
                        System.out.print("Input Jenis Kendaraan Motor|Mobil : ");
                        vehicle = scanner.nextLine();
                        if (!vehicle.equalsIgnoreCase("motor") && !vehicle.equalsIgnoreCase("mobil")) {
                            System.out.println("system : hanya bisa input motor / mobil");
                        }
                    } while (!vehicle.equalsIgnoreCase("motor") && !vehicle.equalsIgnoreCase("mobil"));

                    do {
                        System.out.print("Input Kendaraan Bekas|Baru : ");
                        state = scanner.nextLine();
                        if (!state.equalsIgnoreCase("bekas") && !state.equalsIgnoreCase("baru")) {
                            System.out.println("system : hanya bisa input bekas / baru");
                        }
                    } while (!state.equalsIgnoreCase("bekas") && !state.equalsIgnoreCase("baru"));

                    do {
                        System.out.print("Input Tahun Kendaraan : ");
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            if (year >= 1000 && year <= 9999) {
                                isYearValid = true;
                            } else {
                                System.out.println("system : yang diperbolehkan hanya 4 digit");
                            }
                        } catch (Exception e) {
                            System.out.println("system : mohon periksa kembali input yang Anda masukan");
                        }

                    } while (!isYearValid);

                    do {
                        System.out.print("Input Jumlah Pinjaman Total : ");
                        try {
                            loanTotal = Integer.parseInt(scanner.nextLine());
                            if (loanTotal > 0 && loanTotal <= 1000000000) {
                                isLoanTotalValid = true;
                            } else {
                                System.out.println("system : yang diperbolehkan hanya kurang dari sama dengan 1 miliar");
                            }
                        } catch (Exception e) {
                            System.out.println("system : mohon periksa kembali input yang Anda masukan");
                        }

                    } while (!isLoanTotalValid);

                    do {
                        System.out.print("Input Tenor Pinjaman 1-6 thn. : ");
                        try {
                            loanTenor = Integer.parseInt(scanner.nextLine());
                            if (loanTenor >= 1 && loanTenor <= 6) {
                                isLoadTenorValid = true;
                            } else {
                                System.out.println("system : yang diperbolehkan hanya 1 - 6");
                            }
                        } catch (Exception e) {
                            System.out.println("system : hanya bisa input angka");
                        }

                    } while (!isLoadTenorValid);

                    do {
                        System.out.print("Input Jumlah DP (%) : ");
                        try {
                            downPayment = Integer.parseInt(scanner.nextLine());
                            if (downPayment >= 0 && downPayment <= 100) {
                                if(state.equalsIgnoreCase("baru") && downPayment < 35 ){
                                    System.out.println("system : untuk motor/mobil baru, DP nya minimal adalah 35 %");
                                }else if(state.equalsIgnoreCase("bekas") && downPayment < 25){
                                    System.out.println("system : untuk motor/mobil bekas, DP nya minimal adalah 25 %");
                                }else {
                                    isDownPaymentValid = true;
                                }
                            } else {
                                System.out.println("system : nilai yang diperbolehkan dari 0 - 100");
                            }
                        } catch (Exception e) {
                            System.out.println("system : mohon periksa kembali input yang Anda masukan");
                        }

                    } while (!isDownPaymentValid);

                    System.out.println(vehicle);
                    System.out.println(state);
                    System.out.println(year);
                    System.out.println(loanTotal);
                    System.out.println(loanTenor);
                    System.out.println(downPayment);

                    do {
                        System.out.print("Kembali Ke Menu (Y/N) : ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                            isTryAgainValid = true;
                        }else{
                            System.out.println("system : mohon pilih Y / N");
                        }
                        if (input.equalsIgnoreCase("Y")){
                            isChoiceValid = false;
                        }
                    } while(!isTryAgainValid);

                } else if (choice == 2){
                    System.exit(0);
                } else {
                    System.out.println("perintah tidak ditemukan, ( silahkan pilih sesuai menu )");
                }
            }catch (Exception e){
                System.out.println("perintah tidak ditemukan");
            }
        } while (!isChoiceValid);

        scanner.close();

    }
}

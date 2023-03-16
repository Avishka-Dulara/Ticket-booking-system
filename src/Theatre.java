import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;

public class Theatre {
    static int[] row_1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] row_2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] row_3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("**************Welcome to the New Theatre**************");
        System.out.println("___________________________________________________________");
        while (true) {
            System.out.println("Please select an option");
            System.out.println("1.Buy a ticket");
            System.out.println("2.Print seating area");
            System.out.println("3.Cancel ticket");
            System.out.println("4.List available seats");
            System.out.println("5.Save to file");
            System.out.println("6.Load from file");
            System.out.println("7.Print ticket information");
            System.out.println("8.Sort tickets by price");
            System.out.println("0.Quit");


            System.out.println("select an option:- ");
            int op = sc.nextInt();

            if (op == 0) {
                System.out.println("Thank You.");
                break;
            } else if (op == 1) {
                buy_ticket();
            } else if (op == 2) {
                print_seating_area();
            } else if (op == 3){
                cancel_ticket();
            } else if (op == 4){
                show_available();
            } else if (op == 5) {
                save();
            } else if (op == 6){
                load();

            }
        }

    }
    //method buy ticket
    public static void buy_ticket() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // Ask the user to input the row number and seat number
            System.out.println("Select row number: ");
            int row = sc.nextInt();

            System.out.println("Select seat number:  ");
            int seat = sc.nextInt();
            seat = seat - 1;
            // Check that the row and seat are within range
            if (row <= 3 && row >= 0) {
                switch (row) {
                    case 1:
                        if (seat <= 12 && seat >= 0) {
                            if (row_1[seat] == 0) {
                                System.out.println("1.The seat is available and this seat is reserved for you.");
                                row_1[seat] = 1;

                            } else {
                                System.out.println("1.Seat was occupied.");
                            }
                            return;
                        } else {
                            System.out.println("1.Incorrect seat number");
                        }
                    case 2:
                        // Check that the row and seat are within range
                        if (seat <= 16 && seat >= 0) {
                            if (row_2[seat] == 0) {
                                System.out.println("2.The seat is available and this seat is reserved for you.");
                                row_2[seat] = 1;
                            } else {
                                System.out.println("2.Seat was occupied.");
                            }
                            return;
                        } else {
                            System.out.println("2.Incorrect seat number");
                        }
                    case 3:
                        // Check that the row and seat are within range
                        if (seat <= 20 && seat >= 0) {
                            if (row_3[seat] == 0) {
                                System.out.println("3.The seat is available and this seat is reserved for you.");
                                row_3[seat] = 1;
                            } else {
                                System.out.println("3.Seat was occupied.");
                            }
                            return;

                        } else {
                            System.out.println("3.Incorrect seat number");
                        }
                }
            } else {
                System.out.println("1.2.3.Invalid row umber");
            }
        }
    }

    //method print seating area
    public static void print_seating_area() {
        System.out.println("*********************");
        System.out.println("*       STAGE       *");
        System.out.println("*********************");

        System.out.println("      ");
        for (int i = 0; i < 12; i++) {
            String mark;
            if (row_1[i] == 0) {
                mark = "o";
            } else {
                mark = "x";
            }
            System.out.print(mark);

        }
        System.out.println("    ");
        for (int i = 0; i < 16; i++) {
            if (row_2[1] == 0) {
                String mark = "o";
                System.out.print(mark);
           }else {
                String mark = "x";
                System.out.println(mark);
            }

        }
        System.out.println("  ");
        for (int i = 0; i<20; i++)
            if (row_3[i] == 0) {
                String mark = "o";
                System.out.print(mark);
            } else {
                String mark = "x";
                System.out.println(mark);
            }


    }
    //method cancel ticket
    public static void cancel_ticket(){
        Scanner sc = new Scanner(System.in);
        // Ask the user to input the row number and seat number
        System.out.println("Enter row number: ");
        int row = sc.nextInt();
        System.out.println("Enter seat number: ");
        int seat = sc.nextInt();

        seat = seat - 1;
        if (row<=3 && row>0){
            switch (row){
                case 1:
                    if (seat <= 12 && seat > 0) {
                        if (row_1[seat] == 1) {
                            System.out.println("The seat was canceled");
                            row_1[seat] = 0;

                        } else {
                            System.out.println("Invalid location");
                        }
                        return;
                    } else {
                        System.out.println("Invalid location");
                    }
                case 2:
                    if (seat <= 16 && seat > 0) {
                        if (row_2[seat] == 1) {
                            System.out.println("The seat was canceled");
                            row_2[seat] = 0;

                        } else {
                            System.out.println("Invalid location");
                        }
                        return;
                    } else {
                        System.out.println("Invalid location");
                    }
                case 3:
                    if (seat <= 20 && seat > 0) {
                        if (row_3[seat] == 1) {
                            System.out.println("The seat was canceled");
                            row_3[seat] = 0;

                        } else {
                            System.out.println("Invalid location");
                        }

                    } else {
                        System.out.println("Invalid location");
                    }

            }
        }else {
            System.out.println("Incorrect row number");
        }
    }
    //method show available
    public static void show_available() {

        System.out.print("Seats available in row 1: ");
        for (int j = 0;j <12;j++){
            if (row_1[j]==0){
                int x=j;
                x = x+1;
                System.out.print(x+",");
            }
        }

        System.out.println("\n");
        System.out.print("Seats available in row 2: ");
        for (int j = 0;j <16;j++){
            if (row_2[j]==0){
                int x=j;
                x = x+1;
                System.out.print(x+",");
            }
        }
        System.out.println("\n");
        System.out.print("Seats available in row 3: ");
        for (int j = 0;j <20;j++){
            if (row_3[j]==0){
                int x=j;
                x = x+1;
                System.out.print(x+",");
            }
        }
    }
        //method save data
        public static void save() {
            try {
                FileWriter writer = new FileWriter("row_info.txt");

                // Write each row of data horizontally to the file
                for (int i = 0; i < row_1.length; i++) {
                    writer.write(row_1[i] + "," + row_2[i] + "," + row_3[i] + "\n");
                }

                writer.close();
                System.out.println("Data saved to file.");
            } catch (IOException e) {
                System.out.println("An error occurred while saving data to file.");
                e.printStackTrace();
            }
        }
    //load data from file
    public static void load(){


    }


}



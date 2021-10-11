package com.shelja;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CoWin portal initialised....");
        System.out.println("-------------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all Slots for a Hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("-------------------------------------");
        int n=10;
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int index4 = -1;
        String unique_ID = "100000";
        ArrayList <ArrayList <Object>> vaccines = new ArrayList<ArrayList<Object>>();
        ArrayList <ArrayList <Object>> hospitals = new ArrayList<ArrayList<Object>>();
        ArrayList <ArrayList <Object>> citizens = new ArrayList<ArrayList<Object>>();
        while (n!=8){
            n = sc.nextInt();
            if (n==1) {
                index1++;
                vaccines.add(new ArrayList<>());
                add_vaccine v1 = new add_vaccine();
                System.out.print("Vaccine Name: ");
                v1.Vaccine_Name = sc.nextLine();
                v1.Vaccine_Name+=sc.nextLine();
                vaccines.get(index1).add(v1.Vaccine_Name);
                int x1 = -1;
                while(x1!=0) {
                    System.out.print("Number of Doses: ");
                    v1.Number_of_Doses = sc.nextInt();
                    if(v1.Number_of_Doses>0)
                        x1 = 0;
                }
                vaccines.get(index1).add(v1.Number_of_Doses);
                int x2 = -1;
                if (v1.Number_of_Doses>1) {
                    while (x2 != 0) {
                        System.out.print("Gap between Doses: ");
                        v1.Gap_between_Doses = sc.nextInt();
                        if (v1.Gap_between_Doses > 0)
                            x2 = 0;
                    }
                    vaccines.get(index1).add(v1.Gap_between_Doses);
                }
                System.out.println("Vaccine Name:"+v1.Vaccine_Name+",Number of Doses:"+v1.Number_of_Doses+",Gap between Doses:"+v1.Gap_between_Doses);
            }
            if (n==2){
                index2++;
                hospitals.add(new ArrayList<>());
                register_hospital v2 = new register_hospital();
                System.out.print("Hospital Name: ");
                v2.Hospital_Name = sc.nextLine();
                v2.Hospital_Name+=sc.nextLine();
                hospitals.get(index2).add(v2.Hospital_Name);
                System.out.print("PinCode: ");
                v2.Pincode = sc.nextInt();
                hospitals.get(index2).add(v2.Pincode);
                hospitals.get(index2).add(unique_ID);
                System.out.println("Hospital Name:"+v2.Hospital_Name+",PinCode:"+v2.Pincode+",Unique ID:"+unique_ID);
                int s = Integer.parseInt(unique_ID);
                s++;
                unique_ID = Integer.toString(s);
            }
            if (n==3){
                index3++;
                citizens.add(new ArrayList<>());
                register_citizen v3 = new register_citizen();
                System.out.print("Citizen Name: ");
                v3.Citizen_Name = sc.nextLine();
                v3.Citizen_Name+=sc.nextLine();
                citizens.get(index3).add(v3.Citizen_Name);
                System.out.print("Age: ");
                v3.age = sc.nextInt();
                citizens.get(index3).add(v3.age);
                System.out.print("Unique ID: ");
                v3.unique_id = sc.nextLine();
                v3.unique_id+=sc.nextLine();
                citizens.get(index3).add(v3.unique_id);
                citizens.get(index3).add(0);
                if (v3.age>=18) {
                    System.out.println("Citizen Name:"+v3.Citizen_Name+",Age:"+v3.age+",Unique ID:"+v3.unique_id);
                }
                else{
                    citizens.remove(index3);
                    index3--;
                    System.out.println("Citizen Name:"+v3.Citizen_Name+",Age:"+v3.age+",Unique ID:"+v3.unique_id);
                    System.out.println("Only above 18 are allowed.");
                }
            }
            if (n==4){
                int x3 = -1;
                int save = 0;
                String hospital = "";
                while(x3!=0) {
                    System.out.print("Enter hospital ID: ");
                    hospital = sc.next();
                    for(int i=0; i< hospitals.size(); i++){
                        if(hospitals.get(i).get(2).equals(hospital)){
                            save = i;
                            x3 = 0;
                            break;
                        }
                    }
                }
                System.out.print("Enter Number of Slots to be Added: ");
                int slot = sc.nextInt();
                for (int i=0; i<slot; i++){
                    index2++;
                    System.out.print("Enter Day Number: ");
                    int day = sc.nextInt();
                    hospitals.get(save).add(day);
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    hospitals.get(save).add(quantity);
                    System.out.println("Select Vaccine");
                    for (int j=0; j< vaccines.size(); j++){
                        System.out.println(j+"."+vaccines.get(j).get(0));
                    }
                    int slots = sc.nextInt();
                    String vac = "";
                    for (int j=0; j< slots; j++){
                        vac = (String) vaccines.get(j).get(0);
                    }
                    hospitals.get(save).add(vac);
                    System.out.println("Slot added by hospital "+hospital+" for day: "+day+",Availability Quantity: "+quantity+" of Vaccine "+vaccines.get(slots).get(0));
                }
            }
            if (n==5){
                int x4 = -1;
                String student_id = "";
                String name = "";
                int save = 0;
                while(x4!=0){
                    System.out.print("Enter patient unique ID: ");
                    student_id = sc.next();
                    for (int i=0; i< citizens.size(); i++){
                        if (citizens.get(i).get(2).equals(student_id)){
                            x4 = 0;
                            save = i;
                            name = (String)citizens.get(i).get(0);
                            break;
                        }
                    }
                }
                System.out.println("1.Search by Area");
                System.out.println("2.Search by Vaccine");
                System.out.println("3.Exit");
                System.out.print("Enter Option: ");
                int option = sc.nextInt();
                if (option==1){
                    System.out.print("Enter PinCode: ");
                    int pincode = sc.nextInt();
                    for (int i=0; i< hospitals.size(); i++){
                        if(hospitals.get(i).get(1).equals(pincode)){
                            System.out.println(hospitals.get(i).get(2)+" "+hospitals.get(i).get(0));
                        }
                    }
                    String hospital = "";
                    int x5 = -1;
                    while(x5!=0) {
                        System.out.print("Enter hospital ID: ");
                        hospital = sc.next();

                        for(int i=0; i< hospitals.size(); i++){
                            if(hospitals.get(i).get(2).equals(hospital)){
                                save = i;
                                x5 = 0;
                                break;
                            }
                        }
                    }
                    int pointer = 0;
                    for (int i=0; i<hospitals.size(); i++){
                        if (hospitals.get(i).get(2).equals(hospital)) {
                            for (int j = 3; j < hospitals.get(i).size();j=j+3) {
                                System.out.println(pointer + "-> Day: " + hospitals.get(i).get(j) + " Available Qty:" + hospitals.get(i).get(j + 1) + " Vaccine:" + hospitals.get(i).get(j+2));
                                pointer++;
                            }
                        }
                    }
                    System.out.print("Choose Slot: ");
                    int slot = sc.nextInt();
                    int take = 0;
                    String vaccine = "";
                    int left = 0;
                    int right = 0;
                    for (int i=0; i< hospitals.size(); i++){
                        for (int j=0; j<slot||j<hospitals.get(i).size(); j=j+3){
                            take++;
                            if (take==(slot-1)){
                                vaccine = (String) hospitals.get(i).get(5);
                                left = i;
                                right = j;
                                break;
                            }
                        }
                        if (take==(slot-1))
                            break;
                    }
                    System.out.println(name+" vaccinated with "+vaccines.get(left).get(right));
                    for (int i=0; i< vaccines.size(); i++){
                        if (vaccines.get(left).get(right)==vaccines.get(i).get(0)){
                            vaccines.get(i).set(1,((int)vaccines.get(i).get(1)-1));
                            break;
                        }
                    }
                }
                else if (option==2){
                    System.out.print("Enter Vaccine Name: ");
                    String vac = sc.nextLine();
                    vac+=sc.nextLine();
                    for (int i=0; i< hospitals.size(); i++){
                        if(hospitals.get(i).get(5).equals(vac)){
                            System.out.println(hospitals.get(i).get(2)+" "+hospitals.get(i).get(0));
                        }
                    }
                    String hospital = "";
                    int x5 = -1;
                    while(x5!=0) {
                        System.out.print("Enter hospital ID: ");
                        hospital = sc.next();
                        for(int i=0; i< hospitals.size(); i++){
                            if(hospitals.get(i).get(2).equals(hospital)){
                                save = i;
                                x5 = 0;
                                break;
                            }
                        }
                    }
                    int pointer = 0;
                    for (int i=0; i<hospitals.size(); i++){
                        if (hospitals.get(i).get(2).equals(hospital)) {
                            for (int j = 3; j < hospitals.get(i).size();j=j+3) {
                                System.out.println(pointer + "-> Day: " + hospitals.get(i).get(j) + " Available Qty:" + hospitals.get(i).get(j + 1) + " Vaccine:" + hospitals.get(i).get(j + 2));
                                pointer++;
                            }
                        }
                    }
                    System.out.print("Choose Slot: ");
                    int slot = sc.nextInt();
                    int take = 0;
                    String vaccine = "";
                    int left = 0;
                    int right = 0;
                    for (int i=0; i< hospitals.size(); i++){
                        for (int j=0; j<slot||j<hospitals.get(i).size(); j=j+3){
                            take++;
                            if (take==(slot-1)){
                                vaccine = (String) hospitals.get(i).get(5);
                                left = i;
                                right = j;
                                break;
                            }
                        }
                        if (take==(slot-1))
                            break;
                    }
                    System.out.println(name+" vaccinated with "+vaccines.get(left).get(right));
                    for (int i=0; i< vaccines.size(); i++){
                        if (vaccines.get(left).get(right)==vaccines.get(i).get(0)){
                            vaccines.get(i).set(1,((int)vaccines.get(i).get(1)-1));
                            break;
                        }
                    }
                }
                else
                    continue;
            }
            if (n==6){
                String hospital = "";
                int x5 = -1;
                while(x5!=0) {
                    System.out.print("Enter hospital ID: ");
                    hospital = sc.next();
                    for(int i=0; i< hospitals.size(); i++){
                        if(hospitals.get(i).get(2).equals(hospital)){
                            x5 = 0;
                            break;
                        }
                    }
                    for (int i=0; i<hospitals.size(); i++){
                        if (hospitals.get(i).get(2).equals(hospital)) {
                            for (int j = 3; j < hospitals.get(i).size();j=j+3) {
                                System.out.println("Day: " + hospitals.get(i).get(j) + " Vaccine:" + hospitals.get(i).get(j + 2)+" Available Qty:" + hospitals.get(i).get(j + 1));
                            }
                        }
                    }
                }

            }
            if (n==7){
                int x4 = -1;
                String student_id = "";
                String name = "";
                int save = 0;
                while(x4!=0){
                    System.out.print("Enter patient unique ID: ");
                    student_id = sc.next();
                    for (int i=0; i< citizens.size(); i++){
                        if (citizens.get(i).get(2).equals(student_id)){
                            x4 = 0;
                            save = i;
                            name = (String)citizens.get(i).get(0);
                            break;
                        }
                    }
                }
            }
            if (n==8){
                System.out.println("{End of Test Case}");
                n=8;
            }
            System.out.println("---------------------------------");
            System.out.println("{Menu Options}");
        }
    }
}
class add_vaccine{
    String Vaccine_Name;
    int Number_of_Doses;
    int Gap_between_Doses;
}
class register_hospital{
    String Hospital_Name;
    int Pincode;
}
class register_citizen{
    String Citizen_Name;
    int age;
    String unique_id;
}
class create_slots{
    int Hospital_ID;
    int number_of_slots;
    int day_number;
    int quantity;
}
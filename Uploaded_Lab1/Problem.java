

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {

    public String[] universe;
    public ArrayList<String[]> sets = new ArrayList<>();
    public int size = 0;


    public Problem() {

    }

    /**
     * Method to Remove Repeated Element from a Set
     * @param set The Set to be Inspected
     * @return String[] The Set after removing Repeated Elements
     */

    public String[] unique(String[] set){
        List<String> unique_list = new ArrayList<>();
        unique_list.add(set[0]);
        for(int i = 0; i < set.length; i++){
            boolean found = false;
            for(int j = 0; j < unique_list.size(); j++){
                if(unique_list.get(j).equals(set[i])){
                    found = true;
                }
            }
            if(!found){
                unique_list.add(set[i]);
            }
        }
        return list2StringList(unique_list);
    }

    /**
     * Method to Ensure that a Specified Set is a Subset of the Given Universe
     * @param Universe
     * @param set
     * @return ture if the set is a subset of Universe
     * @return false if the set is not a subset of Universe
     */

    public boolean isSubset(String[] Universe, String[] set)
    {
        for(int i = 0; i < set.length; i++){
            boolean notSubset = true;
            for(int j = 0; j < Universe.length; j++){
                if(Universe[j].equals(set[i])){
                    notSubset = false;
                }
            }
            if(notSubset) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to Add New Sets into the Object to Preform Operations on them
     * Before Adding a Certain Set It-->>
     * 1) Removes Repeated elements
     * 2) Makes Sure it is a Subset of the Universe
     */

    public void addSets() {
        System.out.println("Enter The Number Of Sets To Be Added");
        Scanner in = new Scanner(System.in);
        int n = read_int();
        System.out.println("Enter Elements of Each Set Seperated by Space");
        for(int i = 0; i < n; i++) {
            System.out.println("Enter The #" + Integer.sum(i, 1) + " Set:");
            String input = in.nextLine();
            if(!isSubset(this.universe, input.split(" "))){
                System.out.println("Please Enter a Subset of the Universe ");
                i -= 1;
                continue;
            }
            this.sets.add(unique(input.split(" ")));
            this.size++;
        }
        System.out.println(n + " Sets have been added successfully!");
    }

    /**
     * Method to Edit(overwrite) a Specific Set
     * Asks the User for Index of Set
     */

    public void editSet() {
        System.out.println("Enter The Index Of Set To Be Edited ");
        Scanner in = new Scanner(System.in);
        int n;
        n = read_int();
        System.out.println("Enter the New Set");
        String input = in.nextLine();
        if(isSubset(this.universe, input.split(" "))){
            this.sets.set(n-1, unique(input.split(" ")));
            printSet(input.split(" "));
            System.out.print("Has been Edited Successfully");
        }
        else{
            System.out.println("Please Enter A Subset of the Universe ");
        }
    }

    /**
     * Method to Print a Specific Set on Console
     * Asks the User for Index of the Set to be Printed
     */

    public void printSetMenu() {
        System.out.println("Enter The Index Of Set To Be Printed ");
        Scanner in = new Scanner(System.in);
        int n;
        try {
            n = read_int();
        }
        catch(Exception e) {
            System.out.println("Please make sure to enter a valid number !");
            this.editSet();
            return;
        }
        printSet(this.sets.get(n - 1));
    }

    /**
     * Method to Print Array of Strings to the Console
     * Uses for Loop
     * @param set Array of Strings to Printed
     */

    public void printSet(String[] set)
    {
        System.out.print("{ ");
        for(int i = 0; i < set.length; i++){
            if(i == set.length - 1)
                System.out.print(set[i]);
            else
                System.out.print(set[i] + ", ");
        }
        System.out.println(" }");
    }

    /**
     * Method to Remove a Specific Set from the Object
     * Asks the User the Index of the Set to be Removed
     */

    public void removeSet() {
        System.out.println("Enter The Index Of Sets To Be Removed ");
        Scanner in = new Scanner(System.in);
        int n;
        n = read_int();
        printSet(this.sets.get(n - 1));
        System.out.println("Has Been Removed");
        this.sets.remove(n - 1);
        this.size--;
    }

    /**
     * Method to Convert from List<String> Object to Array of Strings
     * @param string_list List of Strings
     * @return String[] Array of Strings
     */
    public static String[] list2StringList(List<String> string_list){
        String[] string = new String[string_list.size()];
        for(int i = 0; i < string_list.size(); i++){
            string[i] = string_list.get(i);
        }
        return string;
    }

    /**
     * Method to Read the Universe from User on Console
     * Reads the Input as A String then Parses to Array of Strings
     */

    public void readUniverse()
    {
        System.out.println("Enter The Universe (Enter Each Element Seperated by Space and Press Enter):");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        this.universe = unique(input.split(" "));
    }

    /**
     * Method to return the Union of Two Sets
     * By Looping Over The Two Sets
     * @param set1
     * @param set2
     * @return String[] Array of Strings Contains The Union of set1 and set2
     */
    public String[] Union(String[] set1, String[] set2)
    {
        List<String> union_list = new ArrayList<>();
        for(int i = 0; i < set1.length; i++){
            union_list.add(set1[i]);
        }
        for(int i = 0; i < set2.length; i++){
            boolean found = false;
            for(int j = 0; j < union_list.size(); j++){
                if(union_list.get(j).equals(set2[i])){
                    found = true;
                    break;
                }
            }
            if(!found){
                union_list.add(set2[i]);
            }
        }
        return list2StringList(union_list);
    }
    /**
     * Method to return the Intersection of Two Sets
     * By Looping Over The Two Sets
     * @param set1
     * @param set2
     * @return String[] Array of Strings Contains The Intersction of set1 and set2
     */
    public String[] Intersection(String[] set1, String[] set2)
    {
        List<String> intersection_list = new ArrayList<>();

        for(int i = 0; i < set1.length; i++){
            for(int j = 0; j < set2.length; j++){
                if(set1[i].equals(set2[j])){
                    intersection_list.add(set1[i]);
                }
            }
        }
        return list2StringList(intersection_list);
    }
    /**
     * Method to return The Complement of A Set
     * By Looping Over The Set and Universe
     * @param set1
     * @return String[] Array of Strings Contains Complement set1
     */
    public String[] Complement(String[] set1, String[] Universe)
    {
        List<String> complement_list = new ArrayList<>();

        for(int i = 0; i < Universe.length; i++){
            boolean found = false;
            for(int j = 0; j < set1.length; j++){
                if(Universe[i].equals(set1[j])){
                    found = true;
                    break;
                }
            }
            if(!found){
                complement_list.add(Universe[i]);
            }
        }
        return list2StringList(complement_list);
    }
    /**
     * Method to read an entered integer
     * using recursion, it won't stop asking for a valid input till it has one
     * @return Int : a valid integer input
     */
    public static int read_int() {
        int n;
        Scanner in =new Scanner(System.in);
        try {
            n = Integer.parseInt(in.nextLine().replaceAll(" ", ""));
        }
        catch(Exception e) {
            System.out.println("Please make sure to enter a valid number !");
            n = read_int();
        }
        return n;
    }

    public static void main(String[] args) {
        try {
            Problem problem = new Problem();
            problem.readUniverse();
            problem.addSets();
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("============================================================================");
                System.out.print("Universe ==>> ");
                problem.printSet(problem.universe);
                for(int i = 0; i < problem.size; i++){
                    System.out.print(i + 1 + ") ");
                    problem.printSet(problem.sets.get(i));
                }
                System.out.println("============================================================================");
                System.out.println( "[1] Find Intersection Of 2 Sets\n" +
                        "[2] Find Union Of 2 Sets\n" +
                        "[3] Find The Complement Of A Set\n"  +
                        "[4] Add Sets\n" +
                        "[5] Edit A Set\n" +
                        "[6] Print One Set\n" +
                        "[7] Remove A Set\n" +
                        "[8] Exit");
                System.out.print("Choose A Value :::   ");


                int current = read_int();
                int a, b;
                switch(current) {
                    case 4:
                        problem.addSets();
                        break;
                    case 5:
                        problem.editSet();
                        System.out.println("Please Press Enter to Procced ");
                        in.nextLine();
                        break;
                    case 1:
                        System.out.print("Enter The Index Of The First Set: ");
                        a = read_int()-1;
                        System.out.print("Enter The Index Of The Second Set: ");
                        b = read_int()-1;
                        if((a <= problem.size && b <= problem.size) && problem.size != 0){
                            System.out.println("============================================================================");
                            System.out.print("===>>> Their Intersection Is : ");
                            problem.printSet(problem.Intersection(problem.sets.get(a), problem.sets.get(b)));
                            System.out.println("Please Press Enter to Procced ");
                            in.nextLine();
                        }
                        else{
                            System.out.println("============================================================================");
                            System.out.println("Given Index Is Out Of Bounds");
                            System.out.println("============================================================================");
                            System.out.println("Please Press Enter to Procced ");
                            in.nextLine();
                            continue;
                        }
                        break;
                    case 2:
                        System.out.print("Enter The Index Of The First Set: ");
                        a = read_int()-1;
                        System.out.print("Enter The Index Of The Second Set: ");
                        b = read_int()-1;
                        if((a <= problem.size && b <= problem.size) && problem.size != 0){
                            System.out.println("============================================================================");
                            System.out.print("===>>> Their Union Is : ");
                            problem.printSet(problem.Union(problem.sets.get(a), problem.sets.get(b)));
                            System.out.println("Please Press Enter to Procced ");
                            in.nextLine();
                        }
                        else{
                            System.out.println("============================================================================");
                            System.out.println("Given Index Is Out Of Bounds");
                            System.out.println("============================================================================");
                            System.out.println("Please Press Enter to Procced ");
                            in.nextLine();
                            continue;
                        }
                        break;
                    case 3:
                        System.out.print("Enter The Index Of The Set: ");
                        a=read_int()-1;
                        if(a <= problem.size && problem.size != 0){
                            System.out.println("============================================================================");
                            System.out.print("===>>> Their Complement Is : ");
                            problem.printSet(problem.Complement(problem.sets.get(a), problem.universe));
                            System.out.println("Please Press Enter to Procced ");
                            in.nextLine();
                        }
                        else{
                            System.out.println("============================================================================");
                            System.out.println("Given Index(s) Is Out Of Bounds");
                            System.out.println("============================================================================");
                            System.out.println("Please Press Enter to Procced ");
                            in.nextLine();
                            continue;
                        }
                        break;
                    case 6:
                        problem.printSetMenu();
                        System.out.println("Please Press Enter to Procced ");
                        in.nextLine();
                        break;
                    case 7:
                        problem.removeSet();
                        System.out.println("Please Press Enter to Procced ");
                        in.nextLine();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error " +  e);

        }
    }
}
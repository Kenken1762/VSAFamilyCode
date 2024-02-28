import java.io.*;
import java.util.*;

public class familyGenerator {

    public static final int NUM_FAMS = 8;
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;
    public static final int NUM_CLASSIFICATIONS = 4;
    public static final File memberData = new File("/Users/kennynguyen/Desktop/familyGenerator/memberData.txt");
    public static final ArrayList<VSAMember> members = new ArrayList<>();
    public static final ArrayList<VSAFamily> families = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException
    {
        //WHEN USING CODE FOR RAW MEMBER DATA USE P41D3D(or any set of letters that members can't guess)
        // TO DETERMINE IF A MEMBER HAS PAIDED BLANK OTHER A MEMBER CAN ONLY BE ADDED INTO A FAM AFTER
        // THEY HAVE PAID CONFIRMATION OF PAYMENT GOES THROUGH EITHER WHOEVER IS TABLING OR THE TREASURER
        Scanner keyboard = new Scanner(System.in);
        System.out.print("1 to generate familes, 2 to generate a singular entry:");
        int input = Integer.valueOf(keyboard.nextLine());
        if(input == 1) {
            instantiateMembers();
            instantiateFamilies();
            Collections.sort(members);
            makeFamilies();
        }
        else
        {
            String entry = keyboard.nextLine();
            String again = "1";
            while(again.equals("1"))
            {
                createSingularEntry(entry);
                System.out.print("1 to do another, anything else to exit: ");
                again = keyboard.next();
                keyboard.nextLine();
                entry = keyboard.nextLine();
            }
        }
    }

    public static void createSingularEntry(String curMember)
    {
        Scanner chopper = new Scanner(curMember);
            chopper.next();
            chopper.next();
            String name = chopper.next();
            String temp = "";
            while(!containsPronouns(name))
            {
                temp = chopper.next();
                name += " " + temp;
            }
            name = name.substring(0, name.length() - temp.length() - 1);
            String pronouns = temp;
            while(!containsDigit(temp))
            {
                temp = chopper.next();
            }
            String UTEID = temp;
            String email = chopper.next();
            String phoneNumber = chopper.next();
            String temp2 = "";
            while(!containsClassification(temp2))
            {
                temp2 = chopper.next();
            }
            String classification = temp2;
            String semester = chopper.next();
            String temp3 = "";
            while(!containsPaymentType(temp3))
            {
                temp3 = chopper.next();
            }
            String paymentType = temp3;
            String shirtSize = "";
            if(paymentType.equals("Cash"))
                shirtSize = chopper.next();
            else
            {
                chopper.next();
                String checkForLink = chopper.next();
                if(checkForLink.length() > 2)
                    shirtSize = chopper.next();
                else
                    shirtSize = checkForLink;
            }
            VSAMember current = new VSAMember(name, pronouns, UTEID, email, phoneNumber, semester, paymentType, shirtSize, classification);
            StringBuilder sb = new StringBuilder();
            sb.append("Name:" + current.getName() + "(" + current.getUTEID() + ")" + "\n");
            sb.append("Pronouns: " + current.getPronouns() + "\n");
            sb.append("Email: " + current.getEmail() + "\n");
            sb.append("Phone Number: " + current.getPhoneNumber() + "\n");
            sb.append("Semester: " + current.getSemester() + "\n");
            sb.append("Payment Type: " + current.getPaymentType() + "\n");
            sb.append("Shirt Size: " + current.getShirtSize() + "\n\n");

            System.out.println(sb.toString());
    }

    public static void instantiateMembers() throws FileNotFoundException
    {
        Scanner scan = new Scanner(memberData);
        scan.nextLine();

        while(scan.hasNextLine())
        {
            String curMember = scan.nextLine();
            //PASSWORD FOR PAIDED GOES HERE
            if(curMember.contains("P41D3D"))
            {
                Scanner chopper = new Scanner(curMember);
                while(chopper.hasNext())
                {
                    chopper.next();
                    chopper.next();
                    String name = chopper.next();
                    String temp = "";
                    while(!containsPronouns(name))
                    {
                        temp = chopper.next();
                        name += " " + temp;
                    }
                    name = name.substring(0, name.length() - temp.length() - 1);
                    String pronouns = temp;
                    while(!containsDigit(temp))
                    {
                        temp = chopper.next();
                    }
                    String UTEID = temp;
                    String email = chopper.next();
                    String phoneNumber = chopper.next();
                    String temp2 = "";
                    while(!containsClassification(temp2))
                    {
                        temp2 = chopper.next();
                    }
                    String classification = temp2;
                    String semester = chopper.next();
                    String temp3 = "";
                    while(!containsPaymentType(temp3))
                    {
                        temp3 = chopper.next();
                    }
                    String paymentType = temp3;
                    String shirtSize = "";
                    if(paymentType.equals("Cash"))
                        shirtSize = chopper.next();
                    else
                    {
                        chopper.next();
                        String checkForLink = chopper.next();
                        if(checkForLink.length() > 2)
                            shirtSize = chopper.next();
                        else
                            shirtSize = checkForLink;
                    }
                    members.add(new VSAMember(name, pronouns, UTEID, email, phoneNumber, semester, paymentType, shirtSize, classification));
                    chopper.nextLine();
                }
            }
        }
    }

    public static void instantiateFamilies()
    {
        for(int x = 0;x < NUM_FAMS;x++)
        {
            families.add(new VSAFamily());
        }
    }

    private static boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

    private static boolean containsClassification(String s){
        return(s.contains("Freshman") || s.contains("Sophomore") || s.contains("Junior")
                || s.contains("Senior") || s.contains("Super"))?true:false;
    }

    private static boolean containsPaymentType(String s){
        return(s.contains("Venmo") || s.contains("Cash"))?true:false;
    }

    private static boolean containsPronouns(String s){
        return (s.contains("/") || s.contains("prefer"))?true:false;
    }

    private static int[] getNumClassifications()
    {
        int[] numClassifications = new int[NUM_CLASSIFICATIONS * 2];

        for(int x = 0;x < members.size();x++)
        {
            numClassifications[members.get(x).getClassificationNumber() - 1]++;
        }

        return numClassifications;
    }

    private static void makeFamilies() throws FileNotFoundException {

        int index = 0;
        int curCap = 0;

        HashMap<String, Integer> prefList = new HashMap<>();
        Scanner prefScan = new Scanner(new File("/Users/kennynguyen/Desktop/familyGenerator/prefData.txt"));
        while(prefScan.hasNext())
        {
            String cur = prefScan.nextLine();
            Scanner chopper = new Scanner(cur);
            chopper.useDelimiter(":");
            String eid = chopper.next();
            int fam = Integer.valueOf(chopper.next());
            prefList.put(eid, fam);
        }

        int[] prefNumClassification = new int[8];
        for(int x = 0;x < members.size();x++)
        {
            VSAMember temp = members.get(x);
            if(prefList.containsKey(temp.getUTEID().trim()))
            {
                families.get(prefList.get(temp.getUTEID()) - 1).addClassification(temp, temp.getClassificationNumber());
                prefNumClassification[temp.getClassificationNumber() - 1]++;
                members.remove(x);
                prefList.remove(temp.getUTEID());
                x--;
            }
        }

        int[] numClassification = getNumClassifications();
        for(int y = 0;y < NUM_CLASSIFICATIONS * 2;y++)
        {
            curCap += numClassification[y];
            int averageLimiter = (numClassification[y] + prefNumClassification[y])/NUM_FAMS;
            for(int x = index;x < curCap;x++)
            {
                if((x - index + prefNumClassification[y]) >= averageLimiter * NUM_FAMS)
                    averageLimiter++;
                int randNum = (int)(Math.random() * NUM_FAMS);
                while(families.get(randNum).getNumClassification(y + 1) == averageLimiter)
                {
                    randNum = (int)(Math.random() * NUM_FAMS);
                }
                families.get(randNum).addClassification(members.get(x),y + 1);
            }
            index += numClassification[y];
        }

        familiesOutput();
        vsaOverview();
    }

    private static void familiesOutput() throws FileNotFoundException {

        for(int x = 0;x < families.size();x++)
        {
            PrintStream stream = new PrintStream("/Users/kennynguyen/Desktop/familyGenerator/normalOutputs/memberOutput" + (x+1) + ".txt");
            PrintStream detailedStream = new PrintStream("/Users/kennynguyen/Desktop/familyGenerator/detailedOutputs/detailedMemberOutput" + (x+1) + ".txt");
            VSAFamily temp = families.get(x);
            stream.println("FAM: " + (x+1));
            detailedStream.println("FAM: " + (x+1));
            stream.println("Num Fem Identifying: " + temp.getNumFemIdentifying() );
            detailedStream.println("Num Fem Identifying: " + temp.getNumFemIdentifying() );
            stream.println("Num Male Identifying: " + temp.getNumMaleIdentifying() );
            detailedStream.println("Num Male Identifying: " + temp.getNumMaleIdentifying() );
            stream.println("FRESHMAN:" + temp.getNumClassificationTotal(FRESHMAN));
            detailedStream.println("FRESHMAN:" + temp.getNumClassificationTotal(FRESHMAN));
            stream.println("SOPHOMORE:" + temp.getNumClassificationTotal(SOPHOMORE));
            detailedStream.println("SOPHOMORE:" + temp.getNumClassificationTotal(SOPHOMORE));
            stream.println("JUNIOR:" + temp.getNumClassificationTotal(JUNIOR));
            detailedStream.println("JUNIOR:" + temp.getNumClassificationTotal(JUNIOR));
            stream.println("(SUPER)SENIOR:" + temp.getNumClassificationTotal(SENIOR));
            detailedStream.println("(SUPER)SENIOR:" + temp.getNumClassificationTotal(SENIOR));
            stream.println("\n" + families.get(x).toString() + "\n\n");
            detailedStream.println("\n" + families.get(x).toString(true) + "\n\n");
        }
    }

    private static void vsaOverview() throws FileNotFoundException {
        PrintStream stream = new PrintStream("/Users/kennynguyen/Desktop/familyGenerator/vsaOverview.txt");
        int numFreshman = 0;
        int numSophomore = 0;
        int numJunior = 0;
        int numSenior = 0;
        int numFemId = 0;
        int numMaleId = 0;
        int numMaleFreshman = 0;
        int numFemaleFreshman = 0;
        int numMaleSophomore = 0;
        int numFemaleSophomore = 0;
        int numMaleJunior = 0;
        int numFemaleJunior = 0;
        int numMaleSenior = 0;
        int numFemaleSenior = 0;
        for(int x = 0;x < families.size();x++)
        {
            VSAFamily temp = families.get(x);
            numFreshman += temp.getNumClassificationTotal(FRESHMAN);
            numSophomore += temp.getNumClassificationTotal(SOPHOMORE);
            numJunior += temp.getNumClassificationTotal(JUNIOR);
            numSenior += temp.getNumClassificationTotal(SENIOR);
            numFemId += temp.getNumFemIdentifying();
            numMaleId += temp.getNumMaleIdentifying();
            numMaleFreshman += temp.getNumClassification(1);
            numFemaleFreshman += temp.getNumClassification(5);
            numMaleSophomore += temp.getNumClassification(2);
            numFemaleSophomore += temp.getNumClassification(6);
            numMaleJunior += temp.getNumClassification(3);
            numFemaleJunior += temp.getNumClassification(7);
            numMaleSenior += temp.getNumClassification(4);
            numFemaleSenior += temp.getNumClassification(8);
        }

        stream.println("VSA OVERVIEW");
        stream.println("NUM MEMBERS: " + (numMaleId + numFemId));
        for(int x = 0;x < families.size();x++)
        {
            stream.println("NUMBER IN FAM " + (x+1) + ": " + families.get(x).getSize());
        }
        stream.println("NUM FRESHMAN: " + numFreshman);
        stream.println("NUM SOPHOMORE: " + numSophomore);
        stream.println("NUM JUNIOR: " + numJunior);
        stream.println("NUM SENIOR: " + numSenior);
        stream.println("NUM FEM ID: " + numFemId);
        stream.println("NUM MALE ID: " + numMaleId);
        stream.println("NUM MALE FRESHMAN: " + numMaleFreshman);
        stream.println("NUM FEMALE FRESHMAN: " + numFemaleFreshman);
        stream.println("NUM MALE SOPHOMORE: " + numMaleSophomore);
        stream.println("NUM FEMALE SOPHOMORE: " + numFemaleSophomore);
        stream.println("NUM MALE JUNIOR: " + numMaleJunior);
        stream.println("NUM FEMALE JUNIOR: " + numFemaleJunior);
        stream.println("NUM MALE (SUPER)SENIOR: " + numMaleSenior);
        stream.println("NUM FEMALE (SUPER)SENIOR: " + numFemaleSenior);
    }
}

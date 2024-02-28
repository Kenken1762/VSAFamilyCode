import java.util.*;

public class VSAFamily
{
    ArrayList<VSAMember> freshman;
    ArrayList<VSAMember> sophomore;
    ArrayList<VSAMember> junior;
    ArrayList<VSAMember> senior;
    ArrayList<VSAMember> freshmanMale;
    ArrayList<VSAMember> freshmanFemale;
    ArrayList<VSAMember> sophomoreMale;
    ArrayList<VSAMember> sophomoreFemale;
    ArrayList<VSAMember> juniorMale;
    ArrayList<VSAMember> juniorFemale;
    ArrayList<VSAMember> seniorMale;
    ArrayList<VSAMember> seniorFemale;

    public VSAFamily()
    {
        freshman = new ArrayList<>();
        sophomore = new ArrayList<>();
        junior = new ArrayList<>();
        senior = new ArrayList<>();
        freshmanMale = new ArrayList<>();
        freshmanFemale = new ArrayList<>();
        sophomoreMale = new ArrayList<>();
        sophomoreFemale = new ArrayList<>();
        juniorMale = new ArrayList<>();
        juniorFemale = new ArrayList<>();
        seniorMale = new ArrayList<>();
        seniorFemale = new ArrayList<>();
    }

    public int getNumClassificationTotal(int classification)
    {
        switch (classification)
        {
            case 1:
                return freshman.size();
            case 2:
                return sophomore.size();
            case 3:
                return junior.size();
            case 4:
                return senior.size();
        }
        return 0;
    }
    public int getNumClassification(int classification)
    {
        switch(classification)
        {
            case 1:
                return freshmanMale.size();
            case 2:
                return sophomoreMale.size();
            case 3:
                return juniorMale.size();
            case 4:
                return seniorMale.size();
            case 5:
                return freshmanFemale.size();
            case 6:
                return sophomoreFemale.size();
            case 7:
                return juniorFemale.size();
            case 8:
                return seniorFemale.size();
        }
        return 0;
    }

    public void addClassification(VSAMember member, int classification)
    {
        switch(classification)
        {
            case 1:
                freshmanMale.add(member);
                freshman.add(member);
                break;
            case 5:
                freshmanFemale.add(member);
                freshman.add(member);
                break;
            case 2:
                sophomoreMale.add(member);
                sophomore.add(member);
                break;
            case 6:
                sophomoreFemale.add(member);
                sophomore.add(member);
                break;
            case 3:
                juniorMale.add(member);
                junior.add(member);
                break;
            case 7:
                juniorFemale.add(member);
                junior.add(member);
                break;
            case 4:
                seniorMale.add(member);
                senior.add(member);
                break;
            case 8:
                seniorFemale.add(member);
                senior.add(member);
                break;
        }
    }
    public int getSize(){return freshman.size() + sophomore.size() + junior.size() + senior.size();}
    public int getNumFemIdentifying(){return freshmanFemale.size() + sophomoreFemale.size()
    + juniorFemale.size() + seniorFemale.size();}
    public int getNumMaleIdentifying(){return freshmanMale.size() + sophomoreMale.size()
            + juniorMale.size() + seniorMale.size();}
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Freshman\n");
        for(int x = 0;x < freshman.size();x++)
        {
            sb.append(freshman.get(x).getName() + "(" + freshman.get(x).getUTEID() + ")" + "\n");
        }

        sb.append("\nSophomore\n");
        for(int x = 0;x < sophomore.size();x++)
        {
            sb.append(sophomore.get(x).getName() + "(" + sophomore.get(x).getUTEID() + ")" + "\n");
        }

        sb.append("\nJunior\n");
        for(int x = 0;x < junior.size();x++)
        {
            sb.append(junior.get(x).getName() + "(" + junior.get(x).getUTEID() + ")" + "\n");
        }

        sb.append("\nSenior\n");
        for(int x = 0;x < senior.size();x++)
        {
            sb.append(senior.get(x).getName() + "(" + senior.get(x).getUTEID() + ")" + "\n");
        }

        return sb.toString();
    }

    public String toString(boolean detailed)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Freshman\n");
        for(int x = 0;x < freshman.size();x++)
        {
            sb.append("Name:" + freshman.get(x).getName() + "(" + freshman.get(x).getUTEID() + ")" + "\n");
            sb.append("Pronouns: " + freshman.get(x).getPronouns() + "\n");
            sb.append("Email: " + freshman.get(x).getEmail() + "\n");
            sb.append("Phone Number: " + freshman.get(x).getPhoneNumber() + "\n");
            sb.append("Semester: " + freshman.get(x).getSemester() + "\n");
            sb.append("Payment Type: " + freshman.get(x).getPaymentType() + "\n");
            sb.append("Shirt Size: " + freshman.get(x).getShirtSize() + "\n\n");
        }

        sb.append("\nSophomore\n");
        for(int x = 0;x < sophomore.size();x++)
        {
            sb.append("Name:" + sophomore.get(x).getName() + "(" + sophomore.get(x).getUTEID() + ")" + "\n");
            sb.append("Pronouns: " + sophomore.get(x).getPronouns() + "\n");
            sb.append("Email: " + sophomore.get(x).getEmail() + "\n");
            sb.append("Phone Number: " + sophomore.get(x).getPhoneNumber() + "\n");
            sb.append("Semester: " + sophomore.get(x).getSemester() + "\n");
            sb.append("Payment Type: " + sophomore.get(x).getPaymentType() + "\n");
            sb.append("Shirt Size: " + sophomore.get(x).getShirtSize() + "\n\n");
        }

        sb.append("\nJunior\n");
        for(int x = 0;x < junior.size();x++)
        {
            sb.append("Name:" + junior.get(x).getName() + "(" + junior.get(x).getUTEID() + ")" + "\n");
            sb.append("Pronouns: " + junior.get(x).getPronouns() + "\n");
            sb.append("Email: " + junior.get(x).getEmail() + "\n");
            sb.append("Phone Number: " + junior.get(x).getPhoneNumber() + "\n");
            sb.append("Semester: " + junior.get(x).getSemester() + "\n");
            sb.append("Payment Type: " + junior.get(x).getPaymentType() + "\n");
            sb.append("Shirt Size: " + junior.get(x).getShirtSize() + "\n\n");
        }

        sb.append("\nSenior\n");
        for(int x = 0;x < senior.size();x++)
        {
            sb.append("Name:" + senior.get(x).getName() + "(" + senior.get(x).getUTEID() + ")" + "\n");
            sb.append("Pronouns: " + senior.get(x).getPronouns() + "\n");
            sb.append("Email: " + senior.get(x).getEmail() + "\n");
            sb.append("Phone Number: " + senior.get(x).getPhoneNumber() + "\n");
            sb.append("Semester: " + senior.get(x).getSemester() + "\n");
            sb.append("Payment Type: " + senior.get(x).getPaymentType() + "\n");
            sb.append("Shirt Size: " + senior.get(x).getShirtSize() + "\n\n");
        }

        return sb.toString();
    }
}

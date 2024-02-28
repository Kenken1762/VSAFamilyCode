public class VSAMember implements Comparable<VSAMember>{
    String name;
    String pronouns;
    String UTEID;
    String email;
    String phoneNumber;
    String semester;
    String paymentType;
    String shirtSize;
    String classification;
    int classificationNumber;

    public VSAMember(String name, String pronouns, String UTEID, String email, String phoneNumber, String semester, String paymentType, String shirtSize, String classification)
    {
        this.name = name;
        this.pronouns = pronouns;
        this.UTEID = UTEID;
        this.email = email;
        this.phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        this.semester = semester;
        this.paymentType = paymentType;
        this.shirtSize = shirtSize;
        this.classification = classification;
        this.classificationNumber = 0;
        setClassificationNumber();
    }

    public String getName()
    {
        return name;
    }
    public String getPronouns()
    {
        if(pronouns.equals("prefer"))
            return "Prefer not to say";
        return pronouns;}
    public String getUTEID()
    {
        return UTEID;
    }
    public String getEmail(){return email;}
    public String getSemester()
    {
        if(semester.equals("Full"))
            return semester + " Year";
        else
            return semester + " Semester";
    }
    public String getPaymentType(){return paymentType;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getShirtSize(){return shirtSize;}
    public String getClassification()
    {
        return classification;
    }
    public int getClassificationNumber(){return classificationNumber;}


    private void setClassificationNumber()
    {
        if(pronouns.contains("she"))
            classificationNumber += 4;

        if(classification.equals("Freshman"))
            classificationNumber += 1;
        else if(classification.equals("Sophomore"))
            classificationNumber += 2;
        else if(classification.equals("Junior"))
            classificationNumber += 3;
        else
            classificationNumber += 4;
    }

    @Override
    public int compareTo(VSAMember other)
    {
        return this.classificationNumber - other.classificationNumber;
    }

}

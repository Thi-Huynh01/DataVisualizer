public record DataSet (String firstname, String lastname, String city, String year, String ethnicity_or_gender) {

    public String firstname() {
        return firstname;
    }
    public String lastname() {
        return lastname;
    }
    public String city() {
        return city;
    }
    public String year() {
        return year;
    }

    public String ethnicity_or_gender() {
        return ethnicity_or_gender;
    }

}

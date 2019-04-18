package edu.psu.bd.cs.jmm8707;

public class Records
{
    private String country;
    private String code;
    private String state;
    private String languages;
    private String cities;

    public Records(String country, String code, String state, String languages, String cities)
    {
        this.country = country;
        this.code = code;
        this.state = state;
        this.languages = languages;
        this.cities = cities;
    }

    public String getCountry()
    {
        return country;
    }

    public String getCode()
    {
        return code;
    }

    public String getState()
    {
        return state;
    }

    public String getLanguages()
    {
        return languages;
    }

    public String getCities()
    {
        return cities;
    }
}

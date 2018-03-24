package nyc.muaadh_melhi_develpoer.mvp_example_android.model;

import java.util.List;

/**
 * Created by Muaadh on 3/23/18.
 */

public class CountryRes {
    private String name;
    private List<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private int population;
    private List<Float> latlng;
    private String demonym;
    private float gini;
    private List<String> timezones;
    private List<String> borders;
    private String nativeName;
    private int numericCode;
    private List<Currencies> currencies;
    private List<Languages> languages;
    private Translations translations;
    private String flag;
    private String cioc;

    public String getName() {
        return name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }

    public List<Float > getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public float getGini() {
        return gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public int getNumericCode() {
        return numericCode;
    }

    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public String getFlag() {
        return flag;
    }

    public String getCioc() {
        return cioc;
    }
}
